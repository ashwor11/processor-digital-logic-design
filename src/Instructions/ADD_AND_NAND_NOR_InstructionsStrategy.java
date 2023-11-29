package Instructions;

import java.util.ArrayList;
import java.util.List;

import Helpers.Helper;
public class ADD_AND_NAND_NOR_InstructionsStrategy implements IInstructionStrategy{

    private static final String ADDOPCODE = "0001";
    private static final String ANDOPCODE = "0010";
    private static final String NANDOPCODE = "0011";
    private static final String NOROPCODE = "0100";
    private static final String UNUSED_SUFFIX="00";
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
    public String GenerateBinaryInstruction(List<String> elements) {

        StringBuilder binaryString = new StringBuilder(18);

        switch (elements.get(0).toLowerCase()){
            case "add": binaryString.append(ADDOPCODE);
                break;
            case "and": binaryString.append(ANDOPCODE);
                break;
            case "nand": binaryString.append(NANDOPCODE);
                break;
            case "nor":  binaryString.append(NOROPCODE);
                break;
            default:
                System.out.println("Hata");
                break;
        }

        for(int i= 1; i<elements.size();i++){
            binaryString.append(Helper.createBinaryStringForREG_IMM(
                    elements.get(i),(short)4
            ));
        }

        binaryString.append(UNUSED_SUFFIX);

        return binaryString.toString();

    }



}
