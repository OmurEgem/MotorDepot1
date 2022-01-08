package com.company;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson  GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./autopark.json");

    public static void main(String[] args) {
        Autopark[] autoparks = {
                Autopark.makeAutoPark(1,"Renault M","",Base.ON_BASE),
                Autopark.makeAutoPark(2,"Volvo    ","",Base.ON_BASE),
                Autopark.makeAutoPark(3,"DAF XT   ","",Base.ON_BASE)
        };


        String json = GSON.toJson(autoparks);
        write(json);
        System.out.println(readJs());
        System.out.println("#  | Bus       |  Driver  |  State");
        System.out.println();
        System.out.println("---+-----------+----------+--------");
        Autopark [] autoparks1 = GSON.fromJson(readJs(),Autopark[].class);
        for (Autopark a: autoparks1
        ) {
            System.out.println(a.toString());

        }

    }
        private static void write(String obj) {
        Path write = Paths.get(String.valueOf(WRITE_PATH));

        try{
        Files.writeString(write, obj, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    private static String readJs(){
        String json = "";
        try {
            FileReader fileReader = new FileReader(String.valueOf(WRITE_PATH));
            int a ;
            while ((a=fileReader.read()) != -1){
                json+=(char)a;
            }
            return json;
        } catch (Exception e){
            e.printStackTrace();
        }
        return json;
    }
}
