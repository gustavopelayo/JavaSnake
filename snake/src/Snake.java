import java.awt.*;
import java.awt.geom.Point2D;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Stack;

public class Snake {

    private int xCoor;
    private int yCoor;
    public int Length;
    public Point currentDir;

    public ArrayList<Point2D> snakeBody;
    public Snake(int xCoor,int yCoor){

        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.Length = 1;
        this.snakeBody = new ArrayList<>();
    }



    public void moveRight(){
        this.currentDir = new Point(1,0);
        this.xCoor = this.xCoor+ 1;

       if (this.xCoor > 15){
           this.xCoor = 0;
       }
    }
    public void moveLeft(){
        this.currentDir = new Point(-1,0);

        this.xCoor = this.xCoor- 1;

        if (this.xCoor < 0){
            this.xCoor = 15;
        }
    }
    public void moveUp(){
        this.currentDir = new Point(0,1);

        this.yCoor = this.yCoor- 1;

        if (this.yCoor < 0){
            this.yCoor = 11;
        }
    }
    public void moveDown(){
        this.currentDir = new Point(0,-1);

        this.yCoor = this.yCoor+ 1;

        if (this.yCoor >11){
            this.yCoor = 0;
        }

    }

    public int getxCoor() {
        return xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public void setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }

    public void setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }
}

