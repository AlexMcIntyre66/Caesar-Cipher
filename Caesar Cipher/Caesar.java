/**
 * The Caesar Cipher
 * 
 * @author Alex McIntyre
 * @version 1.0
 * 
 */
public class Caesar {
    public static void main(String[] args){
        /**
         * This checks the length of the arguments, if it's more than 1 argument, it lets the user know it's too many
         * 
         * If it's too few it lets them know they're not inputted enough
         * 
         * Otherwise it'll run rotate methose depending if a character is input, or a string is input, and output the answer to the console
         */
        if(args.length > 2){
            System.out.println("Too many parameters! \nUsage: java Caesar n \"cipher text\"");
        }
        else if (args.length < 2){
            System.out.println("Too few parameters!\nUsage: java Caesar n \"cipher text\"");
        }
        else{
            System.out.println(rotate(Integer.parseInt(args[0]), args[1]));
        }
    
    }

    public static char rotate(int shift, char charRotate){
        /**
         * This method takes a character and rotates it by the given integer
         * 
         * It turns the character into a variable, if the variable is between 96 and 123 it's a lower case letter and calculates it as such
         * 
         * If it's between 64 and 91 it's a upper case character and will be calculated as such
         * 
         * If it's between neither of these values it should be returned as it is with no changes
         * 
         */
        char output = 'a';
        int intChar = charRotate;
        int moveTo = intChar + shift;

        if(intChar> 96 && intChar<123){
            while(moveTo > 122){
                moveTo = (96+((moveTo) - 122));
            }
            output = (char) moveTo;
        }
        else if(intChar> 64 && intChar<91){
            while(moveTo > 90){
                moveTo = (64+((moveTo) - 90));
            }
            output = (char) moveTo;
         }
         else{
             output = charRotate;
         }
        return output;
    } 
    
    public static String rotate(int shift, String stringRotate){

        /**
         * This takes a full string and looks through each charater in the string
         * 
         * It will then take each charater in the string and pass it into the above method and rotate it the input integer value to rotate
         * 
         * It then takes the output from that module and appends it to the current output string
         * 
         * It will then output that string once it has rotated through the full string.
         * 
         */
        String output = "";

        for(int i=0; i<stringRotate.length(); i++){
            output += rotate(shift, stringRotate.charAt(i));
        }

        return output;
    }

}
