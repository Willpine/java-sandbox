package app;

public class App 
{
    public static void main( String[] args )
    {
        ByTwos byTwos = new ByTwos();
        ByThrees byThrees = new ByThrees();

        for (int i = 0; i < 5; i++) {
            System.out.println(byTwos.getNext());
            System.out.println(byThrees.getNext());
        }

        // -------------INTERFACE REFERENCE VARIABLES-----------------------------
        // You can create Variables of the interface type
        // and you can have this variable reference Objects
        // that implement this interface.
        Series seriesObject = byTwos;

        for (int i = 0; i < 5; i++) {
            System.out.println("---------BY TWOS------------");
            seriesObject = byTwos;
            System.out.println(seriesObject.getNext());
            System.out.println("-------------BY THREES-------------------");
            seriesObject = byThrees;
            System.out.println(seriesObject.getNext());
        }

        // The interface object can only see methods
        // that the interface declares, and can't see
        // ones that only the object sees;
        
        // --------------------VARIABLES IN INTERFACES----------------------------
        // All values are PUBLIC STATIC FINAL, so all classes can access it.
        // This is how we CALL INTERFACE VARIABLES
        System.out.println("The \"MAX\" value we defined: "+Series.MAX);

        // ------------------INTERFACE DEFINED MEHTODS--------------------------
        // We could have the "printStuff()", a default method on the interface,
        // overriden here. 
        seriesObject.printStuff();
        
        // -------------------STATIC INTERFACE METHODS--------------------------
        // This is wrong:
        // seriesObject.printStuffStatic();

        // This is right:
        Series.printStuffStatic();

        // -------------------PRIVATE INTERFACE METHODS-------------------------
        // This was introduced in JAVA 9
        seriesObject.printStuff();
    }
}
