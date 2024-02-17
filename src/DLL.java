
class Node<E> {

    // Fields
    private E element;
    private Node<E> prev;
    private Node<E> next;

    // Constructors
    public Node() {
        element = null;
        Node<E> prev = null;
        Node<E> next = null;
    }

    public Node(E element) {
        this.element = element;
        Node<E> prev = null;
        Node<E> next = null;
    }

    public Node(E element, Node<E> prev, Node<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    // Getters and Setters
    public E getElement() {
        return this.element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getPrev() {
        return this.prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

}

public class DLL<E> {
    // Fields
    private Node<E> head;
    private Node<E> tail;
    private int counter;

    // Constructors
    public DLL() {
        this.head = null;
        this.tail = null;
        counter = 0;
    }

    // returns size
    int size() {
        return counter;
    }

    // returns True or false
    boolean isEmpty() {
        if (counter == 0) {
            return true;
        } else {
            return false;
        }
    }

    E first() {
        return head.getElement();
    }

    E last() {
        return tail.getElement();
    }

    void addFirst(E element) {

        // if there is already a head
        if (counter >= 1) {
            Node<E> temp = head;
            head = new Node(element, null, temp);
            temp.setPrev(head);
            counter++;

        } else {

            // creates head and tail if there isn't any.
            head = (new Node(element));
            tail = head;
            counter++;
        }
    }

    void addLast(E element) {
        // if there is already a head
        if (counter >= 1) {
            Node<E> temp = tail;
            tail = new Node(element, temp, null);
            temp.setNext(tail);
            counter++;

        } else {

            // creates head and tail if there isnt any
            tail = (new Node(element));
            head = tail;
            counter++;
        }

    }

    E removeFirst() {

        Node<E> temp = head;
        E tempElement = temp.getElement();

        // Sets head to next node and previous node to null
        head = head.getNext();
        temp.setNext(null);
        temp.setElement(null);
        head.setPrev(null);
        counter--;
        return tempElement;
    }

    E removeLast() {

        Node<E> temp = tail;
        E tempElement = temp.getElement();

        // Sets tail to previous node and next node to null
        tail = tail.getPrev();
        temp.setPrev(null);
        temp.setElement(null);
        tail.setNext(null);
        counter--;
        return tempElement;
    }

    @Override
    public String toString() {
        // if zero elements
        String list = "null";

        // if 1 element
        if (counter == 1) {
            list += " <-- " + head.getElement() + " --> null";
        }

        // if more than 1 element
        if (counter > 1) {
            list += " <-- " + head.getElement();
            Node<E> temp = head;

            // concats all elements into String
            for (int i = 1; i < this.counter; i++) {
                temp = temp.getNext();
                list += " <--> ";
                list += temp.getElement();
            }
            list += " --> null";
        }
        return list;
    }

    @Override
    public DLL<E> clone() {
        // New list that copies original list.
        DLL<E> cloneList = new DLL<>();
        Node<E> temp = head;
        Node<E> cloneHead = head;
        cloneList.head = new Node<E>(this.head.getElement());
        cloneList.counter++;

        // iterates through original list and creates nodes for clone list
        while (this.head.getNext() != null) {
            this.head = this.head.getNext();
            cloneList.head.setNext(new Node<E>(this.head.getElement()));
            cloneList.head = cloneList.head.getNext();
            cloneList.counter++;
        }

        // sets clones head and tail
        cloneList.tail = head;
        cloneList.head = cloneHead;
        head = temp;

        return cloneList;
    }

    public DLL<E> deepClone() {
        // new deepclone. The elements point to the original's elements.
        // creates head for clone.
        DLL<E> cloneList = new DLL<>();
        cloneList.head = new Node(this.head.getElement());
        cloneList.counter++;
        Node<E> temp = cloneList.head;
        Node<E> currentNode = this.head;
        Node<E> previousNode = cloneList.head;

        // iterates through array and makes nodes to create list
        for (int i = 1; i < this.counter; i++) {
            currentNode = currentNode.getNext();
            temp.setNext(new Node(currentNode.getElement()));
            temp = temp.getNext();
            temp.setPrev(previousNode);
            previousNode = previousNode.getNext();
            cloneList.counter++;
        }

        return cloneList;

    }

    void insert(int index, E element) {

        // uses addFirst method to save time
        if (index == 0) {
            this.addFirst(element);
        } else

        // uses addLast method to save time
        if ((index == this.counter - 1) && (this.counter != 0)) {
            this.addLast(element);

            // if we are inserted anywhere beside head or tail.
        } else {

            Node<E> temp = this.head;
            Node addedNode = new Node(element);

            // iterates to node behind index
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }

            Node<E> nextOne = temp;
            nextOne = nextOne.getNext();
            nextOne.setPrev(addedNode);
            addedNode.setNext(nextOne);

            temp.setNext(addedNode);
            addedNode.setPrev(temp);
            this.counter++;

        }
    }

    E get(int index) {

        // returns null if index is out of bounds.
        if ((index < 0) || (index > this.counter - 1)) {
            return null;
        }

        // iterates to Node at index
        Node<E> temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getElement();
    }

    E remove(int index) {
        E temp = null;

        // Uses removeFirst to save time
        if (index == 0) {
            return (this.removeFirst());

            // Uses removeFirst to save time
        } else if ((index == this.counter - 1) && (this.counter != 0)) {
            return (this.removeLast());

            // if we need to remove a node thats not head or tail
        } else {
            Node<E> currentNode = this.head;
            Node<E> afterNode = null;
            Node<E> beforeNode = null;

            // iterates to node at index
            for (int i = 0; i < index; i++) {
                beforeNode = currentNode;
                currentNode = currentNode.getNext();
                afterNode = currentNode.getNext();
            }

            currentNode.setNext(null);
            currentNode.setPrev(null);
            temp = currentNode.getElement();
            currentNode.setElement(null);

            beforeNode.setNext(afterNode);
            afterNode.setPrev(beforeNode);

            counter--;
            return temp;
        }

    }

    void remove(Node<E> x) {

        // if x is the tail
        if (x.getNext() == null) {
            Node<E> temp = x.getPrev();
            x.setPrev(null);
            temp.setNext(null);
            counter--;

            // if x is the head
        } else if (x.getPrev() == null) {
            Node<E> temp = x.getNext();
            x.setNext(null);
            temp.setPrev(null);
            counter--;

            // if head is anywhere else
        } else {
            Node<E> tempPrev = x.getPrev();
            Node<E> tempNext = x.getNext();
            tempPrev.setNext(tempNext);
            tempNext.setPrev(tempPrev);
            x.setNext(null);
            x.setPrev(null);
            counter--;

        }

    }

    Node<E> find(E element) {
        Node<E> temp = this.head;

        // iterates through entire list and returns node
        for (int i = 0; i < counter; i++) {
            if (temp.getElement() == element) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    void swap(Node<E> x, Node<E> y) {

        // if x is right before y
        if (x.getNext() == y) {
            Node<E> prevX = x.getPrev();
            Node<E> nextY = y.getNext();

            // if X has a previous node
            if (prevX != null) {
                prevX.setNext(y);

                // if X has a previous node
            } else {
                this.head = y;
            }

            x.setNext(nextY);
            x.setPrev(y);
            y.setPrev(prevX);
            y.setNext(x);

            // if Y has a next node
            if (nextY != null) {
                nextY.setPrev(x);

                // if Y has no next node
            } else {
                this.tail = x;
            }

            // if y is right before x
        } else if (y.getNext() == x) {
            Node<E> prevY = y.getPrev();
            Node<E> nextX = x.getNext();

            // if Y has a previous node
            if (prevY != null) {
                prevY.setNext(x);

                // if Y does not have a previous node
            } else {
                this.head = x;
            }

            y.setNext(nextX);
            y.setPrev(x);
            x.setPrev(prevY);
            x.setNext(y);

            // if X has a next node
            if (nextX != null) {
                nextX.setPrev(y);

                // if X has no next node
            } else {
                this.tail = y;
            }

            // if x and y are anywhere else.
        } else {
            Node<E> prevX = x.getPrev();
            Node<E> nextX = x.getNext();
            Node<E> prevY = y.getPrev();
            Node<E> nextY = y.getNext();

            // Changes Y
            if (prevX != null) {
                prevX.setNext(y);

                // if X is the head
            } else {
                this.head = y;
            }

            if (nextX != null) {
                nextX.setPrev(y);

                // if X is the tail
            } else {
                this.tail = y;
            }

            x.setPrev(prevY);
            x.setNext(nextY);

            
            // Changes X
            if (prevY != null) {
                prevY.setNext(x);

                // if Y is the head
            } else {
                this.head = x;
            }

            if (nextY != null) {
                nextY.setPrev(x);

                // if Y is the tail
            } else {
                this.tail = x;
            }

            y.setPrev(prevX);
            y.setNext(nextX);
        }
    }

    void clear() {
        this.head = null;
        this.tail = null;
        this.counter = 0;

    }

    E set(int index, E element) {
        Node<E> temp = this.head;
        E tempElement;

        // iterates to node at index.
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }

        // replaces element and returns original
        tempElement = temp.getElement();
        temp.setElement(element);
        return tempElement;
    }

}
