import java.util.Queue;
import java.util.LinkedList;

/**
 * RadixSort implements the Least Significant Digit (LSD) Radix Sort algorithm
 * using an array of 10 Queues to achieve O(d * N) linear time complexity.
 */
public class RadixSort 
{
    /**
     * Sorts an array of non-negative integers in ascending order using Radix Sort.
     * 
     * @param array The array of non-negative integers to be sorted.
     */
    public static void radixSort(int[] array) 
    {
        if (array == null || array.length <= 1) 
        {
            return;
        }

        // =========================================================================
        // TODO 1: Initialize Array of 10 Queues
        // Create an array of 10 Queue<Integer> objects (indices 0 through 9).
        // HINT: Remember that instantiating a generic array in Java (new Queue[10]) 
        // leaves every index set to null! You must loop through and instantiate 
        // a concrete Queue (such as LinkedList or ArrayDeque) at each index.
        // =========================================================================
        
        @SuppressWarnings("unchecked")
        // YOUR CODE HERE
        

            

        // =========================================================================
        // TODO 2: Determine Maximum Number of Passes Dynamically
        // Find the maximum value in 'array' and calculate how many digit passes 
        // are required to fully sort the numbers. 
        // DO NOT hardcode the number of passes!
        // =========================================================================
        
        int maxPasses = 0;
        // YOUR CODE HERE



        // =========================================================================
        // TODO 3: Execute Radix Sort Loop (Pass-by-Pass)
        // For each pass (pass 0 = 1s digit, pass 1 = 10s digit, pass 2 = 100s digit...):
        //
        // 1. DISTRIBUTE: Iterate through 'array'. Extract the digit for the current 
        //    pass using integer division and modulo math (NO Strings!). 
        //    Enqueue the number into the corresponding bucket (0-9).
        //
        // 2. COLLECT: Iterate through buckets 0-9. Dequeue elements in FIFO order 
        //    and place them back into 'array' sequentially.
        //
        // 3. PRINT: Call printPass(array, pass + 1) to output array state.
        // =========================================================================
        
        // YOUR CODE HERE

    }

    /**
     * Helper method to print the contents of the array after a specific pass.
     * 
     * @param array      The array being sorted.
     * @param passNumber The current pass number (1-indexed for display).
     */
    public static void printPass(int[] array, int passNumber) 
    {
        System.out.print("Pass " + passNumber + ": [");
        for (int i = 0; i < array.length; i++) 
        {
            System.out.print(array[i]);
            if (i < array.length - 1) 
            {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
