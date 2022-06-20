package src.main.java.com.ap.cdgen.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

  public static void writeToMarkdownFile(String fileName, String data) {
    File myObj = new File(fileName);
    try {
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e2) {
      e2.printStackTrace();
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
