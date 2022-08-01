package homework12;

public class ColourManager {
    private String[] colors = {"blue", "pink", "yellow", "orange", "purple"};

    public String getColour() {
        return colors[(int) (Math.random() * colors.length)];

    }
}
