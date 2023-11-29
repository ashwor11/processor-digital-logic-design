package Instructions;

import Helpers.Helper;

import java.util.ArrayList;

public class JUMPInstructionStrategy implements IInstructionStrategy {

    public final String OPCODE = "0111";
    @Override
    public String GenerateBinaryInstruction(ArrayList<String> elements) {
        String pcOffset = Helper.createBinaryStringForPcOffset(elements.get(1),14);

        return OPCODE + pcOffset;

    }
}
