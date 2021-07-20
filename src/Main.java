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
            File log = new File(args[1] + i);
            FileWriter writer = new FileWriter(args[2] + i + ".csv");

            Scanner scan = new Scanner(log);
            try {
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    writer.write(
                            line.substring(0, line.indexOf("\t")).replace(" ", args[0])
                                    + line.substring(line.indexOf("\t")).replace("\t", args[0]) + "\n");
                    System.out.println(line);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
            writer.close();
        }
    }
}

