package codingProblems;

public class BinarySearchTree {
	public  Node root;
	public BinarySearchTree(){
		this.root = null;
	}
	
	public boolean find(int id){
		Node current = root;
		while(current!=null){
			if(current.data==id){
				return true;
			}else if(current.data > id){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
	public boolean delete(int id){
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while(current.data!=id){
			parent = current;
			if(current.data > id){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current ==null){
				return false;
			}
		}
		//if i am here that means we have found the node
		//Case 1: if node to be deleted has no children
		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}
		//Case 2 : if node to be deleted has only one child
		else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}else if(current.left!=null && current.right!=null){
			
			//now we have found the minimum element in the right sub tree
			Node successor	 = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		return true;		
	}
	
	public Node getSuccessor(Node deleleNode){
		Node successsor =null;
		Node successsorParent =null;
		Node current = deleleNode.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
//		successsorParent
		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}
	public void insert(int id){
		Node newNode = new Node(id);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(id<current.data){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	public void display(Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
	
	/* Function for inorder traversal */
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(Node r)
    {
        if (r != null)
        {
            inorder(r.left);
            System.out.print(r.data +" ");
            inorder(r.right);
        }
    }
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(Node r)
    {
        if (r != null)
        {
            System.out.print(r.data +" ");
            preorder(r.left);             
            preorder(r.right);
        }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(Node r)
    {
        if (r != null)
        {
            postorder(r.left);             
            postorder(r.right);
            System.out.print(r.data +" ");
        }
    } 
    /*
     * To check tree is BST
     */
	boolean isBST() 
	{
		return isBST(root);
	}

	/* returns true if given search tree is binary
     search tree (efficient version) */
	boolean isBST(Node node) 
	{
		return (isBSTUtil(node,Integer.MIN_VALUE,Integer.MAX_VALUE));
	}

	/* Returns true if the given tree is a BST and its 
   values are >= min and <= max. */
	boolean isBSTUtil(Node node, int min, int max)
	{
		/* an empty tree is BST */
		if(node == null)
			return true;

		/* false if this node violates the min/max constraints */
		if(node.data < min || node.data > max)
			return false;

		/* otherwise check the subtrees recursively
        tightening the min/max constraints */
		return (isBSTUtil(node.left, min, node.data-1) &&  // Allow only distinct values
				isBSTUtil(node.right, node.data+1, max));  // Allow only distinct values 
	}
	
	/*
	 * Mirror
	 */
	void mirror() 
	{
        mirror(root);
    }
 
    void mirror(Node node) 
    {
        if (node == null) 
        {
            return;
        } 
        else 
        {
            Node temp;
 
            mirror(node.left);
            mirror(node.right);
 
            /* swap the objects in this node */
            temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }
    
	public static void main(String arg[])
	{
		BinarySearchTree b = new BinarySearchTree();
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		System.out.println(" Original Tree : ");
		b.display(b.root);		
		System.out.println("");
		System.out.println(" Check whether Node with value 4 exists : " + b.find(4));
		System.out.println(" Delete Node with no children (2) : " + b.delete(2));		
		b.display(b.root);
		System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
		b.display(b.root);
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
		b.display(b.root);
		System.out.println("\n Is BST : " + b.isBST());
		
		/* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input tree is :");
        b.inorder();
        System.out.println("");
 
        /* convert tree to its mirror */
        b.mirror();
 
        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of mirror of binary tree is : ");
        b.inorder();
	}
}