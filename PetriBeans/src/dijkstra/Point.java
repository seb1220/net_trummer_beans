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
        g.drawOval(getX() - radius / 2, getY() - radius / 2, radius, radius);
    }

    @Override
    boolean isInNode(Node n) {
        return false;
    }

}
