import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class DuplicateCounter {
    private HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
    private String wordCounter = "";
    private Scanner inSS = null;
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private PrintWriter outFS;

    public void count(String dataFile) throws IOException {
        try {
            fileInputStream = new FileInputStream(dataFile);
            inSS = new Scanner(fileInputStream);

            while (inSS.hasNext()) {
                String currWord;
                currWord = inSS.next();
                if (wordMap.containsKey(currWord)) {
                    wordMap.put(currWord, wordMap.get(currWord) + 1);
                }
                else {
                    wordMap.put(currWord, 1);
                }
            }
            wordCounter = wordMap.toString();
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

            outFS.print(wordCounter);
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
