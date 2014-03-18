package a4;

/**
 * An AbstractNode is an Abstract class that implements Node,
 * so that classes in the abstract syntax tree of a program can reuse code.
 */
abstract class AbstractNode implements Node{

	/**
	 * The number of nodes in this AST, including the current node.
     * This can be helpful for implementing mutate() correctly.
	 */
	public int size(){
		return 0;
	}

	/**
	 * Return a version of the same AST with one random mutation in it.
	 * May have side effects on the original AST.
	 */
	public Node mutate(){
		return null;
	}

	/**
	 * Appends the program represented by this node prettily to
	 * the given StringBuffer.
	 * @param sb The StringBuffer to be appended
	 */
	public void prettyPrint(StringBuffer sb){
		System.out.println();		
	}

}
