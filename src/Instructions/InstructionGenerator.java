package Instructions;

import java.util.ArrayList;

public class InstructionGenerator {
    private IInstructionStrategy strategy;





    public void setStrategy(IInstructionStrategy strategy){
        this.strategy = strategy;
    }

    public String generateBinaryInstruction(ArrayList<String> elements){
        return strategy.GenerateBinaryInstruction(elements);
    }
}
