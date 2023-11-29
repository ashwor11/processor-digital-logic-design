package Instructions;

import java.util.ArrayList;
import java.util.List;

public class InstructionGenerator {
    private IInstructionStrategy strategy;





    public void setStrategy(IInstructionStrategy strategy){
        this.strategy = strategy;
    }

    public String generateBinaryInstruction(List<String> elements){
        return strategy.GenerateBinaryInstruction(elements);
    }
}
