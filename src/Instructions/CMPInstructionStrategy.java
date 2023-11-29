package Instructions;

import Helpers.Helper;

import java.util.ArrayList;

public class CMPInstructionStrategy implements IInstructionStrategy{

    public final String OPCODE = "1010";
    public final String SUFFIX = "00000";
    @Override
    public String GenerateBinaryInstruction(ArrayList<String> elements) {
        String op1 = Helper.createBinaryStringForREG_IMM(elements.get(1), (short) 4);
        String op2 = Helper.createBinaryStringForREG_IMM(elements.get(2), (short) 4);

        return OPCODE + op1 + op2 + SUFFIX;


    }
}
