package JavaFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.exceptions.CsvValidationException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.opencsv.CSVReader;

public class CSVToJsonExample {
    public static void main(String[] args) throws CsvValidationException {
        String inputFilename = "example.csv";
        String outputFilename = "output.json";

        try (CSVReader reader = new CSVReader(new FileReader(inputFilename));
             FileWriter writer = new FileWriter(outputFilename)) {
            String[] header = reader.readNext();
            JSONArray jsonArray = new JSONArray();
            String[] line;
            while ((line = reader.readNext()) != null) {
                JSONObject jsonObject = new JSONObject();
                for (int i = 0; i < header.length; i++) {
                    jsonObject.put(header[i], line[i]);
                }
                jsonArray.put(jsonObject);
            }
            writer.write(jsonArray.toString());
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
