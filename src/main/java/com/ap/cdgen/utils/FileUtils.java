package src.main.java.com.ap.cdgen.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

  public static void writeToMarkdownFile(String fileName, String data) {
    Path path = Paths.get(fileName);

    try {
      Files.createDirectories(path.getParent());
    } catch (IOException e2) {
      e2.printStackTrace();
    }

    try {
      Files.createFile(path);
    } catch (IOException e) {
      System.err.println("already exists: " + e.getMessage());
    }
    FileWriter myWriter = null;
    try {
      myWriter = new FileWriter(fileName);
      myWriter.write(data);
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    try {
      myWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
