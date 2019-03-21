# hw02

## Homework 02 - Due Sunday, September 9 at 11:59 PM

In class we learned more about methods, and in lab this week, we learned a little about arrays. This homework re-inforces both of those lessons by creating some methods that work with arrays, and introduces some simple (but not terribly efficient) sorting techniques.

## Reminder of Useful Commands:
```
git clone <url>
git add <filename>
git commit -am "<commit comment>"
git push
java -d ../../classes *.java
javac -cp ../../classes hw02.<class with main method>
```

## Sorting Arrays of Integers - Getting Started

:warning: Please put all classes for this assignment in package *hw02*

Let's start out with by writing a Java class called *ArraySorter* which will sort arrays of integers. This class will have a single private field - an array of integers of arbitrary length. I called this field *data*.

Add a public constructor to the ArraySorter class which takes an array of integers as an argument, and assigns that array to the field.

Next, create a *smallestAfter* method that takes a single integer as an argument. This method needs to look at the data in the array, starting at the index defined by the *start* argument, to find the *index* of the smallest value that appears at or after the *start* index value. This method should return the *index* of the smallest value. For instance, suppose you start with an unsorted integer array, declared as follows:
```java
int[] unsorted = {3, 7, 9, 10, 2, 6, 3, 1, 2};
```
Then, you create an ArraySorter object using the java code:
```java
ArraySorter us = new ArraySorter(unsorted);
```
Then, if you invoke `us.smallestAfter(4)`, the smallestAfter method should start at the value with index 4, which has the value 2 (unsorted[0]=3, unsorted[1]=7, unsorted[2]=9, unsorted[3]=10, unsorted[4]=2). The smallest value after that is the value "1", which appears at index 7, so `us.smallestAfter(4)` should return the value of 7.

For convenience, let's add a *toString* method to the ArraySorter class.  This can be coded as follows:
```java
public String toString() {
	return Arrays.toString(data);
}
```
Note that you will have to add `import java.util.Arrays;` at the top of the file to allow the Java compiler to find the "Arrays" library class.

Finally, add a main method, like:
```java
public static void main(String[] args) {
		int[] unsorted = { 3, 7, 9, 10, 2, 6, 3, 1, 2};
		ArraySorter us = new ArraySorter(unsorted);
		System.out.println("Raw data: " + us.toString());
		System.out.println("Index of smallest after 4 is : " + us.smallestAfter(4));
}
```
Compile and run this until your ArraySorter method is working.

## Sorting Arrays of Integers - Taking the Next Step

In order to sort the array of integers, we are going to use a methodology that moves the smallest remaining integer to the left in the array, shifting other data to the right. In simple terms, we are going to walk through the array, using *start* to keep track of how much we have already worked on.  The assumption is that everything before the *start* index in the array is already sorted, but everything after *start* may or may not be sorted. For the unsorted portion of the array, we want to move the lowest remaining number into the start position (if the lowest number is not already in the start position). Then we have to put the number that *was* in the start position into the place we took the lowest number from.

To do this, we will make a method called *oneStep*, which takes a single argument called *start*. This method will modify the object itself, but does not need to return any value, so the return type should be *void*. We can use the *smallestAfter* method to find the index of the smallest value after *start*. If the result is the same as *start*, then the smallest value is already at *start* and we are done. Otherwise, we need to store the value that was at the *start* index in a temporary varaible, write the value at the index returned by *smallestAfter* into `data[start]`, and write the temporary variable value into the data element at the smallestAfter result index.

Once this is coded, add the following to the main method to test it:
```java
us.oneStep(0);
System.out.println("After one step: " + us.toString());
```
Check the results. This should have moved the lowest value (the 1 at index 7) to position 0, and the value at position 0, which was a "3" to position 7.

## Sorting Arrays of Integers - Finishing the Job

The only remaining thing we need to do is to sort the entire array. To do this, create a method called *sort* which takes no arguments, and returns no value (it modifies the existing object instead.) The sort method should keep track of a *start* variable, with the assumption that everything to the left of the start variable is already sorted, and everything to the right may or may not be sorted. Notice that if we invoke the *oneStep* method, we can then extend the sorted portion of the array (and reduce the unsorted portion.) All we need to do is initialize *start* to zero, invoke *oneStep(start)*, increment *start* by one, invoke *oneStep(start)* again, and so un until *start* gets to the enf of the array (*data.length - 1*)... sounds like a pretty simple for loop.

Once you have coded your *sort* method, add the following to the main method to test it:
```java
us.sort();
System.out.println("Sorted: " + us.toString());
```

## Food for thought

Here are some questions that don't need to be answered formally, but you might want to think about the answers. (For instance, similar questions might appear on tests or quizzes in the future.)

Notice that the sort routine in the ArraySorter class is destructive in that it destroys the original order of the array. When we studied the String class, we learned about immutable objects. The strategy for these objects was to create a new version of the object, and make all changes on that new object, instead of modifying the original object. Think about what kind of changes you might want to make to ArraySorter to make it non-destructive.

How hard would it be to make the ArraySorter sort method sort in descending order instead of ascending order? What changes would be required to provide a parameter on sort to sort either in ascending or descending order?

It might be interesting to keep track of how many compares are required in order to sort an array, or how many data switches were required. It turns out that the number of compares is pretty well fixed, but the number of switches depends on how well sorted the raw data is to start with.

What should the privacy attribute on some of the methods we added be?  For instance, do you expect anyone outside the class to invoke the *smallestAfter* or *oneStep* methods? Would making these methods private be a good idea?

## Sorting a Library

For lab02, you created a Library class which contained an array of Book objects, where each book had a title and a number of pages. Using the techniques described in the ArraySorter class, can you add a *sort* method to the Library class? (You will need to copy Library.class and Book.class from your lab02 repository, and change the package to hw02.) The sort method should sort the Library from the book with the least number of pages to the book with the most number of pages. Invoke the sort method from your Library main method, and run the catalog method afterwards to make sure you got the correct results.

## Submitting hw02

When you are satisfied with your final results, don't forget to do the following commands:
```
git add ArraySorter.java Book.java Library.java
git commit -am "Final hw02 commit"
git push
git rev-parse HEAD
```
Then copy the resulting hash code, and paste it in myCourses/cs140/content/Homework Submissions/hw02 before Sunday, Sept. 9 at 11:59.

## Grading Criteria

This homework is worth 10 points. If your code does not compile, you will get an 8 point deduction. If your code gets a compiler warning, you will get a 2 point deduction. The CA's will create their own Tester class which will invoke the methods defined above for the ArraySorter class. For each method (smallestAfter, oneStep, and sort) which returns incorrect results, 2 points will be deducted. The Tester class will also create a library, and sort the library. If the result is not sorted correctly, 3 points will be deducted.
