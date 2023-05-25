package de.stan;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JasonSimpleWriter {


    public static void main(String[] args) {

        JSONObject obj = new JSONObject();
        obj.put("name", "stan");
        obj.put("age", 100);

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.put("messages", list);

        try (FileWriter file = new FileWriter("C:\\Users\\soulw\\IdeaProjects\\Bwv Proj\\src\\main\\java\\de\\stan\\Beispieldatei.csv")) {
            file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);

    }


}
