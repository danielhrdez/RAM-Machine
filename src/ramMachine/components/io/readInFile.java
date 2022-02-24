package ramMachine.components.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class readInFile {
  private Scanner input;

  public readInFile(String fileName) {
    try {
      input = new Scanner(new File(fileName));
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
  }

  public String read() {
    if (input.hasNext()) {
      return input.next();
    } else {
      return null;
    }
  }
}