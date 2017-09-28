package sjsu.asemwota.cs146.project3;

public class RedBlackTree <Key extends Comparable<Key>>
{
	public interface Visitor<Key extends Comparable<Key>>{
	    /**
	    This method is called at each node.
	    @param n the visited node
	    */
	    void visit(Node<Key> n);
	}
	
	public static class Node<Key extends Comparable<Key>>
	{
        public Key key;    
        public String color;
        public RedBlackTree.Node<Key> left;
        public Node<Key> right;
        public Node<Key> parent;
        
        public Node()
        {
        	//nothing
        }
        public Node (Key word)
        {
        	key = word;
        }
        public int compareTo (Node<String> other)
        {
        	String A = (String)key;
        	String B = (String)other.key; 
        	
        	return A.compareToIgnoreCase(B);
        }
          
        public boolean equals (Node<String> node)
        {
        	String A = (String)key; 
        	String B = (String)node.key;
        	return (A.equalsIgnoreCase(B));
        }
	}      
	
	//root RB node
		Node<String> root;
		
		/*
		 * I have instances of the color as both a string or a number 
		 * the provided test class require it in numbers 
		 * while I prefer it in words to make it easier to read
		 */
		String black = "1"; 
		String red = "0";
		
		//String black = "black";
		//String red = "red";
	
		
		
	/**
	 * Search for a key
	 * 
	 * @param find - the key to search for
	 */
	public Node<String> lookup(String find)
	{
		Node<String> myNode = new Node<String>(find); 
		
		if(root.equals(myNode))
		{
			return root;
		}
		
		else 
		{
			return recurseLook(myNode, root);
		}
	}
	
	public Node<String> recurseLook (Node<String> myNode, Node<String> current)
	{
		if(myNode == null)
			return null;
		
		else if(current == null)
			return null;
		
		//if incoming is the one, do the thing
		else if(current.equals(myNode))
		{
			return current;
		}
		
		
		else 
		{
			int comp = myNode.compareTo(current); 
			
			if(comp < 0) //mine < current
			{
				return recurseLook(myNode, current.left);
			}
			
			if(comp > 0)
			{
				return recurseLook(myNode, current.right);
			}
			
			else 
				return null;
		}
	
	}
	
		
	/**
	 * Insert a node into a RBT
	 */
	public void insert(String data)
	{
		addNode(data);
	}
	
	
	/**
	 * place a new node in the binary search tree with data the parameter 
	 * and color it red
	 * @param word
	 */
	public void addNode(String word)
	{
		Node<String> myNode = new Node<String>(word);
		
		if(root == null)
		{
			root = myNode;
		}
		
		
		else 
		{
			recurseAdd(myNode, root);
			myNode.color = red;
		}
		fixTree(myNode);
	}
	
	public void recurseAdd(Node<String> myNode, Node<String> current)
	{
		//base case is leaf 
		//if it is a leaf, place it in either left or right, and return
		if(isLeaf(current))
		{
			int comp = myNode.compareTo(current); 
			
			if(comp < 0) //mine < current
			{
				//place in left
				current.left = myNode;
				myNode.parent = current;
				return;
			}
			
			if(comp > 0)
			{
				//place in right
				current.right = myNode;
				myNode.parent = current;
				return;
			}
		}
		
		
		else 
		{
			int comp = myNode.compareTo(current); 
			
			if(comp < 0) //mine < current
			{
				//if left is null, place it here
				if(current.left == null)
				{
					current.left = myNode;
					myNode.parent = current;
					return;
				}
				recurseAdd(myNode, current.left);
			}
			
			if(comp > 0)
			{
				if(current.right == null)
				{
					current.right = myNode;
					myNode.parent = current;
					return;
				}
				recurseAdd(myNode, current.right);
			}
		}
	}

	
	/**
	 * Checks if the given node is the right child of the parent
	 */
	public boolean isRight (Node<String> mine)
	{
		int comp = mine.compareTo(mine.parent); //pos if right
		if(comp > 0)
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}
	
	
	public boolean isLeaf(Node<String> current)
	{
		return ((current.left == null)&&(current.right == null));
	}
	
	
	/**
	 * returns the sibling node of the parameter 
	 * If the sibling does not exist, then return null.
	 * 
	 * @param node
	 * @return the sibling or null
	 */
	public Node<String> getSibling(RedBlackTree.Node<String> me)
	{
		//if parent is null, return 
		if (me.parent == null)
		{
			return null;
		}
		
		//if left, return right child of parent
		if(!(isRight(me))) //not right, so left
		{
			Node<String> other = me.parent.right;
			return other;
		}
		
		//if right, return left child of parent 
		else if(isRight(me))
		{
			Node<String> other = me.parent.left;
			return other;
		}
		
		else 
		{
			return null;
		}
	}
	
	/**
	 *  returns the aunt of the parameter or the sibling of the parent node. 
	 *  If the aunt node does not exist, then return null. 
	 * @param node
	 * @return
	 */
	public Node<String> getAunt (RedBlackTree.Node<String> me)
	{
		//the sibling of the parent
		Node<String> aunt = getSibling(me.parent);
		return aunt;
	}
	
	/**
	 *  returns the parent of your parent node, 
	 *  if it doesn’t exist return null
	 * @param node
	 * @return
	 */
	public Node<String> getGrandparent (RedBlackTree.Node<String> node)
	{
		return node.parent.parent;
	}
	
	public void preOrderVisit(Visitor<String> v)
    {
		preOrderVisit(root, v);
	}
	 
	
	private static void preOrderVisit(Node<String> n, Visitor<String> v)
	{
		if (n == null) return;
	   	v.visit(n);
	   	preOrderVisit(n.left, v);
	   	preOrderVisit(n.right, v);
   }
	
	public void printTree()
	{
		String phrase = RBTTester.makeString(this);
		System.out.println(phrase);
	}
    	
    	
	public void rotateLeft(RedBlackTree.Node<String> x)
	{
		Node<String> y = x.right; 
		x.right = y.left;
		
		if(y.left != null)
		{
			y.left.parent = x;
		}
		
		y.parent = x.parent; 
		
		if(x.parent == null)
		{
			root = y;
		}
		
		else if(x == x.parent.left)
		{
			x.parent.left = y;
		}
		else 
		{
			x.parent.right = y;
		}
		
		y.left = x;
		x.parent = y;
	}
	
	public void rotateRight(RedBlackTree.Node<String> y)
	{
		Node<String> x = y.left; 
		y.left = x.right;
		
		if(x.right != null)
		{
			x.right.parent = y;
		}
		
		x.parent = y.parent; 
		
		if(y.parent == null)
		{
			root = x;
		}
		
		else if(y == y.parent.left)
		{
			y.parent.left = x;
		}
		else 
		{
			y.parent.right = x;
		}
		
		x.right = y;
		y.parent = x;
	}
	
	
	/**
	 * Takes in the current node and fixed the sub tree
	 * @param current
	 */
	public void fixTree(RedBlackTree.Node<String> current)
	{
		//if current is the root, make it black and quit 
		if(current.equals(root))
		{
			current.color = black; 
			return;
		}
		
		//if parent is black, quit -> the tree is a RBT
		if(current.parent.color.equals(black))
		{
			return;
		}
		
		//if current is red and the parent is red --> unbalanced
		if((current.color.equals(red))&&(current.parent.color.equals(red)))
		{
			Node<String> aunt = getAunt(current);
			Node<String> parent = current.parent;
			Node<String> grand = current.parent.parent;
					
			
			//since unbalanced, will have to modify using the following ways: 
			
			/*FIRST PART 
			 * if aunt is empty or black, then 4 sub cases
		     */ 
			
			if((aunt == null) || (aunt.color.equals(black)))
			{
				//CASE A
				//grandparent - parent is left child - current is right child 
				if((!isRight(current.parent)) && (isRight(current)))
				{
					//solution: rotate the parent left 
					rotateLeft(current.parent);
					//then continue recursively fixing the tree starting with original parent
					fixTree(parent);
					//return;
				}
				
				
				//CASE B
				//grandparent - parent is right child - current is left child
				else if((isRight(current.parent))&& !(isRight(current)))
				{
					//solution: rotate the parent right 
					rotateRight(current.parent);
					//continue recursively fixing with original
					fixTree(current);
					//return;
				}
				
				//CASE C
				//grandparent - parent is left child - current is left child 
				else if(!(isRight(current.parent))&&!(isRight(current)))
				{
					//solution: make parent black 
					current.parent.color = black;
					
					//make grandparent red 
					current.parent.parent.color = red;
					
					//rotate grandparent to the right 
					rotateRight(current.parent.parent);
					
					//quit -- balanced tree
					return;
				}
				
				//CASE D
				//grandparent - parent is right child - current is right child 
				else if ((isRight(current.parent))&&(isRight(current)))
				{
					//solution - make parent black 
					current.parent.color = black;
					
					//grandparent red
					current.parent.parent.color = red;
					
					//rotate grandparent to the left 
					rotateLeft(current.parent.parent);
					
					//quit -- balanced tree 
					return; 
				}
				
				
			}
			
			
			/*
			 * SECOND PART 
			 * 	if the aunt is red, then make the parent black, make the aunt black 
			 * make the grandparent red and continue recursively fix up tree starting with grandparent
			 */
			
			else if((aunt.color.equals(red)))
			{
				current.parent.color = black;
				aunt.color = black; 
				current.parent.parent.color = red; 
				
				fixTree(current.parent.parent);
			}
			
	}
		
	}
}
