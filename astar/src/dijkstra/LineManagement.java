package dijkstra;

import java.awt.*;
import java.util.ArrayList;

public class LineManagement {
    private ArrayList<Line> lines;

    LineManagement() {
        lines = new ArrayList<>();
    }

    public void add (Line weiss) {
        lines.add(weiss);
    }

    public ArrayList<Line> isInLine(int x, int y) {
        ArrayList<Line> tmp = new ArrayList<>();
        for (Line l : lines) {
            if (l.getHitbox().isInNode(x, y))
                tmp.add(l);
        }
        if (tmp.get(0) != null)
            return tmp;
        return null;
        /*
        return lines.stream()
                .filter(n -> n.getHitbox().isInNode(x, y))
                .findAny()
                .orElse(null);
        //.get();*/
    }

    public void rePos() {
        lines.forEach(l -> l.rePosition());
    }

    public void paint(Graphics g) {
        lines.forEach(n -> n.getHitbox().paint(g));
    }
}
