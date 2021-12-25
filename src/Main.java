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
        int sum = 0;
        int oldSum = 0;

        for (int a =  1; a < listOfInput.size(); a++) {
            sum = 0;
            for(int b = a; b <= a + 3; b++){
                if(b < listOfInput.size()) {
                    sum += Integer.parseInt(listOfInput.get(b));
                }
            }


            if(oldSum < sum && oldSum != 0){
                i++;

            }
            oldSum = sum;
        }
        System.out.println(i);
    }
}
