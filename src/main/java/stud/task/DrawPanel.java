package stud.task;

import stud.task.converter.ScreenPoint;
import stud.task.drawer.ellipse.AcrDrawer;
import stud.task.drawer.ellipse.BresArc;
import stud.task.drawer.line.BresLine;
import stud.task.drawer.line.DDALine;
import stud.task.drawer.line.LineDrawer;
import stud.task.drawer.line.WuLine;
import stud.task.drawer.line.BezierLine;
import stud.task.drawer.pixel.BufferPixelDrawer;
import stud.task.drawer.pixel.PixelDrawer;
import stud.task.node.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener, KeyListener {

    private LineDrawer ld;
    private Color c = Color.WHITE;
    private int cx = 0, cy = 0;

    public DrawPanel() {
        super();
        ld = new BresLine();
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(
                getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        PixelDrawer pd = new BufferPixelDrawer(bi);
        ld.setPixelDrawer(pd);
        Line line = new Line(getWidth() / 2, getHeight() / 2, cx, cy, c, ld);
        line.draw();

        AcrDrawer ed = new BresArc(pd);
        ed.draw(getWidth() / 2, getHeight() / 2, 100, 100, 3 * Math.PI / 4, Math.PI / 4, c);

        BezierLine bezierLine = new BezierLine();
        bezierLine.draw(ld, 50, c,
                new ScreenPoint(0, 0),
                new ScreenPoint(30, 30),
                new ScreenPoint(60, 0),
                new ScreenPoint(200, 0)
        );
        g.drawImage(bi, 0, 0, null);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        cx = e.getX();
        cy = e.getY();
        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'b':
                ld = new BresLine();
                c = Color.BLUE;
                break;
            case 'd':
                ld = new DDALine();
                c = Color.RED;
                break;
            case 'v':
                ld = new WuLine();
                c = Color.GREEN;
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
