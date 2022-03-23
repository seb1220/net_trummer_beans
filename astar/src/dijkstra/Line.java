package dijkstra;

import java.util.ArrayList;

public class Line {
    private int weight;
    private Node[] nb;
    private Node hitbox;

    Line(Node n1, Node n2) {
        nb = new Node[]{n1, n2};
        setHitbox(new Node((int) (n1.getX() + (n2.getX() - n1.getX()) * 0.5),
                (int) (n1.getY() + (n2.getY() - n1.getY()) * 0.5), getWeight() + "", true));
        setWeight(5);
    }

    public void rePosition() {
        hitbox.setX((int) (nb[0].getX() + (nb[1].getX() - nb[0].getX()) * 0.5));
        hitbox.setY((int) (nb[0].getY() + (nb[1].getY() - nb[0].getY()) * 0.5));
    }

    public Node getHitbox() {
        return hitbox;
    }

    public void setHitbox(Node hitbox) {
        this.hitbox = hitbox;
    }

    public Node[] getNb() {
        return nb;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
        getHitbox().setDesc(getWeight() + "");
    }
}
