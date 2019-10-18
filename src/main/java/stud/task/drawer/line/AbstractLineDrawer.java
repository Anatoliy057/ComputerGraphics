package stud.task.drawer.line;

import stud.task.drawer.pixel.PixelDrawer;

public abstract class AbstractLineDrawer implements LineDrawer {

    protected PixelDrawer pd;

    @Override
    public void setPixelDrawer(PixelDrawer pd) {
        this.pd = pd;
    }
}
