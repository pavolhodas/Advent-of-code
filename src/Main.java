import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    List<String> listOfInput = new ArrayList<>();

    public static void main(String[] args) {

        Main main = new Main();

        String fileName = "E:\\pavol\\appslab2021\\input.txt";

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(main.listOfInput::add);

        } catch (IOException e) {
            e.printStackTrace();
        }
        main.isIncreased();
    }

    public void isIncreased() {

        int forwardByAim = 0;
        int forward = 0;
        int down = 0;
        int up = 0;

        int i = 0;
        String[] splitString;

        for (int a =  0; a < listOfInput.size(); a++) {
            splitString = listOfInput.get(a).split(" ");

            if(splitString[0].equals("forward")){
                forward += Integer.parseInt(splitString[1]);
                forwardByAim += Integer.parseInt(splitString[1]) * (down - up);

            } else if(splitString[0].equals("down")){
                down += Integer.parseInt(splitString[1]);

            }  else if(splitString[0].equals("up")){
                up += Integer.parseInt(splitString[1]);
            }
        }
        System.out.println(forwardByAim * forward);
    }
}
