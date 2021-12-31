import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    List<String> listOfDataInput = new ArrayList<>();

    public static void main(String[] args) {

        Main main = new Main();

        String fileName = "E:\\pavol\\appslab2021\\input.txt";

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(main.listOfDataInput::add);

        } catch (IOException e) {
            e.printStackTrace();
        }
        main.result();
    }

    String co2Num = "";
    String oxygenNumber = "";

    public void oxygenRating() {

        List<String> listOfInput = new ArrayList<>(listOfDataInput);

        int previous = 0;
        ArrayList<String> binary1 = new ArrayList<>();
        ArrayList<String> binary0 = new ArrayList<>();

        int bitSize = listOfInput.get(0).length();

        for (int n = 0; n < bitSize; n++) {
            previous = 0;
            int c = 0;
            for (int i = 0; i < listOfInput.size(); i++) {

                c += Character.getNumericValue(listOfInput.get(i).charAt(n));
                if (c == previous) {
                    binary0.add(String.valueOf(listOfInput.get(i)));
                } else {
                    binary1.add(String.valueOf(listOfInput.get(i)));
                }
                previous = c;

            }
            if(n == 0){
                listOfInput.removeAll(binary0);
            } else if (binary0.size() > binary1.size()) {
                listOfInput.removeAll(binary1);
            } else {
                listOfInput.removeAll(binary0);
            }
            //System.out.println(listOfInput);
            oxygenNumber = listOfInput.get(0);
            //System.out.println(oxygenNumber);
            binary0.clear();
            binary1.clear();

        }
    }
    public void co2Rating () {

        List<String> listOfInput = new ArrayList<>(listOfDataInput);

        int previous = 0;
        ArrayList<String> binary1 = new ArrayList<>();
        ArrayList<String> binary0 = new ArrayList<>();

        int bitSize = listOfInput.get(0).length();

        for (int n = 0; n < bitSize; n++) {
            previous = 0;
            int c = 0;
            for (int i = 0; i < listOfInput.size(); i++) {

                c += Character.getNumericValue(listOfInput.get(i).charAt(n));
                if (c == previous) {
                    binary0.add(String.valueOf(listOfInput.get(i)));
                } else {
                    binary1.add(String.valueOf(listOfInput.get(i)));
                }
                previous = c;

            }

            if(n == 0){
                listOfInput.removeAll(binary1);
            } else if(listOfInput.size() == 1){
                //System.out.println(listOfInput);
            } else if (binary1.size() < binary0.size()) {
                listOfInput.removeAll(binary0);
            } else {
                listOfInput.removeAll(binary1);
            }
            co2Num = listOfInput.get(0);
            //System.out.println(listOfInput);

            binary0.clear();
            binary1.clear();

        }
    }

    public void result(){
        oxygenRating();
        co2Rating();
        System.out.println(Integer.parseInt(oxygenNumber, 2) * Integer.parseInt(co2Num, 2));

    }
}
