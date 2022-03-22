/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geocalc;

/**
 *
 * @author sebastian kawicher
 */
public abstract class Geo2D extends Geo {
    private Punkt p1;
    private Punkt p2;
    
    protected Geo2D(String desc, Punkt p1, Punkt p2) {
        super(desc);
        this.p1 = p1;
        this.p2 = p2;
    }

    public Punkt getP1() {
        return p1;
    }

    public Punkt getP2() {
        return p2;
    }
    
    public abstract int getUmfang();
    public abstract int getFlaeche();
}