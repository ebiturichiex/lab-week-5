//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// TIP TO RUN: press <shortcut action="Run"> or click the Run icon in the gutter.
public class Solution {
    public static void main(String[] args) {
        // Example input
        int[] nums = {38, 27, 43, 3, 9, 82, 10};

        // Invoke the sort method
        nums = sortArray(nums);

        // Print sorted array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static int[] sortArray(int[] nums) {
        // Invoke the mergeSort function
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    // Recursive mergeSort function
    public static void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            // Find the middle point
            int mid = low + (high - low) / 2;

            // Recursively sort the left and right subarrays
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);

            // Merge the sorted subarrays
            merge(array, low, mid, high);
        }
    }

    // Merge function
    public static void merge(int[] array, int low, int mid, int high) {
        // Sizes of the two subarrays to merge
        int n1 = mid - low + 1;
        int n2 = high - mid;

        // Temporary arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            left[i] = array[low + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = array[mid + 1 + j];
        }

        // Merge the temporary arrays

        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy remaining elements of left[], if any
        while (i < n1) {
            array[k++] = left[i++];
        }

        // Copy remaining elements of right[], if any
        while (j < n2) {
            array[k++] = right[j++];
        }
    }
}
