package BrickBreakerGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author chinm
 */
public class MapGenerator {
    public boolean bricks[][];
    public int bricksWidth;
    public int bricksHeight;
    public MapGenerator(int row , int col){
        bricks = new boolean[row][col];
        for (boolean[] rowNum : bricks) {
            for (int j = 0; j < rowNum.length; j++) {
                rowNum[j] = true;
            }
        }
        bricksWidth = 540/col; // 77
        bricksHeight = 150/row; // 50
    }
    public void draw(Graphics2D g) {
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[0].length; j++) {
                if ( bricks[i][j]) { // if true
                    g.setColor(new java.awt.Color(204, 0, 102)); // red 153, 51, 255
                    // making bricks in 1D concept
                    g.fillRect(j * bricksWidth + 80, i * bricksHeight + 50, bricksWidth, bricksHeight);

                    g.setStroke(new BasicStroke(5));
                    g.setColor(new java.awt.Color(32, 32, 32));
                    g.drawRect(j * bricksWidth + 80, i * bricksHeight + 50, bricksWidth, bricksHeight);

                }
            }

        }
    }
    public void setBricksValue(boolean isBrick,int row,int col)
    {
        bricks[row][col] = isBrick;

    }

}