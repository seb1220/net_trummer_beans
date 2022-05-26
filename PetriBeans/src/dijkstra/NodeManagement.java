/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dijkstra;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author sebas
 */
public class NodeManagement implements Serializable {
    private ArrayList<Node> nodes;
    public static final int RADIUS = 20;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 40;
    public static int selectedItem = 0;

    public NodeManagement() {
        nodes = new ArrayList<Node>();
    }
    
    public void add (int x, int y) {
        if (!isNearNode(x, y))
            switch (selectedItem) {
                case 0:
                    nodes.add(new Point(x, y, RADIUS, 0));
                    break;
                case 1:
                    nodes.add(new Transition(x, y, WIDTH, HEIGHT, true));
                    break;
                case 2:
                    nodes.add(new Transition(x, y, WIDTH, HEIGHT, false));
                    break;
            }
    }
    
    public boolean isNearNode(int x, int y) {
        return nodes.stream().anyMatch(n -> n.isNearNode(x, y) );
    }

    public Node isInNode(int x, int y) {
        return nodes.stream()
                .filter(n -> n.isInNode(x, y))
                .findFirst()
                .orElse(null);
                //.get();
    }
    
    public void paint(Graphics g) {
        nodes.stream().filter(n -> n.getClass() == Transition.class)
                .forEach(n -> n.paint(g));
        nodes.stream().filter(n -> n.getClass() == Point.class)
                .forEach(n -> n.paint(g));
    }
}
