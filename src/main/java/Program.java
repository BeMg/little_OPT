import java.util.ArrayList;

public class Program {

    ArrayList<Function> Funcs;

    public Program() {
        this.Funcs = new ArrayList<Function>();
    }

    public ArrayList<Function> getFunc() {
        return this.Funcs;
    }

    public void addFunc(Function f) {
        this.Funcs.add(f);
    }

}
