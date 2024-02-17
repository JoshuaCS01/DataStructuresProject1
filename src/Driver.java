public class Driver {
    
    public static void main (String[] args) {
        DLL newList = new DLL<>();
        newList.addFirst("World");
        newList.addFirst("Hello");
        newList.addLast("Camel");
        newList.addLast("Case");
        System.out.println("Original List  " + newList.toString());

        newList.insert(0, "INSERTED");
        System.out.println("Inserted       " + newList.toString());
        newList.swap(newList.find("World"), newList.find("Hello"));
        System.out.println(newList.toString());
       
        // newList.removeLast();
        // newList.removeFirst();
        
      //  newList.insert(0, "INSERTED");
    //    System.out.println("Inserted       " + newList.toString());
        // newList.swap(newList.find("World"), newList.find("Camel"));
       // newList.remove(newList.find("Camel"));
      //  newList.set(2, "hasChanged");
     //   System.out.println(newList.toString());

        /*
         * System.out.println(newList.get(-3));
         * System.out.println(newList.get(5));
         * System.out.println(newList.get(2));
         * System.out.println(newList.get(3));
         * System.out.println(newList.get(4));
         * System.out.println(newList.remove(4));
         * System.out.println(newList.toString());
         * System.out.println();
         * System.out.println(newList.find("Case").getElement());
         * 
         */

        /*
         * System.out.println("Original List  " + newList.toString());
         * System.out.println("First Clone    " + clone.toString());
         * DLL deepClonetemp = new DLL<>();
         * deepClonetemp = newList.deepClone();
         * System.out.println("DEEP Clone     " + deepClonetemp.toString());
         * newList.head.setElement("DEEPCHANGE");
         * System.out.println("Deep Clone     " + deepClonetemp.toString());
         * deepClonetemp.head.setElement("Deep Change");
         * System.out.println("Deep Clone     " + deepClonetemp.toString());
         */
        newList.clear();
        System.out.println(newList.toString());
    }
}
