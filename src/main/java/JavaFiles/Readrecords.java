package JavaFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Readrecords {
    List<List<String>> records = new ArrayList<>();
    String COMMA_DELIMITER = ",";



    public void readrecord() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader ("Beispieldatei.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
            records.forEach(System.out::println);

        }

    }
}
