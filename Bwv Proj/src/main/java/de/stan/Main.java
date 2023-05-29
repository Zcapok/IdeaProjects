package de.stan;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {

        Readrecords buffreader = new Readrecords();
        buffreader.readrecord();



        String path = "Beispieldatei.csv";
        ArrayList<String> read = new ArrayList<>();
        ReadCsv reader = new ReadCsv();
        try {
            for (String s : reader.readCSV(path)) {
                read.add(s);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(read);



        JSONArray list = new JSONArray();
        list.add(read);

        try (FileWriter file = new FileWriter("Json.json")) {
            file.write(list.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
