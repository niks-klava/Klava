package Klava;

public class Ritenis {
    private String tips;
    private int izmērs;
    
    public Ritenis(String tips, int izmērs, int pozīcija) {
        this.tips = tips;
        this.izmērs = izmērs;
    }
    
    public String getApraksts() {
        return String.format("Ritenis \nTips: "+ tips + "\nIzmērs: " + izmērs);
    }
}
