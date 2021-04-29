package models;

public class Lab {
    private int id;
    private String location;
    private int capacity;

    public Lab(int id, String location, int capacity) {
        this.id = id;
        this.location = location;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
