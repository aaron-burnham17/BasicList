# BasicList
Use the starter code, including the NodeList class, 
which provides an implementation of a basic list.

We are going to use a simple lists to store very long positive numbers, one list element per digit. 
The _most significant_ digit is stored in the head element, the _least significant_ digit is stored in the tail.

As you can see, the starter code's main method already creates some very long numbers.
It is your task, fully implement all methods declared in the Project2 interface, 
so that MyProject2 can calculate the sum of positive very long numbers and store the result in a file.

All methods need to have unit-tests to verify corner cases and happy-paths.
When writing the unit-tests you may find the **java.math.BigInteger** class help-full. 
In the test code you are free to use java classes from all packages.

In the implementation of the Project2 class however, you are limited to

* import java.io.*; 
* import java.util.Iterator; 
* import java.util.Random; 

Moreover, you need to provide a detailed estimate for how often on average ANY iterator's next() method gets called, 
(depending on the value of L) when addition(Iterator<NodeList<Integer>> iterator) gets called.

#Big O Analysis addition(Iterator<NodeList<Integer> iterator)
Due to the recursive and reliant relationship between addition(Iterator), and addition(NodeList1, NodeList2) I think it is appropriate to first dissect and define why 
addition(NodeList1, NodeList2) is in fact O(n^2).

Assume we have two nodelists of equal and long lengths n1 and n2, we can see that iterator.next() is called exactly one time per element of each storing the sum mod 10 into a total nodelist and sum div 10 into a remainder nodelist.  Next we can see that addition is called recursively on our total and remainder, which for most cases we can assume is still linear time, however there are scenarios that we are neglecting. Assume that n1 and n2 are arranged in such a way that all digits prior to the least significant sum to 9 and that the corresponding least signficiant digits sum up to greater than or equal to ten. 

An example of such an arrangement is shown as follows: 

8888889 + 111111

In this case we can see that the remainder leftover from the least signficant digit incurs a domino effect on the remaining digits, calling the addition method recursively for each individual pairing of elements, which now renders our complexity for addition O(n^2).

Next we must apply this value to our second summation method addition(Iterator<NodeList<Integer>> iterator).

Within this summation method we can see that there is first a priming call to iterator.next() for each call of it. Within the method we can also see that the method itself calls addition(nodeList1, nodeList2) recursively until there are no more NodeLists left to recursively call the method on. With this we can assume that the first priming call creates at most linear complexity, and that the recursive call is also n, however, due to the dependence on the recursive call creates a multiplicative relation between the two such that their relationship could be expressed as follows. n1 + n1(n1^2) + n2 + n2(n2^2) + ... + n + n(n^2) which we can simplify to O(n + n^3). With enough nodelists within our iterator, we can drop the n as the n^3, by definition, grows at a much faster rate than n, rendering the final complexity for our addition(Iterator<NodeList<Integer>> iterator) O(n^3).  
