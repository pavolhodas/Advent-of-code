import java.util.ArrayList;
import java.util.List;

public class tessstttt {
    List<String> listOfDataInput = new ArrayList<>();

    public static void main(String[] args) {

        tessstttt main = new tessstttt();

        main.listOfDataInput.add("00100");
        main.listOfDataInput.add("11110");
        main.listOfDataInput.add("10110");
        main.listOfDataInput.add("10111");
        main.listOfDataInput.add("10101");
        main.listOfDataInput.add("01111");
        main.listOfDataInput.add("00111");
        main.listOfDataInput.add("11100");
        main.listOfDataInput.add("10000");
        main.listOfDataInput.add("11001");
        main.listOfDataInput.add("00010");
        main.listOfDataInput.add("01010");
        main.result();
    }
    String co2Num = "";
    String oxygenNumber = "";

    public void oxygenRating() {
        List<String> listOfInput = new ArrayList<>();
        listOfInput = listOfDataInput;

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
            List<String> listOfInput = new ArrayList<>();
            listOfInput = listOfDataInput;

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


//        public void oxigen2(){
//
//                ArrayList<String> dataRaw = (ArrayList<String>) listOfInput;
//                int bitSize = dataRaw.get(0).length();
//                for (int i = 0; i < bitSize; i++) {
//                    int c = 0;
//                    for (String line : dataRaw) {
//                        c += Character.getNumericValue(line.charAt(i));
//                    }
//                    Boolean dominantBit = (c >= (dataRaw.size()/2.0));
//                    final int index = i;
//                    dataRaw.removeIf(line -> line.charAt(index) == (dominantBit?'0':'1'));
//                    if (dataRaw.size() == 1) break;
//                }
//                int rating = 0;
//                for (int i = 0; i < bitSize; i++)
//                {
//                    if (dataRaw.get(0).charAt(i) == '1') rating |= (1 << Math.abs(i-bitSize+1));
//                }
//            System.out.println(rating);
//
//        }
