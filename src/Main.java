import java.util.ArrayList;
import java.util.List;

import Helpers.Helper;
import Helpers.InputReader;
import Instructions.*;

public class Main {

    public static void main(String[] args) {

        InstructionGenerator instractorGenerator = new InstructionGenerator();
        InputReader reader = new InputReader();

        ArrayList<String> instructionsInBinary = new ArrayList<>();

        while(reader.isFileOver() == false) {
            List<String> line = reader.getNextSplittedLine();

            String instructionInBinary = "";

            if(line.get(0).equals("LD") || line.get(0).equals("ST")){
                instractorGenerator.setStrategy(new ST_LD_InstructionsStrategy());
                instructionInBinary = instractorGenerator.generateBinaryInstruction(line);
            }
            else if(line.get(0).equals("JE") || line.get(0).equals("JA")
                    || line.get(0).equals("JB") || line.get(0).equals("JBE")
                    || line.get(0).equals("JAE")){
                instractorGenerator.setStrategy(new JE_JA_JB_JAE_JBEInstructionStrategy());
                instructionInBinary = instractorGenerator.generateBinaryInstruction(line);
            }else if(line.get(0).equals("ADD") || line.get(0).equals("AND") || line.get(0).equals("NAND") || line.get(0).equals("NOR")){
                instractorGenerator.setStrategy(new ADD_AND_NAND_NOR_InstructionsStrategy());
                instructionInBinary = instractorGenerator.generateBinaryInstruction(line);
            }else if(line.get(0).equals("ADDI") || line.get(0).equals("ANDI")){
                instractorGenerator.setStrategy(new ADDI_ANDI_InstructionsStrategy());
                instructionInBinary = instractorGenerator.generateBinaryInstruction(line);
            }else if(line.get(0).equals("CMP")){
                instractorGenerator.setStrategy(new CMPInstructionStrategy());
                instructionInBinary = instractorGenerator.generateBinaryInstruction(line);
            }else if(line.get(0).equals("JUMP")) {
                instractorGenerator.setStrategy(new JUMPInstructionStrategy());
                instructionInBinary = instractorGenerator.generateBinaryInstruction(line);
            }

            instructionsInBinary.add(instructionInBinary);

        }

        ArrayList<String> instructionsInHexadecimal = Helper.convertBinaryInstructionsToHexInstructions(instructionsInBinary);

        Helper.createMemoryFile(instructionsInHexadecimal);


    }

}

