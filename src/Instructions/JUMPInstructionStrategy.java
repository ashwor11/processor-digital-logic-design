package Instructions;

import Helpers.Helper;

import java.util.List;

public class JUMPInstructionStrategy implements IInstructionStrategy {

    public final String OPCODE = "0111";
    @Override
    public String GenerateBinaryInstruction(List<String> elements) {
        String pcOffset = Helper.createBinaryStringForSIGNED(elements.get(1),11);

        return OPCODE + pcOffset + "000";
    }
}
