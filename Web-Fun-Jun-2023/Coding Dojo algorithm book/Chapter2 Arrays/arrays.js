// ***PushFront
// ---Given an array and an additional value, insert this
// value at the beginning of the array. Do this
// without using any built-in array methods.
function pushFront(arr,value)

{
   var newarray = [value];
   for(var i=0;i<arr.length;i++)
   {
      newarray.push(arr[i]);
   }
   return newarray;
}
console.log(pushFront([89,5,-8,789,2,21,-36],5.9));

// ***InsertAt
// ---Given an array, index, and additional value, insert
// the value into the array at the given index. Do this
// without using built-in array methods. You can
// think of PushFront(arr,val)​ as equivalent to
// InsertAt(arr,0,val)​.

function InsertAt(arr, index, value) {
   var newArr = new Array(arr.length + 1);
 
   for (var i = 0; i < index; i++) {
     newArr[i] = arr[i];
   }
 
   newArr[index] = value;
 
   for (var i = index; i < arr.length; i++) {
     newArr[i + 1] = arr[i];
   }
 
   return newArr;
 }

// ***PopFront
// ---Given an array, remove and return the value at
// the beginning of the array. Do this without using
// any built-in array methods except pop().

function PopFront(arr) {
   var firstElement = arr[0];
 
   for (var i = 0; i < arr.length - 1; i++) {
     arr[i] = arr[i + 1];
   }
console.log(arr); 
   arr.pop();
 
   return firstElement;
 };

// ***RemoveAt
// ---Given an array and an index into the array,
// remove and return the array value at that index.
// Do this without using any built-in array methods
// except pop()​. Think of PopFront(arr)​ as
// equivalent to RemoveAt(arr,0)
function RemoveAt(arr, index) {
   var removedValue = arr[index];
 
   for (var i = index; i < arr.length - 1; i++) {
     arr[i] = arr[i + 1];
   }
 
   arr.pop();
 
   return removedValue;
 }


// ***Reverse Array
// ----Given a numerical array, reverse the order of the
// values. The reversed array should have the same
// length, with existing elements moved to other
// indices so that the order of elements is reversed.
function reverseArray(arr)
{
   for(var i =0;i<arr.length/2;i++)
   {
      arr[i]
   }
}


// ***Remove Negatives
// ---Implement a function removeNegatives()​ that
// accepts an array and removes any values that
// are less than zero.
// Second-level challenge: ​don’t use nested loops.
function removeNegative(array) {
   var array1 = array.slice(); 
   for (var i = array1.length - 1; i >= 0; i--) {
      if (array1[i] < 0) {
         array1.splice(i, 1); 
      }
   }
   return array1;
}

removeNegative([9, 8, 7, -8, -12, -15, 5]);



// ***Skyline Heights
// ---You are given an array with heights of consecutive buildings in the city. For example, [-1,7,3]​ would
// represent three buildings: first is actually below street level, second is seven stories high, and third is
// three stories high (but hidden behind the seven-story onbe). You are situated at street level. Return an
// array containing heights of the buildings you can see, in order. Given [1,-1,7,3]​ return [1,7]​.
function skylineHeights(buildings) {
   var visibleBuildings = [];
   var maxHeight = 0;

   for (var i = 0; i < buildings.length; i++) {
      if (buildings[i] > maxHeight) {
         visibleBuildings.push(buildings[i]);
         maxHeight = buildings[i];
      }
   }

   return visibleBuildings;
}

var buildings = [1, -1, 7, 3];
var visibleBuildings = skylineHeights(buildings);
console.log(visibleBuildings); 

// ***Binary Search
// ---Given a sorted array and a value, return whether
// that value is present in the array. Do not
// sequentially iterate the entire array. Instead,
// ‘divide and conquer’, taking advantage of the fact
// that the array is sorted.
function binarySearch(array, value) {
   var low = 0;
   var high = array.length - 1;

   while (low <= high) {
      var mid = Math.floor((low + high) / 2);

      if (array[mid] === value) {
         return true; 
      } else if (array[mid] < value) {
         low = mid + 1; 
      } else {
         high = mid - 1; 
      }
   }

   return false; // Value not found
}

var sortedArray = [1, 3, 5, 7, 9, 11, 13,18];
console.log(binarySearch(sortedArray, 7)); 
console.log(binarySearch(sortedArray, 4)); 




// ***Min Of Sorted-Rotated
// ---You will be given a numerical array that has first
// been sorted, then rotated by an unknown
// amount. Find and return the minimum value in
// that array.

function findMinSortedRotated(array) {
   var low = 0;
   var high = array.length - 1;

   while (low < high) {
      var mid = Math.floor((low + high) / 2);

      if (array[mid] > array[high]) {
         // The pivot point is in the right half
         low = mid + 1;
      } else {
         // The pivot point is in the left half or at mid
         high = mid;
      }
   }

   return array[low];
}


// ***Rotate Array
// ---Implement rotateArr(arr, shiftBy)​ that
// accepts array and offset. Shift arr’s values to the
// right by that amount. ‘Wrap-around’ any values
// that shift off array’s end to the other side, so that
// no data is lost. Operate in-place: given
// ([1,2,3],1)​, change the array to [3,1,2]​.
// Optionally, add these advanced features:
// a) allow a negative shiftBy (shift left, not right),
// b) minimize memory usage. With only a few local
// variables (not an array), handle arrays and
// shiftBys in the millions,
// c) minimize how many touches of each element.


function rotateArr(arr, shiftBy)
{
   
var arr1 = arr.slice(0,shiftBy);
var arr2 = arr.slice(shiftBy,arr.length-1);


var concatenedArray = arr2.concat(arr1);
  return concatenedArray;

}

console.log(rotateArr([7,8,9,25,32,11,22,14], 3));

// ***Second-to-Last
// ---Return the second-to-last element of an array.



// ***Second-Largest
// ---Return the second-largest element of an array.




// ***Nth-to-Last
// ---Return the element that is N-from-array’s-end.



// ***Nth-Largest
// ---Given an array, return the Nth-largest element:
// there should be (N - 1) elements that are larger.

// ***arrConcat
// ---Replicate JavaScript’s concat()​. Create a
// standalone function that accepts two arrays.
// Return a new array containing the first array’s
// elements, followed by the second array’s
// elements. Do not alter the original arrays. Ex.:
// arrConcat( ['a','b'], [1,2] )​ should
// return ['a','b',1,2]​.



// ***Shuffle
// ---Recreate the shuffle()​built into JavaScript, to
// efficiently shuffle a given array’s values. Do you
// need to return anything from your function?


// ***Faster Factorial
// ---Remember iFactorial from last chapter? Take
// that implementation and use a time-space
// tradeoff to accelerate the average running time.
// Recall that iFactorial(num) returns the product of
// positive integers from 1 to the given num. For
// example: fact(1)​ = 1, fact(2)​ = 2, fact(3)
// = 6. For these purposes, fact(0)=1


// ***Smarter Sum
// ---Use a time-space tradeoff to accelerate the
// average running time of an iSigma(num) function
// that returns the sum of all positive integers from 1
// to num. Recall: sig(1) = 1, sig(2) = 3, sig(3) = 6,
// sig(4) = 10.



// ***Fabulous Fibonacci
// ---Use a time-space tradeoff to accelerate the
// average running time of an iFibonacci(num)
// function that returns the ‘num’th number in the
// Fibonacci sequence. Recall: fib(0) = 0, fib(1) = 1,
// fib(2) = 1, fib(3) = 2.



// ***Tricky Tribonacci
// ---Why stop with fibonacci? Create a function to
// retrieve a “tribonacci” number, from the sum of
// the previous 3. Tribonaccis are {0, 0, 1, 1, 2, 4, 7,
// 13, 24, 44, 81, ...}. Again, use a time-space
// tradeoff to make this fast.