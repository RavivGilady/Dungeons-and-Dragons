import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

public class CreatLevel {

    Scanner sc;

    public CreatLevel(String path) {
        File file = new File(path);
        this.sc = null;
        try {
            this.sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //read the next line
    public String nextLine() {
        return sc.nextLine();
    }

    //check if there is next line
    public Boolean hasNextLine() {
        return sc.hasNextLine();
    }

    public List<Enemy> creatEnemyList() {

        List<Enemy> enemyList = new LinkedList<>();
        int counter = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            for (int i=0; i<line.length(); i=i+1) {
                if (line.charAt(i) == 's') {
                    Enemy e = new Monster("Lannister Solider", 80, 80, 8, 3, i, counter, 25, 's', 3);
                    enemyList.add(e);
                }
                if (line.charAt(i) == 'k') {
                    Enemy e = new Monster("Lannister Knight", 200, 200, 14, 8, i, counter, 50, 'k', 4);
                    enemyList.add(e);
                }
                if (line.charAt(i) == 'q') {
                    Enemy e = new Monster("Queen’s Guard", 400, 400, 20, 15, i, counter, 100, 'q', 5);
                    enemyList.add(e);
                }
                if (line.charAt(i) == 'z') {
                    Enemy e = new Monster("Wright", 600, 600, 30, 15, i, counter, 100, 'z', 3);
                    enemyList.add(e);
                }
                if (line.charAt(i) == 'b') {
                    Enemy e = new Monster("Bear-Wright ", 1000, 1000, 75, 30, i, counter, 250, 'b', 4);
                    enemyList.add(e);
                }
                if (line.charAt(i) == 'g') {
                    Enemy e = new Monster("Giant-Wright", 1500, 1500, 100, 40, i, counter, 500, 'g', 5);
                    enemyList.add(e);
                }
                if (line.charAt(i) == 'w') {
                    Enemy e = new Monster("White Walker", 2000, 2000, 150, 50, i, counter, 1000, 'w', 6);
                    enemyList.add(e);
                }
                if (line.charAt(i) == 'M') {
                    Enemy e = new Monster("The Mountain ", 1000, 1000, 60, 25, i, counter, 500, 'M', 6);
                    enemyList.add(e);
                }
                if (line.charAt(i) == 'C') {
                    Enemy e = new Monster("Queen Cersei", 100, 100, 10, 10, i, counter, 1000, 'C', 1);
                    enemyList.add(e);
                }

                if (line.charAt(i) == 'K') {
                    Enemy e = new Monster("Night’s King ", 5000, 5000, 300, 150, i, counter, 5000, 'K', 8);
                    enemyList.add(e);
                }
                if (line.charAt(i) == 'B') {
                    Enemy e = new Trap("Bonus Trap",1,1,1,1,i,counter,250,'B',5,6,2);
                    enemyList.add(e);
                }
                if (line.charAt(i) == 'Q') {
                    Enemy e = new Trap("Queen’s Trap",250,250,50,10,i,counter,100,'Q',4,10,4);
                    enemyList.add(e);
                }
                if (line.charAt(i) == 'D') {
                    Enemy e = new Trap("Death Trap",500,500,100,20,i,counter,250,'D',6,10,3);
                    enemyList.add(e);
                }

            }
            counter = counter +1;
        }
        return enemyList;
    }
    public List<Point> creatWallsList() {
        List<Point> wallsList = new LinkedList<>();
        int counter = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            for (int i = 0; i < line.length(); i = i + 1) {
                if (line.charAt(i) == '#') {
                    Point p = new Point(i, counter);
                    wallsList.add(p);
                }
            }
            counter = counter + 1;
        }
        return wallsList;
    }
    public int width () {
        int counter = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            counter = counter + 1;
        }
        return counter;
    }
    public int length () {
        int counter = 0;
        while (sc.hasNextLine()&counter==0) {
            String line = sc.nextLine();
            counter = line.length();
        }
        return counter;
    }
}

