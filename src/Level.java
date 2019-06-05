import java.util.List;

public class Level {
    private List<Enemy> enemiesList;
    private List<Player> playerList;
    private List<Point> walls;
    private int width;
    private int length;

    public Level(List<Enemy> enemiesList, List<Player> playerList, List<Point> walls, int width, int length) {
        this.enemiesList = enemiesList;
        this.playerList = playerList;
        this.walls = walls;
        this.width = width;
        this.length = length;
    }
    public void gameTick()
    {

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
        if(checkWalls(playerMovementPoint))
            desiredPlayer.setPosition(playerMovementPoint);
        checkForEnemies(playerPosition);
    }
    public void moveLeft(int playerPosition)
    {
        Player desiredPlayer=playerList.get(playerPosition);
        Point playerMovementPoint=new Point(desiredPlayer.getPosition());
        playerMovementPoint.moveLeft();

        if(checkWalls(playerMovementPoint))
            desiredPlayer.setPosition(playerMovementPoint);
        checkForEnemies(playerPosition);
    }

    public void moveUp(int playerPosition)
    {
        Player desiredPlayer=playerList.get(playerPosition);
        Point playerMovementPoint=new Point(desiredPlayer.getPosition());
        playerMovementPoint.moveRight();

        if(checkWalls(playerMovementPoint))
            desiredPlayer.setPosition(playerMovementPoint);
        checkForEnemies(playerPosition);
    }
    public void moveDown(int playerPosition)
    {
        Player desiredPlayer=playerList.get(playerPosition);
        Point playerMovementPoint=new Point(desiredPlayer.getPosition());
        playerMovementPoint.moveRight();

        if(checkWalls(playerMovementPoint))
            desiredPlayer.setPosition(playerMovementPoint);
        checkForEnemies(playerPosition);
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
    private void checkForEnemies(int playerPosition) {
        Player desiredPlayer=playerList.get(playerPosition);
        Point playerMovementPoint=new Point(desiredPlayer.getPosition());
        for (Enemy en : enemiesList)
            if(playerMovementPoint.equals(en.getPosition()))
                desiredPlayer.attact(en);
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
}
