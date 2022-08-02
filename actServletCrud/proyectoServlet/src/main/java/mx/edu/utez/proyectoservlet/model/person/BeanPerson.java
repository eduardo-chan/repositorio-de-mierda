package mx.edu.utez.proyectoservlet.model.person;

import java.util.Date;

public class BeanPerson {
    private long id;
    private String name;
    private String lastName;
    private String email;
    private int age;
    private String phone;   //nuestro obj, tabla

    private Date birthday;

    private String image;   //cuando tenga a mi obj, lo ocupo

    public BeanPerson() {
    }

    public BeanPerson(long id, String name, String lastName, String email, int age, String phone, Date birthday) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.phone = phone;
        this.birthday = birthday;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {return birthday;}

    public void setBirthday(Date birthday) {this.birthday = birthday;}

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}














//beanPerson - representacion de nuestra tabla en bd


















