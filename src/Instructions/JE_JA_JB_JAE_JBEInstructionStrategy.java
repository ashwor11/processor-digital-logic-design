package Instructions;

import Helpers.Helper;

import java.util.ArrayList;
import java.util.List;

public class JE_JA_JB_JAE_JBEInstructionStrategy implements IInstructionStrategy {

    private final String JE_OPCODE = "1011";
    private final String JA_OPCODE = "1100";
    private final String JBO_OPCODE = "1101";
    private final String JAE_OPCODE = "1110";
    private final String JBE_OPCODE = "1111";

    private final String SUFFIX = "0000";

    @Override
    public String GenerateBinaryInstruction(List<String> elements) {

        String binaryCode = "";

        switch (elements.get(0)){

            case "JE":
                binaryCode += JE_OPCODE;
                break;

            case "JA":
                binaryCode += JA_OPCODE;
                break;
            case "JBO":
                binaryCode += JBO_OPCODE;
                break;
            case "JAE":
                binaryCode += JAE_OPCODE;
                break;
            case "JBE":
                binaryCode += JBE_OPCODE;
                break;
        }

        String addr10 = Helper.createBinaryStringForREG_IMM(elements.get(1),(short)10);

        binaryCode = binaryCode + addr10 + SUFFIX;

        return binaryCode;



    }
}
