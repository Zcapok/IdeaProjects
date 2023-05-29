package JavaFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVreader {
    public static void main(String[] args) {
        String fileName = "example.csv";
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        // Factory method to decide whether to read, write or create the file
        CSVFactory factory = new CSVFactory();
        CSV csv = factory.createCSV("read", fileName);
        csv.read(lines);
    }
}

class CSVFactory {
    public CSV createCSV(String type, String fileName) {
        if (type.equalsIgnoreCase("read")) {
            return new CSVReader(fileName);
        } else if (type.equalsIgnoreCase("write")) {
            return new CSVWriter(fileName);
        } else if (type.equalsIgnoreCase("create")) {
            return new CSVCreator(fileName);
        } else {
            return null;
        }
    }
}

interface CSV {
    void read(List<String> lines);

    void write(List<String> lines);

    void create();
}

class CSVReader implements CSV {
    private String fileName;

    public CSVReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void read(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }

    @Override
    public void write(List<String> lines) {

    }

    @Override
    public void create() {

    }
}

class CSVWriter implements CSV {
    private String fileName;

    public CSVWriter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void read(List<String> lines) {

    }

    @Override
    public void write(List<String> lines) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String line : lines) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + fileName);
        }
    }

    @Override
    public void create() {

    }
}

class CSVCreator implements CSV {
    private String fileName;

    public CSVCreator(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void read(List<String> lines) {

    }

    @Override
    public void write(List<String> lines) {

    }

    @Override
    public void create() {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Header 1,Header 2,Header 3\n");
            writer.write("Value 1,Value 2,Value 3\n");
            writer.write("Value 4,Value 5,Value 6\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + fileName);
        }
    }
}

