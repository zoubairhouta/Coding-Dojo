// Some like it flatvar 

arr2d = [ [2, 5, 8],
              [3, 6, 1],
              [5, 7, 7] ];
    
// We can console.log the `8` in this array if we
console.log(arr2d[0][2]);
// the first index `0` will select the `[2, 5, 8]` sub-array
// the second index `2` will select the `8` out of that sub-
// Write a function called isPresent2d(arr2d, value) that returns true if the value is present and false otherwise

isPresent2d(arr2d, value)
{
    for(var i =0;i<arr2d.length;i++)

    {
        for(var j =0;j<arr2d[i].length;j++)
        {
            if(arr2d[i][j] ===value)
            {
            return true;
            }
        }
    }
    return false
}