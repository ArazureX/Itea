package homework12;

public abstract class ParentShape {

    protected String name;
    protected String colour;
    protected double square;
    protected double perim;


    public abstract Double countSquare();
    public abstract Double countPerim();

    public void printInfo() {
        System.out.println("Name: " + name + "\nColour: " + colour + "\nSquare: " + square + "\nPerimetr: " + perim);
    }

    protected void updateColour() {
        colour = (square > 30 ? "Blue" : colour);
    }
}






