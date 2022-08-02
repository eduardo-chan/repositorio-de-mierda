package mx.edu.utez.proyectoservlet.model.person;

import mx.edu.utez.proyectoservlet.utils.MySQLConnection;

import java.io.InputStream;
import java.sql.*;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPerson {
    Connection conn;   //crear una conexión a la bd
    PreparedStatement pstm; // para preparar las consultas
    ResultSet rs; //para preparar los resultados que nos devuelvan las consultas


    //consultas
    private final String GET_PERSONS = "SELECT * FROM person";
    private final String INSERT_PERSON = "INSERT INTO person (name, lastName, age, email, phone, birthday, image)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String FIND_PERSON = "SELECT * FROM person WHERE id = ?";
    private final String UPDATE_PERSON = "UPDATE person SET name = ?, lastName = ?, age = ?, email = ?, phone = ?" +
            "WHERE id = ?";
    private final String DELETE_PERSON = "DELETE FROM person WHERE id = ?";


    //devolver una lista de personas, con lo que salga de la consulta, guarda
    public List<BeanPerson> showPersons (){
        List<BeanPerson> personList = new LinkedList<>();
        BeanPerson person = null; //obj para guardar y meter a la lista

        //
        try {
            conn = new MySQLConnection().getConnection(); //metodo que utilizamos para crear la conexión
            String query = GET_PERSONS;  //crea la sentencia
            pstm = conn.prepareStatement(query); //prepara la sentencia
            rs = pstm.executeQuery(); // ejecuta la sentencia
            while (rs.next()) {  //lo trae, verifica y recorre
                person = new BeanPerson(); // crea el obj en BeanPerson
                person.setId(rs.getLong("id"));
                person.setName(rs.getString("name"));
                person.setLastName(rs.getString("lastName"));
                person.setAge(rs.getInt("age"));
                person.setEmail(rs.getString("email"));
                person.setPhone(rs.getString("phone"));
                person.setBirthday(rs.getDate("birthday"));
                byte[] image = rs.getBytes("image");
                String imageSTR = Base64.getEncoder().encodeToString(image);
                person.setImage(imageSTR);
                //cada vez que llene el obj, lo añade a la lista
                personList.add(person);
            }
        }catch (SQLException e) {
            //logger - anuncios que dice la consola de lo que está pasando
            Logger.getLogger(DaoPerson.class.getName())
                    .log(Level.SEVERE, "Error en showPersons xd -> ", e); //obtener el nombre de la clase
        }finally { //cerrar las conexiones
            closeConnections();
        }
        return personList;

    }

    public boolean savePerson(BeanPerson person, InputStream image){
        try {
            conn = new MySQLConnection().getConnection();
            String query = INSERT_PERSON; //crea
            pstm = conn.prepareStatement(query); //prepara
            pstm.setString(1, person.getName()); //mandar texto como primer parámetro
            pstm.setString(2, person.getLastName());
            pstm.setInt(3, person.getAge());
            pstm.setString(4, person.getEmail());
            pstm.setString(5, person.getPhone());
            pstm.setDate(6, new Date(person.getBirthday().getTime()));
            pstm.setBlob(7, image);

            return pstm.executeUpdate()==1; //si es correcto devuelve un uno, si es erróneo devuelve 0
        }catch (SQLException e) {
            Logger.getLogger(DaoPerson.class.getName())
                    .log(Level.SEVERE, "error en savePerson -> ", e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public BeanPerson findPerson (Long id){
        try {
            conn = new MySQLConnection().getConnection();
            String query = FIND_PERSON;
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id); //pasamos parámetro
            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanPerson person = new BeanPerson();
                person.setId(rs.getLong("id"));
                person.setName(rs.getString("name"));
                person.setLastName(rs.getString("lastName"));
                person.setAge(rs.getInt("age"));
                person.setEmail(rs.getString("email"));
                person.setPhone(rs.getString("phone"));

                return person;
            }
        }catch (SQLException e) {
            Logger.getLogger(DaoPerson.class.getName())
                    .log(Level.SEVERE, "Error en findPerson xd -> ", e);
        }finally {
            closeConnections();
        }
        return null;

    }

    public boolean updatePerson(BeanPerson person){
        try {
            conn = new MySQLConnection().getConnection();
            String query =UPDATE_PERSON;
            pstm = conn.prepareStatement(query);
            pstm.setString(1, person.getName());
            pstm.setString(2, person.getLastName());
            pstm.setInt(3, person.getAge());
            pstm.setString(4, person.getEmail());
            pstm.setString(5, person.getPhone());
            pstm.setLong(6, person.getId());

            return pstm.executeUpdate()==1;
        }catch (SQLException e) {
            Logger.getLogger(DaoPerson.class.getName())
                    .log(Level.SEVERE, "error en updatePerson -> ", e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public boolean deletePerson(long id){
        try {
            conn = new MySQLConnection().getConnection();
            String query =DELETE_PERSON;
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id);

            return pstm.executeUpdate()==1;
        }catch (SQLException e) {
            Logger.getLogger(DaoPerson.class.getName())
                    .log(Level.SEVERE, "error en deletePerson -> ", e);
            return false;
        } finally {
            closeConnections();
        }
    }



    public void closeConnections() {
        try {
            if (conn != null) { //si tiene algo
                conn.close();
            }

            if (pstm != null) {
                pstm.close();
            }

            if (rs != null) {
                rs.close();
            }

        }catch (Exception e) {
            System.out.println(e + " xd ");
        }
    }

}








//bean, es una clase, representante de la tabla de nuestra bd
//dao, contiene todas las sentencias sql que apuntan a la bd