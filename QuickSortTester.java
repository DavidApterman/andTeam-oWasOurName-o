
/*****************************************************
 * class QuickSortTester
 *
*
* Answer questions here; algorithm already commented
 *****************************************************/

/***
    PROTIP: Assume no duplicates during initial development phase.
    Once you have a working implementation, test against arrays 
    with duplicate values, and revise if necessary. (Backup first.)
 ***/

public class QuickSortTester 
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }
    //--------------^  HELPER METHODS  ^--------------

    //left = upper bound, partition = pivot choice, right = lower bound
    public static int partition(int[] arr, int left, int right, int partition){
      //  System.out.println(printArray(arr));
        int v = arr[partition];
        int swapped = arr[right];
        arr[right] = arr[partition];
        arr[partition] = swapped;
      //  System.out.println(printArray(arr));
        int s = left;
        for(int i = left; i < right; i++){
            if(arr[i] <= v){
                int swap = arr[s];
                arr[s] = arr[i];
                arr[i] = swap;
               // System.out.println(printArray(arr));
                s += 1;
            }
        }
        int newSwap = arr[right];
        arr[right] = arr[s];
        arr[s] = newSwap;
        //System.out.println(printArray(arr));
        return s;
    }
    //************************************** TESTER/TIMING HELPER METHODS **************************************
    
    //Builds an array w/ random numbers ranging from 0 to ray (not inclusive of ray)
    
    public static int[] fillRandom(int ray){
        int[] ary = new int[ray];
        for(int i = 0; i < ary.length; i++){
            ary[i] = (int) (Math.random() * ray);
        }
        return ary;
    }
    
    // Builds an array w/ everything already in order :)
    public static int[] fillSorted(int ray){
        int[] ary = new int[ray];
        for(int i = 0; i < ary.length; i++){
            ary[i] = i;
        }
        return ary;
    }
    
    /*
        * Helper method to measure the amount of time it takes to do quicksort
        * Takes in an int ray = array size for merge sort to be performed on
        * Returns the amount of time it took to perform mergesort in nanoseconds
    */
    public static long time(int[] ray){
        //Makes randomly filled array
        
        //Starts time
        long start = System.nanoTime();
        
        //Sorts it w/ QuickSort on newly filled array
        QuickSortTester.qsort(ray);
        
        // Ends time
        long end = System.nanoTime();
        
        //Returns total time
        return end - start;  
    }
    
    
    
    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d ) 
    { 
        qsortH(d, 0, d.length - 1);
    }
    
    public static void qsortH(int[] arr, int left, int right){
       
        if(left < right){
                int pvtPos = partition(arr, left, right, ((left + right) / 2));
                qsortH(arr, left, pvtPos-1);
                qsortH(arr, pvtPos + 1, right);
            }
    }

    
    // Calculates average of running quicksort on the same array 100000 times, shuffling (or not if it's on an already sorted array) 
    // Prints out this average runtime
    public static long averagePrint (int[] ary, boolean random) {
        
       // counter is used to add up all the quicksort times
	   long counter = 0;
        
       // Performs quick sort on 10000 arr-sized arrays and gets the times -- 10,000 repetitions
	   for (int i = 0; i < 100000; i ++) {
        if(random) shuffle(ary);
	       counter += (time (ary));
	   }
        
       // Returns average of these times
	   return (counter / 100000);
    }
    
    public static void main( String[] args ) 
    {
        /**
            - This method, for every number (in intervals of 10) 100 -- 10000:
                makes an array of size [number] first randomly arranged
                runs quicksort on it 100000 times, shuffling it each time
                times each run of quicksort in nanoseconds
                averages these 100000 times out
                prints out this average
                makes an array of size [number] already sorted
                runs quicksort on it another 100000 times, not shuffling each time
                averages
                prints out average
                continues to next number
                Should give us a good estimate of efficiency
                
        **/
        
        for (int i = 100; i < 10010; i+= 10){
            int[] arr = QuickSortTester.fillRandom(i);
            long random = QuickSortTester.averagePrint(arr, true);
            System.out.println("Random Array: n = " + i + " -- " + random);
            System.out.println("------------------------------------------------");
            int[] arry = QuickSortTester.fillSorted(i);
            long sorted = QuickSortTester.averagePrint(arry, false);
            System.out.println("Sorted Array: n = " + i + " -- " + random);
            System.out.println("------------------------------------------------");
        }
	//get-it-up-and-running, static test case:
	

    }//end main

}//end class QuickSort
