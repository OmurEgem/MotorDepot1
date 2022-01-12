package com.company;

import java.util.UUID;

public class Drivers extends Autopark {
   private String uniqueID ;
    private String driverName;




    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }


    public static Drivers makeDriver(String id,String driverName){
        Drivers driver = new Drivers();
        driver.uniqueID = id;
        driver.driverName = driverName;


        return driver;
    }

    @Override
    public String toString() {
        return uniqueID +"    "+ driverName +"    "+super.getBase()  ;
    }
}
