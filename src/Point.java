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
        return (Math.sqrt(sum));
    }
}
