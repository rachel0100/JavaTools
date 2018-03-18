public class BubbleSort {
   /* Walk through array as long as it has unsorted elements. */
   // Slow algo. O(n^2) time.
   //Low mem algo. O(1) space. 
   public static void bubbleSort(int[] arr) {
      boolean needSorting = true;                              // assume array is not sorted
      for (int k = 1; k < arr.length && needSorting; k++) {
         needSorting = false;                                  // array could be sorted
         for (int i = 0; i < arr.length - k; i++) {
            if (arr[i] > arr[i + 1]) {
               swapElement(arr, i, i + 1);                       // swap if ith is greater than ith+1
               needSorting = true;                             // array is not sorted
            }
         }
      }
   }

   public static void swapElement(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }

   public static void main(String[] args) { 
      int[] arr = {4, 6, 3, 4, -8, 14, -2, 7, 21, 6};
      bubbleSort(arr);
      for (int i = 0; i < arr.length; i++) {
         System.out.println(arr[i] + " ");
      }
   }

}
