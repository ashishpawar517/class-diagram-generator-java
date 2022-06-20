package src.main.java.com.ap.cdgen;

import src.main.java.com.ap.cdgen.utils.FileUtils;
import src.main.java.com.ap.cdgen.utils.GraphUtils;

public class Main {

  public static void main(String[] args) {
    String packagePath = "src.main.java.com.ap.cdgen.source";
    String markdownCode = GraphUtils.createGraph(packagePath);
    FileUtils.writeToMarkdownFile(
      "src/main/java/com/ap/cdgen/markdown/sample2.md",
      markdownCode
    );
  }
}
