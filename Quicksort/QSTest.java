package sjsu.Asemwota.cs146.project2;

import static org.junit.Assert.*;

//import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

public class QSTest {

	private Quicksort QS;
	
	@Before
	public void setUp() throws Exception {
		QS = new Quicksort();
	    QS.reset();
	}

	@Test
	public void testConstructor() {
		assertNotEquals(QS, null);
	}

	@Test 
	public void testSwap()
	{
		int [] array1 = {2, 4, 6, 8}; 
		int [] array2 = {2, 8, 6, 4};
		QS.swap(array1, 1, 3);
		
		assertArrayEquals(array1, array2);
		
	}
	
	@Test
	public void testPartition()
	{
		int [] array1 = {7, 3, 4, 5}; 
		int [] array2 = {7, 3, 4, 5};
		Arrays.sort(array2);
		
		int piv = 2;
		int num = QS.partition(array1, 0, array1.length-1);
		
		assertArrayEquals(array1, array2); 
		assertEquals(num, piv);
	}
	
	
	@Test
	public void testQs1() {
		int [] arraya = {5, 4, 7, 2, 3, 8, 1, 9}; 
		int [] arrayb = {5, 4, 7, 2, 3, 8, 1, 9}; //correct sorted array
		Arrays.sort(arrayb);
		
		//run QS1()
		arraya = QS.qs1(arraya, 0, arraya.length-1);
		assertArrayEquals(arraya, arrayb);
	}
	
	@Test 
	public void testQs1pop()
	{
		int [] arraya = QS.populate(8910);
		int [] arrayb = Arrays.copyOf(arraya, arraya.length);
		
		Arrays.sort(arrayb);
		arraya = QS.qs1(arraya, 0, arraya.length-1);
		
		assertArrayEquals(arraya, arrayb);
	}

	@Test
	public void testQs2() {
		int [] array1 = {7, 3, 5, 2, 9, 4}; 
		int [] array2 = {2, 3, 4, 5, 7, 9};
		
		//run QS2() 
		array1 = QS.qs2(array1, 0, array1.length-1);
		assertArrayEquals(array1, array2);
	}
	
	@Test
	public void testQS21() {
		int [] array1 = {3, 9, 2, 8, 1}; 
		int [] array2 = {1, 2, 3, 8, 9};
		
		//run QS2() 
		array1 = QS.qs2(array1, 0, array1.length-1);
		assertArrayEquals(array1, array2);
	}
	
	@Test
	public void testQS22() {
		int [] array1 = {3, 9, 2, 8, 1, 5}; 
		int [] array2 = {1, 2, 3, 5, 8, 9};
		
		//run QS2() 
		array1 = QS.qs2(array1, 0, array1.length-1);
		assertArrayEquals(array1, array2);
	}


	
	@Test 
	public void testQs2pop()
	{
		int [] arraya = QS.populate(100000);
		int [] arrayb = Arrays.copyOf(arraya, arraya.length);
		
		Arrays.sort(arrayb);
		arraya = QS.qs2(arraya, 0, arraya.length-1);
		
		assertArrayEquals(arraya, arrayb);
	}

	@Test 
	public void testRandom()
	{
		int a = 2; 
		int b = 4; 
		
		int x = QS.random(a, b);
		System.out.println(x);
		assertTrue((x >= a) && (x <= b));
	}
	
	@Test
	public void testSelect() {
		int [] array1 = new int[10];
		
		for(int i = 0; i < 10; i++)
		{
			array1[i] = i;
		}
		
		//median is 4
		int median = QS.select(array1, 0, array1.length-1, ((array1.length)+1)/2); 
		assertEquals(array1[median], 4);
	}
	
	@Test
	public void testSelect2() {
		int [] array1 = {4, 9, 2, 8, 1};
		
		//median is 4
		int median = QS.select(array1, 0, array1.length-1, ((array1.length)+1)/2); 
		assertEquals(4, array1[median]);
	}
	
	@Test
	public void testSelect3() {
		int [] array1 = {3, 9, 2, 8, 1, 5};
		//1 2 3 5 8 9
		
		//median is 3
		int median = QS.select(array1, 0, array1.length-1, ((array1.length))/2); 
		assertEquals(3, array1[median]);
	}
	
	@Test
	public void testSelect4() {
		int [] array1 = {7, -12, 108, 8, 15};
		//-12, 7, 8, 15, 108
		
		//median is 3
		int median = QS.select(array1, 0, array1.length-1, ((array1.length)+1)/2); 
		assertEquals(8, array1[median]);
	}
	
	@Test
	public void testSelect5() {
		int [] array1 = {3, 9, 2};
		//2 3 9
		
		//median is 3
		int median = QS.select(array1, 0, array1.length-1, ((array1.length)+1)/2); 
		assertEquals(3, array1[median]);
	}
	
	
	@Test
	public void testPopulate() {
		int n = 15;
		int [] array1 = QS.populate(n);
		
		assertEquals(array1.length, n);
	}

	
	@Test
	public void testReset() {
		QS.reset(); 
		
		assertEquals(QS.getPartCount(), 0);
	}

	
//	public static void main (String [] args)
//	{
//		//test for large inputs and print out total time and comparisons for both 
//		//10,000 --> 100 million (zeroes: 4, 5, 6, 7, 8)
//		Quicksort QS = new Quicksort();
//		
//		int [] size = {10000, 100000, 1000000, 10000000, 100000000}; 
//		
//		for (int n : size)
//		{
//			System.out.println("Array size: " + n);
//			int [] arr = QS.populate(n);
//			int [] arr2 = Arrays.copyOf(arr, arr.length);
//			
//			
//			//------ QS1 --------------
//			long beg = System.currentTimeMillis();
//			int [] array = QS.qs1(arr, 0, arr.length-1);
//			long  end = System.currentTimeMillis();
//			
//			long elapsed = end - beg;
//			long comp = QS.getPartCount();
//			
//			System.out.println("QS1 takes: " + TimeUnit.MILLISECONDS.toSeconds(elapsed) + " s");
//			System.out.println("QS1 took " + comp + " comparisons \n");
//			
//			QS.reset();
//			
//			
//			//---------QS2-------------
//			
//			
//			long beg2 = System.currentTimeMillis();
//			int [] array2 = QS.qs2(arr2, 0, arr2.length-1);
//			long end2 = System.currentTimeMillis();
//			
//			long elapsed2 = end2 - beg2;
//			long comp2 = QS.getPartCount();
//			
//			System.out.println("QS2 takes: " + TimeUnit.MILLISECONDS.toSeconds(elapsed2) + " s");
//			System.out.println("QS2 took " + comp2 + " comparisons \n");
//			
//			QS.reset();
//			
//			assertArrayEquals(array, array2);
//		}
//	}
}
