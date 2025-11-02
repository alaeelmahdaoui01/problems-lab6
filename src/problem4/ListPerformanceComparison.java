package problem4;

import java.util.*;

public class ListPerformanceComparison {

    private static final int SIZE = 100_000;        // total elements
    private static final int OPERATIONS = 10_000;   // random operations to test

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();


        System.out.println("---- Performance Comparison ----");

        System.out.println("---- Populate both lists ----");
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // 2️⃣ Random insertions and deletions
        testRandomInsertDelete(arrayList, "ArrayList");
        testRandomInsertDelete(linkedList, "LinkedList");

        // 3️⃣ Sequential insertions/deletions at beginning and end
        testSequentialInsertDelete(arrayList, "ArrayList");
        testSequentialInsertDelete(linkedList, "LinkedList");

        // 4️⃣ Random access test
        testRandomAccess(arrayList, "ArrayList");
        testRandomAccess(linkedList, "LinkedList");
    }

    // ------------------------------------------------------------

    private static void testRandomInsertDelete(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        for (int i=0 ; i < OPERATIONS; i++){
            list.add(random.nextInt(list.size()), 100);
            list.remove(random.nextInt(list.size()));
        }


        long end = System.nanoTime();
        System.out.printf("%s - Random insert/delete: %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------

    private static void testSequentialInsertDelete(List<Integer> list, String name) {
        long start = System.nanoTime();

        // Insertions at beginning and end

        for (int i=0 ; i < OPERATIONS; i++){
            list.add(0, 20) ;  // adding at first
            list.add(41);  // adding element at last
        }

        // Deletions at beginning and end
        for (int i=0 ; i < OPERATIONS; i++){
            list.remove(0) ;  // removing at first
            list.remove(list.size() -1);// removing element at last
        }



        long end = System.nanoTime();
        System.out.printf("%s - Sequential insert/delete (start/end): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------

    private static void testRandomAccess(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        long sum = 0;
        for (int i = 0; i < OPERATIONS; i++) {
            sum+= list.get(random.nextInt(list.size())) ;
        }

        long end = System.nanoTime();
        System.out.printf("%s - Random access (get): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }
}

// Analyze the results
// Explain why one performs better than the other in each scenario
// based on their underlying data structures


// output :
// ---- Performance Comparison ----
// ---- Populate both lists ----
// ArrayList - Random insert/delete: 212,690 ms
// LinkedList - Random insert/delete: 2852,278 ms
// ArrayList - Sequential insert/delete (start/end): 306,689 ms
// LinkedList - Sequential insert/delete (start/end): 7,509 ms
// ArrayList - Random access (get): 3,482 ms
// LinkedList - Random access (get): 1369,193 ms

// Analyzing the results and explanation

// In the random insert/delete, we notice that neither ArrayList nor LinkedList has efficient time
// they're both slow but ArrayList remains better
// because in ArrayList, it must shift elements after the index where there was an addition or removal
// and in LinkedList it traverses to the wanted index

// In the sequential insert/delete at beginning and end, LinkedList is clearly better and faster
// compared to ArrayList. Because LinkedList has direct references to first and last indexes so O(1) complexity
// meanwhile ArrayList must shift elements when adding or removing at the start, thus we have O(n) complexity

// In the random access, ArrayList is clearly better and faster
// compared to LinkedList. Because ArrayList has direct access by index so O(1) complexity
// meanwhile LinkedList must traverse elements from start to end to reach the index, thus we have O(n) complexity

