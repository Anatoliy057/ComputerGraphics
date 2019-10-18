package stud.task.drawer.ellipse;

import java.awt.*;

public abstract class BresEllipse extends AbstarctEllipseDrawer {

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
        while (ny  <= b+1 && nx <= 1){
            int cx = x + nx - 1;
            int cy = y + ny - 1;
            mirror(cx, cy, x - cx, y - cy, c);
            if (e1 < 0) {
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

    protected abstract void mirror(int x, int y, int dx, int dy, Color c);
}
