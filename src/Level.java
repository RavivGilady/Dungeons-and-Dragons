import java.util.List;

public class Level {
    private List<Enemy> enemiesList;
    private List<Player> playerList;
    private List<Point> walls;
    private int width;
    private int length;
    private String combatNotification ="";

    public Level(List<Enemy> enemiesList, List<Player> playerList, List<Point> walls, int width, int length) {
        this.enemiesList = enemiesList;
        this.playerList = playerList;
        this.walls = walls;
        this.width = width;
        this.length = length;
    }
    public void gameTick()
    {
        for (Player pl : playerList) {
            if(!pl.isDead())
                pl.gameTick();
        }
        for(Enemy en: enemiesList)
            en.gameTick();

    }

    public void playerMove(int playerPosition,char movement)
    {
        Player desiredPlayer=playerList.get(playerPosition);
        Point playerMovementPoint=new Point(desiredPlayer.getPosition());

        if (movement=='w')
            playerMovementPoint.moveUp();
        if (movement=='s')
            playerMovementPoint.moveDown();
        if (movement=='a')
            playerMovementPoint.moveLeft();
        if (movement=='d')
            playerMovementPoint.moveRight();
        if (movement=='e')
            desiredPlayer.specialAbility(enemiesList);
        //TODO check if there's anything to do with boolean return value
        if(checkWalls(playerMovementPoint) && checkForEnemiesAndAttack(playerPosition,playerMovementPoint))
            desiredPlayer.setPosition(playerMovementPoint);
        //checkForEnemiesAndAttack(playerPosition); TODO change it to stay in place and attack
    }

    public boolean checkWalls(Point playerMovementPoint)
    {
        boolean canMove=true;
        for(Point p : walls) {
            if (playerMovementPoint.equals(p))
                canMove = false;
        }
        return canMove;
    }
    private boolean checkForEnemiesAndAttack(int playerPosition,Point position) {
        Player desiredPlayer=playerList.get(playerPosition);
        Point playerMovementPoint=position;
        for (Enemy en : enemiesList)
            if(playerMovementPoint.equals(en.getPosition())) {
                attackEnemy(desiredPlayer,en);
                return false;
            }
        return true;
    }

    public void attackEnemy(Player attacker,Enemy defender)
    {
        int[] combatStats =attacker.attack(defender);
        this.combatNotification +="Player "+attacker.getName() +" attacked "+defender.getName() + " and made "+ combatStats[0] +" attack" +
                "point, and " + defender.getName()+ "had " +combatStats[1] +" defense point.\n";
        if (defender.isDead()) {
            combatNotification +=defender.getName()+" is now dead! \n";
            attacker.addExp(defender.getExperience()); // add the experience that the player should get from this enemy
            enemiesList.remove(defender);
        }
        else
            combatNotification +=defender.getName()+" has "+ defender.getCurrentHealth() +" health point remaining.\n";

    }
    public String printBoard() {
        char[][] boardAsArray = new char[length][width];
        for (int i = 0; i < length; i++)
            for (int j = 0; j < width; j++)
                boardAsArray[i][j] = '.';
        for(Enemy en : enemiesList)
        {
            boardAsArray[en.getYposition()][en.getXposition()]=en.getTile();
        }
        for(Player pl : playerList)
        {
            boardAsArray[pl.getYposition()][pl.getXposition()]=pl.getTile();
        }
        return arrayToBoard(boardAsArray);

    }

    private String arrayToBoard(char[][] board)
    {
        String newBoard="";
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[i].length ; j++) {
                newBoard+=board[i][j];
            }
            newBoard+= "\n";
        }
        return newBoard;
    }
    public String printMessages() {
        String output = combatNotification;
        combatNotification ="";
        for (Player p : playerList) {
            if (p.isDead())
                output += "Player " + p.getName() + " died in the last game round! his level was - "+p.getLevel()+
                        " and his EXP was: " +p.getExperience()+ "\n";
            else if (p.levelUp()) {
                output += "Player " + p.getName() + " leveled up to level - " + p.getLevel() + "\n";
            }
        }
        return output;
    }
    public String playerStats(Player p)
    {
        String output="Stats of Player: "+p.getName()+"\n";
        output+= "Health pool= "+p.getHealthPool();
        return output;
    }
}
