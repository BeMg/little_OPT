public class ASTCompiler {

    public Function compile(ASTNode curr) {
        Function f = new Function();

        if(!isFunction(curr)) {
            curr.dump();
            throw new AssertionError("This node is unable to compile.");
        }

        ASTNode Name = curr.getChild().get(0);
        ASTNode Args = curr.getChild().get(1);

        ASTNode FunctionBody = curr.getChild().get(2);

        compileBody(FunctionBody, f);

        return f;
    }

    static Instruction compileBody(ASTNode curr, Function f) {

        Instruction I = new Instruction();

        switch (curr.getNodeType()) {
            case STATEMENT:
                for(int i=0; i<curr.getChild().size(); i++) {
                    compileBody(curr.getChild().get(i), f);
                }
                break;
            case ADD:
                I.setType(InstType.ADD);
                Instruction left = compileBody(curr.getChild().get(0), f);
                Instruction right = compileBody(curr.getChild().get(1), f);
                I.addOperand(left);
                I.addOperand(right);
                break;
            case VAR:
                I.setType(InstType.VAR);
                break;
            case RETURN:
                I.setType(InstType.RETURN);
                Instruction retVal = compileBody(curr.getChild().get(0), f);
                I.addOperand(retVal);
                break;
            case PROGRAM:
            case FUNCNAME:
            case ARGS:
            case FUNCTION:
                throw new AssertionError(curr.getNodeType() + " should not be here.");
        }
        if(I.getType() != null) {
            I.setID(f.distributeID());
            f.addInst(I);
        }
        return I;
    }

    static boolean isFunction(ASTNode curr) {
        return curr.getNodeType() == ASTNodeType.FUNCTION;
    }


}
