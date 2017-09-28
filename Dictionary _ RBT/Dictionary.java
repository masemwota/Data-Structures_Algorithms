package sjsu.asemwota.cs146.project3;

import java.io.*;
import java.util.Scanner;

import org.junit.Test;

public class Dictionary {
	
	public static void main (String [] args)
	{ 
		RedBlackTree<String> rbt = new RedBlackTree<String>();
		
		File file = new File("C:/Users/Marietta/Documents/__SJSU__/Spring 2017/CS 146/Project 3/Project3/src/sjsu/asemwota/cs146/project3/dictionary.txt");
		try
		{
			Scanner in = new Scanner(file);
	
			long dictBeg = System.currentTimeMillis();
			
			while(in.hasNext())
			{
				String s = in.next();
				rbt.insert(s);
				//System.out.println(s);
			}
			in.close();
			
			long dictEnd = System.currentTimeMillis();
			long dictElapsed = dictEnd - dictBeg;
			
			System.out.println("Time taken for dictionary: " + dictElapsed);
			
			
			File poem = new File("C:/Users/Marietta/Documents/__SJSU__/Spring 2017/CS 146/Project 3/Project3/src/sjsu/asemwota/cs146/project3/Poem.txt");
			Scanner sc = new Scanner(poem);
			
			int wordsNotFound = 0;
			int wordsFound = 0;
			
			long poemBeg = System.currentTimeMillis();
			while(sc.hasNext())
			{
				String p = sc.next();
				//look up if the word is contained in the RBT
				//if the word is not contained, put in counter
				RedBlackTree.Node<String> mine = rbt.lookup(p);
				if(mine == null)
				{
					wordsNotFound++;
					System.out.println(p);
					//System.out.println("word not found");
				}
				else 
				{
					wordsFound++;
					//System.out.println(mine.key);
				}
				
			}
			sc.close();
			
			long poemEnd = System.currentTimeMillis();
			long poemElapsed = poemEnd - poemBeg;
			
			System.out.println("Time taken for poem: " + poemElapsed);
			
			System.out.println("Words found: " + wordsFound);
			System.out.println("Words not found: " + wordsNotFound);
	    }
		catch (FileNotFoundException e)
		{
			e.getMessage();
		}
		
	}
	
}
