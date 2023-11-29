package Helpers;

public class Helper {


    //Usable for register and immediate values
    public static String createBinaryStringForREG_IMM(String str,short desiredLength){

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

    public static String createBinaryStringForPcOffset(String str,int desiredLength){
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


}
