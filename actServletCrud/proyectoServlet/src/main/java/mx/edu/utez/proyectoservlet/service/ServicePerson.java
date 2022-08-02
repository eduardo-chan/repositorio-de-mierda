package mx.edu.utez.proyectoservlet.service;

import mx.edu.utez.proyectoservlet.model.person.BeanPerson;
import mx.edu.utez.proyectoservlet.model.person.DaoPerson;
import mx.edu.utez.proyectoservlet.utils.ResultAction;

import java.io.InputStream;
import java.util.List;

public class ServicePerson {
    DaoPerson daoPerson = new DaoPerson();

    public List<BeanPerson> showPersons(){
        return daoPerson.showPersons();
    }

    public ResultAction savePerson(BeanPerson person, InputStream image){
        ResultAction result = new ResultAction();
        if (daoPerson.savePerson(person, image)){ //si la inserción se hizo correctamente devuelve o hace algo
            result.setResult(true);
            result.setMessage("persona registrada correctamente :)"); //no jala esta madre
            result.setStatus(200); //código 200todo oki
        }else {
            result.setResult(false);
            result.setMessage("error al registrar persona :(");
            result.setStatus(400); //código 400 error de servidor
        }
        return result;
    }

    public BeanPerson findPerson(Long id){
        return daoPerson.findPerson(id);
    }

    public ResultAction updatePerson(BeanPerson person){
        ResultAction result = new ResultAction();
        if (daoPerson.updatePerson(person)){
            result.setResult(true);
            result.setMessage("persona modificada correctamente :)");
            result.setStatus(200);
        }else {
            result.setResult(false);
            result.setMessage("error al modificar persona :(");
            result.setStatus(400);
        }
        return result;
    }

    public ResultAction deletePerson(long id){
        ResultAction result = new ResultAction();
        if (daoPerson.deletePerson(id)){
            result.setResult(true);
            result.setMessage("persona modificada correctamente :)");
            result.setStatus(200);
        }else {
            result.setResult(false);
            result.setMessage("error al modificar persona :(");
            result.setStatus(400);
        }
        return result;
    }

}




//hace la comunicación entre dao y el servlet
// si se tiene que hacer algun cambio en la info que se está manipulando, se puede hacer en el service
//antes de que pase al dao, en lugar de meter muchas cosas al servlet





//dao, bean, bd - modelo
//jsp - vista
//servlet, service - controlador
