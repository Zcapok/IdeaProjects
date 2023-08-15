package Datenspeicherung;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FilesUtil {
    public static Path createDirectory(Path pathObject) throws IOException {
        return Files.createDirectory(pathObject);
    }

    public static Path createDirectories(Path pathObject) throws IOException {
        return Files.createDirectories(pathObject);
    }

    public static Path createFile(Path aFile) throws IOException {
        return Files.createFile(aFile);
    }

    public static List<String> readAllLines(Path aFile, Charset encoding) throws IOException {
        return Files.readAllLines(aFile, encoding);
    }
}
