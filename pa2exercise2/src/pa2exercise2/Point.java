package pa2exercise2;

import java.awt.*;
import java.io.Serializable;

public class Point implements Serializable {
    public static final int RADIUS = 10;
    private int x, y;

    Point(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void set(int x, int y) {
        setX(x);
        setY(y);
    }

    public void move(int dx, int dy) {
        set(getX() + dx, getY() + dy);
    }

    public void paint(Graphics g) {
        g.setColor(new Color(245, 245, 245));
        g.fillOval(getX() - RADIUS, getY() - RADIUS, RADIUS * 2, RADIUS * 2);
        g.setColor(Color.black);
        g.drawOval(getX() - RADIUS, getY() - RADIUS, RADIUS * 2, RADIUS * 2);
    }

    public boolean isInPoint(int x, int y) {
        return (int) Math.round(Math.sqrt((x - getX()) * (x - getX()) + (y - getY()) * (y - getY()))) < RADIUS;
    }
}
