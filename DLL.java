class Node<E> {

    //Fields
    private E element;
    private Node<E> prev;
    private Node<E> next;

    //Constructors
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

    public Node(E element, Node <E> prev, Node<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    //Getters and Setters
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

public class DLL <E>{
     //Fields
     private Node<E> head;
     private Node<E> tail;
     private int counter;
 
     //Constructors
     public DLL () {
         this.head = null;
         this.tail = null;
         counter = 0;
     }
 
     int size() {
         return counter;
     }
 
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
        if (counter >= 1) {
            Node<E> temp = head;
            head = new Node(element, null, temp);
            counter++;

        } else{

        head = (new Node(element));
        tail = head;
        counter++;
        }
     }
    
     void addLast(E element) { 
 
 if (counter >= 1) {
            Node<E> temp = tail;
            tail = new Node(element, temp, null);
            temp.setNext(tail);
            counter++;

        } else{

        tail = (new Node(element));
        counter++;
        }

     }
    

     E removeFirst() {
        Node<E> temp = head;
        E tempElement = temp.getElement();
        head = temp.getNext();
        temp.setNext(null);
        temp.setElement(null);
        head.setPrev(null);
        counter--;
        return tempElement;
     }
  
     
     E removeLast() {
        Node<E> temp = tail;
        E tempElement = temp.getElement();
        tail = tail.getPrev();
        temp.setPrev(null);
        temp.setElement(null);
        tail.setNext(null);
        counter--;
        return tempElement;
     }

     @Override
     public String toString() {
        String list = "null";

        if (counter == 1) {
            list += " <-- " + head.getElement() + " --> null" ;
        }

        if (counter > 1) {
            list += " <-- " + head.getElement();
            Node<E> temp = head;

            for (int i = 1; i < counter; i++) {
                head = head.getNext();
                list += " <--> ";
                list+= head.getElement();
        }
        list += " --> null";
        head = temp;
    }
        return list;
     }


    @Override
    public DLL<E> clone() {
        DLL<E> cloneList = new DLL<>();
        Node<E> temp = head;
        Node<E> cloneHead = head;
        cloneList.head = new Node<E>(this.head.getElement());
        cloneList.counter++;

        while(this.head.getNext() != null){
            this.head = this.head.getNext();
            cloneList.head.setNext(new Node<E>(this.head.getElement()));
            cloneList.head = cloneList.head.getNext();
            cloneList.counter++;
        }

        cloneList.tail = head;
        cloneList.head = cloneHead;
        head = temp;
        return cloneList;
    }

     public DLL<E> deepClone() {
              DLL<E> cloneList = new DLL<>();
        Node<E> temp = head;
        Node<E> cloneHead = head;
        cloneList.head = new Node<E>(this.head.getElement());
        cloneList.counter++;

        while(this.head.getNext() != null){
            this.head = this.head.getNext();
            cloneList.head.setNext(new Node<E>(this.head.getElement()));
            cloneList.head = cloneList.head.getNext();
            cloneList.counter++;
        }

        cloneList.tail = head;
        cloneList.head = cloneHead;
        head = temp;
        return cloneList;

     }
/*
     void insert() {

     }

     E get(int index) {
        E temp = 5;
        return temp;
     }

     E remove(int index) {
        E temp = 5;
        return temp;
     }

     void remove(Node<E> x) {

     }

     Node<E> find(E element) {
        Node<E> temp = 5;
        return temp;
     }

     void swap (Node<E> x, Node<E> y) {

     }

     void clear(){

     }

    E set(int index, E element) {
        E temp = 5;
        return temp;
    }
    */
    




 
 

    public static void main (String[] args) {
        DLL newList = new DLL<>();
        newList.addFirst("World");
        newList.addFirst("Hello");
        newList.addLast("Camel");
        newList.addLast("Case");
        System.out.print(newList.head.getElement());
        System.out.println(newList.head.getNext().getElement());
        System.out.println(newList.toString());
        DLL clone = new DLL<>();
        clone = newList.clone();
        System.out.println(clone.toString());
        newList.head.setElement("CHANGED");
        System.out.println(clone.toString());

        DLL deepClonetemp = new DLL<>();
        deepClonetemp = newList.deepClone();
        System.out.println(deepClonetemp.toString());
        newList.head.setElement("CHANGED");
        System.out.println(deepClonetemp.toString());
        



    }
    
}


