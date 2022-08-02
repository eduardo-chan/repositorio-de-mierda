package mx.edu.utez.proyectoservlet.controller.person;

import mx.edu.utez.proyectoservlet.model.person.BeanPerson;
import mx.edu.utez.proyectoservlet.service.ServicePerson;
import mx.edu.utez.proyectoservlet.utils.ResultAction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ServletPerson",
        urlPatterns = {
        "/getPersons",
        "/createPerson",
        "/savePerson",
        "/getPerson",
        "/updatePerson",
        "/deletePerson"
})

@MultipartConfig(maxFileSize = 1024*1024*100) //igual a 100mb
public class ServletPerson extends HttpServlet {

    String action;
    String urlRedirect = "/getPersons";
    ServicePerson servicePerson = new ServicePerson();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8"); // para que soporte caracteres especiales
        action = request.getServletPath();   //cachar el url que manda, la path

        switch (action){
            case "/getPersons":
                List<BeanPerson> personList = servicePerson.showPersons();
                System.out.println(personList.size()); //tamaño de la lista
                request.setAttribute("personList", personList); //mostrar la lista en la vista
                urlRedirect = "/WEB-INF/view/person/indexPerson.jsp";
                break;
            case "/createPerson":
                urlRedirect = "/WEB-INF/view/person/createPerson.jsp";
                break;
            case "/getPerson":
                String id = request.getParameter("id");
                id = (id == null) ? "0" : id;
                //System.out.println("ID PERSON -> " + id );
                try {
                    BeanPerson person = servicePerson.findPerson(Long.parseLong(id));
                    System.out.println(person); //ver que nos trae
                    request.setAttribute("person", person);
                    urlRedirect = "/WEB-INF/view/person/updatePerson.jsp"; //manda el obj person a esta vista
                }catch (Exception e ) {
                    urlRedirect = "/getPersons";
                }
                break;

            default:
                urlRedirect = "/getPersons";
        }
        request.getRequestDispatcher(urlRedirect).forward(request,response);  //lo manda a index, responde y muestra
        //dispatcher lo manda a urlRedirect, este se encarga de cachar las ubis de los jsp, lo manda a jsp, y responde

    }

    //savePerson en doPost pq guarda datos, manipularlos, y ocultar, si se hace con doGet los datos se verían en la URL
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8"); //para q lo mande igual
        response.setContentType("text/html");
        action = request.getServletPath();


        switch (action){
            case "/savePerson":
                //recuperar valores
                String name = request.getParameter("name");
                String lastName = request.getParameter("lastName");
                String age = request.getParameter("age");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String birthday = request.getParameter("birthday");
                Part filePart = request.getPart("image");
                InputStream image = filePart.getInputStream();


                try {
                //guardamos
                BeanPerson person = new BeanPerson();
                person.setName(name);
                person.setLastName(lastName);
                person.setAge(Integer.parseInt(age)); //lo pasamos a int
                person.setEmail(email);
                person.setPhone(phone);


                    Date birthdaySDF = new SimpleDateFormat( "yyyy-MM-dd").parse(birthday);
                    person.setBirthday(birthdaySDF);

                    ResultAction result = servicePerson.savePerson(person, image);
                    urlRedirect = "/getPersons?=result="+ result.isResult()
                            + "&message=" + result.getMessage()
                            + "&status=" + result.getStatus();

                } catch (ParseException e) {
                    e.printStackTrace();

                }



                

                break;
            case "/updatePerson":
                String name2 = request.getParameter("name");
                String lastName2 = request.getParameter("lastName");
                String age2 = request.getParameter("age");
                String email2 = request.getParameter("email");
                String phone2 = request.getParameter("phone");
                String id = request.getParameter("id");

                BeanPerson person2 = new BeanPerson();
                person2.setName(name2);
                person2.setLastName(lastName2);
                person2.setAge(Integer.parseInt(age2));
                person2.setEmail(email2);
                person2.setPhone(phone2);
                person2.setId(Long.parseLong(id));

                ResultAction result2 = servicePerson.updatePerson(person2);
                urlRedirect = "/getPersons?=result="+ result2.isResult()
                        + "&message=" + result2.getMessage()
                        + "&status=" + result2.getStatus();
                break;
            case "/deletePerson":
                String id2 = request.getParameter("id");
                id2 = (id2 == null)?"0":id2;
                System.out.println("ID PERSONA -> " + id2 + " xd");
                //urlRedirect = "/getPersons";
                ResultAction result3 = servicePerson.deletePerson(Long.parseLong(id2));
                urlRedirect = "/getPersons?=result="+ result3.isResult()
                        + "&message=" + result3.getMessage()
                        + "&status=" + result3.getStatus();
                break;

            default:
                urlRedirect = "/getPersons";

        }
        //obtener la dirección de donde se hizo la pretición y contatenar urlRedirect, y lo redirecciona a getPersons
        response.sendRedirect(request.getContextPath() + urlRedirect);
        //http://localhost:8080/proyectoServlet_war_exploded/+urlRedirect
    }
}


//do get, obtener datos, hacer consultas
//do post, no muestra datos, hace inserciones

//request - petición
//respose - respuesta del servidor
