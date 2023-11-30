package Instructions;

import java.util.List;

import Helpers.Helper;

public class ADDI_ANDI_InstructionsStrategy implements IInstructionStrategy {

    private static final String ADDI_OPCODE = "0101";
    private static final String ANDI_OPCODE = "0110";

    /*
    4 opcode 17-14
    4 Destination Reg 13-10
    4 SRC1 Reg 9-6
    6 Immediate Value 5-0
    2 unused bits(00) 1-0
     */

    @Override
    public String GenerateBinaryInstruction(List<String> elements) {

        StringBuilder binaryString = new StringBuilder(18);
        String str = elements.get(0);
        switch (str) {
            case "ADDI":
                binaryString.append(ADDI_OPCODE);
                break;
            case "ANDI":
                binaryString.append(ANDI_OPCODE);
                break;
            default:
                System.out.println("Unsupported operation");
                break;
        }

        for (int i = 1; i < elements.size() - 1; i++) {
            binaryString.append(Helper.createBinaryStringForREG_UNSIGNED(
                    elements.get(i), (short) 4
            ));
        }

        // Assuming the last element is the immediate value
        binaryString.append(Helper.createBinaryStringForSIGNED(
                elements.get(elements.size() - 1), (short) 6
        ));


        return binaryString.toString();
    }
}
