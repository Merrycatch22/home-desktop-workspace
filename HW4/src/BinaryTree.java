import java.io.*;
/**
 * BinaryTree.java
 * Nicholas Tarn
 * 5/25/16
 * Windows 7 Eclipse Compiler for Java
 * An abstract Binary Tree.
 *
 */
public abstract class BinaryTree<E> implements TreeInterface<E> {
	protected BinaryNode<E> root=null; // reference to the root
    protected int size=0; // number of nodes in the tree

    public BinaryTree(){ }


    /** Clears the whole tree */
    public void clear()
    {
    	    	root = null;
    		size = 0;
    }
    
	/* FINISH THIS METHOD so it will call writeTree which
		will display the tree LIKE below, in this example, 50 is in the root
		70 is in the RIGHT child of the root, 20 is in the LEFT child of the root,
		80 is in the RIGHT child of 70, 60 is in the LEFT child of 70,
		40 is in the RIGHT child of 20, 10 is in the LEFT child of 20
1. 50
2. 70
3. 80 
3. 60  
2. 20 
3. 40 
3. 10
*/
	public void writeIndentedTree(PrintStream writer)
	{
		// Call the writeTree, passing this parameter, this' root, 1 and ""
		writeTree(writer,this.root,1,"");
	}

	// FINISH THE FOLLOWING METHOD so it returns if the root is null,
	//     calls print or println for the PrintWriter parameter to write the root's data
	//     then (like preorder, but "reversed" and with level and indent) make
	//     recursive calls to writeTree
	protected void writeTree(PrintStream writer, 
			BinaryNode<E> root, int level, String indent)
	{
		if(root==null){
			return;
		}
		writer.println(indent+level+". "+root.getData());
		writeTree(writer,root.getRightChild(),level+1,indent+"    ");
		writeTree(writer,root.getLeftChild(),level+1,indent+"    ");
	}


    @Override /** Preorder traversal from the root */
    public void preorder(Visitor<E> visitor) 
    {
        preorder(root, visitor);
    }

    @Override /** Inorder traversal from the root*/
    public void inorder(Visitor<E> visitor) 
    {
        inorder(root, visitor);
    }

    @Override /** Postorder traversal from the root */
    public void postorder(Visitor<E> visitor) 
    {
    		postorder(root, visitor);
    }

    @Override /** Get the number of nodes in the tree */
    public int getSize() 
    {
    		return size;
    }


    @Override /** Return true if the tree is empty */
    public boolean isEmpty() 
    {
    		return getSize() == 0;
    }

    /** Preorder traversal from a subtree */
    protected void preorder(BinaryNode<E> root, Visitor<E> visitor) 
    {
    		if (root == null)
    			return;
    		visitor.visit(root.getData());
    		preorder(root.getLeftChild(), visitor);
    		preorder(root.getRightChild(), visitor);
    }

     /** Inorder traversal from a subtree */
    protected void inorder(BinaryNode<E> root, Visitor<E> visitor) 
    {
         // you finish (part of HW#4), SEE preorder above this
    	if (root == null)
			return;
    	inorder(root.getLeftChild(), visitor);
		visitor.visit(root.getData());
    	inorder(root.getRightChild(), visitor);
    	

    }

     /** Postorder traversal from a subtree */
    protected void postorder(BinaryNode<E> root, Visitor<E> visitor) 
    {
         // you finish (part of HW#4)
    	if (root == null)
			return;
    	postorder(root.getLeftChild(), visitor);
		
    	postorder(root.getRightChild(), visitor);
    	visitor.visit(root.getData());

    }
} // end abstract BinaryTree class

