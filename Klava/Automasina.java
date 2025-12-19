package Klava;

public class Automasina {
    private String marka;
    private String modelis;
    private Sture sture;
    private Ritenis[] riteņi;
    private Atrumkarba atrumkarba;

    public Automasina(String marka, String modelis, Sture sture, Ritenis[] riteņi, Atrumkarba atrumkarba) {
        this.marka = marka;
        this.modelis = modelis;
        this.sture = sture;
        this.riteņi = riteņi;
        this.atrumkarba = atrumkarba;
    }

    public String getApraksts() {
        StringBuilder apraksts = new StringBuilder();
        apraksts.append(String.format("AUTOMĀŠĪNA\nMarka: %s\nModelis: %s\n\n", marka, modelis));
        apraksts.append(sture.getApraksts()).append("\n\n");
        for (int i = 0; i < riteņi.length; i++) {
            apraksts.append(String.format("Ritenis %d:\n%s\n\n", i + 1, riteņi[i].getApraksts()));
        }
        apraksts.append(String.format("ATRUMKARBA\nVeids: " + atrumkarba.veids + "\n"));
        return apraksts.toString();
    }
}
