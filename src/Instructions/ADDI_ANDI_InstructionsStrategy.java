package Instructions;

import java.util.ArrayList;
import Helpers.Helper;

public class ADDI_ANDI_InstructionsStrategy implements IInstructionStrategy {

    private static final String ADDI_OPCODE = "0101";
    private static final String ANDI_OPCODE = "0110";
    private static final String UNUSED_SUFFIX = "00";

    /*
    4 opcode 17-14
    4 Destination Reg 13-10
    4 SRC1 Reg 9-6
    6 Immediate Value 5-0
    2 unused bits(00) 1-0
     */

    @Override
    public String GenerateBinaryInstruction(ArrayList<String> elements) {

        StringBuilder binaryString = new StringBuilder(18);

        switch (elements.get(0).toLowerCase()) {
            case "addi":
                binaryString.append(ADDI_OPCODE);
                break;
            case "andi":
                binaryString.append(ANDI_OPCODE);
                break;
            default:
                System.out.println("Unsupported operation");
                break;
        }

        for (int i = 1; i < elements.size() - 1; i++) {
            binaryString.append(Helper.createBinaryStringForREG_IMM(
                    elements.get(i), (short) 4
            ));
        }

        // Assuming the last element is the immediate value
        binaryString.append(Helper.createBinaryStringForREG_IMM(
                elements.get(elements.size() - 1), (short) 6
        ));

        binaryString.append(UNUSED_SUFFIX);

        return binaryString.toString();
    }
}
