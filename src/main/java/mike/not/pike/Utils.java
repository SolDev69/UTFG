package mike.not.pike;

import java.math.BigInteger;

public class Utils {
    static int getRandomIntInclusiveI(int min, int max) {
        return (int)Math.floor(Math.random() * (max - min + 1) + min); // The maximum is inclusive and the minimum is inclusive
    }
    static double getRandomDoubleInclusiveD(double min, double max) {
        return Math.random() * (max - min + 1) + min; // The maximum is inclusive and the minimum is inclusive
    }

    static void printDebug(java.lang.Object o) {
        if (Main.debug == true)
            System.out.println(o);
    }

    static boolean isCollided (Character character, Pellet pellet) {
        return isAbove(character, pellet)
                && ((pellet.y-pellet.getHeight()) <= (character.getY()+1/character.getHeight()));
    }

    private static boolean isAbove(Character character, Pellet pellet) {
        //print("yes " + character.getX() + " " + pellet.x + " " + (character.getX() + 1.0/character.getWidth()));
        return ((character.getX() + 1.0 / character.getWidth()) >= (pellet.x + 1.0 / pellet.size)) && (pellet.x >= character.getX())
                // || ((pellet.x + 1.0 / pellet.size < ))
                ;
    }

    public static void incrementScore() {
        incrementScore(1);
    }

    public static void incrementScore(long incrementBy) {
        Main.getInstance().setScore(Main.getInstance().getScore().add(BigInteger.valueOf(incrementBy)));
    }
}
