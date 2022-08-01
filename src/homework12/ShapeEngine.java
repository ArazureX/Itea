package homework12;


import java.util.Scanner;

public class ShapeEngine {

    public void engineStart() {
        boolean isQuit = true;
        Scanner scanner = new Scanner(System.in);
        ParentShape[] parentShapes = new ParentShape[9];
        int countTypesOfShapes = 3;
        int countOfShapes = 0;
        ColourManager colour = new ColourManager();

        do {

            System.out.print("For Circle type '1'\n" +
                    "For Triangle type '2' \n" +
                    "For Rectangle type '3' \n" +
                    "For Quit type '0' \n");
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    if (countOfShapes == countTypesOfShapes) {
                        System.out.println("Too match, please choose another figure");
                        break;
                    }
                    System.out.println("Type Radius of Circle");
                    double radius = scanner.nextDouble();
                    parentShapes[countOfShapes++] = new Circlee(radius, colour.getColour());
                    break;
                case 2:
                    if (countOfShapes == countTypesOfShapes) {
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
                    parentShapes[countOfShapes++] = new Trianglee(legFirst, legSecond, legThird, heightToFirstLeg, colour.getColour());
                    break;
                case 3:
                    if (countOfShapes == countTypesOfShapes) {
                        System.out.println("Too match");
                        break;
                    }
                    System.out.println("Type first leg of Rectangle");
                    double sideFirst = scanner.nextDouble();
                    System.out.println("Type second leg of Rectangle");
                    double sideSecond = scanner.nextDouble();
                    parentShapes[countOfShapes++] = new Rectanglee(sideFirst, sideSecond, colour.getColour());
                    break;
                case 0:
                    System.out.println("Quit");
                    isQuit = false;
                    break;
                default:
                    System.out.println("Sorry, please choose '1', '2', '3' or '0' ");
            }
            if (countOfShapes == parentShapes.length) {
                    isQuit = false;
            }
        } while (isQuit);

        for (int i = 0; i < countOfShapes; i++) {
            parentShapes[i].printInfo();
        }

        scanner.close();
    }
}

