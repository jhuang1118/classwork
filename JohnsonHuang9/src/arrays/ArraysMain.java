package arrays;

import java.util.Arrays;

public class ArraysMain {
	
	private String[] suits;
	private String[] values;
	
	
	public ArraysMain() {
		tuesdayMethods();
	}
	
	private void tuesdayMethods() {
		int[] orderTest = {1,20,3,65,5,54,7,8,63,10};
		isConsecutive(orderTest,2,5);
		System.out.println(Arrays.toString(orderTest));
		System.out.println(isConsecutive(orderTest,2,5));
		System.out.println(longestConsecutiveSequence(orderTest));
	}
	
	
	/**
	 * return the length of the longest con. sequence in the array
	 * ex: lcs({1,2,3,2,3,4,5,2,3,4}) -> 4
	 * @param arr
	 * @return
	 */
	private int longestConsecutiveSequence(int[] arr) {
		/*int lcs = 1;
		for(int i = 0; i < arr.length - 1; i++) {
			if(isConsecutive(arr, i, i + 1)) {
				lcs++;
			}
			else {
				lcs = 1;
			}
			
		}
		return lcs;*/
		int max = 1;
		int current = 1;
		for(int i = 0; i < arr.length; i++) {
			while (i + current < arr.length && isConsecutive(arr, i, i + current)) {
				current++;
			}
			if(current > max) {
				max = current;
			}
			i = i + current -1;
			current = 1;
		}
		return max;
	}
	
	/**
	 * returns true if all of the elements from start to end are increasing by 1
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	private boolean isConsecutive(int[] arr, int start, int end) {
		for(int i = start; i < end; i++) {
			if(arr[i] != arr[i + 1] - 1) {
				return false;
			}
		}
		
		return true;
	}
	/**
	 * The element at index 0 moves to the last position in the array
	 * as all other elements move forward. This must happen exactly n times.
	 * @param arr
	 * @param n
	 */
	private void cycleThrough(int[] arr, int n) {
		for(int i = 0; i < n ; i++) {
			frontToBack(arr);
		}
	}

	/**
	 * removes the element at index 0, pushes all other elements
	 * forward
	 * puts the element that was at index 0 at the end
	 * @param arr
	 */
	private void frontToBack(int[] arr) {
		int temp = arr[0];
		for(int i = 0; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[arr.length - 1] = temp;
	}
	
	private void warmUpMethods() {
		int[] testArray = {1,2,3,4,5};
		reverseOrder(testArray);
		System.out.println(Arrays.toString(testArray));
		System.out.println(Arrays.toString(subArray(testArray,2,2)));
	}
	private void reverseOrder(int[] arr) {
		for(int i = 0; i < arr.length/2; i++) {
			swap(arr,i,arr.length- 1 - i);
		}
	}
	
	private int[] subArray(int[] arr, int start, int length) {
		int[] newArray = new int[length];
		for(int i = 0; i < length; i++) {
			newArray[i] = arr[i + start];
		}
		return newArray;
	}
	
	public void cardMethods() {
		suits = new String[4];
		suits[0] = "Clubs";
		suits[1] = "Hearts";
		suits[2] = "Diamonds";
		suits[3] = "Spades";
		values = new String[13];
		for(int i = 0; i < values.length; i++) {
			values[i] = "" +(i + 1);
		}
		values[0] = "Ace";
		values[12] = "King";
		values[11] = "Queen";
		values[10] = "Jack";
		printDeck();
	}
	
	private void printDeck() {
		String[] deck = new String[52];
		int index = 0;
		for(String suit: suits){
		  for(String value: values){
		  	deck[index] = value + " of " + suit;
		  	index++;
		  }
		 }
		 
	}
		
	private void shuffle(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			swap(arr, i, (int)(Math.random() * arr.length));
		}
		
	}
	/**
	 * Swaps elements at i and j 
	 * @param arr
	 * @param i
	 * @param j
	 */
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	/**
	 * Populate arr with numbers from 1 to arr.length, in order
	 * @param arr
	 */
	
	private void populate1ToN(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		
	}

	private void countOccurences(int[] arr, int start, int end) {
		//why create an array with this length?
		int[] counter = new int [end - start +1];
		for(int value: arr) {
			//why value - start?
			counter[value - start]++;
		}
		for(int i = 0; i < counter.length; i++) {
			System.out.println("The value " + (i + start) + " was rolled " + counter[i] + "times.");
		}
	}

	/**
	 * this method populates arr with results from rolling 2 dice 
	 * @param arr
	 */
	
	private void populate(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = diceRoll(3);
		}
		
		//incorrect way:
//		for(int value: arr) {
//			value = diceRoll(2);
//		}
	}
	
	public void arrayNotes() {
		// two ways to construct an array:
				int[] firstWay = {0,1,2,3,4,5};
				//this way will only work with the declaration.
				//will not work:
//				firstWay = {6,7,8,9,10};
				
				String[] secondWay = new String[5];
				//you can go on like so, creating values at each index:
//				secondWay[0] = 1;
//				secondWay[1] = 10;
				
				//TWO WAYS TO ITERATE THROUGH AN ARRAY:
				for(int i = 0; i < secondWay.length; i++) {
					System.out.println("The #" + i + " element is " + secondWay[i]);
				}
				
				for(String value: secondWay) {
					System.out.println("Element is " + value);
				}
				//NOTE: primitive arrays are auto-populated with 0s;
				//Object arrays are not populated (null)
	}
	
	public static void main(String[] args) {
		ArraysMain sample = new ArraysMain();
		//1. Arrays are collections of primitives and Objects
		//SPECIAL NOTE: This is the ONLY collection of primitives
	
		//2. Size cannot be edited
		
		/*3. Elements of an array are REFERENCES to objects. In 
		 * other words, changing an element of an array changes the reference,
		 * not the object.
		 */
	}
	
	/**
	 * returns the result after rolling n number of dice
	 * @param n
	 * @return
	 */
	
	public int diceRoll(int n) {
		int sum = 0;
		for(int i = 0; i < n; i++) {
			int num = (int) ((Math.random() * 6) + 1);
			sum += num;
		}
		return sum;
	}
	
	
}
