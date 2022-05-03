package dijkstra;

import java.awt.*;

public class Transition extends Node {
    private int width;
    private int height;
    private boolean vertical;
    public Transition(int x, int y, int width, int height, boolean vertical) {
        super(x, y);
        setWidth(width);
        setHeight(height);
        setVertical(vertical);
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

    @Override
    void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(getX() - getWidth() / 2, getY() - getHeight() / 2, getWidth(), getHeight());
    }

    @Override
    boolean isInNode(int x, int y) {
        System.out.println("ajjaaj " + (x > getX() - getWidth() / 2 && x < getX() + getWidth() / 2));
        return x > getX() - getWidth() / 2 && x < getX() + getWidth() / 2 && y > getY() - getHeight() / 2 && y < getY() + getHeight() / 2;
    }
}
