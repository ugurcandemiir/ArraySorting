package hw02;
import java.util.Arrays;

public class ArraySorter {
	private int[] data;
	public ArraySorter(int[] arrayForSorting){
		data = arrayForSorting;
					
	}
	public int smallestAfter(int start) {
		
		
		int smallest = Integer.MAX_VALUE;
		int idx = -1;
		for(int i = start; i < data.length; i++){

			if(data[i] < smallest) {
			
				idx = i;
				smallest = data[i];
	
			}
		}
		
		return idx;
		}
	
	public void oneStep (int start) {
		int returnedStart = smallestAfter(start);
		if(returnedStart != start){
			int tmp = data[start];
			data[start] = data[returnedStart];
			data[returnedStart] = tmp;
		}
		
	}
	public String toString() {
		return Arrays.toString(data);

	}
	public void sort(){
	
		for(int i = 0; i < data.length; i++) { // Sort the whole array
			oneStep(i);
		}	
	}
	
	public static void main(String[] args) {
		int[] unsorted = { 3, 7, 9, 10, 2, 6, 3, 1, 2};
		ArraySorter us = new ArraySorter(unsorted);
		System.out.println("====================================");	
		System.out.println("Raw data: " + us.toString());
		System.out.println("====================================");	
		System.out.println("Index of smallest after 4 is : " + us.smallestAfter(4));
		System.out.println("====================================");	
		System.out.println("After length step: " + us.toString());
		us.sort();
		System.out.println("====================================");	
		System.out.println("Sorted : " + us.toString());
		System.out.println("====================================");				
		
	}
	
	
}

