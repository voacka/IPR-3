import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//task3:
//        args[0] = ";"
//        args[1] = "D:\\IT\\IPR\\Java\\logs_parsed\\main.log.2014-11-17-parsed-"
//        args[2] = "D:\\IT\\IPR\\Java\\logs_csv\\main.log.2014-11-17-"

public class Main {

    public static void main(String[] args) throws IOException {

        for (int i = 1; i < 6; i++) {
            File log = new File("D:\\IT\\IPR\\Java\\logs_parsed\\main.log.2014-11-17-parsed-" + i);
            FileWriter writer = new FileWriter("D:\\IT\\IPR\\Java\\logs_csv\\main.log.2014-11-17-" + i + ".csv");

            Scanner scan = new Scanner(log);
            try {
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    line = line.replace(";", " ");
                    try {
                        writer.write(
                                line.substring(0, line.indexOf("\t")).replace(" ", ";")
                                        + line.substring(line.indexOf("\t")).replace("\t", ";") + "\n");
                    } catch (IndexOutOfBoundsException e) {
                        writer.write(line.substring(0, 10) + ";"
                                + line.substring(11, 23) + ";"
                                + line.substring(24, 30) + ";"
                                + line.substring(31) + "\n");
                    }
                    System.out.println(line);
                }
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
            writer.close();
        }
    }
}

