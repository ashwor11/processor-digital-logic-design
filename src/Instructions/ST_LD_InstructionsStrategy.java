import java.util.ArrayList;
import java.util.List;

import Helpers.Helper;


public class ST_LD_InstructionsStrategy implements IInstructionStrategy{

    private String generateOpCode(String instructionName) {
        String opCode = "";

        switch (instructionName) {
            case "LD":
                opCode = "1000";
                break;
            case "ST":
                opCode = "1001";
                break;
            default:
                break;
        }
        return opCode;
    }
    private String generateRegisterCode(String register){
        String registerCode = "";
        registerCode = Helper.createBinaryStringForREG_IMM(register, (short)4);
        return registerCode;
    }

    private String generateAddressBinary(String address) {
        String binaryAddress = "";
        binaryAddress = Helper.createBinaryStringForREG_IMM(address, (short)10);
        return binaryAddress;

    }

   @Override
    public String GenerateBinaryInstruction(ArrayList<String> elements) {

        String opCode = generateOpCode(elements.get(0));
        String registerCode = generateRegisterCode(elements.get(1));
        String address = generateAddressBinary(elements.get(2));

        String binaryInstruction = opCode + registerCode +address;

        return binaryInstruction;
    }
}