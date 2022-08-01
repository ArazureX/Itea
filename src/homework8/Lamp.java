package homework8;

public class Lamp {
    int brightness;
    boolean isTurnedOn;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    void turnOnLamp() {

        if (isTurnedOn) {
            brightness = 0;
            isTurnedOn = false;
        } else {
            brightness = 100;
            isTurnedOn = true;
        }
    }

    void switchCondition() {
        String statusAnswer = isTurnedOn == true ? "Lamp is " + "turned " + ANSI_GREEN + "ON " + ANSI_RESET + "Brightness = " + brightness :
                "Lamp is " + "turned " + ANSI_RED + "OFF " + ANSI_RESET + "Brightness = " + brightness;
        System.out.println(statusAnswer);
    }
}
