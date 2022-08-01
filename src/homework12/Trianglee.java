package homework12;

public class Trianglee extends ParentShape {
        private double legFirst;
        private double legSecond;
        private double legThird;
        private  double heightToFirstLeg;
    public Trianglee(double legFirst, double legSecond, double legThird, double heightToFirstLeg, String colour) {
        name = "Triangle";
        this.legFirst=legFirst;
        this.legSecond=legSecond;
        this.legThird=legThird;
        this.heightToFirstLeg=heightToFirstLeg;
        this.colour=colour;
        updateColour();
        countPerim();
        countSquare();

    }

    @Override
    public Double countSquare() {
        square = 0.5 * legFirst * heightToFirstLeg;
        return square;
    }

    @Override
    public Double countPerim() {
        perim = legFirst + legSecond + legThird;
        return perim;
    }
}
