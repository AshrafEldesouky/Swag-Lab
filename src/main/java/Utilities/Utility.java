package Utilities;

import java.util.Random;

public class Utility {

    public static int getRandomNumberBetween1and6() {
        Random random = new Random();
        // Generate a random integer between 0 (inclusive) and 30 (exclusive)
        int randomNumber = random.nextInt(6);
        // Add 1 to make the range inclusive of 1 and 30
        return randomNumber + 1;
    }
    public static int getRandomNumberBetween1andN(int randomRange) {
        Random random = new Random();
        // Generate a random integer between 0 (inclusive) and 30 (exclusive)
        int randomNumber = random.nextInt(randomRange);
        // Add 1 to make the range inclusive of 1 and 30
        return randomNumber + 1;
    }
    public static String getRandom_differentCategories() {
        String[] names = {"Computers ", "Electronics ", "Apparel ", "Digital downloads ", "Books ", "Jewelry ", "Gift Cards "};
        int randomIndex = new Random().nextInt(names.length);
        return names[randomIndex];
    }
}
