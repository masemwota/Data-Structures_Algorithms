package sjsu.Asemwota.cs146.project2;

import java.util.Random;

public class Quicksort {
	
	long comparisons;
	
	//there is no need for a constructor because java automatically provides an invisible no-args constructor
	
	public void reset()
	{
		comparisons = 0; 
	}
	
	
	/**
	 * Quicksort using last element as pivot
	 * 
	 * @param array the array to sort
	 * @param x - the starting index
	 * @param y - the ending index
	 * @return sorted array
	 */
	public int[] qs1 (int[] array, int x, int y)
	{
		if(x < y)
		{
			//q is pivot point <q is smaller; >q is bigger 
			int q = partition(array, x, y); 
			qs1(array, x, q-1);
			qs1(array, q+1, y);
		}
		
		return array;
	}
	
	
	/**
	 * Partition
	 * 
	 * @param array
	 * @param p - starting index
	 * @param r - ending index
	 * @return
	 */
	public int partition (int[] array, int p, int r)
	{
		//x is pivot = last element
		int x = array[r];
		
		//i is the wall between subarrays: i-1 is less than pivot 
		int i = p - 1; 
		
		//from beginning of array until the pivot point
		for(int j = p; j <= r-1; j++)
		{
			//if this element is less than the pivot
			if(array[j] <= x)
			{
				//move the wall to the right to include an element that's not supposed to be there
				i++;
				//swap the newly included element with current element
				swap(array, i, j);
			}
			comparisons++;
		}
		//swap the element to the right of wall with the pivot
		swap(array, i+1, r);
		
		//return index of pivot
		return i+1;
	}
	
	public void swap(int[] array, int x, int y)
	{
		int temp = array[x]; 
		array[x] = array[y];
		array[y] = temp;
	}
	
	/**
	 * Quicksort using the median element as pivot, by the randomized select algorithm
	 * 
	 * @param array the array to sort
	 * @param x - the starting index
	 * @param y - the ending index
	 * @return sorted array
	 */
	public int[] qs2 (int[]array, int x, int y)
	{
		if(x < y)
		{
			//int q = randomPartition(array, x, y);
			int n = y-x; 
			
			int i;
			if(n % 2 == 0)
				i = n/2;
			else
				i = (n+1)/2;
			
			int q = select(array, x, y, i);
			qs2(array, x, q-1);
			qs2(array, q+1, y);
		}
		
		return array;
	}
	
	
	
	public int randomPartition(int[] array, int p, int r)
	{
		int i = random(p, r); 
		swap(array, r, i);
		return partition(array, p, r);
	}
	
	public int random(int p, int r)
	{
		Random gen = new Random();
		int x = p + gen.nextInt(r - p + 1); 
		
		return x;
	}
	
	/**
	 * Method to select the median
	 * 
	 * @param array the array to sort
	 * @param p - the starting index
	 * @param r - the ending index
	 * @param i - the order statistic wanted - typically half of the length of the array
	 * @return median
	 */
	public int select(int[] array, int p, int r, int i)
	{
		//returning the halfway order statistic
		
		//if start is same as end index, return either
		if (p == r)
			return p;
		
		//index of pivot of array between start and end
		int q = randomPartition(array, p, r);
		int k = q - p + 1;
		
		if (i == k)
			return q; 
		
		else if (i < k)
			return select(array, p, q-1, i);
		else 
			return select(array, q+1, r, i-k);
	}
	
	
	
	
	//**************************
	
	////NOT FINISHED////////
	/**
	 * QuickSort using deterministic algorithm
	 * 
	 * @param array the array to sort
	 * @param x - the starting index
	 * @param y - the ending index
	 * @return sorted array
	 */
	public int[] qs3 (int [] array, int x, int y)
	{
		if(x < y)
		{
			//int q = randomPartition(array, x, y);
			int n = y-x; 
			
			int i;
			if(n % 2 == 0)
				i = n/2;
			else
				i = (n+1)/2;
			
			int q = select(array, x, y, i);
			qs2(array, x, q-1);
			qs2(array, q+1, y);
		}
		
		return array;
	}
	
	public int selectMedian(int[] array, int p, int r, int i)
	{
		//determine the median of medians -- x
		//partition the input array around x - diff method
		//k = index of median x
		//if k = i, return x
		//if i < k, select recursively A[1...k-1]
		//if i > k, select recursively A[k+1...n]
		
		
		return 0;
	}
	//***********************************
	
	
	
	/**
	 * Populates an array with ints 
	 * @param amount - the number of elements
	 * @return filled array
	 */
	public int[] populate(int amount)
	{
		int [] array = new int [amount];
		Random gen = new Random();
		
		for(int i = 0; i < array.length; i++)
		{
			array[i] = gen.nextInt(amount);
			//array[i] = i;
		}
		
		return array;
	}
	
	
	/**
	 * Method to count comparisons
	 * @return the amount of comparisons
	 */
	public long getPartCount() 
	{
		return comparisons;
	}
}
