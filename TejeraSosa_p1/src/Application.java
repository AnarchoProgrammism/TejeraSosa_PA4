import java.io.IOException;
public class Application {
    public static void main(String[] args) {
        DuplicateRemover duplicateRemover = new DuplicateRemover();
        try {
            duplicateRemover.remove("problem1.txt");
            duplicateRemover.write("unique_words.txt");
        }
        catch (IOException bad) {
            System.out.println("Caught IOException " + bad.getMessage());
        }
    }
}