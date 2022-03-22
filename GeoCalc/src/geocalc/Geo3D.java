/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geocalc;

/**
 *
 * @author sebastian kawicher
 */
public abstract class Geo3D extends Geo {
    private Geo2D figur2D;
    private int hoehe;
    
    protected Geo3D(String desc, Geo2D figur2D, int hoehe) {
        super(desc);
        this.figur2D = figur2D;
        this.hoehe = hoehe;
    }

    public Geo2D getFigur2D() {
        return figur2D;
    }

    public int getHoehe() {
        return hoehe;
    }
    
    public abstract int getUmfang();
    public abstract int getFlaeche();
    public abstract int getOberfläche();
    public abstract int getVolumen();
}




