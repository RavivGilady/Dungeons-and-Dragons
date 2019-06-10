import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Tests {
    static Level first;
    public static void main(String[] args) {
//        List<Enemy>[] enemyList=new LinkedList<Enemy>[2];
        List<Player> playerList=new LinkedList<>();
        Enemy g=new Monster("raviv",5,5,5,5,2,5,5,'4',5);

        Player p=new Rogue("raviv",55,5,5,5,6,2,5,2,34,'@');
        playerList.add(p);
        List<Point> walls=new LinkedList<>();
//        enemyList.add(g);
//        first=new Level(enemyList,playerList,walls,30,10);
        printBoard();
    }



    private static void printBoard()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println(first.printBoard());

        first.playerMove(0,'s');
        first.playerMove(0,'s');
        first.playerMove(0,'s');
        first.playerMove(0,'a');
        first.playerMove(0,'a');
        first.playerMove(0,'a');
        first.playerMove(0,'a');

        System.out.println(first.printBoard());


    }
}
