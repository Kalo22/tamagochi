package softwaredesign;

import java.util.Scanner;

public class BodyBuilderFactory {

    public static Bodybuilder create() {

        int typeNum;
        Scanner scan = new Scanner(System.in);
        typeNum = scan.nextInt();
        while(!scan.hasNextInt() || (typeNum != 1 && typeNum != 2 && typeNum != 3)) {
        //while (typeNum != 1 && typeNum != 2 && typeNum != 3) {
            System.out.println("Enter a valid number of the ones listed above");
            //typeNum = scan.nextLine();
            typeNum = scan.nextInt();
            scan.nextInt();
        }

//        while (typeNum != 1 || typeNum != 2 || typeNum != 3) {
//            System.out.println("Enter a valid number of the ones listed above");
//            typeNum = scan.nextInt();
//            }
//        typeNum = scan.nextInt();
        if(scan.nextInt() == 1) return new Skinny();
        else if(scan.nextInt() == 2) return new Bulky();
        else return new Fat();
    }

}
