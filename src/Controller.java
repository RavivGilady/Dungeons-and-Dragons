import java.lang.invoke.LambdaConversionException;
import java.util.List;

public class Controller {
    private Level currentLevel;
    int i;
    boolean stop;
    CreateLevel cl;
    private String path;

    private boolean firsTime;
    public Controller (String directoryPath ,int[] playersChoose) {
        path=directoryPath;
        i=1;
        cl= new CreateLevel(directoryPath + " "+ i +".txt");
        List<Player> players=cl.createPlayerList(playersChoose);
        List<Enemy>[] enemiesList=cl.createEnemyList();
        List<Point> walls=cl.createWallsList();
        int width=cl.width();
        int length=cl.length();
        currentLevel=new Level(enemiesList,players,walls,width,length);
        stop=false;
    }


    public String runGame(char movement){
        if(!stop) {
            String output = "";
            currentLevel.playerMove(0, movement);
            currentLevel.enemiesMove();
            currentLevel.gameTick();
            output += currentLevel.printBoard();
            output += currentLevel.printMessages();

            if (currentLevel.isGameOver())
            {
                output += "***** GAME OVER *****";
                stop=true;
            }
            else if (currentLevel.isDone()) {
                List<Player> players=currentLevel.getPlayers();
                output += "Level " + i + "Cleared!";
                if(NextLevel(players))
                    output += "Good luck on level " + i ;
                else
                    output += "!*!*!*!*!* GAME FINISHED *!*!*!*!" ;

            }
            return output;
        }
        return "NO MORE LEVELS";
    }
    public boolean NextLevel(List<Player> players){
        try {
            cl = new CreateLevel(path + " " + i + ".txt");
            List<Enemy>[] enemiesList=cl.createEnemyList();
            List<Point> walls=cl.createWallsList();
            cl.fixPlayerPosition(players);
            int width=cl.width();
            int length=cl.length();
            currentLevel=new Level(enemiesList,players,walls,width,length);
            return true;
        }
        catch(Exception e){
            stop=true;
            return false;

        }

    }
    public boolean stop()
    {
        return stop;
    }
    public String printBoard()
    {
        if(!stop)
        return currentLevel.printBoard();
        return "";
    }
}
