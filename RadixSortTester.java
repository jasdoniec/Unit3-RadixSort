import java.util.Arrays;
import java.util.Queue;

/**
 * RadixSortTester provides automated verification for the RadixSort implementation.
 * It tests:
 * 1. Catching uninitialized Queue arrays with helpful hints.
 * 2. Correct sorting across varied array sizes and digit lengths.
 * 3. Enforcement of FIFO (Queue) stability vs. LIFO (Stack) destruction.
 * 4. Dynamic pass counting (1-digit up to 5-digit inputs).
 */
public class RadixSortTester 
{
    private static int testsPassed = 0;
    private static int totalTests = 0;

    public static void main(String[] args) 
    {
        System.out.println("==================================================");
        System.out.println("       RUNNING RADIX SORT AUTOMATED TEST SUITE    ");
        System.out.println("==================================================\n");

        testNullPointerCatch();
        testBasicSort();
        testFifoStability();
        testVariableDigitLengths();
        testEdgeCases();

        System.out.println("==================================================");
        System.out.println("TEST RESULTS: " + testsPassed + " / " + totalTests + " PASSED");
        System.out.println("==================================================");

        if (testsPassed == totalTests) 
        {
            System.out.println("🎉 CONGRATULATIONS! Your RadixSort implementation passed all tests!");
        } 
        else 
        {
            System.out.println("❌ Some tests failed. Review the hints and diagnostic messages above.");
        }
    }

    /**
     * Tests if RadixSort catches or avoids NullPointerExceptions when dealing 
     * with array of Queues initialization.
     */
    private static void testNullPointerCatch() 
    {
        totalTests++;
        System.out.println("--- Test 1: Queue Array Initialization Check ---");
        int[] input = { 5, 2, 9, 1 };
        
        try 
        {
            RadixSort.radixSort(input);
            System.out.println("✅ Passed: No NullPointerException thrown during bucket access.");
            testsPassed++;
        } 
        catch (NullPointerException e) 
        {
            System.out.println("❌ FAILED: NullPointerException detected!");
            System.out.println("   💡 HINT: Remember that Java arrays of objects (Queue<Integer>[]) start with");
            System.out.println("   all elements set to null. You must loop from 0 to 9 and instantiate each bucket:");
            System.out.println("   buckets[i] = new LinkedList<>(); (or ArrayDeque)");
        } 
        catch (Exception e) 
        {
            System.out.println("❌ FAILED: Unexpected exception: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println();
    }

    /**
     * Tests standard unsorted array sorting accuracy.
     */
    private static void testBasicSort() 
    {
        totalTests++;
        System.out.println("--- Test 2: Basic Radix Sort Test ---");
        int[] input = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int[] expected = { 2, 24, 45, 66, 75, 90, 170, 802 };

        try 
        {
            System.out.println("Sorting input: " + Arrays.toString(input));
            RadixSort.radixSort(input);
            
            if (Arrays.equals(input, expected)) 
            {
                System.out.println("✅ Passed: Array correctly sorted -> " + Arrays.toString(input));
                testsPassed++;
            } 
            else 
            {
                System.out.println("❌ FAILED: Output mismatch!");
                System.out.println("   Expected: " + Arrays.toString(expected));
                System.out.println("   Actual:   " + Arrays.toString(input));
            }
        } 
        catch (Exception e) 
        {
            System.out.println("❌ FAILED with Exception: " + e.getMessage());
        }
        System.out.println();
    }

    /**
     * Tests whether Queue (FIFO) stability is preserved. If a student uses Stack (LIFO),
     * this specific arrangement will fail to sort correctly.
     */
    private static void testFifoStability() 
    {
        totalTests++;
        System.out.println("--- Test 3: FIFO Queue Structure Enforcement ---");
        // This specific sequence exposes LIFO (Stack) reversal during passes
        int[] input = { 12, 11, 22, 21, 32, 31 };
        int[] expected = { 11, 12, 21, 22, 31, 32 };

        try 
        {
            RadixSort.radixSort(input);
            if (Arrays.equals(input, expected)) 
            {
                System.out.println("✅ Passed: FIFO Queue ordering confirmed -> " + Arrays.toString(input));
                testsPassed++;
            } 
            else 
            {
                System.out.println("❌ FAILED: Incorrect order detected!");
                System.out.println("   Expected: " + Arrays.toString(expected));
                System.out.println("   Actual:   " + Arrays.toString(input));
                System.out.println("   💡 HINT: Did you use a Queue (FIFO) for each bucket? If elements come out");
                System.out.println("   in LIFO order (like a Stack), previous digit pass sorting will be corrupted!");
            }
        } 
        catch (Exception e) 
        {
            System.out.println("❌ FAILED with Exception: " + e.getMessage());
        }
        System.out.println();
    }

    /**
     * Tests variable digit lengths up to 5-digit numbers (10,000) to ensure pass count
     * is calculated dynamically rather than hardcoded.
     */
    private static void testVariableDigitLengths() 
    {
        totalTests++;
        System.out.println("--- Test 4: Dynamic Pass Counting (Large & Varied Digits) ---");
        int[] input = { 10000, 4, 321, 55, 9090, 7 };
        int[] expected = { 4, 7, 55, 321, 9090, 10000 };

        try 
        {
            RadixSort.radixSort(input);
            if (Arrays.equals(input, expected)) 
            {
                System.out.println("✅ Passed: Correctly sorted 1 to 5 digit numbers -> " + Arrays.toString(input));
                testsPassed++;
            } 
            else 
            {
                System.out.println("❌ FAILED: Output mismatch!");
                System.out.println("   Expected: " + Arrays.toString(expected));
                System.out.println("   Actual:   " + Arrays.toString(input));
                System.out.println("   💡 HINT: Ensure your pass counter dynamically finds the maximum value");
                System.out.println("   and runs enough passes to process all digits!");
            }
        } 
        catch (Exception e) 
        {
            System.out.println("❌ FAILED with Exception: " + e.getMessage());
        }
        System.out.println();
    }

    /**
     * Tests boundary edge cases: single element, already sorted, empty/null arrays.
     */
    private static void testEdgeCases() 
    {
        totalTests++;
        System.out.println("--- Test 5: Edge Case Handling ---");
        
        int[] single = { 42 };
        int[] singleExpected = { 42 };
        
        int[] sorted = { 1, 2, 3, 4, 5 };
        int[] sortedExpected = { 1, 2, 3, 4, 5 };

        try 
        {
            RadixSort.radixSort(single);
            RadixSort.radixSort(sorted);
            RadixSort.radixSort(null); // Should handle gracefully without crashing

            if (Arrays.equals(single, singleExpected) && Arrays.equals(sorted, sortedExpected)) 
            {
                System.out.println("✅ Passed: Handled single-element, pre-sorted, and null arrays.");
                testsPassed++;
            } 
            else 
            {
                System.out.println("❌ FAILED: Edge case failure!");
            }
        } 
        catch (Exception e) 
        {
            System.out.println("❌ FAILED with Exception: " + e.getMessage());
        }
        System.out.println();
    }
}