package cl.duoc.cmartinez.cinemasubsidiaries.domain;

public class Subsidiary {
    private int id;
    private String name;
    private String address;
    private String phone;
    private int capacity;
    private boolean active;

    public Subsidiary(int id, String name, String address, String phone, int capacity, boolean active) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.capacity = capacity;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isActive() {
        return active;
    }
}
