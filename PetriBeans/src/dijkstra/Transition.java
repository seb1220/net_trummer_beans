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
        return width;
    }

    public int getHeight() {
        return height;
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
        if (vertical)
            g.fillRect(getX() - width / 2, getY() - height / 2, width, height);
        else
            g.fillRect(getX() - height / 2, getY() - width / 2, height, width);
    }

    @Override
    boolean isInNode(Node n) {
        return false;
    }
}
