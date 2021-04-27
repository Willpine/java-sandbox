package app;

// INTERFACES
// All the classes that implement this interface
// will have a starting 0 value, and everytime
// this getNext method gets called, it'll increment
// it by A CERTAIN AMOUNT.
public interface Series {

    // ---------INTERFACE REFERENCE VARIABLES---------------
    // You can create Variables of the interface type
    // and you can have this variable reference Objects
    // that implement this interface.
    int MAX = 10;

    String ERRORMSG = "Cannot go above value " + 10;

    int getNext();

    // --------------DEFAULT METHODS------------------------
    // We can define DEFAULT METHODS on an interface.
    // , and these can be overriden later. ONLY JAVA 8 AND ABOVE
    default void printStuff(){
        System.out.println("Live from NY. It's Saturday night.");
        printMoreStuff();
    }

    // -------------------STATIC INTERFACE METHODS--------------------------
    // Works just like a normal static method
    static void printStuffStatic(){
        System.out.println("Live from NY. It's a STATIC night.");
    }

    // -------------------PRIVATE INTERFACE METHODS-------------------------
    // Works just like a normal private method
    // This was introduced in JAVA 9
    private void printMoreStuff(){
        System.out.println("More Stuff");
    }
}
