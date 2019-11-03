import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class DuplicateRemover{
    private HashSet<String> fileWords = new HashSet<String>();
    private String uniqueWords;
    private Scanner inSS = null;
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private PrintWriter outFS;

    public DuplicateRemover(){
        uniqueWords = "";
    }

    public void remove(String dataFile) throws IOException {
        try {
            fileInputStream = new FileInputStream(dataFile);
            inSS = new Scanner(fileInputStream);

            while (inSS.hasNext()) {
                fileWords.add(inSS.next());
            }
            for (String word : fileWords) {
                uniqueWords += word + " ";
            }
        }
        catch (IOException bad) {
            System.out.println("Caught IOException " + bad.getMessage());
        }
        finally {
            fileInputStream.close();
        }
    }

    public void write(String outputFile) throws IOException {
        try {
            fileOutputStream = new FileOutputStream(outputFile);
            outFS = new PrintWriter(fileOutputStream);

            outFS.print(uniqueWords);
            outFS.flush();
        }
        catch (IOException bad) {
            System.out.println("Caught IOException " + bad.getMessage());
        }
        finally {
            fileOutputStream.close();
        }
    }

}