package cursedcreations.fangame;

public class MathUtils {
    static int getRandomIntInclusive(int min, int max) {
        return (int)Math.floor(Math.random() * (max - min + 1) + min); // The maximum is inclusive and the minimum is inclusive
    }

}
