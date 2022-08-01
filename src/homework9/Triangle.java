package homework9;

public class Triangle {
    private String name = "Triangle";
    private String colour;
    private double square;
    private double perim;

    public Triangle(double legFirst, double legSecond, double legThird, double heightToFirstLeg, String colour) {
        square = 0.5 * legFirst * heightToFirstLeg;
        perim = legFirst + legSecond + legThird;
        this.colour=colour;
        updateColour();

    }

    public void printInfo(){
        System.out.println("Name: " + name + "\nColour: " + colour +  "\nSquare: "+ square+ "\nPerimetr: " + perim);
    }


    private void updateColour() {
        colour = (square > 30 ? "Blue" : colour);
    }
}
