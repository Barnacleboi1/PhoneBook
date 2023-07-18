package phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Instant;
import java.time.LocalTime;
import java.time.Period;
import java.util.*;

public class Main {
    public static File directory = new File("C:\\Users\\Robik\\eclipse-workspace\\Phone Book (Java)\\data\\directory.txt");
    public static File targets = new File("C:\\Users\\Robik\\eclipse-workspace\\Phone Book (Java)\\data\\find.txt");
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start searching...");
        long startingTime = System.currentTimeMillis();
        linearSearch();
        Thread.sleep(10000);
        long endingTime = System.currentTimeMillis();
        long timeDifference = endingTime - startingTime;
        long minutes = (timeDifference / 1000) / 60;
        long seconds = (timeDifference / 1000) % 60;
        long milliseconds = timeDifference - ((minutes * 60000) + ( seconds * 1000));
        System.out.printf("Time taken: %d min. %d sec. %d ms. to complete", minutes, seconds, milliseconds );

    }
    public static void linearSearch() {
        Set<String> phoneLists = new HashSet<>();
        Scanner targetReader;
        Scanner directoryReader;

        try {
            targetReader = new Scanner(targets);
            directoryReader = new Scanner(directory);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
        int entries = 0;
        while (targetReader.hasNext()) {
            entries++;
            String targetName = targetReader.nextLine();
            String directoryLine = directoryReader.nextLine();
            if (directoryLine.contains(targetName)) {
                phoneLists.add(directoryLine.split(" ")[0]);
            }
        }
        System.out.printf("Found %d / %d entries.", entries, entries);
    }
}
