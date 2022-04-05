/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dijkstra;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author sebas
 */
public class Node implements Serializable {
    public static final int RADIUS = 20;
    
    private int x;
    private int y;
    private String desc;
    
    private ArrayList<Line> lines;
    
    private int hop;
    private Node predecessor;
    private boolean active;
    private Node[] path;
    private Node target;

    private boolean weiss;
    
    private boolean selected;

    public Node(int x, int y, String desc, boolean weiss) {
        setX(x);
        setY(y);
        setDesc(desc);
        lines = new ArrayList<Line>();
        setHop(Integer.MAX_VALUE);
        setActive(false);
        setSelected(false);
        setPath(null);
        setWeiss(weiss);
        setHop(1000000);
    }

    public void setWeiss(boolean weiss) {
        this.weiss = weiss;
    }

    public boolean isWeiss() {
        return weiss;
    }

    public void setTarget(Node target) {
        this.target = target;
    }

    public Node getTarget() {
        return target;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Node[] getPath() {
        return path;
    }
    
    public boolean isSelected() {
        return selected;
    }

    public String getDesc() {
        return desc;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPath(Node path1, Node path2) {
        this.path = new Node[]{path1, path2};
    }
    
    public void setPath(Node[] path) {
        this.path = path;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setHop(int hop) {
        this.hop = hop;
    }

    public void setPredecessor(Node predecessor) {
        this.predecessor = predecessor;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getHop() {
        return getNoDistance() + (Math.sqrt(((getX() - getTarget().getX()) * (getX() - getTarget().getX())) + ((getY() - getTarget().getY()) * (getY() - getTarget().getY())))) * 0.04;
    }

    public int getNoDistance() {
        return hop;
    }

    public Node getPredecessor() {
        return predecessor;
    }

    public boolean isActive() {
        return active;
    }
    
    public void paint(Graphics g) {
        if (!isWeiss()) {
            g.setColor(Color.WHITE);
            g.fillOval(x-RADIUS, y-RADIUS, RADIUS*2, RADIUS*2);
        } else {
            g.setColor(new Color(214, 217, 223));
            g.fillOval(x-RADIUS/2, y-RADIUS/2, RADIUS*1, RADIUS*1);
        }

        g.setColor(Color.BLACK);
        if (getPath() != null)
            g.setColor(Color.GREEN);
        if (isSelected())
            g.setColor(Color.RED);
        if (!isWeiss())
            g.drawOval(x-RADIUS, y-RADIUS, RADIUS*2, RADIUS*2);
        g.setColor(Color.BLACK);
        int width = g.getFontMetrics().stringWidth(getDesc());
        int height = g.getFontMetrics().getAscent() / 2;
        g.drawString(getDesc(), getX() - width/2, (int) (getY() + (int)height / 1.5));
    }
    
    public void paintLines (Graphics g) {
        // nb.forEach(n -> g.drawLine(x, y, n.getX(), n.getY()));
        for (Line l : lines) {
            Node n = l.getNb()[1];
            g.setColor(Color.BLACK);
            if (getPath() != null && ((getPath()[0] != null && n == getPath()[0]) || (getPath()[1] != null && n == getPath()[1])))
                g.setColor(Color.GREEN);
            g.drawLine(x, y, n.getX(), n.getY());
        }
    }
    
    public void addNb (Line l) {
        lines.add(l);
    }
    
    public void move (int dx, int dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
    
    public boolean isInNode(int x, int y) {
        return (Math.hypot(this.x - x, this.y - y) < RADIUS);
    }
    
    public boolean isNearNode(int x, int y) {
        return (Math.hypot(this.x - x, this.y - y) < RADIUS * 2.86);
    }
    
    public Node findNextSuccessor() {
        Line succer = lines.stream()
                .filter(n -> (!n.getNb()[1].isActive() || (n.getNb()[1].getHop() > getHop())))
                .findFirst()
                .orElse(null);
        
        if (succer == null)
            setActive(false);
        
        return succer.getNb()[1];
    }
    
    public boolean getSuccessorsDone() {
        boolean any = false;
        for (Line n : lines) {
            if (n.getNb()[1].getNoDistance() > getNoDistance()) {
                n.getNb()[1].setActive(true);
                n.getNb()[1].setPredecessor(this);
                n.getNb()[1].setHop((int) (getNoDistance() + n.getWeight()));
                any = true;
            }
        }
        setActive(false);
        return any;
    }

    public ArrayList<Node> getSuccessors() {
        ArrayList<Node> nbs = new ArrayList<Node>();
        for (Line n : lines) {
            nbs.add(n.getNb()[1]);
        }
        return nbs;
    }

    public int getWeightBetween(Node m) {
        for (Line n : lines) {
            if (n.getNb()[1] == m) {
                return n.getWeight();
            }
        }
        return 0;
    }
}
