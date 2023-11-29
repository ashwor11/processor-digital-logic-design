package Instructions;

import java.util.ArrayList;

public class ADDInstructionStrategy implements IInstructionStrategy{

    private static final String OPCODE = "0001";

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

        StringBuilder binaryString = new StringBuilder(18);

        binaryString.append(OPCODE);

        //binaryString.

        return null;

    }



}
