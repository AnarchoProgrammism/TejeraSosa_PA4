import java.util.Scanner;
import java.security.SecureRandom;

public class CAI {

    public static double makeQuestion(SecureRandom randGen, int difficulty, int questionType) {
        int x = 0;
        int y = 0;
        double questionResult = 0;
        String[] operation = {"plus", "times", "minus", "divided by"};
        int randomOperation = 0;

        if (difficulty == 1) {
            x = randGen.nextInt(9) + 1;
            y = randGen.nextInt(9) + 1;
        }
        else if (difficulty == 2) {
            x = randGen.nextInt(99) + 1;
            y = randGen.nextInt(99) + 1;
        }
        else if (difficulty == 3) {
            x = randGen.nextInt(999) + 1;
            y = randGen.nextInt(999) + 1;
        }
        else if (difficulty == 4) {
            x = randGen.nextInt(9999) + 1;
            y = randGen.nextInt(9999) + 1;
        }
        if (questionType == 5) {
            randomOperation = randGen.nextInt(4);
            System.out.println("How much is " + x + " " + operation[randomOperation] + " " + y + "?");
        }
        else {
            System.out.println("How much is " + x + " " + operation[questionType - 1] + " " + y + "?");
        }

        if (questionType == 1) {
            questionResult = (double) x + y;
        }
        else if (questionType == 2) {
            questionResult = (double) x * y;
        }
        else if (questionType == 3) {
            questionResult = (double) x - y;
        }
        else if (questionType == 4) {
            questionResult = (double) x / y;
        }
        else if (questionType == 5) {
            if (randomOperation == 0) {
                questionResult = (double) x + y;
            }
            else if (randomOperation == 1) {
                questionResult = (double) x * y;
            }
            else if (randomOperation == 2) {
                questionResult = (double) x - y;
            }
            else if (randomOperation == 3) {
                questionResult = (double) x / y;
            }
        }

        return questionResult;
    }

    public static double getPercentRight (int numRight) {
        double percentRight;

        percentRight = ((double) numRight / 10.0) * 100;

        return percentRight;
    }

    public static void printMessage(SecureRandom randGen, boolean right) {
        if (right) {
            switch (randGen.nextInt(4) + 1) {
                case 1:
                    System.out.println("Very good!");
                    break;
                case 2:
                    System.out.println("Excellent!");
                    break;
                case 3:
                    System.out.println("Nice work!");
                    break;
                case 4:
                    System.out.println("Keep up the good work!");
                    break;
            }
        }
        else {
            switch (randGen.nextInt(4) + 1) {
                case 1:
                    System.out.println("No. Please try again.");
                    break;
                case 2:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 3:
                    System.out.println("Don’t give up!");
                    break;
                case 4:
                    System.out.println("No. Keep trying.");
                    break;
            }
        }
    }

    public static int getArithmeticType(Scanner in) {
        int choice;

        System.out.println("Please enter your desired arithmetic type.");
        System.out.println("1 - addition only");
        System.out.println("2 - multiplication only");
        System.out.println("3 - subtraction only");
        System.out.println("4 - division only");
        System.out.println("5 - random mix of the above");

        choice = in.nextInt();
        while (choice < 1 || choice > 5) {
            System.out.println("That's not an option enter (1-5):");
            choice = in.nextInt();
        }

        return choice;
    }

    public static int getDifficulty(Scanner in) {
        int choice;

        System.out.println("Please enter your desired difficulty level (1-4):");
        choice = in.nextInt();

        while (choice < 1 || choice > 4) {
            System.out.println("Invalid level, enter (1-4):");
            choice = in.nextInt();
        }

        return choice;
    }

    public static void main(String[] args) {
        SecureRandom randGen = new SecureRandom();
        Scanner in = new Scanner(System.in);
        double result;
        double answer;
        char again = 'y';
        int numRight;
        int numWrong;
        int difficultyLevel;
        int arythmeticType;

        while (again == 'y') {
            numRight = 0;
            numWrong = 0;

            difficultyLevel = getDifficulty(in);
            arythmeticType = getArithmeticType(in);

            for (int i = 0; i < 10; ++i) {
                result = makeQuestion(randGen, difficultyLevel, arythmeticType);

                System.out.println("Enter answer:");
                answer = in.nextDouble();

                if (Math.abs(result - answer) < 0.0001) {
                    printMessage(randGen, true);
                    ++numRight;
                } else {
                    printMessage(randGen, false);
                    ++numWrong;
                }
            }

            System.out.println();
            System.out.println("Number correct: " + numRight);
            System.out.println("Number wrong: " + numWrong);


            if (getPercentRight(numRight) < 75.0) {
                System.out.println("Please ask your teacher for extra help.");
            }
            else {
                System.out.println("Congratulations, you are ready to go to the next level!");
            }

            System.out.println("Would you like to do another session? (y for yes, any other letter for no)");
            again = in.next().charAt(0);
        }
    }
}
