package homework9;

import java.util.Scanner;

public class hm9 {
    public static void main(String[] args) {
        boolean isQuit = true;
        Scanner scanner = new Scanner(System.in);
        Circle[] circlesArr = new Circle[3];
        Triangle[] trianglesArr = new Triangle[3];
        Rectangle[] rectanglesArr = new Rectangle[3];
        int countCircle = 0;
        int countTriangle = 0;
        int countRectangle = 0;
        Colour colour = new Colour();

        do {

            System.out.print("For Circle type '1'\n" +
                    "For Triangle type '2' \n" +
                    "For Rectangle type '3' \n" +
                    "For Quit type '0' \n");
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    if (countCircle == (circlesArr.length)) {
                        System.out.println("Too match, please choose another figure");
                        break;
                    }
                    System.out.println("Type Radius of Circle");
                    double radius = scanner.nextDouble();
                    circlesArr[countCircle++] = new Circle(radius , colour.getColour());
                    break;
                case 2:
                    if (countTriangle == (trianglesArr.length)) {
                        System.out.println("Too match");
                        break;
                    }
                    System.out.println("Type first leg of Triangle");
                    double legFirst = scanner.nextDouble();
                    System.out.println("Type second leg of Triangle");
                    double legSecond = scanner.nextDouble();
                    System.out.println("Type third leg of Triangle");
                    double legThird = scanner.nextDouble();
                    System.out.println("Type height to first leg of Triangle");
                    double heightToFirstLeg = scanner.nextDouble();
                    trianglesArr[countTriangle++]= new Triangle(legFirst, legSecond, legThird, heightToFirstLeg, colour.getColour());
                    break;
                case 3:
                    if (countRectangle == (rectanglesArr.length)) {
                        System.out.println("Too match");
                        break;
                    }
                    System.out.println("Type first leg of Rectangle");
                    double sideFirst = scanner.nextDouble();
                    System.out.println("Type second leg of Rectangle");
                    double sideSecond = scanner.nextDouble();
                    rectanglesArr[countRectangle++] = new Rectangle(sideFirst, sideSecond, colour.getColour());
                    break;
                case 0:
                    System.out.println("Quit");
                    isQuit = false;
                    break;
                default:
                    System.out.println("Sorry, please choose '1', '2', '3' or '0' ");
            }
            if ((countCircle == circlesArr.length) && (countRectangle == rectanglesArr.length) && (countTriangle == trianglesArr.length)) {
                isQuit = false;
            }
        } while (isQuit);

        for (int i = 0; i < countCircle; i++) {
            circlesArr[i].printInfo();
        }
        for (int i = 0; i < countRectangle; i++) {
            rectanglesArr[i].printInfo();
        }
        for (int i = 0; i < countTriangle; i++) {
            trianglesArr[i].printInfo();
        }
        scanner.close();
    }
}
