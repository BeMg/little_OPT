import java.util.ArrayList;
import java.util.Stack;

public class ASTParser {

    public ASTNode parse(String source) {

        int index_of_left_bra = source.indexOf('(');

        if(index_of_left_bra == -1) {
            return null;
        }

        int offset_for_right_bra = findPairBracket(source.substring(index_of_left_bra, source.length()));

        String NodeName = source.substring(0, index_of_left_bra).strip();
        String NodeBody = source.substring(index_of_left_bra, index_of_left_bra+offset_for_right_bra+1);

        ASTNode curr = new ASTNode();

        setASTNodeType(curr, NodeName);

        for(String s: splitChildNode(NodeBody)) {
            ASTNode child = parse(s);
            if(child != null) {
                curr.addNode(child);
            } else {
                // leaf here.
                curr.setValue(s);
            }
        }

        return curr;
    }

    private static int findPairBracket(String source) {
        int result = -1;
        int len = source.length();
        Stack<Character> checker = new Stack<Character>();
        checker.push('(');
        for(int i=1; i<len; i++) {
            if(source.charAt(i) == '(') {
                checker.push('(');
            }
            if(source.charAt(i) == ')') {
                checker.pop();
            }
            if(checker.empty()) {
                result = i;
                break;
            }
        }
        return result;
    }

    private static ArrayList<String> splitChildNode(String curr) {
        ArrayList<Integer> indexOfComma = new ArrayList<Integer>();
        indexOfComma.add(0);
        Stack<Integer> checker = new Stack<Integer>();
        int len = curr.length()-1;
        for(int i=1; i<len; i++) {
            if(curr.charAt(i) == '(') {
                checker.push(0);
            }
            if(curr.charAt(i) == ')') {
                checker.pop();
            }
            if(curr.charAt(i) == ',' && checker.empty()) {
                indexOfComma.add(i);
            }
        }
        indexOfComma.add(len);
        ArrayList<String> rst = new ArrayList<String>();

        for(int i=0; i+1<indexOfComma.size(); i++) {
            rst.add(curr.substring(indexOfComma.get(i)+1, indexOfComma.get(i+1)));
        }

        return rst;
    }

    private static void setASTNodeType(ASTNode curr, String NodeName) {
        if(NodeName.equals("PROGRAM")) {
            curr.setNodeType(ASTNodeType.PROGRAM);
        }
        else if(NodeName.equals("FUNCTION")) {
            curr.setNodeType(ASTNodeType.FUNCTION);
        }
        else if(NodeName.equals("STATEMENT")) {
            curr.setNodeType(ASTNodeType.STATEMENT);
        }
        else if(NodeName.equals("ADD")) {
            curr.setNodeType(ASTNodeType.ADD);
        }
        else if(NodeName.equals("RETURN")) {
            curr.setNodeType(ASTNodeType.RETURN);
        }
        else if(NodeName.equals("ARGS")) {
            curr.setNodeType(ASTNodeType.ARGS);
        }
        else if(NodeName.equals("VAR")) {
            curr.setNodeType(ASTNodeType.VAR);
        }
        else if(NodeName.equals("CONSTANT")) {
            curr.setNodeType(ASTNodeType.CONSTANT);
        }
        else if(NodeName.equals("FUNCNAME")) {
            curr.setNodeType(ASTNodeType.FUNCNAME);
        }
        else {
            throw new AssertionError( NodeName + " is invalid Node name.");
        }
    }
}
