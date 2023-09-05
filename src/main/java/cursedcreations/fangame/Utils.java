package cursedcreations.fangame;

public class Utils {
    static int getRandomIntInclusiveI(int min, int max) {
        return (int)Math.floor(Math.random() * (max - min + 1) + min); // The maximum is inclusive and the minimum is inclusive
    }
    static double getRandomDoubleInclusiveD(double min, double max) {
        return Math.random() * (max - min + 1) + min; // The maximum is inclusive and the minimum is inclusive
    }

    static void print(java.lang.Object o) {
        System.out.println(o);
    }

    static boolean isCollided (Character character, Pellet pellet) {
        return isAbove(character, pellet)
                && ((pellet.y-pellet.getHeight()) <= (character.getY()+1/character.getHeight()));
    }

    private static boolean isAbove(Character character, Pellet pellet) {
        //print("yes " + character.getX() + " " + pellet.x + " " + (character.getX() + 1.0/character.getWidth()));
        return ((character.getX() + 1.0 / character.getWidth()) < (pellet.x + 1.0 / pellet.size)) || (pellet.x >= character.getX());
    }
}
