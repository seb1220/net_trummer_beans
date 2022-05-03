package dijkstra;

import java.awt.*;

public class Point extends Node {
    private int radius;
    public Point(int x, int y, int r) {
        super(x, y);
        setRadius(r);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval(getX() - radius, getY() - radius, radius * 2, radius * 2);
    }

    @Override
    boolean isInNode(int x, int y) {
        return getRadius() * 1.0 > Math.hypot(getX() - x, getY() - y);
    }

}
