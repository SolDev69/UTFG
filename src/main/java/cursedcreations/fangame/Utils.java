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
}
