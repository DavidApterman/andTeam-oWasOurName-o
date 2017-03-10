//Team andTeam-OWasOurName-O: Mariaaaaa Acuna, David Bob Apterman, Arpita Nag 
//APCS pd3
//Lab#01 -- What Does the Data Say? (And How?)
//2017-03-09

/*****************************************************
 * class QuickSortTester
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): QSort will find the value at the middle of the array and use it as a pivot position. It will place all values less than the pivot to its left and all the values greater than the pivot to its right. This method will recurse through the the two sub-arrays on either side of the pivot until it encounters an array of 1 element, at which point the original array will be sorted.
 *
 * 2a. Worst pivot choice / array state and associated runtime: 
 *The worst pivot choice is when the pivot ends up being either the smallest or largest element in the array because we end up with sub-arrays of size 0 and size n-1 and end up making n-1 nested calls, resulting in a O(n^2) runtime.
An array of all or mostly equal numbers poses the same problem/possibility of.
 * 2b. Best pivot choice / array state and associated runtime:
 *The best pivot choice is one that always divides the array QuickSort is working on into two roughly equal halves. If this happens, only log2 (n) calls are needed and the runtime is O(n log n).
 * 3. Approach to handling duplicate values in array:
 *The method I coded that assumed no duplicates also worked for array with duplicates so yay QuickSort? I don't see anything wronger with them getting moved to either side of the pivot.
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

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }

    //Formerly mysterion:
    public static int partition(int [] arr, int lb, int ub, int pivot){
	// lb = lower bound, ub = upper bound
	int v = arr[pivot];
	swap( ub, pivot,arr);
	int s = lb;
	for (int i = lb; i < ub; i++){
	    if (arr[i] < v) {
		swap( s, i,arr);
		s++;
	    }
	}
	swap( ub, s,arr);
	//printArray(arr);
	//System.out.println(" Returns: "+ s +"\n"); //prints final value of s
	return s;
    }
    public static void populate( int []  a ) {
	int al = a.length;
	for ( int i = 0; i < al; i++ ) {
	    a[i] = (int) Math.random() * 101;
	}
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qSort( int[] d ) 
    { 
	qsortH(d,0,d.length-1);
    }

    // Thinkers are encouraged to roll their own subroutines.
    // Insert your auxiliary helper methods here.
    public static void qsortH(int[] d,int lb,int ub) {
	int pvtPos;
	if(lb < ub){
	    pvtPos = partition(d, lb, ub,(lb+ub)/2);
	    qsortH(d,lb,pvtPos-1);
	    qsortH(d,pvtPos+1,ub);
	}
    }

    //main method for testing
    public static void main( String[] args ) 
    {

        long beginTime;
       	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//        AVERAGE CASE 
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //Arrays to test various sizes with RANDOM numbers from 1-100. Will allow us
	//to graph average runtime curve
	int[] arr0 = {0};
	int[] arr1 = new int [10];
	int[] arr2 = new int [100];
	int[] arr3 = new int [1000];
	int[] arr4 = new int [10000];
	int[] arr5 = new int [100000];

	populate( arr1 );
	populate( arr2 );
	populate( arr3 );
	populate( arr4 );
	populate( arr5 );
	System.out.println("Just your state of the art random int array seasonal data gathering");
	beginTime = System.nanoTime();
	for (int i = 0; i < 1000; i ++){
	    QuickSortTester.qSort( arr0 );
	}
	System.out.println("Time for an array of size 1: " + ((System.nanoTime() - beginTime )) / 1000);

        beginTime = System.nanoTime();
	for (int i = 0; i < 1000; i ++){
	    QuickSortTester.qSort( arr1 );
	}
	System.out.println("Time for an array of size 10: " + ((System.nanoTime() - beginTime )) / 1000);

	beginTime = System.nanoTime();
	for (int i = 0; i < 1000; i ++){
	    QuickSortTester.qSort( arr2 );
	}
	System.out.println("Time for an array of size 100: " + ((System.nanoTime() - beginTime )) / 1000);

	beginTime = System.nanoTime();
	for (int i = 0; i < 1000; i ++){
	    QuickSortTester.qSort( arr3 );
	}
	
	System.out.println("Time for an array of size 1000: " + ((System.nanoTime() - beginTime )) / 1000);
	/*
	beginTime = System.nanoTime();
	for (int i = 0; i < 1000; i ++){
	    QuickSortTester.qSort( arr4 );
	}
	System.out.println("Time for an array of size 10000: " + ((System.nanoTime() - beginTime )) / 1000);
	
	beginTime = System.nanoTime();
	for (int i = 0; i < 1000; i ++){
	    QuickSortTester.qSort( arr5 );
	}
	System.out.println("Time for an array of size 100000: " + ((System.nanoTime() - beginTime )) / 1000);
	*/
	
       	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//        BEST CASE 
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//Arrays looking at the best case scenario ( O(n log n) )
	System.out.println();
	System.out.println("Now let's look at the best case");
	int[] b0 = {43,31,-12,45,1299,666,123};
	int[] b1 = {-14,-10,-120,-5,2,1,0};
	int[] b2 = {110,98,65,4,121,1203,999,765,732};
	int[] b3 = {57,55,50,40,30,60,90,80,70,67,65};
	int[] b4 = {40,36,30,25,16,9,36,81,64,49,47,44,41};
	int[] c0,c1,c2,c3,c4;
	beginTime = System.nanoTime();
	for (int i = 0; i < 1000; i ++){
	    c0 = b0;
	    QuickSortTester.qSort( c0 );
	}
	//	System.out.println("Time for an array of size 7: " + ((System.nanoTime() - beginTime )) / 1000);

        beginTime = System.nanoTime();
	for (int i = 0; i < 1000; i ++){
	    c1 = b1;
	    QuickSortTester.qSort( c1 );
	}
	System.out.println("Time for an array of size 7: " + ((System.nanoTime() - beginTime )) / 1000);

	beginTime = System.nanoTime();
	for (int i = 0; i < 1000; i ++){
	    c2 = b2;
	    QuickSortTester.qSort( c2 );
	}
	System.out.println("Time for an array of size 9: " + ((System.nanoTime() - beginTime )) / 1000);

	beginTime = System.nanoTime();
	for (int i = 0; i < 1000; i ++){
	    c3 = b3;
	    QuickSortTester.qSort( c3 );
	}
	System.out.println("Time for an array of size 11: " + ((System.nanoTime() - beginTime )) / 1000);

	beginTime = System.nanoTime();
	for (int i = 0; i < 1000; i ++){
	    c4 = b4;
	    QuickSortTester.qSort( c4 );
	}
	System.out.println("Time for an array of size 13: " + ((System.nanoTime() - beginTime )) / 1000);
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//        WORST CASE 
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//Arrays looking at the best case scenario ( O(n^2) )
	System.out.println();
	System.out.println("Now let's look at the worst case");
	int[] w0 = {6,4,2,1,3,5,7};
	int[] w1 = {27,22,19,18,20,24,29};
	int[] w2 = {34,27,22,19,18,20,24,29,45};
	int[] w3 = {52,34,27,22,19,18,20,24,29,45,63};
	int[] w4 = {69,52,34,27,22,19,18,20,24,29,45,63,81};
	int[] d0,d1,d2,d3,d4;
	beginTime = System.nanoTime();
	for (int i = 0; i < 1000; i ++){
	    d0 = w0;
	    QuickSortTester.qSort( d0 );
	}
	//	System.out.println("Time for an array of size 7: " + ((System.nanoTime() - beginTime )) / 1000);

        beginTime = System.nanoTime();
	for (int i = 0; i < 1000; i ++){
	    d1 = w1;
	    QuickSortTester.qSort( d1 );
	}
	System.out.println("Time for an array of size 7: " + ((System.nanoTime() - beginTime )) / 1000);

	beginTime = System.nanoTime();
	for (int i = 0; i < 1000; i ++){
	    d2 = w2;
	    QuickSortTester.qSort( d2 );
	}
	System.out.println("Time for an array of size 9: " + ((System.nanoTime() - beginTime )) / 1000);

	beginTime = System.nanoTime();
	for (int i = 0; i < 1000; i ++){
	    d3 = w3;
	    QuickSortTester.qSort( d3 );
	}
	System.out.println("Time for an array of size 11: " + ((System.nanoTime() - beginTime )) / 1000);

	beginTime = System.nanoTime();
	for (int i = 0; i < 1000; i ++){
	    d4 = w4;
	    QuickSortTester.qSort( d4 );
	}
	System.out.println("Time for an array of size 13: " + ((System.nanoTime() - beginTime )) / 1000);
	
       
    }//end main

}//end class QuickSortTester
