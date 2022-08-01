package homework18;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.square, square) == 0 && Double.compare(circle.perim, perim) == 0 && Objects.equals(name, circle.name) && Objects.equals(colour, circle.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, colour, square, perim);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", square=" + square +
                ", perim=" + perim +
                '}';
    }
}
