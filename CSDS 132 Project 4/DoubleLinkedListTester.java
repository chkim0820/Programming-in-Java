/**
 * A class containing test codes for DoubleLinkedList class.
 * @author Chaehyeon Kim
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

public class DoubleLinkedListTester {

    /**
     * Tests if the overridden equals method in DoubleLinkedList works
     */
    @Test
    public void testEquals() {
        // two lists that are equal with the same length
        DoubleLinkedList < Integer > list1 = new DoubleLinkedList < Integer > ();
        for (int i = 5; i > 0; i--)
            list1.addToFront(i);
        DoubleLinkedList < Integer > list2 = new DoubleLinkedList < Integer > ();
        for (int i = 5; i > 0; i--)
            list2.addToFront(i);
        // list with the same length but different elements
        DoubleLinkedList < Integer > list3 = new DoubleLinkedList < Integer > ();
        for (int i = 10; i > 5; i--)
            list3.addToFront(i);
        // list with different length
        DoubleLinkedList < Integer > list4 = new DoubleLinkedList < Integer > ();
        list4.addToFront(1);
        // list that is null
        DoubleLinkedList < Integer > list5 = new DoubleLinkedList < Integer > ();
        assertEquals("Two lists that are equal with the same length returns a false false", true, list1.equals(list2));
        assertEquals("Two lists that are equal with the same length returns a false false", true, list2.equals(list1));
        assertEquals("Two lists of the same lengths with diff. elements returns a false true", false, list1.equals(list3));
        assertEquals("A longer list and a list with a single element returns a false true", false, list1.equals(list4));
        assertEquals("A list with elements with a null list returns a false false", false, list1.equals(list5));
        assertEquals("A list with a single element compared with a null list returns a false true", false, list4.equals(list5));
    }

    /**
     * Tests if the append method in DoubleLinkedList works
     */
    @Test
    public void testAppend() { // check the link b/w two links
        // 1st list containing elements 1 to 4 (multiple elements)
        DoubleLinkedList < Integer > list1 = new DoubleLinkedList < Integer > ();
        for (int i = 4; i > 0; i--)
            list1.addToFront(i);
        // 2nd list containing elements 5 to 8 (multiple elements)
        DoubleLinkedList < Integer > list2 = new DoubleLinkedList < Integer > ();
        for (int i = 8; i > 4; i--)
            list2.addToFront(i);

        // 1st list with a single elements
        DoubleLinkedList < Integer > list3 = new DoubleLinkedList < Integer > ();
        list3.addToFront(9);
        // 2nd list with a single element
        DoubleLinkedList < Integer > list4 = new DoubleLinkedList < Integer > ();
        list4.addToFront(10);

        // 1st list that is null
        DoubleLinkedList < Integer > list5 = new DoubleLinkedList < Integer > ();
        // 2nd list that is null
        DoubleLinkedList < Integer > list6 = new DoubleLinkedList < Integer > ();

        list1.append(list2);
        assertEquals("Two lists of same length appended returns a false back value", new Integer(8), list1.getBack().getElement());
        assertEquals("Two lists of same length appended returns a false front value", new Integer(1), list1.getFront().getElement());

        list3.append(list4);
        assertEquals("Two lists with a single element appended returns a false front value", new Integer(9), list3.getFront().getElement());
        assertEquals("Two lists with a single element appended returns a false back value", new Integer(10), list3.getBack().getElement());

        list5.append(list6);
        assertEquals("Two null lists appended returns a false non-null value", null, list5.getFront());
        assertEquals("Two null lists appended returns a false non-null value", null, list5.getBack());

        list2.append(list4);
        assertEquals("Two lists with multiple elements and one element appended returns a false front value", new Integer(5), list2.getFront().getElement());
        assertEquals("Two lists with multiple elements and one element appended returns a false back value", new Integer(10), list2.getBack().getElement());

        list2.append(list6);
        assertEquals("Two lists with multiple elements and null appended returns a false front value", new Integer(5), list2.getFront().getElement());
        assertEquals("Two lists with multiple elements and null appended returns a false back value", new Integer(10), list2.getBack().getElement());

        list4.append(list6);
        assertEquals("Two lists with one element and null appended returns a false front value", new Integer(10), list4.getFront().getElement());
        assertEquals("Two lists with one element and null appended returns a false back value", new Integer(10), list4.getBack().getElement());
    }

    /**
     * Tests the iterator method in DoubleLinkedList class
     */
    @Test
    public void testIterator() {
        // A list containing elements from 1 to 5
        DoubleLinkedList < Integer > list = new DoubleLinkedList < Integer > ();
        for (int i = 5; i > 0; i--)
            list.addToFront(i);

        /* checking that we get out what we put it */
        int i = 1;
        for (Integer x: list)
            assertEquals("Testing value returned by iterator", new Integer(i++), x);

        if (i != 6)
            fail("The iterator did not run through all the elements of the list");
    }

    /**
     * Tests hasNext method of DoubleLinkedListIterator nested class inside DoubleLinkedList class
     */
    @Test
    public void testHasNextAndHasPrevious() {
        // A list containing elements from 1 to 5 (tests multiple elements)
        DoubleLinkedList < Integer > list1 = new DoubleLinkedList < Integer > ();
        for (int i = 5; i > 0; i--)
            list1.addToFront(i);
        DoubleLinkedList < Integer > .DoubleLinkedListIterator < Integer > it1 = list1.iterator();
        // A list with a single element 10 (tests single element)
        DoubleLinkedList < Integer > list2 = new DoubleLinkedList < Integer > ();
        list2.addToFront(10);
        DoubleLinkedList < Integer > .DoubleLinkedListIterator < Integer > it2 = list2.iterator();
        // 1st list that is null (tests no element)
        DoubleLinkedList < Integer > list3 = new DoubleLinkedList < Integer > ();
        DoubleLinkedList < Integer > .DoubleLinkedListIterator < Integer > it3 = list3.iterator();

        /* Testing hasNext() on a list containing multiple elements */
        for (Integer x: list1) {
            assertEquals("hasNext() method does not work for a list containing multiple elements", true, it1.hasNext());
            it1.next();
        }
        if (it1.hasNext() == true)
            fail("The iterator falsely indicates that nodeptr has next");

        /* Testing hasPrevious() on a list containing multiple elements */
        int i = 5;
        while (i > 0) {
            it1.previous();
            assertEquals("hasPrevious() method does not work for a list containing multiple elements", true, it1.hasPrevious());
        }
        if (it1.hasNext() == true)
            fail("The iterator falsely indicates that nodeptr has next");

        /* Testing hasNext() on a list containing a single element */
        for (Integer x: list2) {
            assertEquals("hasNext() method does not work for a list containing a single element", true, it2.hasNext());
            it2.next();
        }
        if (it2.hasNext() == true)
            fail("The iterator falsely indicates that nodeptr has next");

        /* Testing hasPrevious() on a list containing a single element */
        assertEquals("hasPrevious() method does not work for a list containing a single element", true, it2.hasPrevious());

        if (it2.hasPrevious() == true)
            fail("The iterator falsely indicates that nodeptr has next");

        /* Testing hasNext() on a list containing no element (null) */
        assertEquals("hasNext() method does not work for a null list", false, it3.hasNext());

        /* Testing hasPrevious() on a list containing no element (null) */
        assertEquals("hasPrevious() method does not work for a null list", false, it3.hasPrevious());
    }

    /**
     * Tests next method of DoubleLinkedListIterator nested class inside DoubleLinkedList class
     */
    @Test
    public void testNext() {

        // A list containing elements from 1 to 5 (tests multiple elements)
        DoubleLinkedList < Integer > list1 = new DoubleLinkedList < Integer > ();
        for (int i = 5; i > 0; i--)
            list1.addToFront(i);
        DoubleLinkedList < Integer > .DoubleLinkedListIterator < Integer > it1 = list1.iterator();
        // A list with a single element 10 (tests single element)
        DoubleLinkedList < Integer > list2 = new DoubleLinkedList < Integer > ();
        list2.addToFront(10);
        DoubleLinkedList < Integer > .DoubleLinkedListIterator < Integer > it2 = list2.iterator();
        // 1st list that is null (tests no element)
        DoubleLinkedList < Integer > list3 = new DoubleLinkedList < Integer > ();
        DoubleLinkedList < Integer > .DoubleLinkedListIterator < Integer > it3 = list3.iterator();

        /* Tests calling next() one after another on a list containing multiple elements */
        int i = 1;
        for (Integer x: list1)
            assertEquals("Test for continuous next() call on a list containing multiple elements fail", x, it1.next());
        try {
            it1.next();
        } catch (NoSuchElementException e) {
            // all is good; supposed to return a NoSuchElementException since trying to access null node.
        }

        /* Tests calling next() one after another on a list containing a single element */
        i = 1;
        for (Integer x: list2)
            assertEquals("Test for next() call on a list containing one element fails", x, it2.next());
        try {
            it2.next();
        } catch (NoSuchElementException e) {
            // all is good; supposed to return a NoSuchElementException since trying to access null node.
        }

        /* Tests calling next() on a list containing no element (null) */
        try {
            it3.next();
        } catch (NoSuchElementException e) {
            // all is good; supposed to return a NoSuchElementException on a null list.
        }

        /* Resets the lists to test calling next() and previous() back and forth */
        // A list containing elements from 1 to 5 (tests multiple elements)
        list1 = new DoubleLinkedList < Integer > ();
        for (i = 5; i > 0; i--)
            list1.addToFront(i);
        it1 = list1.iterator();
        // A list with a single element 10 (tests single element)
        list2 = new DoubleLinkedList < Integer > ();
        list2.addToFront(10);
        it2 = list2.iterator();

        /* Tests going back and forth from next() to previous() on a list with multiple elements */
        assertEquals("Test for next() and previous() calls back and forth on a list with multiple elements fails", new Integer(1), it1.next());
        assertEquals("Test for next() and previous() calls back and forth on a list with multiple elements fails", new Integer(2), it1.next());
        assertEquals("Test for next() and previous() calls back and forth on a list with multiple elements fails", new Integer(2), it1.previous());
        assertEquals("Test for next() and previous() calls back and forth on a list with multiple elements fails", new Integer(2), it1.next());
        assertEquals("Test for next() and previous() calls back and forth on a list with multiple elements fails", new Integer(2), it1.previous());

        /* Tests going back and forth from previous() to next() on a list with a single element */
        assertEquals("Test for next() and previous() calls back and forth on a list with one element fails", new Integer(10), it2.next());
        assertEquals("Test for next() and previous() calls back and forth on a list with one element fails", new Integer(10), it2.previous());
        assertEquals("Test for next() and previous() calls back and forth on a list with one element fails", new Integer(10), it2.next());
        assertEquals("Test for next() and previous() calls back and forth on a list with one element fails", new Integer(10), it2.previous());

    }

    /**
     * Tests previous method of DoubleLinkedListIterator nested class inside DoubleLinkedList class
     */
    @Test
    public void testPrevious() {
        // A list containing elements from 1 to 5 (tests multiple elements)
        DoubleLinkedList < Integer > list1 = new DoubleLinkedList < Integer > ();
        for (int i = 5; i > 0; i--)
            list1.addToFront(i);
        DoubleLinkedList < Integer > .DoubleLinkedListIterator < Integer > it1 = list1.iterator();
        // A list with a single element 10 (tests single element)
        DoubleLinkedList < Integer > list2 = new DoubleLinkedList < Integer > ();
        list2.addToFront(10);
        DoubleLinkedList < Integer > .DoubleLinkedListIterator < Integer > it2 = list2.iterator();
        // 1st list that is null (tests no element)
        DoubleLinkedList < Integer > list3 = new DoubleLinkedList < Integer > ();
        DoubleLinkedList < Integer > .DoubleLinkedListIterator < Integer > it3 = list3.iterator();

        /* Tests calling previous() one after another on a list containing multiple elements */
        int i = 5;
        for (Integer x: list1)
            it1.next();
        while (i > 0) {
            assertEquals("Test for continuous next() call on a list containing multiple elements fail", new Integer(i--), it1.previous());
        }
        try {
            it1.previous();
        } catch (NoSuchElementException e) {
            // all is good; supposed to return a NoSuchElementException since trying to access null node.
        }

        /* Tests calling previous() one after another on a list containing a single element */
        it2.next();
        while (i > 0) {
            assertEquals("Test for continuous next() call on a list containing multiple elements fail", new Integer(10), it2.previous());
        }
        try {
            it2.previous();
        } catch (NoSuchElementException e) {
            // all is good; supposed to return a NoSuchElementException since trying to access null node.
        }

        /* Tests calling previous() on a list containing no element (null) */
        try {
            it3.previous();
        } catch (NoSuchElementException e) {
            // all is good; supposed to return a NoSuchElementException on a null list.
        }

        /* Resets the lists to test calling next() and previous() back and forth */
        // A list containing elements from 1 to 5 (tests multiple elements)
        list1 = new DoubleLinkedList < Integer > ();
        for (i = 5; i > 0; i--)
            list1.addToFront(i);
        it1 = list1.iterator();
        // A list with a single element 10 (tests single element)
        list2 = new DoubleLinkedList < Integer > ();
        list2.addToFront(10);
        it2 = list2.iterator();

        /* Tests going back and forth from next() to previous() on a list with multiple elements */
        assertEquals("Test for next() and previous() calls back and forth on a list with multiple elements fails", new Integer(1), it1.next());
        assertEquals("Test for next() and previous() calls back and forth on a list with multiple elements fails", new Integer(2), it1.next());
        assertEquals("Test for next() and previous() calls back and forth on a list with multiple elements fails", new Integer(2), it1.previous());
        assertEquals("Test for next() and previous() calls back and forth on a list with multiple elements fails", new Integer(2), it1.next());
        assertEquals("Test for next() and previous() calls back and forth on a list with multiple elements fails", new Integer(2), it1.previous());

        /* Tests going back and forth from previous() to next() on a list with a single element */
        assertEquals("Test for next() and previous() calls back and forth on a list with one element fails", new Integer(10), it2.next());
        assertEquals("Test for next() and previous() calls back and forth on a list with one element fails", new Integer(10), it2.previous());
        assertEquals("Test for next() and previous() calls back and forth on a list with one element fails", new Integer(10), it2.next());
        assertEquals("Test for next() and previous() calls back and forth on a list with one element fails", new Integer(10), it2.previous());
    }

    /**
     * Tests add method of DoubleLinkedListIterator nested class inside DoubleLinkedList class
     */
    @Test
    public void testAdd() {

        // A list containing elements from 1 to 5 (tests multiple elements)
        DoubleLinkedList < Integer > list1 = new DoubleLinkedList < Integer > ();
        for (int i = 5; i > 0; i--)
            list1.addToFront(i);
        DoubleLinkedList < Integer > .DoubleLinkedListIterator < Integer > it1 = list1.iterator();
        // First list with a single element 10 (tests single element)
        DoubleLinkedList < Integer > list2 = new DoubleLinkedList < Integer > ();
        list2.addToFront(10);
        DoubleLinkedList < Integer > .DoubleLinkedListIterator < Integer > it2 = list2.iterator();
        // Second list with a single element 10 (tests single element)
        DoubleLinkedList < Integer > list3 = new DoubleLinkedList < Integer > ();
        list3.addToFront(29);
        DoubleLinkedList < Integer > .DoubleLinkedListIterator < Integer > it3 = list3.iterator();
        // A list that is null (tests no element)
        DoubleLinkedList < Integer > list4 = new DoubleLinkedList < Integer > ();
        DoubleLinkedList < Integer > .DoubleLinkedListIterator < Integer > it4 = list4.iterator();

        /* Tests add() method to the front of the list containing many elements*/
        it1.add(100);
        assertEquals("A test for using add() to the front of the list fails", new Integer(1), it1.next());
        assertEquals("A test for using add() to the front of the list fails", new Integer(1), it1.previous());
        assertEquals("A test for using add() to the front of the list fails", new Integer(100), it1.previous());
        assertEquals("A test for using add() to the front of the list fails", new Integer(100), it1.next());
        assertEquals("A test for using add() to the front of the list fails", new Integer(1), it1.next());

        /* Tests add() method to the middle of the list containing many elements after next()*/
        it1.next();
        it1.add(200);
        assertEquals("A test for using add() to the middle of the list after next() fails", new Integer(3), it1.next());
        assertEquals("A test for using add() to the middle of the list after next() fails", new Integer(3), it1.previous());
        assertEquals("A test for using add() to the middle of the list after next() fails", new Integer(200), it1.previous());
        assertEquals("A test for using add() to the middle of the list after next() fails", new Integer(2), it1.previous());

        /* Tests add() method to the middle of the list containing many elements after previous() */
        it1.next();
        it1.next();
        it1.next();
        it1.previous();
        it1.add(300);
        assertEquals("A test for using add() to the middle of the list after previous() fails", new Integer(300), it1.previous());
        assertEquals("A test for using add() to the middle of the list after previous() fails", new Integer(200), it1.previous());
        assertEquals("A test for using add() to the middle of the list after previous() fails", new Integer(200), it1.next());
        assertEquals("A test for using add() to the middle of the list after previous() fails", new Integer(300), it1.next());

        /* Tests add() method to the back of the list containing many elements */
        it1.next();
        it1.next();
        it1.next();
        it1.add(400);
        assertEquals("Test for using add() to the back of the list containing many elements fail", new Integer(400), it1.previous());
        assertEquals("Test for using add() to the back of the list containing many elements fail", new Integer(4), it1.previous());
        assertEquals("Test for using add() to the back of the list containing many elements fail", new Integer(4), it1.next());
        assertEquals("Test for using add() to the back of the list containing many elements fail", new Integer(400), it1.next());
        try {
            it1.next();
        } catch (NoSuchElementException e) {
            // fine; supposed to throw an exception if trying to access a null node
        }

        /* Tests add() method to the front of the list containing one element */
        it2.add(1);
        assertEquals("Test for add() method to the front of the list containing one element fails", new Integer(1), it2.previous());
        assertEquals("Test for add() method to the front of the list containing one element fails", new Integer(1), it2.next());
        assertEquals("Test for add() method to the front of the list containing one element fails", new Integer(10), it2.next());

        /* Tests add() method to the back of the list containing one element */
        it3.next();
        it3.add(1);
        assertEquals("Test for add() method to the back of the list containing one element fails", new Integer(1), it3.previous());
        assertEquals("Test for add() method to the back of the list containing one element fails", new Integer(20), it3.previous());

        /* Tests add() method to the list containing no element (null) */
        it4.add(1);
        assertEquals("Test for add() method to the list containing no element fails", new Integer(1), it4.next());
        assertEquals("Test for add() method to the list containing no element fails", new Integer(1), it4.previous());
    }

    /**
     * Tests set method of DoubleLinkedListIterator nested class inside DoubleLinkedList class
     */
    @Test
    public void testSet() {
        // A list containing elements from 1 to 5 (tests multiple elements)
        DoubleLinkedList < Integer > list1 = new DoubleLinkedList < Integer > ();
        for (int i = 5; i > 0; i--)
            list1.addToFront(i);
        DoubleLinkedList < Integer > .DoubleLinkedListIterator < Integer > it1 = list1.iterator();
        // A list with a single element 10 (tests single element)
        DoubleLinkedList < Integer > list2 = new DoubleLinkedList < Integer > ();
        list2.addToFront(10);
        DoubleLinkedList < Integer > .DoubleLinkedListIterator < Integer > it2 = list2.iterator();
        // 1st list that is null (tests no element)
        DoubleLinkedList < Integer > list3 = new DoubleLinkedList < Integer > ();
        DoubleLinkedList < Integer > .DoubleLinkedListIterator < Integer > it3 = list3.iterator();

        /* Test for set() method after next() in a list containing multiple elements */
        it1.next();
        it1.set(100);
        assertEquals("The test for set() method after next() in a list containing multiple elements fails", new Integer(100), it1.previous());

        /* Test for set() method after previous() in a list containing multiple elements */
        it1.next();
        it1.previous();
        it1.set(200);
        assertEquals("The test for set() method after previous() in a list containing multiple elements fails", new Integer(200), it1.next());

        /* Test for set() method after next() in a list containing one element */
        it2.next();
        it2.set(100);
        assertEquals("The test for set() method after next() in a list containing one element fails", new Integer(100), it2.previous());

        /* Test for set() method after previous() in a list containing one element */
        it2.next();
        it2.previous();
        it2.set(200);
        assertEquals("The test for set() method after previous() in a list containing multiple elements fails", new Integer(200), it2.next());

        /* Test for set() method in a list containing no list */
        it3.set(1);
        try {
            it3.previous();
        } catch (NoSuchElementException e) {
            // is okay; method is supposed to do nothing if the list is already null
        }
        try {
            it3.next();
        } catch (NoSuchElementException e) {
            // is okay; method is supposed to do nothing if the list is already null
        }
    }
}