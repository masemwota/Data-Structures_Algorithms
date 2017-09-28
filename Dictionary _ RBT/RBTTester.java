package sjsu.asemwota.cs146.project3;
import static org.junit.Assert.*;

import org.junit.Test;

public class RBTTester {
	
	/*
	 * MY TEST CODE
	 */
	
	@Test
	public void testPrintTree() {
		RedBlackTree<String> rbt = new RedBlackTree<String>();
    	rbt.addNode("A");
    	rbt.addNode("B");
    	rbt.addNode("C");
    	rbt.addNode("D");
    	
    	String phrase = makeString(rbt); 
    	
    	rbt.printTree(); 
    	System.out.println(phrase + "\n");
	}

	@Test 
	public void testFixTree()
	{
		RedBlackTree<String> rbt = new RedBlackTree<String>();
    	rbt.addNode("A");
    	rbt.addNode("B");
    	rbt.addNode("C");
    	rbt.addNode("D");
    	
    	RedBlackTree<String> rbt2 = new RedBlackTree<String>();
    	rbt2.addNode("D");
    	rbt2.addNode("C");
    	rbt2.addNode("B");
    	rbt2.addNode("A");
    	
    
    	String rbtphrase = makeStringDetails(rbt);
    	String rbt2phrase = makeStringDetails(rbt2);
    	
    	//assertEquals(rbt.root.key, rbt2.root.key);
    	assertNotEquals(rbtphrase, rbt2phrase);
    	assertEquals("BACD", makeString(rbt));
    	assertEquals("CBAD", makeString(rbt2));
    	
    	System.out.println(makeStringDetails(rbt) + "\n");
    	System.out.println(makeString(rbt2) + "\n");
	}
	
	@Test
	public void testFixTree2()
	{
		RedBlackTree<String> rbt = new RedBlackTree<String>();
    	rbt.addNode("A");
    	rbt.addNode("K");
    	rbt.addNode("B");
    	rbt.addNode("D");
    	rbt.addNode("C");
    	
    	RedBlackTree<String> rbt2 = new RedBlackTree<String>();
    	rbt2.addNode("A");
    	rbt2.addNode("K");
    	rbt2.addNode("B");
    	rbt2.addNode("D");
    	rbt2.addNode("C");
    	
    
    	String rbtphrase = makeStringDetails(rbt);
    	String rbt2phrase = makeStringDetails(rbt2);
    	
    	//assertEquals(rbt.root.key, rbt2.root.key);
    	assertEquals(rbtphrase, rbt2phrase);
    	assertEquals("BADCK", makeString(rbt));
    	
    	System.out.println(makeString(rbt) + "\n");
    	System.out.println(makeStringDetails(rbt2) + "\n");
	}
	
	
	@Test
	public void testAddNode() {
		RedBlackTree<String> rbt = new RedBlackTree<>();
    	rbt.addNode("1");
    	rbt.addNode("2");
    	rbt.addNode("3");
    	rbt.addNode("74");
    	rbt.addNode("8");
    	rbt.addNode("6");
    	rbt.addNode("5");
    	
    	RedBlackTree<String> rbt2 = new RedBlackTree<>(); 
    	rbt2.addNode("1");
    	rbt2.addNode("2");
    	rbt2.addNode("3");
    	rbt2.addNode("74");
    	rbt2.addNode("8");
    	rbt2.addNode("6");
    	rbt2.addNode("5");
    	
    	String rbtphrase = makeStringDetails(rbt);
    	String rbt2phrase = makeStringDetails(rbt2);
    	
    	assertEquals(rbtphrase, rbt2phrase);
    	System.out.println(makeString(rbt) + "\n");
    	
    	
    	RedBlackTree<String> rbt3 = new RedBlackTree<>();
    	rbt3.addNode("3");
    	rbt3.addNode("2");
    	rbt3.addNode("5");
    	
    	RedBlackTree<String> rbt4 = new RedBlackTree<>();
    	rbt4.addNode("3");
    	rbt4.addNode("2");
    	rbt4.addNode("5");
    	
    	String rbt3phrase = makeString(rbt3);
    	String rbt4phrase = makeString(rbt4);
    	
    	assertEquals(rbt3phrase, rbt4phrase);
    	System.out.println(rbt3phrase +"\n");
 
    	
    	
    	RedBlackTree<String> rbt7 = new RedBlackTree<>();
    	rbt7.addNode("A");
    	rbt7.addNode("B");
    	rbt7.addNode("C");
    	rbt7.addNode("D");
    	rbt7.addNode("E");
    	
    	RedBlackTree<String> rbt8 = new RedBlackTree<>();
    	rbt8.addNode("A");
    	rbt8.addNode("B");
    	rbt8.addNode("C");
    	rbt8.addNode("D");
    	rbt8.addNode("E");
    	
    	String rbt7phrase = makeStringDetails(rbt7);
    	String rbt8phrase = makeStringDetails(rbt8);
    	
    	assertEquals(rbt7phrase, rbt8phrase);
    	//System.out.println(rbt8phrase +"\n");
    	System.out.println(makeStringDetails(rbt7) + "\n");
    	
    	
    	RedBlackTree<String> rbt9 = new RedBlackTree<>();
    	rbt9.addNode("A");
    	rbt9.addNode("B");
    	rbt9.addNode("C");
    	rbt9.addNode("D");
    	rbt9.addNode("E");
    	
    	RedBlackTree<String> rbt10 = new RedBlackTree<>();
    	rbt10.addNode("a");
    	rbt10.addNode("b");
    	rbt10.addNode("c");
    	rbt10.addNode("d");
    	rbt10.addNode("e");
    	
    	String rbt9phrase = makeStringDetails(rbt9);
    	String rbt10phrase = makeStringDetails(rbt10);
    	
    	//assertEquals(rbt9phrase, rbt10phrase);
    	assertTrue(rbt9phrase.equalsIgnoreCase(rbt10phrase));
    	//System.out.println(rbt10phrase +"\n");
    	System.out.println(makeStringDetails(rbt9) + "\n");
	}


	@Test
	public void testLookup() {
		RedBlackTree<String> rbt = new RedBlackTree<String>();
    	rbt.addNode("3");
    	rbt.addNode("4");
    	rbt.addNode("1");
    	rbt.addNode("2");
    	
    	RedBlackTree.Node<String> found = rbt.lookup("2");
    	
    	assertEquals("2", found.key);
	}
	
	@Test
	public void testGetSibling() {
		RedBlackTree<String> rbt = new RedBlackTree<>();
    	rbt.addNode("3");
    	rbt.addNode("2");
    	rbt.addNode("5");
    	
    	RedBlackTree.Node<String> check = rbt.lookup("2");
    	RedBlackTree.Node<String> sib = rbt.getSibling(check);
    	
    	assertNotEquals(null, sib);
    	System.out.println("The sibling of " + check.key + " is " + sib.key);
    	assertEquals("5", sib.key);
    	
    	//with letters 
    	
    	RedBlackTree<String> rbt2 = new RedBlackTree<>();
    	rbt2.addNode("A");
    	rbt2.addNode("B");
    	rbt2.addNode("C");
    	rbt2.addNode("D");
    	
    	RedBlackTree.Node<String> check2 = rbt2.lookup("A");
    	RedBlackTree.Node<String> sib2 = rbt2.getSibling(check2);
    	
    	assertNotEquals(null, sib2);
    	System.out.println("The sibling of " + check2.key + " is " + sib2.key + "\n");
    	assertEquals("C", sib2.key);
	}

	@Test
	public void testGetAunt() {
		RedBlackTree<String> rbt = new RedBlackTree<>();
    	rbt.addNode("A");
    	rbt.addNode("B");
    	rbt.addNode("C");
    	rbt.addNode("D");
    	
    	RedBlackTree.Node<String> check = rbt.lookup("D");
    	RedBlackTree.Node<String> aunt = rbt.getAunt(check);
    	
    	assertNotEquals(null, aunt);
    	System.out.println("The aunt of " + check.key + " is " + aunt.key + "\n");
    	assertEquals("A", aunt.key);
	}

	@Test
	public void testGetGrandparent() {
		RedBlackTree<String> rbt = new RedBlackTree<>();
    	rbt.addNode("A");
    	rbt.addNode("B");
    	rbt.addNode("C");
    	rbt.addNode("D");
    	
    	RedBlackTree.Node<String> check = rbt.lookup("D");
    	RedBlackTree.Node<String> grand = rbt.getGrandparent(check);
    	
    	assertNotEquals(null, grand);
    	System.out.println("The grandparent of " + check.key + " is " + grand.key + "\n");
    	assertEquals("B", grand.key);
    }

	
	@Test
	public void testLeaf() {
		RedBlackTree<String> rbt = new RedBlackTree<String>();
		rbt.addNode("A");
		rbt.addNode("B");
		rbt.addNode("C");
		rbt.addNode("D");
		
		RedBlackTree.Node<String> child = rbt.lookup("A");
		boolean answer = rbt.isLeaf(child);
		
		System.out.println(answer);
		System.out.println("Children: " + child.left +" " +  child.right);
		assertTrue(answer);
		
		//test when it is false
		
		RedBlackTree<String> rbt2 = new RedBlackTree<String>();
		rbt2.addNode("A");
		rbt2.addNode("B");
		rbt2.addNode("C");
		rbt2.addNode("D");
		
		RedBlackTree.Node<String> child2 = rbt2.lookup("C");
		boolean answer2 = rbt.isLeaf(child2);
		
		System.out.println(answer2);
		System.out.println("Children: " + child2.left +" " +  child2.right.key + "\n");
		assertFalse(answer2);
	}

	
	
	
	/*
	 * PROVIDED TEST CODE
	 */

	@Test
	public void test() {
		RedBlackTree<String> rbt = new RedBlackTree<>();
        rbt.insert("D");
        rbt.insert("B");
        rbt.insert("A");
        rbt.insert("C");
        rbt.insert("F");
        rbt.insert("E");
        rbt.insert("H");
        rbt.insert("G");
        rbt.insert("I");
        rbt.insert("J");
        assertEquals("DBACFEHGIJ", makeString(rbt));
        String str=     
"Color: 1, Key:D Parent: \n"+
"Color: 1, Key:B Parent: D\n"+
"Color: 1, Key:A Parent: B\n"+
"Color: 1, Key:C Parent: B\n"+
"Color: 1, Key:F Parent: D\n"+
"Color: 1, Key:E Parent: F\n"+
"Color: 0, Key:H Parent: F\n"+
"Color: 1, Key:G Parent: H\n"+
"Color: 1, Key:I Parent: H\n"+
"Color: 0, Key:J Parent: I\n";
		assertEquals(str, makeStringDetails(rbt));
            
    }
	
	
	
    public static String makeString(RedBlackTree t)
    {
       class MyVisitor implements RedBlackTree.Visitor<String> {
          String result = "";
          public void visit(RedBlackTree.Node<String> n)
          {
             result = result + n.key;
          }
       };
       MyVisitor v = new MyVisitor();
       t.preOrderVisit(v);
       return v.result;
    }

    public static String makeStringDetails(RedBlackTree t)
	{
       class MyVisitor implements RedBlackTree.Visitor<String> {
          String result = "";
          public void visit(RedBlackTree.Node<String> n)
          {
        	  if(n.key == null)
        		  result += "nothing found";
        	  else if(n.parent == null)
        		  result = result +"Color: "+n.color+", Key:"+n.key+" Parent: "+"\n";
        	  else if(n.color == null)
        		  result = result +"Color: "+", Key:"+n.key+" Parent: "+n.parent.key+"\n";
        	  else if(!(n.key).equals(""))
        		  result = result +"Color: "+n.color+", Key:"+n.key+" Parent: "+n.parent.key+"\n";
             
          }
       };
       
       MyVisitor v = new MyVisitor();
       t.preOrderVisit(v);
       return v.result;
	}  
    
 }
  
