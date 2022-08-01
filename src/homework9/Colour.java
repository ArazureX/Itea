package homework9;

public class Colour {
    private String[] colors = {"blue", "pink", "yellow", "orange", "purple"};

    public String getColour() {
        return colors[(int) (Math.random() * colors.length)];

    }

}
