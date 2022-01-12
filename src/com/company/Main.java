package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./autopark.json");
    public static final Path WRITE_PATH1 = Paths.get("./driver.json");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Autopark[] autoparks = {
                Autopark.makeAutoPark(1, "Renault M", "", "Base"),
                Autopark.makeAutoPark(2, "Volvo    ", "", "Base"),
                Autopark.makeAutoPark(3, "DAF XT   ", "", "Base")
        };
        Drivers[] drivers = {
                Drivers.makeDriver("dr1", "Petr"),
                Drivers.makeDriver("dr2", "Askar"),
                Drivers.makeDriver("dr3", "Uson"),
        };
        String json = GSON.toJson(autoparks);
        String json1 = GSON.toJson(drivers);
        write(json, json1);


        preview(autoparks);
        System.out.println("Выбери авто оп id и посмотри описание :");
        chooseVariant(autoparks, drivers);

    }

    private static void serviceStart(Autopark[] autoparks, Drivers[] drivers) throws Exception {
        System.out.println("Выбери машину id:");
        int press = scanner.nextInt();
        switch (press) {
            case 1:
                System.out.println("Выбери водителя id:");

                int press1 = scanner.nextInt();

                switch (press1) {
                    case 1:
                        autoparks[0].setDriver(drivers[0].getDriverName());
                        preview(autoparks);

                        break;
                    case 2:
                        autoparks[0].setDriver(drivers[1].getDriverName());
                        preview(autoparks);

                        break;
                    case 3:
                        autoparks[0].setDriver(drivers[2].getDriverName());
                        preview(autoparks);

                        break;

                    default:
                        throw new Exception(" Используйте только 1,2,3 ");
                }
            case 2:
                System.out.println("Выбери водителя id:");
                int press2 = scanner.nextInt();
                switch (press2) {
                    case 1:
                        autoparks[1].setDriver(drivers[0].getDriverName());
                        preview(autoparks);
                        sVybor(autoparks, drivers);

                        break;
                    case 2:
                        autoparks[1].setDriver(drivers[1].getDriverName());
                        preview(autoparks);
                        sVybor(autoparks, drivers);

                        break;
                    case 3:
                        autoparks[1].setDriver(drivers[2].getDriverName());
                        preview(autoparks);
                        sVybor(autoparks, drivers);

                        break;

                    default:
                        throw new Exception(" Используйте только 1,2,3 ");


                }
            case 3:
                System.out.println("Выбери водителя id:");
                int press3 = scanner.nextInt();
                switch (press3) {
                    case 1:
                        autoparks[2].setDriver(drivers[0].getDriverName());
                        preview(autoparks);
                        sVybor(autoparks, drivers);
                        break;
                    case 2:
                        autoparks[2].setDriver(drivers[1].getDriverName());
                        preview(autoparks);
                        sVybor(autoparks, drivers);
                        break;
                    case 3:
                        autoparks[2].setDriver(drivers[2].getDriverName());
                        preview(autoparks);
                        sVybor(autoparks, drivers);
                        break;
                    default:
                        throw new Exception(" Используйте только 1,2,3 ");
                }
                break;
            default:
                throw new Exception(" Используйте только 1,2,3 ");
        }
    }
    private static void sVybor(Autopark[] autoparks, Drivers[] drivers) throws Exception {
        System.out.println("""
                \nPress 1 to change Driver
                Press 2 to send to the Route
                Press 3 to send to the Repairing
                Press 4 choose other truck""");
        int press = scanner.nextInt();

        switch (press) {

            case 1:
                int press1 = scanner.nextInt();
                switch (press1) {
                    case 1:
                        autoparks[0].setBase(autoparks[0].sendBase());
                        previewDr(drivers);
                        serviceStart(autoparks, drivers);
                        sVybor(autoparks, drivers);
                        break;
                    case 2:
                        autoparks[0].setBase(autoparks[0].sendRoad());
                        preview(autoparks);
                        sVybor(autoparks, drivers);
                        break;
                    case 3:
                        autoparks[0].setBase(autoparks[0].sendRepair());
                        preview(autoparks);
                        sVybor(autoparks, drivers);
                        break;
                    default:
                        throw new Exception(" Используйте только 1,2,3 ");
                }
            case 2:
                int press2 = scanner.nextInt();
                switch (press2) {
                    case 1:
                        autoparks[1].setBase(autoparks[1].sendBase());
                        previewDr(drivers);
                        serviceStart(autoparks, drivers);
                        sVybor(autoparks, drivers);
                        break;
                    case 2:
                        autoparks[1].setBase(autoparks[1].sendRoad());
                        preview(autoparks);
                        sVybor(autoparks, drivers);
                        break;
                    case 3:
                        autoparks[1].setBase(autoparks[1].sendRepair());
                        preview(autoparks);
                        sVybor(autoparks, drivers);
                        break;
                    default:
                        throw new Exception(" Используйте только 1,2,3 ");
                }
            case 3:
                int press3 = scanner.nextInt();
                switch (press3) {
                    case 1:
                        autoparks[2].setBase(autoparks[2].sendBase());
                        previewDr(drivers);
                        serviceStart(autoparks, drivers);
                        sVybor(autoparks, drivers);
                        break;
                    case 2:
                        autoparks[2].setBase(autoparks[2].sendRoad());
                        preview(autoparks);
                        sVybor(autoparks, drivers);
                        break;
                    case 3:
                        autoparks[2].setBase(autoparks[2].sendRepair());
                        preview(autoparks);
                        sVybor(autoparks, drivers);
                        break;
                    default:
                        throw new Exception(" Используйте только 1,2,3 ");
                }
            case 4:
                preview(autoparks);
                System.out.println("Выбери авто оп id :");
                chooseVariant(autoparks, drivers);
                break;
        }
    }
    private static void chooseVariant(Autopark[] autoparks, Drivers[] drivers) throws Exception {
        int press = scanner.nextInt();

        switch (press) {

            case 1:
                System.out.println("\nN          : " + autoparks[0].getId()
                        + "\nBus        : " + autoparks[0].getName()
                        + "\nDriver     : "
                        + "\nBus State  : " + autoparks[0].getBase());
                previewDr(drivers);
                serviceStart(autoparks, drivers);
                break;
            case 2:
                System.out.println("\nN          : " + autoparks[1].getId()
                        + "\nBus        : " + autoparks[1].getName()
                        + "\nDriver     : "
                        + "\nBus State  : " + autoparks[1].getBase());
                previewDr(drivers);
                serviceStart(autoparks, drivers);
                break;


            case 3:
                System.out.println("\nN          : " + autoparks[2].getId()
                        + "\nBus        : " + autoparks[2].getName()
                        + "\nDriver     : "
                        + "\nBus State  : " + autoparks[2].getBase());
                previewDr(drivers);
                serviceStart(autoparks, drivers);

                break;

            default:
                throw new Exception(" Используйте только 1,2,3 ");

        }
    }

    private static void preview(Autopark[] autoparks) {
        System.out.println("---------TRUCK---INF--------");
        System.out.println("# |Bus\t\t|Driver\t|State");
        System.out.println("--+---------+-------+-----");
        System.out.println(autoparks[0].toString());
        System.out.println(autoparks[1].toString());
        System.out.println(autoparks[2].toString());
    }

    private static void previewDr(Drivers[] drivers) {
        System.out.println("---------DRIVER---INF--------");
        System.out.println("# |Driver\t\t|Bus\t");
        System.out.println("--+-------------+-------+");
        System.out.println(drivers[0].toString());
        System.out.println(drivers[1].toString());
        System.out.println(drivers[2].toString());
    }

    private static void write(String obj, String obj1) {
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        Path write1 = Paths.get(String.valueOf(WRITE_PATH1));
        try {
            Files.writeString(write, obj, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            Files.writeString(write1, obj1, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
