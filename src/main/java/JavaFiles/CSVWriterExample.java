package JavaFiles;

import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class CSVWriterExample {
    public static void main(String[] args) {
        String[] header = { "Name", "Age", "City" };
        String[] data1 = { "John", "25", "New York" };
        String[] data2 = { "Jane", "30", "Los Angeles" };

        try (CSVWriter writer = new CSVWriter(new FileWriter("example.csv"))) {
            writer.writeNext(header);
            writer.writeNext(data1);
            writer.writeNext(data2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
