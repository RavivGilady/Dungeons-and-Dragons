public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point (Point p)
    {
        this.x=p.getX();
        this.y=p.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveRight(){
        x=x+1;
    }
    public void moveLeft(){
        x=x-1;
    }
    public void moveUp(){
        y=y-1;
    }
    public void moveDown(){
        y=y+1;
    }
}
