package homework9;

public class Rectangle {
    private String name = "Rectangle";
    private String colour;
    private double square;
    private double perim;

    public Rectangle(double sideFirst, double sideSecond, String colour) {
        square = sideFirst * sideSecond;
        perim = (sideFirst *2 ) + (sideSecond*2);
        this.colour = colour;
        updateColour();
    }


    public void printInfo(){
        System.out.println("Name: " + name + "\nColour: " + colour + "\nSquare: "+ square+ "\nPerimetr: " + perim);
    }

    private void updateColour() {
        colour = (square > 30 ? "Blue" : colour);
    }
}
