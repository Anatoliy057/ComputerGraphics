package stud.task.drawer.ellipse;

import stud.task.drawer.pixel.PixelDrawer;

public abstract class AbstarctEllipseDrawer implements EllipseDrawer {

    protected PixelDrawer pd;

    @Override
    public void setPixelDrawer(PixelDrawer pd) {
        this.pd = pd;
    }
}
