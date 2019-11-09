package stud.task;

import stud.task.drawer.line.BresLine;
import stud.task.drawer.line.DDALine;
import stud.task.drawer.line.LineDrawer;
import stud.task.drawer.line.WuLine;
import stud.task.drawer.pixel.BufferPixelDrawer;
import stud.task.drawer.pixel.PixelDrawer;
import stud.task.node.Text;
import stud.task.table.TTFTableFormatException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawPanel extends JPanel implements MouseMotionListener, KeyListener, MouseWheelListener {

    private LineDrawer ld;
    private Color c = Color.WHITE;
    private Text text;
    private boolean input = false;
    private StringBuilder sb = new StringBuilder();
    private double rstr = 0, rsym = 0, em = 0.02;
    private int mod = 3;
    private boolean closed = false;
    private int cx = 200, cy = 200;

    public DrawPanel() {
        super();
        ld = new BresLine();
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.addMouseWheelListener(this);
        this.repaint();
        File file = ResLoader.getInstance().getFile("ttf/default.ttf");
        try {
            text = new Text(file);
        } catch (IOException | TTFTableFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(
                getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        PixelDrawer pd = new BufferPixelDrawer(bi);
        ld.setPixelDrawer(pd);
        text.draw(cx, cy, ld, sb.toString(), em, rstr, rsym, Color.WHITE);
        g.drawImage(bi, 0, 0, null);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'i') {
            input = true;
            return;
        }
        if (!input) {
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
        } else {
            if (!closed) {
                sb.append(e.getKeyChar());
                repaint();
            } else {
                closed = false;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 8: {
                closed = true;
                sb.deleteCharAt(sb.length() - 1);
                repaint();
                break;
            }
            case 112: {
                closed = true;
                mod = 1;
                break;
            }
            case 113: {
                closed = true;
                mod = 2;
                break;
            }
            case 114: {
                closed = true;
                mod = 3;
                break;
            }
            case 37: {
                cx -= 10;
                repaint();
                break;
            }
            case  38: {
                cy -= 10;
                repaint();
                break;
            }
            case 39: {
                cx += 10;
                repaint();
                break;
            }
            case  40: {
                cy += 10;
                repaint();
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (input) {
            int i;
            if (e.getUnitsToScroll() > 0) {
                i = 1;
            } else {
                i = -1;
            }
            switch (mod) {
                case 1: {
                    rstr = rstr + i*Math.PI/10;
                    break;
                }
                case 2: {
                    rsym = rsym + i*Math.PI/10;
                    break;
                }
                case 3: {
                    em = em + i * 0.01;
                }
            }
            repaint();
        }
    }
}
