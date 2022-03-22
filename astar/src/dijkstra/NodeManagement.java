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
    private int counter = 0; // 64

    public NodeManagement() {
        nodes = new ArrayList<Node>();
    }
    
    public void add (int x, int y) {
        //String desc = "A";
        if (!isNearNode(x, y))
            nodes.add(new Node(x, y, /*((char)++counter) + ""*/++counter + ""));
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
        nodes.forEach(n -> n.paintLines(g));
        nodes.forEach(n -> n.paint(g));
    }
    
    public void findPath(Node start, Node end) { // nix worky, no more
        clearEnt();
        
        start.setActive(true);
        start.setPredecessor(null);
        start.setHop(0);

        nodes.forEach(n -> n.setTarget(end));
        
        Node nextup = start;
        
        while (!end.isActive()) {
            //nodes.forEach(n -> System.out.println(n.getDesc() + " " + n.getHop()));
            nextup = findLowestHop();
            if (nextup == null) {
                System.out.println("No possible route found");
                return;
            }
            //System.out.println(nextup.getDesc());
            nextup.getSuccessorsDone();

        }
        String path = "";
        Node pre = end.getPredecessor();
        Node oldPre = end;
        oldPre.setPath(null, pre);
        path += oldPre.getDesc() + " ";
        while (pre != null) {
            path += pre.getDesc() + " ";
            pre.setPath(oldPre, pre.getPredecessor());
            //System.out.println(pre.getDesc());
            oldPre = pre;
            pre = pre.getPredecessor();
        }
        String[] ent = path.split(" ");
        int i = ent.length - 1;
        while (i >= 0) {
            System.out.println(ent[i]);
            i--;
        }
        System.out.println("------");
    }
    
    private Node findLowestHop() {
        return nodes.stream()
            .filter(n -> n.isActive())
            .min(Comparator.comparing(Node::getHop))
            .orElse(null);
    }
    
    public void clearEnt() {
        nodes.forEach(n -> {
            n.setPredecessor(null);
            n.setActive(false);
            n.setHop(Integer.MAX_VALUE);
            n.setPath(null);
            n.setTarget(null);
        });
    }
    
    public ArrayList<Node> getSelectedNodes() {
        ArrayList<Node> sel = new ArrayList<Node>();
        nodes.stream().filter(n -> (n.isSelected())).forEachOrdered(n -> {
            sel.add(n);
        });
        return sel;
    }
}
