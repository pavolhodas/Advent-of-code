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

    public static void main(String args[]) {

        Main main = new Main();

        String fileName = "E:\\pavol\\appslab2021\\input.txt";

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(main.listOfInput::add);

        } catch (IOException e) {
            e.printStackTrace();
        }
        main.isValid();
    }

    private int valid;
    HashMap<String, String> passportData = new HashMap<String, String>();

    public void isValid() {
        List<String> listOfElements;

        for (int i = 0; i < listOfInput.size(); i++) {
            listOfElements = Arrays.asList(listOfInput.get(i).split(" "));

            for (int a = 0; a < listOfElements.size(); a++) {


                String[] parts = listOfElements.get(a).split(":");

                if (!listOfElements.get(a).isEmpty()) {
                    passportData.put(parts[0], parts[1]);
                }
                if (passportData.size() == 8) {
                    valid = valid + 1;
                    passportData.clear();
                } else if (passportData.size() == 7 && !passportData.containsKey("cid")) {
                    valid = valid + 1;
                    passportData.clear();
                } else if (listOfElements.get(a).isEmpty()) {
                    passportData.clear();
                    System.out.println(valid);
                }
                System.out.println(listOfElements.get(a));
            }
        }
        System.out.println(valid);
    }
}
