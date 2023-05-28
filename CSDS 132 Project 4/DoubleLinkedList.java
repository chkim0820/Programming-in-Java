import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

/**
 * A doubly linked linked list.
 * @author Chaehyeon Kim
 */
public class DoubleLinkedList < T > implements Iterable < T > {
    /** a reference to the first node of the double linked list */
    private DLNode < T > front;

    /** a reference to the last node of a double linked list */
    private DLNode < T > back;

    /** Create an empty double linked list. */
    public DoubleLinkedList() {
        front = back = null;
    }

    /** 
     * Returns true if the list is empty.
     * @return  true if the list has no nodes
     */
    public boolean isEmpty() {
        return (getFront() == null);
    }

    /**
     * Returns the reference to the first node of the linked list.
     * @return the first node of the linked list
     */
    protected DLNode < T > getFront() {
        return front;
    }

    /**
     * Sets the first node of the linked list.
     * @param node  the node that will be the head of the linked list.
     */
    protected void setFront(DLNode < T > node) {
        front = node;
    }

    /**
     * Returns the reference to the last node of the linked list.
     * @return the last node of the linked list
     */
    protected DLNode < T > getBack() {
        return back;
    }

    /**
     * Sets the last node of the linked list.
     * @param node the node that will be the last node of the linked list
     */
    protected void setBack(DLNode < T > node) {
        back = node;
    }

    /**
     * Add an element to the head of the linked list.
     * @param element  the element to add to the front of the linked list
     */
    public void addToFront(T element) {
        if (getFront() == null) {
            setFront(new DLNode < T > (element, null, null));
            setBack(getFront());
        } else {
            getFront().setPrevious(new DLNode < T > (element, null, getFront()));
            if (getFront().getNext() == null)
                setBack(getFront());
            setFront(getFront().getPrevious());
        }
    }

    /**
     * Add an element to the tail of the linked list.
     * @param element  the element to add to the tail of the linked list
     */
    public void addToBack(T element) {
        if (getFront() == null) {
            setFront(new DLNode < T > (element, null, null));
            setBack(getFront());
        } else if (getFront().getNext() == null) {
            getFront().setNext(new DLNode < T > (element, getFront(), null));
            setBack(getFront().getNext());
        } else {
            getBack().setNext(new DLNode < T > (element, getBack(), null));
            setBack(getBack().getNext());
        }
    }

    /**
     * Remove and return the element at the front of the linked list.
     * @return  the element that was at the front of the linked list
     * @throws NoSuchElementException if attempting to remove from an empty list
     */
    public T removeFromFront() throws NoSuchElementException {
        if (getFront() != null) {
            T save = getFront().getElement();
            if (getFront().getNext() == null) {
                setFront(null);
                setBack(null);
            } else {
                setFront(getFront().getNext());
                getFront().setPrevious(null);
            }
            return save;
        }
        throw new NoSuchElementException();
    }

    /**
     * Remove and return the element at the back of the linked list.
     * @return the element that was at the back of the linked list
     * @throws NoSuchElementException if attempting to remove from an empty list
     */
    public T removeFromBack() {
        if (getFront() != null) {
            T save = getBack().getElement();
            if (getFront().getNext() == null) {
                setFront(null);
                setBack(null);
            } else {
                setBack(getBack().getPrevious());
                getBack().setNext(null);
            }
            return save;
        }
        throw new NoSuchElementException();
    }

    /**
     * Overrides the equals method of Object class.
     * @param obj  the double linked list that is being checked to see if it's equal with this DLNode.
     * @return  whether the two double linked lists are equal or not
     */
    @Override
    public boolean equals(Object obj) {
        boolean answer = false; // a local variable to store the return value
        if (obj instanceof DoubleLinkedList) {
            DoubleLinkedList < ? > e = (DoubleLinkedList < ? > ) obj; // variable to store obj typecasted to DoubleLinkedList
            DLNode < T > thisptr = this.getFront(); // variable that stores this list's front node
            DLNode < ? > objptr = e.getFront(); // variable that stores the input list's front node
            while (thisptr != null && objptr != null) {
                answer = (thisptr.getElement().equals(objptr.getElement()));
                thisptr = thisptr.getNext();
                objptr = objptr.getNext();
            }
            if (thisptr != null || objptr != null)
                answer = false;
        }
        return answer;
    }

    /**
     * Appends the nodes of the input linked list to the end of the nodes of this list
     * @param list  the linked list to be appended at the end of the nodes of this list
     */
    public void append(DoubleLinkedList < T > list) {
        if (getFront() == null) {
            setFront(list.getFront());
            setBack(list.getBack());
        } else {
            DLNode < T > saveBack = list.getBack(); // variable that stores the input list's back node
            DLNode < T > saveFront = list.getFront(); // variable that stores the input list's front node
            if (saveFront != null) {
                getBack().setNext(list.getFront());
                saveFront.setPrevious(this.getBack());
                setBack(saveBack);
            }
        }
    }

    /**
     * Returns an interator for the linked list that starts at the head of the list and runs to the tail.
     * @return  the iterator that runs through the list from the head to the tail
     */
    @Override
    public DoubleLinkedListIterator < T > iterator() {
        return new DoubleLinkedListIterator < > (getFront());
    }

    public class DoubleLinkedListIterator < T > implements ListIterator < T > {

        /** The DLNode of the instance of this iterator class */
        private DLNode < T > nodeptr;

        /** Saves whether method next() or previous() was run (next: 1, previous: 2) */
        private int lastRun;

        /** Saves whether method add() has been called after the last call to next or previous */
        private boolean addCalled; // true if called, false if not called

        /** Saves whether previous() & next() methods are going back and forth */
        private boolean altCalls;

        /**
         * A constructor for the DoubleLinkedListIterator class
         * @param front  the first node in the input
         */
        public DoubleLinkedListIterator(DLNode < T > front) {
            nodeptr = front;
            lastRun = 0;
            addCalled = false;
            altCalls = false;
        }

        /**
         * A method that overrides Iterator interface's hasNext method
         * @return  Returns true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            boolean answer = false; // variable to store whether nodeptr has next node or not
            if (((nodeptr != null) && (nodeptr.getNext() != null)) // multiple elements in the list & nodeptr has a next
                ||
                ((nodeptr != null) && (nodeptr.getNext() == null) && (nodeptr.getPrevious() == null) && (lastRun != 1)))
                // or only single value in the list & first time calling next()
                answer = (nodeptr != null);
            else if (nodeptr == null)
                answer = false;
            return answer;
        }

        /**
         * A method that overrides Iterator interface's next method
         * @return  Returns the next element in the iteration
         * @throws NoSuchElementException if there is no next element.
         */
        @Override
        public T next() {
            if (hasNext()) {
                if (lastRun == 1) { // last run method is next()
                    nodeptr = nodeptr.getNext();
                    altCalls = false; // no alternative calls b/w next() & previous()
                } else if (lastRun == 2) // last run method is previous()
                    altCalls = true; // is alternative calls b/w next() & previous()

                lastRun = 1; // set last run method to be next
                addCalled = false; // reset addCalled; add() method not called w/o next()
                return nodeptr.getElement();
            }
            throw new NoSuchElementException();
        }

        /**
         * returns whether there is a non-null node after nodeptr
         * @return  Returns whether there is a non-null node after nodeptr
         */
        @Override
        public boolean hasPrevious() {
            boolean answer = false; // variable to store whether nodeptr has previous node or not
            if (lastRun == 2) // last run method is previous()
                answer = (nodeptr.getPrevious() != null);
            else if (lastRun == 1) // last run method is next()
                answer = (nodeptr != null);
            return answer;
        }

        /**
         * Returns the previous element in the list and moves nodeptr position backwards.
         * @return the value previous element in the list
         * @throws NoSuchElementException if there is no previous element.
         */
        @Override
        public T previous() {
            if (hasPrevious()) {
                if (lastRun != 1) { // last run method is not next()
                    nodeptr = nodeptr.getPrevious();
                    altCalls = false; // no alternative calls b/w next() & previous()
                } else if (lastRun == 1) // last run method is next()
                    altCalls = true; // is alternative calls b/w next() & previous()
                lastRun = 2; // sets last run method to be previous()
                addCalled = false; // reset addCalled; add() method not called w/o next()
                return nodeptr.getElement();
            }
            throw new NoSuchElementException();
        }

        /**
         * Overrides the add method of ListIterator interface
         * @param element  the element to be added before the implicit cursor
         */
        @Override
        public void add(T element) {
            addCalled = true; // saves the value of addCalled to be true since add() method run
            if (hasNext()) {
                DLNode < T > newNode; // variable that stores the new node to be added to the list
                DLNode < T > save = nodeptr; // variable that stores the current nodeptr's node
                if (lastRun == 1) { // last run method is next()
                    DLNode < T > savenext = nodeptr.getNext(); // saves the next node of nodeptr
                    newNode = new DLNode < T > (element, nodeptr, nodeptr.getNext());
                    savenext.setPrevious(newNode);
                    save.setNext(newNode);
                    nodeptr = nodeptr.getNext();
                } else if (lastRun == 2) { // last run method is previous()
                    DLNode < T > saveprev = nodeptr.getPrevious(); // saves the previous node of nodeptr
                    newNode = new DLNode < T > (element, nodeptr.getPrevious(), nodeptr);
                    saveprev.setNext(newNode);
                    save.setPrevious(newNode);
                } else if (lastRun == 0) { // method next() or previous() has not run yet
                    newNode = new DLNode < T > (element, null, nodeptr);
                    nodeptr.setPrevious(newNode);
                }
            } else { // if nodeptr does not have next (list is empty)
                nodeptr = new DLNode < T > (element, null, null);
            }
        }

        /**
         * Overrides the set method of of ListIterator interface
         * @param element  the element to replace the last returned value by next or previous
         */
        @Override
        public void set(T element) {
            if ((addCalled == false) && (lastRun != 0)) // next or previous method has been called without add method call after
                nodeptr.setElement(element);
        }

        /**
         * Overrides the remove() method in ListIterator interface
         * @throws UnsupportedOperationException since method is not implemented according to API description
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /**
         * Overrides the nextIndex() method in ListIterator interface
         * @return the index of the element to be returned by a subsequent call to next()
         * @throws UnsupportedOperationException since method is not implemented according to API description
         */
        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        /**
         * Overrides the previousIndex() method in ListIterator interface
         * @return the index of the element to be returned by a subsequent call to previous()
         * @throws UnsupportedOperationException since method is not implemented according to API description
         */
        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }
    }
}