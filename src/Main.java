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

        int previous = 0;
        int i = 0;

        for (int a =  0; a < listOfInput.size(); a++) {
            if(previous < Integer.parseInt(listOfInput.get(a))){
                i++;
                System.out.println(Integer.parseInt(listOfInput.get(a)));
            }
            previous = Integer.parseInt(listOfInput.get(a));
        }
        System.out.println(i-1);
    }
}
