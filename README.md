# andTeam-oWasOurName-o
<h2> Assessment of QuickSort's Big-Oh runtime </h2>

In the best case, the Big-Oh runtime is n log n. Our implementation used the midpoint as the pivot position. If the value at the pivot position is the median value in the array, and the numbers on the left are all less than the median and sorted in descending order, and the numbers on the right are all greater than the median and sorted in descending order, QuickSort will always divide the array into optimal sub-arrays. <br>
e.g: 3,2,1,4,7,6,5 <br>
By working with optimal halves we reduce the number of nested calls needed to log n, resulting in the n log n runtime.
<br><br>
In the average case, the Big-Oh runtime appears to still be n log n (if with a higher coefficient than the best case). While the most likely case will rarely divide into nice halves, it will also rarely divide into the most undesirable configuration (an array of no elements and an array of all elements but the last pivot). By analyzing the data returned by QuickSortTester/ graphing its curve, we were able to conclude that the average case follows n log n runtime. 
<br><br>
In the worst case, the Big-Oh runtime is n^2. Once again, using the midpoint as the pivot, if the value at the pvot is the smallest value in the array, and the data is arranged in descending/ascending non-consecutive order on either side, QuickSort will always divide the array into the most undesirable configuration: a subarray of size 0 and a subarray of size n-1. <br>
e.g: 6,4,2,1,3,5,7 <br>
By working with subarrays that shrink by 1 with each call, we require n-1 nested calls, resulting in the n^2 runtime. 

<h2> Methodology </h2>

We used for loops to call QuickSort on the arrays 1,000 times and then averaged out the time value. <br>
System.nanoTime() allowed us to measure how long each task took (on average) in nanoseconds <br>
Pivot selection affects runtime massively, determing how optimally QuickSort will be able to do its job. Data arrangement is thus a major factor as well, determing the future pivot positions of QuickSort's calls to sort the subarrays.
