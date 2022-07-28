import java.util.ArrayList;

public class Instruction {

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Instruction() {
        this.type = null;
        this.Operand = new ArrayList<Instruction>();
        this.ID = -1;
    }

    public InstType getType() {
        return type;
    }

    public void setType(InstType type) {
        this.type = type;
    }

    InstType type;

    ArrayList<Instruction> Operand;

    int ID;

    public void addOperand(Instruction Inst) {
        this.Operand.add(Inst);
    }

    public Instruction getOperand(int index) {
        return this.Operand.get(index);
    }

    public void dump() {
        System.out.print("R" + this.ID);
        System.out.print(" = ");
        System.out.print(this.type);
        System.out.print(" ");
        for(Instruction I: this.Operand) {
            System.out.print("R" + I.getID());
            System.out.print(" ");
        }
        System.out.print("\n");
    }

}
