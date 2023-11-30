package Helpers;

import java.io.*;
import java.util.ArrayList;

public class Helper {


    //Usable for register and immediate values
    public static String createBinaryStringForREG_UNSIGNED(String str, short desiredLength){

        str = str.toLowerCase();
        boolean flag = str.contains("r");


        if(flag){//register

            str = str.substring(1);

        }
        //immediate

        str = Integer.toBinaryString(Integer.parseInt(str));

        while(str.length()<desiredLength){
            str = "0" + str;
        }


        return str;
    }

    public static String createBinaryStringForSIGNED(String str, int desiredLength){
        str = str.toLowerCase();

        //immediate

        str = Integer.toBinaryString(Integer.parseInt(str));


        while(str.length()<desiredLength){
            str = "0" + str;
        }
        if(str.length()>desiredLength){
            str = str.substring(18);
        }

        return str;
    }

    public static ArrayList<String> convertBinaryInstructionsToHexInstructions(ArrayList<String> instructionsInBinary){
        ArrayList<String> instructionsInHexadecimal = new ArrayList<>();

        for(String instructionInBinary : instructionsInBinary){
            int number = Integer.parseInt(instructionInBinary,2);
            String instructionInHexadecimal = Integer.toHexString(number);
            while(instructionInHexadecimal.length()<5){
                instructionInHexadecimal = "0" + instructionInHexadecimal;
            }
            instructionsInHexadecimal.add(instructionInHexadecimal);
        }
        return  instructionsInHexadecimal;
    }

    public static void createMemoryFile(ArrayList<String> instructionInHexadecimal){


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("v2.0 raw")))) {



            for (String hexNumber : instructionInHexadecimal) {
                writer.write(hexNumber + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] hexStringToByteArray(String s) {
        return  null;
    }


}
