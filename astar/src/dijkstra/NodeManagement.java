/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dijkstra;

import java.awt.Graphics;
import java.awt.desktop.ScreenSleepEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author sebas
 */
public class NodeManagement implements Serializable {
    private ArrayList<Node> nodes;

    private ArrayList<Node> open_lst;
    private ArrayList<Node> closed_lst;

    private int counter = 0; // 64

    public NodeManagement() {
        nodes = new ArrayList<Node>();
    }
    
    public void add (int x, int y) {
        //String desc = "A";
        if (!isNearNode(x, y))
            nodes.add(new Node(x, y, /*((char)++counter) + ""*/++counter + "", false));
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
        start.setPredecessor(start);
        start.setHop(0);

        nodes.forEach(n -> n.setTarget(end));

        open_lst = new ArrayList<Node>();
        closed_lst = new ArrayList<Node>();

        open_lst.add(start);

        while (open_lst.size() > 0) {
            Node n = null;
            for (Node v : open_lst)
                if (n == null || v.getHop() < n.getHop())
                    n = v;

            if (n == end || n == null) {
                continue;
            } else {
                for (Node m : n.getSuccessors()) {
                    if (!open_lst.contains(m) && !closed_lst.contains(m)) {
                        open_lst.add(m);
                        m.setPredecessor(n);
                        m.setHop(n.getNoDistance()); // wrong
                    } else {
                        if (m.getNoDistance() > n.getHop()) {
                            // like above wrong thing
                        }
                    }
                }
            }
        }
        /*
        nodes.forEach(n -> n.setTarget(end));
        
        Node nextup;
        boolean activator = true;
        while (end.isActive() || activator) {
            //nodes.forEach(n -> System.out.println(n.getDesc() + " " + n.getHop()));
            nextup = findLowestHop();
            open_lst.add(nextup);
            if (nextup == null) {
                System.out.println("No possible route found");
                return;
            }
            System.out.println("Nextup: " + nextup.getDesc());
            for (Node n : nodes) {
                System.out.println("----");
                System.out.println(n.getDesc());
                System.out.println(n.getNoDistance());
                System.out.println(n.getHop());
                if (n.getPredecessor() != null)
                    System.out.println(n.getPredecessor().getDesc());
                else
                    System.out.println("null");
            }
            System.out.println("---------------");
            nextup.getSuccessorsDone();
            if (end.isActive())
                activator = false;
        }
        */
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
