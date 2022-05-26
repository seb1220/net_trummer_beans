package dijkstra;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Transition extends Node {
    private int width;
    private int height;
    private boolean vertical;

    private ArrayList<Point> pre;
    private ArrayList<Point> suc;

    public Transition(int x, int y, int width, int height, boolean vertical) {
        super(x, y);
        setWidth(width);
        setHeight(height);
        setVertical(vertical);
        pre = new ArrayList<Point>();
        suc = new ArrayList<Point>();
    }

    public int getWidth() {
        if (isVertical())
            return width;
        else
            return height;
    }

    public int getHeight() {
        if (isVertical())
            return height;
        else
            return width;
    }

    public boolean isVertical() {
        return vertical;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    public void addPre(Point p) {
        pre.add(p);
    }

    public void addSuc(Point p) {
        suc.add(p);
    }

    public void fire() {
        boolean ready = true;
        for (Point n : pre)
            ready = n.getTokens() >= 1;

        if (!ready)
            return;

        for (Point n : pre)
            n.rmToken();

        for (Point n : suc)
            n.addToken();
    }

    @Override
    void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(getX() - getWidth() / 2, getY() - getHeight() / 2, getWidth(), getHeight());

        for (Point n : pre)
            g.drawLine(getX(), getY(), n.getX(), n.getY());

        for (Point n : suc)
            g.drawLine(getX(), getY(), n.getX(), n.getY());
    }

    @Override
    boolean isInNode(int x, int y) {
        return x > getX() - getWidth() / 2 && x < getX() + getWidth() / 2 && y > getY() - getHeight() / 2 && y < getY() + getHeight() / 2;
    }
}
