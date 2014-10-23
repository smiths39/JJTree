// Name:PrintVisitor.java
// Author: David Sinclair      Date: 29 Aug 2012
//
// Visitor for "pretty printing" an abstract syntax tree in the ExprLang language
//

public class PrintVisitor implements ExprLangVisitor
{
    public Object visit(SimpleNode node, Object data)
    {
	throw new RuntimeException("Visit SimpleNode");
    }

    public Object visit(ASTprogram node, Object data)
    {
	node.jjtGetChild(0).jjtAccept(this, data);
	System.out.println(";");
	return(data);
    }

    public Object visit(ASTDecl node, Object data)
    {
	System.out.print(node.value + " ");
	node.jjtGetChild(0).jjtAccept(this, data);
	return data;
    }

    public Object visit(ASTStms node, Object data)
    {
	node.jjtGetChild(0).jjtAccept(this, data);
	System.out.println(";");
	node.jjtGetChild(1).jjtAccept(this, data);
	return data;
    }

    public Object visit(ASTAdd_op node, Object data)
    {
	node.jjtGetChild(0).jjtAccept(this, data);
	System.out.print(" " + node.value + " ");
	node.jjtGetChild(1).jjtAccept(this, data);
	return data;
    }

    public Object visit(ASTBool_op node, Object data)
    {
	node.jjtGetChild(0).jjtAccept(this, data);
	System.out.print(" " + node.value + " ");
	node.jjtGetChild(1).jjtAccept(this, data);
	return data;
    }

    public Object visit(ASTMult_op node, Object data)
    {
	node.jjtGetChild(0).jjtAccept(this, data);
	System.out.print(" " + node.value + " ");
	node.jjtGetChild(1).jjtAccept(this, data);
	return data;
    }

    public Object visit(ASTNot_op node, Object data)
    {
	System.out.print("~");
	return(node.jjtGetChild(0).jjtAccept(this, data));
    }

    public Object visit(ASTExp node, Object data)
    {
	System.out.print("(");
	node.jjtGetChild(0).jjtAccept(this, data);
	System.out.print(")");
	return(data);
    }

    public Object visit(ASTidentifier node, Object data)
    {
	System.out.print(node.value);
	return data;
    }

    public Object visit(ASTnumber node, Object data)
    {
	System.out.print(node.value);
	return data;
    }
}