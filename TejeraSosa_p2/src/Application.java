import java.io.IOException;
public class Application {
    public static void main(String[] args) {
        DuplicateCounter duplicateCounter = new DuplicateCounter();
        try {
            duplicateCounter.count("problem2.txt");
            duplicateCounter.write("unique_word_counts.txt");
        }
        catch (IOException bad) {
            System.out.println("Caught IOException " + bad.getMessage());
        }
    }
}