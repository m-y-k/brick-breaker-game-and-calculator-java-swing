package BrickBreakerGame;

import BrickBreakerGame.GamePlay;

import javax.swing.JFrame;

/**
 *
 * @author chinm
 */
public class MyApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BrickBreaker");
        GamePlay gameplay = new GamePlay();
        frame.setBounds(300,80,700,600);
        //frame.setTitle("BrickBreaker");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gameplay);
    }

}