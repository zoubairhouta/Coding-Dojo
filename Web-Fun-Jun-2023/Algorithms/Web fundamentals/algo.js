function reverse(array)
{
    for(var i=0;i<array.length/2 ;i++)
    {
        var temp = array[i];
        array[i]=array[array.length -1 -i];
        array[array.length -1 -i] = temp;
    }
    return array;
}
console.log(reverse([8,5,6,7,2,3,56,4]));
