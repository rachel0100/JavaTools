import java.util.Arrays;

public class MinHeap {
   // wraps elementArray array
   // elementArray array is an array of a fixed length, but if it gets too big we will increase the capacity
   private int capacity = 10;
   private int size = 0;

   int[] elementArray = new int[capacity];

   /* Helper functions */
   // Get parent or child nodes
   private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
   private int getRightChildIndex(int parentIndex) { return 2 * parentIndex +2; }
   private int getParentIndex(int childIndex) { return (childIndex - 1) / 2; }

   // Check if index has parent or child nodes
   private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
   private boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }
   private boolean hasParent(int index) { return getParentIndex(index) >= 0; }

   // Return elementArray array value of parent or child nodes
   private int getLeftChildElement(int index) { return elementArray[getLeftChildIndex(index)]; }
   private int getRightChildElement(int index) { return elementArray[getRightChildIndex(index)]; }
   private int getParentElement(int index) { return elementArray[getParentIndex(index)]; }

   // Swaps values at two indices.
   private void swapElements(int index1, int index2) {
      int temp = elementArray[index1];
      elementArray[index1] = elementArray[index2];
      elementArray[index2] = temp;
   }

   // Adds extra capacity if array is full.
   private void ensureExtraCapacity() {
      if (size == capacity) {
         elementArray = Arrays.copyOf(elementArray, capacity * 2);     // create new array with double capacity, copy old array over
         capacity *= 2;                                  // double capacity size
      }
   }

   // Checks if array is empty if so return an except because there is nothing at the front
   private void checkForEmptyArray(int size) {
      if (size == 0) throw new IllegalStateException();
   }

   // Peek Method. Returns root element.
   public int peek() {
      checkForEmptyArray(size);                          // empty array check
      return elementArray[0];
   }

   // Poll Method. Extracts root element from array.
   public int poll() {
      checkForEmptyArray(size);                          // empty array check
      int elem = elementArray[0];                        // get root element
      elementArray[0] = elementArray[size - 1];          // move last element to root
      size--;                                            // shrink array 
      walkDownHeap();                                    // re-heapify
      return elem;
   }

   // Add an element.
   public void addElement(int elem) {
      ensureExtraCapacity();                             // make sure there is capacity
      elementArray[size] = elem;                         // add new element into last array spot
      size++;                                            // increase size
      walkUpHeap();                                      // adjust heap looking upwards, swaping each element with its parent
   }

   // Walks up the heap as long as the parent exists and is less than the added element.
   public void walkUpHeap() {
      int index = size - 1;                              // start at last element added
      while (hasParent(index) && getParentElement(index) > elementArray[index]) {
         swapElements(getParentIndex(index), index);     // swap the added element with its parent
         index = getParentIndex(index);                  // update index
      }
   }

   // Walks down the heap as long as the child exists and is more than the parent element.
   public void walkDownHeap() {
      int index = 0;                                     // root element
      while (hasLeftChild(index)) {
         // determine if left or right child is the smallest
         int smallChildIndex = getLeftChildIndex(index);
         if (hasRightChild(index) && getRightChildElement(index) < getLeftChildElement(index)) {
            smallChildIndex = getRightChildIndex(index); 
         }
         if (elementArray[index] < elementArray[smallChildIndex]) {
            break;                                       // break if element is smaller than child
         } else {
            swapElements(index, smallChildIndex);        // swap element with smallest child
         }
         index = smallChildIndex;                        // update index;
      }
   }
}
