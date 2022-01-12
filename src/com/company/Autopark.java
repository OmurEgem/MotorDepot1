package com.company;

public class Autopark {
    private int id;
    private String name;
    private String driver;
    private String base;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public static Autopark makeAutoPark(int id, String name, String driver, String base){
        Autopark autopark = new Autopark();
        autopark.id = id;
        autopark.name= name;
        autopark.driver=driver;
        autopark.base = base;

        return autopark;
    }


    public String sendRoad() {

        return base = "Route";
    }

    public String sendRepair() {

        return base = "Repair";
    }

    public String sendBase() {

        return base = "Base";
    }
    @Override
    public String toString() {
        return   id+"   " + name +"      "+ driver+"          " + base ;
    }
}
