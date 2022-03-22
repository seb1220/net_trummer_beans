/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teltar;

/**
 *
 * @author Kawicher.Sebastian
 */
public abstract class Tarif {
    private String bez;
    private String telnr;
    
    protected Tarif(String bez, String telnr) {
        this.bez = bez;
        this.telnr = telnr;
    }
    
    public static Tarif GetTarif(String bez, String telnr, int gebuehren) {
        if (!checkNumber(telnr))
            return null;
        return new Tarif_A(bez, telnr, gebuehren);
    }
    public static Tarif GetTarif(String bez, String telnr, double gebuehren, double conentgelt) {
        if (!checkNumber(telnr))
            return null;
        return new Tarif_B(bez, telnr, gebuehren, conentgelt);
    }

    public String getBez() {
        return bez;
    }

    public String getTelnr() {
        return telnr;
    }

    public void setBez(String bez) {
        this.bez = bez;
    }

    private void setTelnr(String telnr) {
        this.telnr = telnr;
    }
    
    public String GetInfo() {
        return "Tarif: " + getBez() + ", " + getGebuehren() + "/Monat";
    }
    
    public double GetKosten (int x) {
        return getGebuehren();
    }
    
    public int GetBonuspunkte (int x) {
        return x * 2;
    }
    
    public abstract double getGebuehren();
    
    private static boolean checkNumber(String telnr) {
        if (telnr.length() != 10)
            return false;
        int s = 0;
        for (int i = 0; i < telnr.length(); ++i) {
            s += telnr.charAt(i) - '0';
        }
        if (s % 4 != 0) {
            return false;
        }
        return true;
    } 
}
