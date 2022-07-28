import org.w3c.dom.Node;

import java.util.ArrayList;

public class ASTNode {

    public ASTNode() {
        child = new ArrayList<ASTNode>();
    }

    public ASTNodeType getNodeType() {
        return NodeType;
    }

    public void setNodeType(ASTNodeType nodeType) {
        NodeType = nodeType;
    }


    public ArrayList<ASTNode> getChild() {
        return child;
    }

    public void addNode(ASTNode curr) {
        child.add(curr);
    }

    public void dump() {
        System.out.println(this.NodeType + ": " + this.value);
        for(ASTNode n: this.child) {
            n.dumpWithFromat(1);
        }
    }

    public void dumpWithFromat(int indent) {
        String node_format =  new String(" ").repeat(indent);
        System.out.print(node_format);
        System.out.println(this.NodeType + ": " + this.value);
        for(ASTNode n: this.child) {
            n.dumpWithFromat(indent+1);
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    ASTNodeType NodeType;
    ArrayList<ASTNode> child;
    String value;

}
