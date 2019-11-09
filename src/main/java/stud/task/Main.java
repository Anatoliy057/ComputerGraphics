package stud.task;


import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(1500, 1000);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DrawPanel dp = new DrawPanel();
        jFrame.add(dp);
        jFrame.addKeyListener(dp);
        jFrame.setVisible(true);
    }
}
