package app;

public class ByTwos implements SeriesSub{
    int val;

    ByTwos(){
        val = 0;
    }

    @Override
    public int getNext() {
        if (val >= MAX) {
            System.out.println(ERRORMSG);
        } else {
            val += 2;
        }
        return val;
    }

    @Override
    public int getPrev(){
        val -= 2;
        return val;
    }

    @Override
    public void printStuff() {
        System.out.println("I am the ByTwos class.");
    }

    // An interface reference variable can't see this
    // method, cause he is declared and defined by this class
    // and not by the interface.
}
