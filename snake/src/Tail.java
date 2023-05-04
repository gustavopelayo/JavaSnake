public class Tail {
    private int xCoor;
    private int yCoor;

    public Tail(int xCoor,int yCoor){

        this.xCoor = xCoor;
        this.yCoor = yCoor;
    }


    public void moveRight(){
        this.xCoor = this.xCoor+ 1;
        if (this.xCoor > 15){
            this.xCoor = 0;
        }
    }
    public void moveLeft(){
        this.xCoor = this.xCoor- 1;
        if (this.xCoor < 0){
            this.xCoor = 15;
        }
    }
    public void moveUp(){

        this.yCoor = this.yCoor- 1;

        if (this.yCoor < 0){
            this.yCoor = 11;
        }
    }
    public void moveDown(){

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
