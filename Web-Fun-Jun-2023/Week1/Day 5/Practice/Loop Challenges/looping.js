// Print odds 1-20

 function printOdds()
 {
 for(var i = 1;i<21;i+=2)
 {
     console.log(i);
 }
 }
console.log(printOdds());

// Decreasing Multiples of 3

function decreasingMultiplesOf3()
{
    for(var i=100;i>0;i--)
    {
        if(i%3==0)
        {
            console.log(i);
        }
    }
}
console.log(decreasingMultiplesOf3());

// Print the sequence
function PrintTheSequence()

{
    for (var i = 0; i <= 5; i++) {
        var value = 4 - i * 1.5;
        console.log(value);
      };
}
console.log(PrintTheSequence());

// Sigma 
function Sigma()
{
    var sum =0;
    for(var i = 0;i<101;i++)
    {
       
        sum+=i; 
    }
    return sum;

}
console.log(Sigma());

// Factorial
function Factorial()
{
var product = 1;
for(var i = 1;i<13;i++)
{

    product *=i;

}
return product;
}
console.log(Factorial());
