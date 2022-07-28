import java.util.ArrayList;

public class Function {

    ArrayList<BasicBlock> BBs;
    ArrayList<Instruction> allInst;
    int current_ID;

    public Function() {
        this.BBs = new ArrayList<BasicBlock>();
        this.allInst = new ArrayList<Instruction>();
        this.current_ID = 0;
    }

    public int distributeID() {
        int rst = current_ID;
        current_ID = current_ID + 1;
        return rst;
    }

    public ArrayList<BasicBlock> getBBs() {
        return this.BBs;
    }

    public void addBB(BasicBlock BB) {
        this.BBs.add(BB);
    }

    public void addInst(Instruction Inst) {
        this.allInst.add(Inst);
    }

    public void dump() {
        for(Instruction I: this.allInst) {
            I.dump();
        }
    }

}
