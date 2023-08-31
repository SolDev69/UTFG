package cursedcreations.fangame;

public class MathUtils {
    static int getRandomIntInclusiveI(int min, int max) {
        return (int)Math.floor(Math.random() * (max - min + 1) + min); // The maximum is inclusive and the minimum is inclusive
    }
    static double getRandomDoubleInclusiveD(double min, double max) {
        return Math.random() * (max - min + 1) + min; // The maximum is inclusive and the minimum is inclusive
    }

}
