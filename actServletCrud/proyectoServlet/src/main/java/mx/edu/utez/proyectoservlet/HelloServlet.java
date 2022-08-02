package mx.edu.utez.proyectoservlet;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> acabo de modificar el sevlet</h1>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th>Nombre</th>");
        out.println("<th>Apellido</th>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}