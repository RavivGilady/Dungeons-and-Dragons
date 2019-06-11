import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Tests {
    static Level first;
    public static void  main(String[] args) {




        String path="level 1.txt";
        CreatLevel c=new CreatLevel(path);
        List<Enemy>[] enemiesList=c.creatEnemyList();
        List<Player> playerList=new LinkedList<>();
        Player p=new Rogue("raviv",55,55,100,5,1,9,5,2,34,'@');
        playerList.add(p);
        List<Point> walls=c.creatWallsList();
        int width=c.width();
        int length=c.length();
        first=new Level(enemiesList,playerList,walls,width,length);
        System.out.println(first.printBoard());
        Scanner sc=new Scanner(System.in);
        String g=sc.next();
        while (g!="!!"){
            printBoard(g.charAt(0));
            g=sc.next();
        }

    }



    private static void printBoard(char movement)
    {
        first.playerMove(0,movement);
        first.enemiesMove();
        first.gameTick();
        System.out.println(first.printBoard());
        System.out.println(first.printMessages());



    }
}
