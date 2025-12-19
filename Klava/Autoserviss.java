package Klava;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Autoserviss {
    private ArrayList<Automasina> automasinas;
    
    public Autoserviss() {
        this.automasinas = new ArrayList<>();
    }
    
    public void pievienotAuto() {
        try {
            // Ievadām automašīnas pamatdatus
            String marka = JOptionPane.showInputDialog(null, "Ievadiet automašīnas marku:");
            if (marka == null || marka.trim().isEmpty()) return;
            
            String modelis = JOptionPane.showInputDialog(null, "Ievadiet automašīnas modeli:");
            if (modelis == null || modelis.trim().isEmpty()) return;
            
            // Izveidojam stūri
            String stureTips = JOptionPane.showInputDialog(null, "Ievadiet stūres tipu:");
            if (stureTips == null || stureTips.trim().isEmpty()) return;
            Sture sture = new Sture(stureTips);
            
            // Izveidojam riteņus
            Ritenis[] riteni = new Ritenis[4];
            for (int i = 0; i < 4; i++) {
                String ritenaTips = JOptionPane.showInputDialog(null, 
                    "Ievadiet " + (i + 1) + ". riteņa tipu:");
                if (ritenaTips == null || ritenaTips.trim().isEmpty()) return;
                
                String izmersStr = JOptionPane.showInputDialog(null, 
                    "Ievadiet " + (i + 1) + ". riteņa izmēru (collas):");
                if (izmersStr == null || izmersStr.trim().isEmpty()) return;
                int izmers = Integer.parseInt(izmersStr);
                
                riteni[i] = new Ritenis(ritenaTips, izmers, i + 1);
            }
            
            // Izveidojam ātrumkārbu
            String[] atrumkarbasVeidi = {"Manuāla", "Automātiska", "Robotizēta"};
            String atrumkarbasVeids = (String) JOptionPane.showInputDialog(null,
                "Izvēlieties ātrumkārbas veidu:",
                "Ātrumkārba",
                JOptionPane.QUESTION_MESSAGE,
                null,
                atrumkarbasVeidi,
                atrumkarbasVeidi[0]);
            if (atrumkarbasVeids == null) return;
            Atrumkarba atrumkarba = new Atrumkarba(atrumkarbasVeids);
            
            // Izveidojam automašīnu
            Automasina jauna = new Automasina(marka, modelis, sture, riteni, atrumkarba);
            automasinas.add(jauna);
            
            JOptionPane.showMessageDialog(null, 
                "Automašīna veiksmīgi pievienota!\nKopā autoserviss: " + automasinas.size());
                
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, 
                "Kļūda! Ievadiet pareizu skaitli!", 
                "Ievades kļūda", 
                JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                "Notikusi kļūda: " + e.getMessage(), 
                "Kļūda", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public void apskatitVisasAutomasinas() {
        if (automasinas.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                "Autoservisā nav nevienas automašīnas!", 
                "Nav datu", 
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        StringBuilder viss = new StringBuilder();
        viss.append("AUTOSERVISĀ ESOŠĀS AUTOMAŠĪNAS:\n");
        viss.append("Kopā: " + automasinas.size() + "\n\n");
        viss.append("=".repeat(40) + "\n\n");
        
        for (int i = 0; i < automasinas.size(); i++) {
            viss.append("Nr. " + (i + 1) + "\n");
            viss.append(automasinas.get(i).getApraksts());
            viss.append("=".repeat(40) + "\n\n");
        }
        
        JOptionPane.showMessageDialog(null, 
            viss.toString(), 
            "Visas automašīnas", 
            JOptionPane.INFORMATION_MESSAGE);
    }

    public void dzestAutomasinu() {
        if (automasinas.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                "Autoservisā nav nevienas automašīnas!", 
                "Nav datu", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Izveidojam sarakstu izvēlei
        String[] opcijas = new String[automasinas.size()];
        for (int i = 0; i < automasinas.size(); i++) {
            opcijas[i] = (i + 1) + ". " + automasinas.get(i).getApraksts().split("\n")[1];
        }
        
        String izvelne = (String) JOptionPane.showInputDialog(null,
            "Izvēlieties automašīnu dzēšanai:",
            "Dzēst automašīnu",
            JOptionPane.QUESTION_MESSAGE,
            null,
            opcijas,
            opcijas[0]);
            
        if (izvelne != null) {
            int indekss = Integer.parseInt(izvelne.split("\\.")[0]) - 1;
            
            int apstiprinajums = JOptionPane.showConfirmDialog(null,
                "Vai tiešām vēlaties dzēst šo automašīnu?\n\n" + 
                automasinas.get(indekss).getApraksts(),
                "Apstiprināt dzēšanu",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
                
            if (apstiprinajums == JOptionPane.YES_OPTION) {
                automasinas.remove(indekss);
                JOptionPane.showMessageDialog(null, 
                    "Automašīna veiksmīgi izdzēsta!\nAtlikušās: " + automasinas.size());
            }
        }
    }
    
    public static void main(String[] args) {
        
    }
}
