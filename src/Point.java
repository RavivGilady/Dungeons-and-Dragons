import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
    private Point (Point p,int movement) //0 - left, 1- right, 2 - up, 3 - down
    {
        if(movement==0) {
            this.x = p.getX() - 1;
            this.y = p.getY();
        }
        if(movement==1) {
            this.x = p.getX() + 1;
            this.y = p.getY();
        }
        if(movement==2) {
            this.x = p.getX();
            this.y = p.getY() + 1;
        }
        if(movement==3) {
            this.x = p.getX() ;
            this.y = p.getY() - 1;
        }

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
    public boolean equals(Object o)
    {
        //must use instance of for equal function in order to implement the right way
        if (!(o instanceof Point))
            return false;
        Point p=(Point)o;
        return (this.x==p.x && this.y==p.y);

    }

    public double distance(Point playerPosition) {
        int x_es= this.x-playerPosition.x;
        int y_es=this.y-playerPosition.y;
        double sum=Math.pow((double)x_es,2) +Math.pow((double)y_es,2);
        double output=Math.sqrt(sum);
        return (output);
    }


    public boolean outOfBounds(int length, int width) {
        if (y>=length | x>=width | y<0 | x<0)
            return true;

        return false;
    }

    public void moveTowards(Point player) {
        int dx=x-player.x;
        int dy=y-player.y;
        if(Math.abs(dx)>Math.abs(dy)){
            if(dx>0)
                moveLeft();
            else
                moveRight();
        }
        else {
            if (dy > 0)
                moveUp();
            else
                moveDown();
        }
    }

    public List<Point> findPointsInRange(int range)
    {
     List<Point> output=new LinkedList<>(givePointsNear(range));
     return output;

    }

    private Set<Point> givePointsNear(int range)
    {
        Set<Point> output = new LinkedHashSet<>();
        output.add(this);
        if (range != 0) {
            Point left = new Point(this,0);
            Point right = new Point(this,1);
            Point up = new Point(this,2);
            Point down = new Point(this,3);
            output.add(left);
            output.add(right);
            output.add(up);
            output.add(down);
            output.addAll(left.givePointsNear(range - 1));
            output.addAll(right.givePointsNear(range - 1));
            output.addAll(up.givePointsNear(range - 1));
            output.addAll(down.givePointsNear(range - 1));

        }
    return output;
    }
}
