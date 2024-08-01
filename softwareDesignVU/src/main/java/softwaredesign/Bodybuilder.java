package softwaredesign;
import java.util.Scanner;

//import com.sun.xml.internal.ws.wsdl.writer.document.soap.Body;

abstract class Bodybuilder {
    public Boolean alive = true;
    public String name;
    public double height;
    Integer gender, ethnicity, bodyFat;
    int nutrition = 50;
    int hydration = 50;
    int hygiene = 50;
    int experience = 0;

    void setName() {
        Scanner scanObj = new Scanner(System.in);
        this.name = scanObj.nextLine();
    }

    void setGender() {
        int input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextInt();
        while (input != 1 && input != 2) {
            System.out.println("Enter a valid number of the ones listed above");
            input = scan.nextInt();
            //input = scan.nextInt();
        }
        //this.gender = scan.nextInt();
        this.gender = input;
    }

    void setEthnicity() {
        int input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextInt();
        while (input != 1 && input != 2) {
            System.out.println("Enter a valid number of the ones listed above");
            input = scan.nextInt();
        }
        this.ethnicity = input;
    }

    void setHeight() {
        Scanner scan = new Scanner(System.in);
        while(!scan.hasNextDouble()) {
            System.out.println("Enter a decimal measurement with a comma as a separator");
            scan.next();
        }
        this.height = scan.nextDouble();
    }

    void commandExecute (String command) {
        switch (command) {
            case "eat":
                Eat();
                break;
            case "drink":
                Drink();
                break;
            case "shower":
                Shower();
                break;
            default:
                System.out.println("Error. Invalid command");
        }
    }

    void Eat() {
        if (nutrition <= 80) {
            nutrition += 21;
        } else if (nutrition <= 100) {
            nutrition = 101;
        }
    }

    void Drink() {
        if (hydration <= 80) {
            hydration += 21;
        } else if (hydration <= 100) {
            hydration = 101;
        }
    }

    void Shower() {
        if (hygiene <= 80) {
            hygiene += 21;
        } else if (hygiene <= 100) {
            hygiene = 101;
        }
    }

    void decreaseStats() {
        nutrition -= 1;
        hydration -= 1;
        hygiene -= 1;
    }

}

class Skinny extends Bodybuilder {
    Skinny() {
        bodyFat = 30;
    }
}

class Bulky extends Bodybuilder {
    Bulky() {
        bodyFat = 50;
    }
}

class Fat extends Bodybuilder {
    Fat() {
        bodyFat = 80;
    }
}
