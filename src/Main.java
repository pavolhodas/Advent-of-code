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

        int a = 0;
        int b = 0;
        String[] splitter;
        ArrayList<String> binary1 = new ArrayList<>();
        ArrayList<String> binary0 = new ArrayList<>();
        ArrayList<String> binary = (ArrayList<String>) listOfInput;
        ArrayList<String> binaryy = new ArrayList<>();
        for(int n = 0; n < 12; n++){
            for(int i = 0; i < binary.size(); i++) {

                    splitter = binary.get(i).split("");
                if(Integer.parseInt(splitter[n]) == 1){
                    a++;
                    System.out.println(a);
                    binary1.add(binary.get(i));
                }else if(Integer.parseInt(splitter[n]) == 0){
                    b++;
                    binary0.add(binary.get(i));
                }

                if(a + b == binary.size()){
                    if(a > b){
                        binaryy = binary1;
                        //binary1.clear();
                        System.out.println(binary + "jjj");
                    }else if(a < b){
                        binaryy = binary0;
                        //binary0.clear();
                        System.out.println(binary + "nnn");
                    }
                    a=0;
                    b=0;
                    binary = binaryy;
                }

            }
            binary = binaryy;


            //System.out.println(binary1);
            //System.out.println(n);
            System.out.println(binary.size());
        }
    }
}
