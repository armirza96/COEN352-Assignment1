package Question5;

/**
 * 
 * @author abdul
 *	this program takes in an array and a target value
 * and prints out the index of target value in the array
 * in 2logn time
 */

public class BitonicArray {
	public static void main(String[] args) {

		// value in array to searcg for
//		int target = 4; //9;
//		
//		int[] bitonicArray = {
//				1,2,3,4,5, // increasing
//				10,9,8,7,6 // decreasing
//		};
		
		int target = 14;
		
		int[] bitonicArray = {
				1,2,3,4,5,6,7,8,9,10, // increasing
				25,24,23,22,21,20,19,18,17,16,15,14,13,12,11 // decreasing
		};
		
		int right = bitonicArray.length - 1;
		int left = 0;
		
		int bitonicPoint = findBitonicPoint(bitonicArray, left, right);
		
		System.out.println("Bitonic Point: " + bitonicPoint + "; Value in array: " + bitonicArray[bitonicPoint]);
		
		
		int indexAt = 0;
		if(target < bitonicArray[bitonicPoint] && target > bitonicArray[right]) {
			
			indexAt = binarySearchRightSide(bitonicArray, bitonicPoint, right, target);
		} else {
			indexAt = binarySearchLeftSide(bitonicArray, left, bitonicPoint, target);
		}
		
		if(indexAt > -1) { 
			System.out.println("Value found at index: " + indexAt + "; Value is (from array): " + bitonicArray[indexAt]);
		} else {
			System.out.println("Value not found");
		}
	}
	
	static int findBitonicPoint(int[] array, int left, int right) {
		
		System.out.println("Bitonic Point: " + left + " " + right + " " + array[left] + " " + array[right]);
		
	    int mid = left + (right - left) / 2; 

        if (left < array[mid] && array[mid] > right) 
            return mid; 
	  
        if (array[mid] > array[left] && array[mid] > array[right]) 
            return findBitonicPoint(array, left, mid + 1); 
	  
        if (array[mid] < array[left] && array[mid] < array[right]) 
            return findBitonicPoint(array, left, mid + 1); 

	    return findBitonicPoint(array, mid - 1, right);       
	}
	
	static int binarySearchRightSide(int[] array, int left, int right, int target) {
        if (left <= right) { 
            int mid = left + (right - left) / 2; 
  
            if (array[mid] == target) 
                return mid; 
  
            if (array[mid] < target) 
                return binarySearchRightSide(array, left, mid - 1, target); 
  
            return binarySearchRightSide(array, mid + 1, right, target); 
        }
		return -1; 
	}
	
	static int binarySearchLeftSide(int[] array, int left, int right, int target) {
        if (left <= right) { 
            int mid = left + (right - left) / 2; 
  
            if (array[mid] == target) 
                return mid; 
  
            if (array[mid] > target) 
                return binarySearchLeftSide(array, left, mid - 1, target); 
  
            return binarySearchLeftSide(array, mid + 1, right, target); 
        }
		return -1; 
	}
}
