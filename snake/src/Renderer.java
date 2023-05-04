import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Renderer {
    private JFrame frame;
    private JPanel[][] panel;
//    private JPanel snakePanel;

    private JLabel label;

    private int OriginaltileSize = 16;
    private int scale = 3;
    private int finalTileSize = OriginaltileSize * scale;
    private int height = 12;
    private int width = 16;

    private int ScreenWidth = width * finalTileSize;
    private int ScreenHeight = height * finalTileSize;

    public Renderer() {
        frame = new JFrame("Frame");


       
        frame.setSize(new Dimension(ScreenWidth, ScreenHeight));

        centreWindow(frame);
        frame.addKeyListener(new MyKeyListener());
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setLayout(null);


        panel = new JPanel[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {

                panel[x][y] = new JPanel();
                panel[x][y].setLayout(null);
                panel[x][y].setLocation(x*finalTileSize,y*finalTileSize);
                panel[x][y].setSize(finalTileSize,finalTileSize);

                if ((x%2 != 0 && y %2 == 0) || (x%2 == 0 && y %2 != 0 )){
                    panel[x][y].setBackground(Color.DARK_GRAY);
                }
                else{
                    panel[x][y].setBackground(Color.LIGHT_GRAY);

                }
                frame.add(panel[x][y]);
            }

            frame.repaint();
        }

    }


    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }


    public void update(int[][] matrix){

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {


                if ((x%2 != 0 && y %2 == 0) || (x%2 == 0 && y %2 != 0 )){
                    panel[x][y].setBackground(Color.DARK_GRAY);
                }
                else{
                    panel[x][y].setBackground(Color.LIGHT_GRAY);

                }

                switch (matrix[x][y]){
                    case 0:
                        break;
                    case 1:
                        panel[x][y].setBackground(Color.GREEN);
                        break;
                    case 2:
                        panel[x][y].setBackground(Color.RED);
                        break;
                }
            }

            frame.repaint();    }
}
}
