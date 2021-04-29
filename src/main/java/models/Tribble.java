package models;

public class Tribble {
    private int id;
    private String name;
    private int age;
    private Lab lab;

    public Tribble(int id, String name, int age, Lab lab) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.lab = lab;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Lab getLab() {
        return lab;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }
}
