package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class randomGenerator {
    private static boolean deter;
    private static Scanner number;
    private static Scanner action;
    private static Random generator=new Random();


    public static void randomGenerator (String numbers, String actions){
        File numberFile = new File(numbers);
        try {
            number = new Scanner(numberFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        File actionFile = new File(actions);
        try {
            action = new Scanner(actionFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        deter = true;
    }

    public static int generateNumber(int value){
        int random;
        if(deter){
            while(number.hasNext()){
                random = Integer.parseInt(number.nextLine());
                if(random <= value)
                    return random;
            }
        }

        random = generator.nextInt(value);
        return random;
    }

    public static String generateAction (){
        if(deter){
        if(action.hasNext())
            return action.nextLine();
    }
        return "no more lines in the file";
}


    public static boolean notFinished() {
        return (action.hasNext() & number.hasNext());
    }
}

