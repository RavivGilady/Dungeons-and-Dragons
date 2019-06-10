import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;
import java.util.List;
public class randomGenerator {
    private static boolean deter;
    private static Scanner number;
    private static Scanner action;
    private static Random generaor;

    public randomGenerator (){
        deter = false;
        generaor = new Random();
    }

    public randomGenerator (String numbers, String actions){
        File numberFile = new File(numbers);
        try {
            number = new Scanner(numberFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        File actionFile = new File(actions);
        try {
            number = new Scanner(actionFile);
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
        random = generaor.nextInt(value);
        return random;
    }

    public String generateAction (){
        if(deter){
            if(action.hasNext())
               return action.nextLine();
        }
        return "no more lines in the file";
    }













}

