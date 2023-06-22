package de.stan;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WindowsKeyReader {
    public static void main(String[] args) {
        try {
            String command = "cmd /c slmgr /dli | find \"Product Key\"";
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Product Key")) {
                    String windowsKey = line.split(":")[1].trim();
                    System.out.println("Windows-Schlüssel: " + windowsKey);
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}