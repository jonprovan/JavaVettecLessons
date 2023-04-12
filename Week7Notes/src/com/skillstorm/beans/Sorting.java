package com.skillstorm.beans;

public class Sorting {

	// repetitive operation, so i made it a method
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	// need a method for finding our partition
	// partition is where the sorting happens, it puts all of the low values on one side and 
	// the high values on the other
	private int partition(int[] arr, int low, int high) {
		// we use the last index as a pivot, and sort based on that pivot
		int pivot = arr[high];
		int i = low - 1; // swap marker
		
		System.out.println("Pivot: " + pivot + ", Low: " + arr[low]);
		
		for (int j = low; j <= high - 1; j++) { // j is our current index
			// if the current value is less than the pivot
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
			print(arr);
		}
		// swap our pivot and whatever our swap marker is
		swap(arr, i + 1, high);
		print(arr);
		return i + 1;
	}
	
	//need a method for the actual quicksort
	public void quicksort(int[] arr, int low, int high) {
		// want to loop through this as long as our low index is < our high index
		if (low < high) {
			// partition is going to up all our low values on one side and high values on the other
			int partitionIndex = partition(arr, low, high);
			
			// splits the array in half at the partition
			quicksort(arr, low, partitionIndex - 1);
			quicksort(arr, partitionIndex + 1, high);
		}
	}
	
	public void insertionSort(int[] arr) {
		int length = arr.length;
		// you search a value and everything below that value
		for (int i = 1; i < length; i++) {
			int value = arr[i]; // the value we are comparing
			int j = i - 1; // the index we are comparing value to
			
			System.out.println("Loop: " + i + ", Checking: " + value);
			
			while (j >= 0 && arr[j] > value) {
				System.out.print("Against " + arr[j] + " -> ");
				// while we are still in a valid index and our value is less than
				// j, we shift j over one space
				arr[j + 1] = arr[j];
				j--;
				print(arr);
			}
			// j is now either -1 or is less than value
			arr[j + 1] = value; // we went too far, go back and place value there
			print(arr);
		}
	}
	
	// has to recheck the array multiple times
	public void bubbleSort(int[] arr) {
		// each number bubbles up until its at the correct spot
		int length = arr.length;
		
		// need to stop before the end of the array because we are comparing
		// our value with the next one, can't compare with null
		for (int i = 0; i < length - 1; i++) {
			// need to keep track of the index of the value we're comparing,
			// we start from 0 on every loop
			// the end half of the array will always be sorted due to the bubbling,
			// so we dont check it
			System.out.println("Loop: " + (i + 1));
			for (int j = 0; j < length - i - 1; j++) {
				System.out.print("Checking: " + arr[j] + " -> ");
				if (arr[j] > arr[j + 1]) {
					// swap these elements
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
				print(arr);
			}
		}
	}
	
	// arrays dont have a nice toString
	public void print(int[] arr) {
		System.out.print("[ ");
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println(" ]");
	}
}
