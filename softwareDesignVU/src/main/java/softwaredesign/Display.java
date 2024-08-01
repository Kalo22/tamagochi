package softwaredesign;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Display {

    public void welcomeScreen() {

        clearScreen();
        printText("ASCIIprompts/WelcomeScreen/Welcome.txt");
        textDelay(500);
        printText("ASCIIprompts/WelcomeScreen/to.txt");
        textDelay(500);
        printText("ASCIIprompts/WelcomeScreen/bodybuildertext.txt");
        textDelay(500);
        printText("ASCIIprompts/WelcomeScreen/smash.txt");
        textDelay(2000);
        clearScreen();
        printText("ASCIIprompts/Setters/bodytype.txt");
    }

    public void enterDetails(Bodybuilder bodybuilder) {
        clearScreen();
        printText("ASCIIprompts/Setters/name.txt");
        bodybuilder.setName();
        clearScreen();
        printText("ASCIIprompts/Setters/gender.txt");
        bodybuilder.setGender();
        clearScreen();
        printText("ASCIIprompts/Setters/ethnicity.txt");
        bodybuilder.setEthnicity();
        clearScreen();
        printText("ASCIIprompts/Setters/height.txt");
        bodybuilder.setHeight();
        clearScreen();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printText(String file) {
        try {
            System.out.println(new String(Files.readAllBytes(Paths.get(file))));
        } catch(IOException e) {
            System.out.println("File not found");
        }
    }

    public static void textDelay(int sec) {
        try {
            Thread.sleep(sec);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    public void printStats(int fps, int ups, int iterr) {

            System.out.println(String.format("FPS: %d, UPS %d, I: %d", fps, ups, iterr));
            fps = 0;
            ups = 0;
    }

    public void printBodybuilder(Bodybuilder bodybuilder) {

            try {
                if(bodybuilder.gender == 1 && bodybuilder.ethnicity == 1) {
                    System.out.println(new String(Files.readAllBytes(Paths.get("ASCIIprompts/bodybuilders/bodybuilder.txt"))));
                }
                else if(bodybuilder.gender == 1 && bodybuilder.ethnicity == 2) {
                    System.out.println(new String(Files.readAllBytes(Paths.get("ASCIIprompts/bodybuilders/bodybuilderafro.txt"))));
                }
                else if(bodybuilder.gender == 2 && bodybuilder.ethnicity == 1) {
                    System.out.println(new String(Files.readAllBytes(Paths.get("ASCIIprompts/bodybuilders/bodybuilderfemale.txt"))));
                }
                else {
                    System.out.println(new String(Files.readAllBytes(Paths.get("ASCIIprompts/bodybuilders/bodybuilderafrofemale.txt"))));
                }
            } catch(IOException e) {
                System.out.println("FIle not found");
            }
    }

    public void printBars(Bodybuilder bodybuilder) {
        System.out.println("|NUTRITION| --> " + bodybuilder.nutrition);
        System.out.println("|HYDRATION| --> " + bodybuilder.hydration);
        System.out.println("|HYGIENE| --> " + bodybuilder.hygiene);
        System.out.println("|BODY FAT| --> " + bodybuilder.bodyFat);
        System.out.println("|LEVEL| --> " + bodybuilder.experience);
    }

    public void printInfo(Bodybuilder bodybuilder) {
        clearScreen();
        System.out.println("Name: " + bodybuilder.name + "    Gender: " + bodybuilder.gender);
        System.out.format("Height: %.2f m.\n", bodybuilder.height);
    }

}
