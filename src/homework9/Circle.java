package homework9;

public class Circle {
    private String name = "Circle";
    private String colour;
    private double square;
    private double perim;

    public Circle(double radius, String colour) {
        square = Math.PI + Math.pow(radius, 2);
        perim = Math.PI * 2 * radius;
        this.colour = colour;
        updateColour();
    }



    public void printInfo() {
        System.out.println("Name: " + name + "\nColour: " + colour + "\nSquare: " + square + "\nPerimetr: " + perim);
    }



    private void updateColour() {
        colour = (square > 30 ? "Blue" : colour);
    }
}
