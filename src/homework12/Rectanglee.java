package homework12;

public class Rectanglee extends ParentShape {
    private double sideFirst;
    private double sideSecond;

    public Rectanglee(double sideFirst, double sideSecond, String colour) {
        name = "Rectangle";
        this.sideFirst=sideFirst;
        this.sideSecond=sideSecond;
        this.colour = colour;
        updateColour();
        countPerim();
        countSquare();
    }

    @Override
    public Double countSquare() {
        square = sideFirst * sideSecond;
        return square;
    }

    @Override
    public Double countPerim() {
        perim = (sideFirst * 2) + (sideSecond * 2);
        return perim;
    }
}
