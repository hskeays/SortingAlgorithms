import java.util.Arrays;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        int[] array = {3, 2, 1, 0};
        System.out.println("Before: \n" + Arrays.toString(array));
        // Uncomment the sorting algorithm you want to test:
        //quickSort(array);
        //mergeSort(array);
        //insertionSort(array);
        //bubbleSort(array);
        System.out.println("\nAfter: \n" + Arrays.toString(array));
    }

    // Quicksort Algorithm
    private static void quickSort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        // Choose a random pivot element
        int pivotIndex = new Random().nextInt(highIndex - lowIndex + 1) + lowIndex;
        int pivot = array[pivotIndex];

        // Move the pivot element to the end
        swap(array, pivotIndex, highIndex);

        // Partition the array and get the index of the pivot
        int leftPointer = partition(array, lowIndex, highIndex, pivot);

        // Recursively sort the sub-arrays
        quickSort(array, lowIndex, leftPointer - 1);
        quickSort(array, leftPointer + 1, highIndex);
    }

    // Overloaded method to start the quicksort with initial parameters
    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Helper method to partition the array
    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        // Move elements smaller than the pivot to the left and larger to the right
        while (leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }

        // Move the pivot back to its correct position
        swap(array, leftPointer, highIndex);
        return leftPointer;
    }

    // Helper method to swap two elements in an array
    private static void swap(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    // Merge Sort Algorithm
    private static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }

        // Split the array into two halves
        int midIndex = array.length / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[array.length - midIndex];

        // Copy elements to the left and right halves
        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = array[i];
        }

        for (int i = midIndex; i < array.length; i++) {
            rightHalf[i - midIndex] = array[i];
        }

        // Recursively sort and merge the halves
        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(array, leftHalf, rightHalf);
    }

    // Helper method to merge two sorted arrays
    private static void merge(int[] array, int[] leftHalf, int[] rightHalf) {
        int i = 0, j = 0, k = 0;

        // Merge the two halves back into the original array
        while (i < leftHalf.length && j < rightHalf.length) {
            if (leftHalf[i] <= rightHalf[j]) {
                array[k] = leftHalf[i];
                i++;
            } else {
                array[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left and right halves
        while (i < leftHalf.length) {
            array[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightHalf.length) {
            array[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    // Insertion Sort Algorithm
    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentValue = array[i];
            int j = i - 1;

            // Shift elements greater than the current value to the right
            while (j >= 0 && array[j] > currentValue) {
                array[j + 1] = array[j];
                j--;
            }

            // Place the current value in its correct position
            array[j + 1] = currentValue;
        }
    }

    // Bubble Sort Algorithm
    private static void bubbleSort(int[] array) {
        int len = array.length;

        // Traverse the array and swap adjacent elements if they are in the wrong order
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements if they are in the wrong order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
