package oop.practice;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Display display1 = new Display(3840, 2160, 163, "Samsung Odyssey G9");
        Display display2 = new Display(1920, 1080, 82, "HP Pavilion 22cwa");
        Display display3 = new Display(3440, 1440, 110, "Acer Predator X34");


        System.out.println("\nTask 1 the comparison of displays:");
        display1.compareSize(display2);
        display1.compareSharpness(display2);
        display2.compareSize(display3);
        display2.compareSharpness(display3);
        display1.compareWithMonitor(display3);

        System.out.println("\nTask 3 the assistant:");
        Assistant assistant = new Assistant("Assisant");
        assistant.assignDisplay(display1);
        assistant.assignDisplay(display2);
        assistant.assignDisplay(display3);

        assistant.assist();
        assistant.buyDisplay(display2);

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
//reading the files
        System.out.println("\nTask 4(updated task 2) the file reader:");
        String filePaths[] = {"/Users/suleimanpasa/oop-course-repo/lab-papers-please/java-classifcation/src/main/resources/text.txt",
                "/Users/suleimanpasa/oop-course-repo/lab-papers-please/java-classifcation/src/main/resources/text2.txt",
                "/Users/suleimanpasa/oop-course-repo/lab-papers-please/java-classifcation/src/main/resources/text3.txt"};
        FileReader fileReader = new FileReader();
        System.out.println("Choose a file to read:");
        for (int i = 0; i < filePaths.length; i++) {
            System.out.println((i + 1) + ". " + filePaths[i]);
        }
        System.out.println("Enter the number of the file you want to read:");
        int fileChoice = scanner.nextInt() - 1;

        if (fileChoice >= 0 && fileChoice < filePaths.length) {
            System.out.println("File to check: " + filePaths[fileChoice]);
            String fileContent = fileReader.readFileIntoString(filePaths[fileChoice]);
            TextData textData = new TextData(filePaths[fileChoice], fileContent);

            System.out.println("File name: " + textData.getFileName());
            System.out.println("File content: " + textData.getText());
            System.out.println("Number of vowels: " + textData.getNumberOfVowels());
            System.out.println("Number of consonants: " + textData.getNumberOfConsonants());
            System.out.println("Number of letters: " + textData.getNumberOfLetters());
            System.out.println("Number of sentences: " + textData.getNumberOfSentences());
            System.out.println("The longest word: " + textData.getLongestWord());
        } else {
            System.out.println("Invalid input. Please try again.");
        }
        scanner.close();

    }
}



