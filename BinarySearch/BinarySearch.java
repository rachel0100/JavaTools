public class BinarySearch {

   public static void main(String[] args) { 
      int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
      int val = 5;
      System.out.println(iterativeBinarySearch(arr, val));
   }

   public static int iterativeBinarySearch(int[] arr, int val) {
      int low = 0;
      int high = arr.length-1;

      while (low <= high) {
         int mid = (high + low) / 2;
         if (val < arr[mid]) {
            high = mid - 1; 
         } else if (val == arr[mid]) {
            return mid;
         } else {
            low = mid + 1;
         }
      }
      return -1;
   }

}
