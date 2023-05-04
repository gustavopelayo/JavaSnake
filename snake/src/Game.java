

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;
public class Game {
    int oldx = 0;
    int oldy= 0;
    private int xPos= 0;
    private int yPos =0;
    private Renderer renderer;

    public boolean gameover;
    ArrayList<Tail> tails = new ArrayList<>();
    Snake snake;
    Tail newTail;
    private Apple apple = GenerateApple();

    public Game() {

        renderer = new Renderer();
        CreateMap(renderer);
        snake = new Snake(3,0);
        newTail = new Tail(0,0);
        this.gameover = false;
    }

    public void update(){
        int[][] matrix = new int[16][12];
        for(int x = 0; x<16;x++){
            for (int y = 0; y < 12; y++) {
                matrix[x][y] = 0;
            }
        }

        if((MyKeyListener.dPressed) && (snake.currentDir !=  new Point(1,0))){


                MyKeyListener.aPressed = false;
                MyKeyListener.wPressed = false;
                MyKeyListener.sPressed = false;
                snake.moveRight();
                Point2D movePos = new Point2D.Double();

                movePos.setLocation(snake.getxCoor(), snake.getyCoor());

            System.out.println("head: "+ movePos);
                snake.snakeBody.add(movePos);
                if (snake.snakeBody.size() - 1 == snake.Length) {
                    snake.snakeBody.remove(0);
                }
            System.out.println("----------");


            System.out.println(checkColision(snake,movePos));

            System.out.println("----------");


                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

            if (checkColision(snake,movePos) == true){
                System.out.println("Game Over!");
                gameover = true;

            }


            if (CheckAppleCollected(snake, apple)) {

                    snake.Length++;

                }

                RenderMovement(matrix, snake.getxCoor(), snake.getyCoor());
            }


        if((MyKeyListener.aPressed) && (snake.currentDir !=  new Point(1,0))){



            MyKeyListener.dPressed = false;
            MyKeyListener.wPressed = false;
            MyKeyListener.sPressed = false;


            snake.moveLeft();
            Point2D movePos = new Point2D.Double();

            movePos.setLocation(snake.getxCoor(),snake.getyCoor());
            snake.snakeBody.add(movePos);

            System.out.println("head: "+ movePos);

            if (snake.snakeBody.size()-1 == snake.Length) {
                snake.snakeBody.remove(0);
            }


            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            if (checkColision(snake,movePos) == true){
                System.out.println("Game Over!");
                gameover = true;

            }



            if(CheckAppleCollected(snake,apple)){

                snake.Length++;

            }
            System.out.println(checkColision(snake,movePos));


            RenderMovement(matrix,snake.getxCoor(), snake.getyCoor());


        }
        if((MyKeyListener.wPressed) && (snake.currentDir !=  new Point(0,-1))){


            MyKeyListener.dPressed = false;
            MyKeyListener.aPressed = false;
            MyKeyListener.sPressed = false;


            snake.moveUp();
            Point2D movePos = new Point2D.Double();

            movePos.setLocation(snake.getxCoor(),snake.getyCoor());
            snake.snakeBody.add(movePos);
            System.out.println("head: "+ movePos);

            if (snake.snakeBody.size()-1 == snake.Length) {
                snake.snakeBody.remove(0);
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

//            System.out.println("snake x: "+snake.getxCoor()+" snake y: "+ snake.getyCoor());


            if (checkColision(snake,movePos) == true){
                System.out.println("Game Over!");
                gameover = true;
            }




            if(CheckAppleCollected(snake,apple)){

                snake.Length++;

            }
            System.out.println(checkColision(snake,movePos));


            RenderMovement(matrix,snake.getxCoor(), snake.getyCoor());


        }

        if((MyKeyListener.sPressed) && (snake.currentDir !=  new Point(0,-1))){


            MyKeyListener.dPressed = false;
            MyKeyListener.aPressed = false;
            MyKeyListener.wPressed = false;

            snake.moveDown();
            Point2D movePos = new Point2D.Double();

            movePos.setLocation(snake.getxCoor(),snake.getyCoor());
            snake.snakeBody.add(movePos);
            System.out.println("head: "+ movePos);

            if (snake.snakeBody.size()-1 == snake.Length) {
                snake.snakeBody.remove(0);
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }


            if (checkColision(snake,movePos) == true){
                System.out.println("Game Over!");
                gameover = true;

            }



//            System.out.println("snake x: "+snake.getxCoor()+" snake y: "+ snake.getyCoor());
            if(CheckAppleCollected(snake,apple)){

                snake.Length++;

            }
            System.out.println(checkColision(snake,movePos));


            RenderMovement(matrix,snake.getxCoor(), snake.getyCoor());

        }
    }

    public void RenderMovement(int matrix[][],int xPos, int yPos){



            matrix[xPos][yPos] = 1;

        for (Point2D point:
             snake.snakeBody){
            matrix[(int) point.getX()][(int) point.getY()] = 1;

        }
        matrix[apple.getxCoor()][apple.getyCoor()] = 2;

        if ((CheckAppleCollected(snake, apple)) == true) {

            matrix[apple.getxCoor()][apple.getyCoor()] = 0;
            this.apple = GenerateApple();

        }

        renderer.update(matrix);



    }


    public void CreateMap(Renderer renderer){


         this.apple = GenerateApple();

        int[][] matrix = new int[16][12];
        for(int x = 0; x<16;x++){
            for (int y = 0; y < 12; y++) {
                matrix[x][y] = 0;
            }
        }
        matrix[3][0] = 1;
        matrix[apple.getxCoor()][apple.getyCoor()] = 2;

        renderer.update(matrix);


    }

    private  Apple GenerateApple(){
        int posX = ThreadLocalRandom.current().nextInt(0, 15 + 1);
        int posY = ThreadLocalRandom.current().nextInt(0, 11 + 1);

        Apple apple = new Apple(posX,posY);

        return apple;

    }
    private boolean CheckAppleCollected(Snake snake, Apple apple) {

        if (snake.getxCoor() == apple.getxCoor() && snake.getyCoor() == apple.getyCoor()){
            System.out.println("Collected Apple");
            return true;
        }
        else return false;
    }

    private boolean checkColision(Snake snake, Point2D movePos){

        System.out.println(snake.snakeBody.size());
        for (Point2D point2D:
                snake.snakeBody) {
            if (point2D == snake.snakeBody.get(snake.snakeBody.size()-1)) continue;
            if (movePos.equals(point2D))
                return true;
        }
        return false;
    }



}

