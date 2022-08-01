import java.util.ArrayList;

public class Function {

    ArrayList<BasicBlock> BBs;
    ArrayList<Instruction> allInst;
    int current_ID;
    String name;
    ArrayList<String> args;

    public void addArgs(String _var) {
        this.args.add(_var);
    }

    public String getArgs(int index) {
        return this.args.get(index);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Function() {
        this.BBs = new ArrayList<BasicBlock>();
        this.allInst = new ArrayList<Instruction>();
        this.current_ID = 0;
        this.name = new String();
        this.args = new ArrayList<String>();
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
        System.out.print(this.name + ": ");
        System.out.println(this.args);
        for(Instruction I: this.allInst) {
            I.dump();
        }
    }

}
