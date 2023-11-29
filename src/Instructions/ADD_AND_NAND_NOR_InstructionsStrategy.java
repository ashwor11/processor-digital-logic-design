package Instructions;

import java.util.ArrayList;
import Helpers.Helper;
public class ADD_AND_NAND_NOR_InstructionsStrategy implements IInstructionStrategy{

    private static final String ADDOPCODE = "0001";
    private static final String ANDOPCODE = "0010";
    private static final String NANDOPCODE = "0011";
    private static final String NOROPCODE = "0100";

    //18 bit

    /*
    4 opcode 17-14
    4 Destination Reg 13-10
    4 SRC1 Reg 9-6
    4 SRC2 Reg 5-2
    2 unused bits(00) 1-0
     */

    // Add R5 R0 R2
    @Override
    public String GenerateBinaryInstruction(ArrayList<String> elements) {

        switch (elements.get(0).toLowerCase()){
            case "add": break;

        }


        StringBuilder binaryString = new StringBuilder(18);

        binaryString.append(ADDOPCODE);



        return null;

    }



}
