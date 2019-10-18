package stud.task.drawer.ellipse;

import stud.task.drawer.pixel.PixelDrawer;

import java.awt.*;

public abstract class WuEllipse extends AbstarctEllipseDrawer {

    public WuEllipse() {
    }

    public WuEllipse(PixelDrawer pd) {
        setPixelDrawer(pd);
    }

    @Override
    public void draw(int x, int y, int a, int b, Color c) {
        double sqA = a * a;
        double sqB = b * b;

        double e1;
        double e2;
        int ny = 1;
        int nx = 1-a;



        e1 = sqB * (0.25 - a) + sqA;
        e2 = sqB * (1 - 2*a) + sqA * 0.25;

        fourQuartersPixel(x + nx - 1, y + ny - 1, nx - 1, ny - 1, c);

        while (ny  <= b+1 && nx <= 1){
            int cx = x + nx - 1;
            int cy = y + ny - 1;
            if (e1 < 0) {
                fourQuartersPixel(cx, cy, x - cx, cy - y, c);
                e1 += sqA * (ny * 2 + 1);
                e2 += sqA * ((ny - 0.5) * 2 + 1);
                ny++;
            } else if (e2 > 0) {
                e1 += sqB * (2 * (nx - 0.5) + 1);
                e2 += sqB * (2 * nx + 1);
                nx++;
            } else {
                e1 += sqA * (ny * 2 + 1) + sqB * (2 * (nx - 0.5) + 1);
                e2 += sqB * (2 * nx + 1) + sqA * ((ny - 0.5) * 2 + 1);
                nx++;
                ny++;
            }
        }
    }

    private void fourQuartersPixel(int x, int y, int dx, int dy, Color c) {
        dx *= 2;
        dy *= 2;
        pd.pixel(x, y, c);
        pd.pixel(x+dx, y, c);
        pd.pixel(x, y-dy, c);
        pd.pixel(x+dx, y-dy, c);
    }

    private double convert(double e, double d) {
        e = Math.abs(e);
        if (e >= d) {
            return 0;
        }
        return (d-e)/d;
    }
}
