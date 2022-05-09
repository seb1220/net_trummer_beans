package dijkstra;

import java.awt.*;
import java.io.Serializable;

import static java.lang.Math.max;

public class Point extends Node {
    private int radius;
    private int tokens;
    public Point(int x, int y, int r, int tokens) {
        super(x, y);
        setRadius(r);
        setTokens(tokens);
    }

    public int getRadius() {
        return radius;
    }

    public int getTokens() {
        return tokens;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public void addToken() {
        setTokens(getTokens() + 1);
    }

    public void rmToken() {
        setTokens(max(0, getTokens() - 1));
    }
    @Override
    void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(getX() - radius, getY() - radius, radius * 2, radius * 2);
        g.setColor(Color.BLACK);
        g.drawOval(getX() - radius, getY() - radius, radius * 2, radius * 2);
        int width = g.getFontMetrics().stringWidth(getTokens() + "");
        int height = g.getFontMetrics().getAscent() / 2;
        g.drawString(getTokens() + "", getX() - width/2, (int) (getY() + (int)height / 1.5));
    }

    @Override
    boolean isInNode(int x, int y) {
        return getRadius() * 1.0 > Math.hypot(getX() - x, getY() - y);
    }

}
