/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawdemofrm;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Verena
 */
public class FigureManagment {
    private ArrayList<Figure> figs;

    public FigureManagment()
    {
        figs = new ArrayList<Figure>();
    }
    public void add(Figure fig)
    {
        figs.add(fig);
    }
    public void paint(Graphics g)
    {
        for (int i = 0; i < figs.size(); i++)
            figs.get(i).paint(g);

    }
}
