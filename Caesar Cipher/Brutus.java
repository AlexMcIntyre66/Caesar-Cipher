import java.util.Arrays;
/**
 * The Caesar Cipher
 * 
 * @author Alex McIntyre
 * @version 1.0
 * 
 */
public class Brutus {


    public static void main(String[] args){

        /**
         * This main method takes a string argument in an array, converts it into a string and removes the square brackets
         * It then creates to arrays for the chi values of the strings and an array for the strings that it will be compared against
         * 
         * It keeps a track of the lowest chi score and whichever string has the lowest chi score, it will output
         * 
         */

        String input = Arrays.toString(args);
        input = input.replace("[","");
        input = input.replace("]","");
        double[] chiValues = new double[26];
        String[] stringList = new String[26];
        double lowestChi = Integer.MAX_VALUE;
        int lowestChiPos = 0; 
        
        

        for(int i =0; i < 26; i++){
            stringList[i] = Caesar.rotate(i, input);
            chiSquared(frequency(stringList[i]), english);
            chiValues[i] = chiSquared(frequency(stringList[i]), english);
        }

        for (int j =0; j < 26; j++){
            if (chiValues[j] < lowestChi){
                lowestChi = chiValues[j];
                lowestChiPos = j;
            }
        }
        String output =stringList[lowestChiPos];
        System.out.println(output);

    }



    public static int[] count(String input){
        /**
         * This method counts how many times each letter appears in the string and puts this into an array of the length of the string and outputs the array
         * 
         */
        int[] count = new int[26];

            for(int j=0; j < input.length();j++){
                char letter = (input.charAt(j));
                letter = Character.toLowerCase(letter);
                switch(letter){
                    case 'a':
                        count[0] += 1;
                        break;
                    case 'b':
                        count[1] += 1;
                        break;
                    case 'c':
                        count[2] += 1;
                        break;
                    case 'd':
                        count[3] += 1;
                        break;
                    case 'e':
                        count[4] += 1;
                        break;
                    case 'f':
                        count[5] += 1;
                        break;
                    case 'g':
                        count[6] += 1;
                        break;
                    case 'h':
                        count[7] += 1;
                        break;
                    case 'i':
                        count[8] += 1;
                        break;
                    case 'j':
                        count[9] += 1;
                        break;
                    case 'k':
                        count[10] += 1;
                        break;
                    case 'l':
                        count[11] += 1;
                        break;
                    case 'm':
                        count[12] += 1;
                        break;
                    case 'n':
                        count[13] += 1;
                        break;
                    case 'o':
                        count[14] += 1;
                        break;
                    case 'p':
                        count[15] += 1;
                        break;
                    case 'q':
                        count[16] += 1;
                        break;
                    case 'r':
                        count[17] += 1;
                        break;
                    case 's':
                        count[18] += 1;
                        break;
                    case 't':
                        count[19] += 1;
                        break;
                    case 'u':
                        count[20] += 1;
                        break;
                    case 'v':
                        count[21] += 1;
                        break;
                    case 'w':
                        count[22] += 1;
                        break;
                    case 'x':
                        count[23] += 1;
                        break;
                    case 'y':
                        count[24] += 1;
                        break;
                    case 'z':
                        count[25] += 1;
                        break;
                }
        }
        
        return count;
    }


    public static double[] frequency(String input){

        /**
         * This methose takes in the string from the user and calculates the frequency of each letter used and outputs it in an array
         * 
         */
        double[] frequency = new double[26];
        int[] count = count(input);
        String word = input.toString();
        double length = word.length();
        


        for(int i=0; i<26; i++){
            frequency[i] = (count[i]/length);
        }

        return frequency;
    }

    public static double chiSquared(double[] input, double[] english){

        /** 
         * This takes a frequency table from the input word and compares it against the frequency table defined by the english language
         * 
         * This then runs the chi squared calculation using both sets of values across the entire array
         * 
         * and outputs the chi squared for the inputted string.
         * 
         */
        double output = 0;

        for(int i=0; i < 26; i++){
            output += (Math.pow((input[i]-english[i]),2)/english[i]);
        }

        return output;
    }

    public static final double[] english = {
        0.0855, 0.0160, 0.0316, 0.0387, 0.1210, 0.0218, 0.0209, 0.0496, 0.0733,
        0.0022, 0.0081, 0.0421, 0.0253, 0.0717, 0.0747, 0.0207, 0.0010, 0.0633,
        0.0673, 0.0894, 0.0268, 0.0106, 0.0183, 0.0019, 0.0172, 0.0011
    };
}
