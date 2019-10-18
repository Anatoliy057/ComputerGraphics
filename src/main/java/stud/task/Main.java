package stud.task;

import javax.swing.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        JFrame jFrame = new JFrame();
        jFrame.setSize(500, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DrawPanel dp = new DrawPanel();
        jFrame.add(dp);
        jFrame.addKeyListener(dp);
        jFrame.setVisible(true);
    }
}
