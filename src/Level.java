import java.util.List;

public class Level {
    private List<Enemy>[] enemiesLists; // [List<Enemy> Monsters , List<Enemy> Traps]
    private List<Player> playerList;
    private List<Point> walls;
    private int width;
    private int length;
    private String combatNotification ="";

    public Level(List<Enemy>[] enemiesList, List<Player> playerList, List<Point> walls, int width, int length) {
        this.enemiesLists = enemiesList;
        this.playerList = playerList;
        this.walls = walls;
        this.width = width;
        this.length = length;
    }
    public void gameTick(){
        for (Player pl : playerList) {
            if(!pl.isDead())
                pl.gameTick();
        }
        for(List<Enemy> enemiesList: enemiesLists)
            for(Enemy en: enemiesList)
                en.gameTick();

    }
    public void playerMove(int playerPosition,char movement){
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
        if (movement=='e') {
                combatNotification+=desiredPlayer.specialAbility(enemiesLists);
                removeDeadEnemies();
        }
        if(checkWalls(playerMovementPoint))
            if(checkForEnemiesAndAttack(playerPosition,playerMovementPoint))
                desiredPlayer.setPosition(playerMovementPoint);
    }
    private void removeDeadEnemies() {
        for(List<Enemy> enemies : enemiesLists)
            for (Enemy en : enemies)
                if(en.isDead())
                    enemies.remove(en);
    }
    public boolean checkWalls(Point playerMovementPoint){
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
        for(List<Enemy> enemies : enemiesLists)
            for (Enemy en : enemies)
                if(playerMovementPoint.equals(en.getPosition())) {
                    attackGameUnit(desiredPlayer,en);
                    return false;
            }
        return true;
    }
    public void attackGameUnit(Player attacker,Enemy defender){
        int[] combatStats =attacker.attack(defender);
        if( combatStats[0]>combatStats[1])
        {
            combatNotification+=attacker.getName()+" attacked " + defender.getName() +" and made him "+combatStats[0] + "damage! ";
            if (defender.isDead())
            {
                combatNotification+=" And killed him! ";
                attacker.addExp(defender.getExperience()); // add the experience that the player should get from this enemy
                removeEnemy(defender);
            }
            else
                combatNotification+=defender.getName() +" has " + defender.getCurrentHealth() +" health points remaining";
            combatNotification+="\n";
        }
        else
            combatNotification+=attacker.getName()+" tried to attack " + defender.getName() +"  and make "+combatStats[0]+"attack points," +
                    " but couldn't hurt him because " + defender.getName() +"had " +combatStats[1] + " defence points! \n";
    }
    private void removeEnemy(Enemy defender) {
        if (enemiesLists[0].contains(defender))
            enemiesLists[0].remove(defender);
        if (enemiesLists[1].contains(defender))
            enemiesLists[1].remove(defender);
    }
    public String printBoard() {
        char[][] boardAsArray = new char[length][width];
        for (int i = 0; i < length; i++)
            for (int j = 0; j < width; j++)
                boardAsArray[i][j] = '.';
        for(List<Enemy> enemies:enemiesLists)
            for(Enemy en : enemies)
            {
                boardAsArray[en.getYposition()][en.getXposition()]=en.getTile();
            }
        for(Player pl : playerList)
        {
            boardAsArray[pl.getYposition()][pl.getXposition()]=pl.getTile();
        }
        return arrayToBoard(boardAsArray);

    }
    private String arrayToBoard(char[][] board){
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
            else
            {
                while(p.levelUp()) {
                    output += "Player " + p.getName() + " leveled up to level - " + p.getLevel() + "\n";
                }
                output +=playerStats(p);
            }
        }
        return output;
    }
    public String playerStats(Player p){
        return p.toString();
    }
    public void emptyNotification(){
        combatNotification="";
    }
    public void enemiesMove()
    {
        monsterMove();
        trapsMove();
    }

    private void monsterMove() {

        for(Enemy mon :enemiesLists[0])
        {
            Point desiredMovement =mon.move(); //TODO implement
            if(checkWalls(desiredMovement))
                if(checkForPlayersAndAttack(desiredMovement,mon,0))
                    mon.setPosition(desiredMovement);
        }
    }
    private boolean checkForPlayersAndAttack(Point position,Enemy en,int range)
    {
        Point enemyMovementPoint=position;
        for (Player P : playerList)
            if(!P.isDead() & enemyMovementPoint.distance(P.getPosition())<=range) {
                attackPlayer(en,P);
                return false;
            }
        return true;
    }

    private void attackPlayer(Enemy attacker,Player defender) {
        int[] combatStats =attacker.attack(defender);
        if( combatStats[0]>combatStats[1])
        {
            combatNotification+=attacker.getName()+" attacked " + defender.getName() +" and made him "+combatStats[0] + "damage! ";
            if (defender.isDead())
            {
                combatNotification+=" And killed him! ";
            }
            else
                combatNotification+=defender.getName() +" has " + defender.getCurrentHealth() +" health points remaining";
            combatNotification+="\n";
        }
        else
            combatNotification+=attacker.getName()+" tried to attack " + defender.getName() +"  and make "+combatStats[0]+"attack points," +
                    " but couldn't hurt him because " + defender.getName() +"had " +combatStats[1] + " defence points! \n";
    }

    private void trapsMove() {
    }


    public int numOfEnemies()
    {
        return (enemiesLists[0].size() +enemiesLists[1].size());
    }
}
