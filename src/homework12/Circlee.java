package homework12;

public class Circlee extends ParentShape {
    private double radius;
    public Circlee(double radius, String colour) {
        name = "Circle";
        this.radius = radius;
        this.colour = colour;
        updateColour();
        countSquare();
        countPerim();
    }

    @Override
    public Double countSquare() {
        square = Math.PI + Math.pow(radius, 2);
        return square;

    }

    @Override
    public Double countPerim() {
        perim = Math.PI * 2 * radius;
        return perim;
    }
}
