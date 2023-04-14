package com.skillstorm.beans;

public class Sorting {

	private void merge(int[] arr, int left, int mid, int right) {
		// need to find the size for both of our arrays that we want to merge
		int leftSize = mid - left + 1;
		int rightSize = right - mid;
		
		// create out new arrays
		int[] leftArray = new int[leftSize];
		int[] rightArray = new int[rightSize];
		
		// copy our data over
		for (int i = 0; i < leftSize; i++) {
			// data for the left array
			// need to move past our leftmost index as we progress
			// left + i [when i == 0] == left-most index
			leftArray[i] = arr[left + i];
		}
		
		for (int j = 0; j < rightSize; j++) {
			// data for the right array
			// right side starts from 1 past the mid point
			rightArray[j] = arr[mid + 1 + j];
		}
		
		System.out.print("Left -> ");
		print(leftArray);
		System.out.print("Right -> ");
		print(rightArray);
		
		// now we merge them together
		int l = 0, r = 0; // initial indexes of both
		
		// index where we want to start adding these in our original array
		int oIndex = left; 
		
		while (l < leftSize && r < rightSize) {
			// add the values in
			if (leftArray[l] <= rightArray[r]) {
				// if our left array value is smaller, or equal then insert it
				arr[oIndex] = leftArray[l];
				l++;
			} else {
				arr[oIndex] = rightArray[r];
				r++;
			}
			oIndex++;
		}
		
		// if there is anything left in either array
		while (l < leftSize) {
			arr[oIndex] = leftArray[l];
			l++;
			oIndex++;
		}
		
		while (r < rightSize) {
			arr[oIndex] = rightArray[r];
			r++;
			oIndex++;
		}
		
		System.out.print("Merged -> ");
		print(arr); // the entire array wont change, but the pieces we rearranged will
	}
	
	// the sorting piece, this will break my array up
	public void mergeSort(int[] arr, int left, int right) {
		// left-most index, right-most index
		// and the array
		if (left < right) { // my base case
			//if left is not less than right then length is not 1
			// find our mid point index
			int mid = (left + (right - 1)) / 2;
			
			// break up those two halves further
			mergeSort(arr, left, mid); // first half
			mergeSort(arr, mid + 1, right); // our second half
			
			// once they are just one element in size
			merge(arr, left, mid, right);
		}
	}
	
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
		// when the high and low values are the same thing the length is 1, so we stop
		// this is our base case
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
		System.out.println("]");
	}
}
