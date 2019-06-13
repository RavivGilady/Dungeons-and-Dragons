package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

public class CreateLevel {

    private String  path;

    public CreateLevel(String path) {

        File tmpDir = new File(path);
        boolean exists = tmpDir.exists();
        if(!exists) {
            System.out.println(path);
            throw new IllegalArgumentException();
        }
        this.path = path;
    }

    public List<Player> createPlayerList (int[] players){//TODO change in assignment 4 for multiple version
        List<Player> PlayerList = new LinkedList<>();
        Scanner sc = restartScanner();
        int lineIndex=0;
        int counter = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            for (int j = 0; j < line.length(); j = j + 1) {
                if(line.charAt(j) == '@'){
                    if(players[counter]==1){
                        Warrior p = new Warrior("Jon Snow",300,300,30,4,j,lineIndex,0,1,6,0,'@');
                        PlayerList.add(p);
                    }
                    if(players[counter]==2){
                        Warrior p = new Warrior("The Hound",400,400,20,6,j,lineIndex,0,1,4,0,'@');
                        PlayerList.add(p);
                    }
                    if(players[counter]==3){
                        Mage p = new Mage("Melisandre",160,160,10,1,j,lineIndex,0,1,40,300,300,30,5,6,'@');
                        PlayerList.add(p);
                    }
                    if(players[counter]==4){
                        Mage p = new Mage("Thoros of Myr",250,250,25,3,j,lineIndex,0,1,15,150,150,50,3,3,'@');
                        PlayerList.add(p);
                    }
                    if(players[counter]==5){
                        Rogue p = new Rogue("Arya Stark",150,150,40,2,j,lineIndex,0,1,20,'@');
                        PlayerList.add(p);
                    }
                    if(players[counter]==6){
                        Rogue p = new Rogue("Bronn",250,250,35,3,j,lineIndex,0,1,60,'@');
                        PlayerList.add(p);
                    }
                    counter = counter +1;

                }

            }
            lineIndex++;
        }
        return PlayerList;
    }
    public List<Enemy>[] createEnemyList() {

        LinkedList[] enemyList = new LinkedList[2];
        enemyList[0]= new LinkedList<Monster>();
        enemyList[1]= new LinkedList<Trap>();

        Scanner sc = restartScanner();
        int counter = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            for (int i=0; i<line.length(); i=i+1) {
                if (line.charAt(i) == 's') {
                    Enemy e = new Monster("Lannister Solider", 80, 80, 8, 3, i, counter, 25, 's', 3);
                    enemyList[0].add(e);
                }
                if (line.charAt(i) == 'k') {
                    Enemy e = new Monster("Lannister Knight", 200, 200, 14, 8, i, counter, 50, 'k', 4);
                    enemyList[0].add(e);
                }
                if (line.charAt(i) == 'q') {
                    Enemy e = new Monster("Queen’s Guard", 400, 400, 20, 15, i, counter, 100, 'q', 5);
                    enemyList[0].add(e);
                }
                if (line.charAt(i) == 'z') {
                    Enemy e = new Monster("Wright", 600, 600, 30, 15, i, counter, 100, 'z', 3);
                    enemyList[0].add(e);
                }
                if (line.charAt(i) == 'b') {
                    Enemy e = new Monster("Bear-Wright ", 1000, 1000, 75, 30, i, counter, 250, 'b', 4);
                    enemyList[0].add(e);
                }
                if (line.charAt(i) == 'g') {
                    Enemy e = new Monster("Giant-Wright", 1500, 1500, 100, 40, i, counter, 500, 'g', 5);
                    enemyList[0].add(e);
                }
                if (line.charAt(i) == 'w') {
                    Enemy e = new Monster("White Walker", 2000, 2000, 150, 50, i, counter, 1000, 'w', 6);
                    enemyList[0].add(e);
                }
                if (line.charAt(i) == 'M') {
                    Enemy e = new Monster("The Mountain ", 1000, 1000, 60, 25, i, counter, 500, 'M', 6);
                    enemyList[0].add(e);
                }
                if (line.charAt(i) == 'C') {
                    Enemy e = new Monster("Queen Cersei", 100, 100, 10, 10, i, counter, 1000, 'C', 1);
                    enemyList[0].add(e);
                }

                if (line.charAt(i) == 'K') {
                    Enemy e = new Monster("Night’s King ", 5000, 5000, 300, 150, i, counter, 5000, 'K', 8);
                    enemyList[0].add(e);
                }
                if (line.charAt(i) == 'B') {
                    Enemy e = new Trap("Bonus Trap",1,1,1,1,i,counter,250,'B',5,6,2);
                    enemyList[1].add(e);
                }
                if (line.charAt(i) == 'Q') {
                    Enemy e = new Trap("Queen’s Trap",250,250,50,10,i,counter,100,'Q',4,10,4);
                    enemyList[1].add(e);
                }
                if (line.charAt(i) == 'D') {
                    Enemy e = new Trap("Death Trap",500,500,100,20,i,counter,250,'D',6,10,3);
                    enemyList[1].add(e);
                }

            }
            counter = counter +1;
        }
        return enemyList;
    }
    public List<Point> createWallsList() {
        List<Point> wallsList = new LinkedList<>();
        Scanner sc = restartScanner();
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
    public int length () {
        Scanner sc = restartScanner();
        int counter = 0;
        while (sc.hasNextLine()) {
            sc.nextLine();
            counter = counter + 1;
        }
        return counter;
    }
    public int width () {
        Scanner sc = restartScanner();
        String line = sc.nextLine();
        return line.length();

    }
    private  Scanner restartScanner(){
        Scanner sc = null;
        File file = new File(path);
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sc;
    }


    public void fixPlayerPosition(List<Player> players) {
        Scanner sc = restartScanner();
        int lineIndex = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            for (int j = 0; j < line.length(); j = j + 1) {
                if (line.charAt(j) == '@') {
                    Point newPoint = new Point(j, lineIndex);
                    players.get(0).setPosition(newPoint);

                }
            }
            lineIndex++;
        }
    }
}

