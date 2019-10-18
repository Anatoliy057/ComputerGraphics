package stud.task.drawer.pixel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BufferPixelDrawer implements PixelDrawer {

    private BufferedImage bi;

    public BufferPixelDrawer(BufferedImage bi) {
        this.bi = bi;
    }

    @Override
    public void pixel(int x, int y, Color c) {
        bi.setRGB(x, y, c.getRGB());
    }

    @Override
    public int getRGB(int x, int y) {
        return bi.getRGB(x, y);
    }
}
