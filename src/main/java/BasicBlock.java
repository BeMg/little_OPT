import java.util.ArrayList;

public class BasicBlock {

    public BasicBlock() {
        this.Inst = new ArrayList<Instruction>();
    }

    public ArrayList<Instruction> getInstruction() {
        return this.Inst;
    }

    ArrayList<Instruction> Inst;
}
