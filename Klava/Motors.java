package Klava;

public class Motors {
    double tilpums;
    int jauda;
    String tips;
    
    public Motors(double tilpums, int jauda, String tips) {
        this.tilpums = tilpums;
        this.jauda = jauda;
        this.tips = tips;
    }
    
    public void startet() {
        System.out.println("Motors startēts!");
    }
    
    public String getApraksts() {
        return String.format("MOTORS\nTilpums: " + tilpums + "\nJauda: " + jauda + "\nTips: " + tips);
    }
}
