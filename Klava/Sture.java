package Klava;

public class Sture {
    String tips;
    
    public Sture(String tips) {
        this.tips = tips;
    }
    
    public void pagriezt(String virziens) {
        System.out.println("Stūre pagriezta " + virziens);
    }
    
    public String getApraksts() {
        return String.format("STŪRE\nTips: " + tips);
    }
}
