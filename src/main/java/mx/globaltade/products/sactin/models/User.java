package mx.globaltade.products.sactin.models;

public class User {

    public String name;

    public String last_name;

    public String mail;

    public User() {
        super();
    }

    public User(String name, String last_name) {
        this.name = name;
        this.last_name = last_name;
    }

    public User(String name, String last_name, String mail) {
        this.name = name;
        this.last_name = last_name;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
