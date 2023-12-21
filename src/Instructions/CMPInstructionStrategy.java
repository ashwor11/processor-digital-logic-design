package Instructions;

import Helpers.Helper;

import java.util.List;

public class CMPInstructionStrategy implements IInstructionStrategy{

    public final String OPCODE = "1010";
    public final String SUFFIX = "000000";
    @Override
    public String GenerateBinaryInstruction(List<String> elements) {
        String op1 = Helper.createBinaryStringForREG_UNSIGNED(elements.get(1), (short) 4);
        String op2 = Helper.createBinaryStringForREG_UNSIGNED(elements.get(2), (short) 4);

        return OPCODE + op1 + op2 + SUFFIX;


    }
}
