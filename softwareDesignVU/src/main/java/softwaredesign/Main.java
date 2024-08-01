package softwaredesign;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main (String[] args){


        new Thread(new Gameloop()).start();

    }

}
