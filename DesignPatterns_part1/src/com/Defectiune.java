package com;

public class Defectiune {
    private EDefectiune tipDefectiune;
    private boolean reparat;
    private boolean verificat;
    private String descriere;

    public Defectiune(EDefectiune tipDefectiune, String descriere) {
        this.tipDefectiune = tipDefectiune;
        this.reparat = false;
        this.verificat = false;
        this.descriere = descriere;
    }

    public EDefectiune getTip() {
        return this.tipDefectiune;
    }

    public void efectueazaReparatii() {
        this.reparat = true;
    }

    public void verifica() {
        this.verificat = true;
    }

    public boolean esteVerificata() {
        return this.verificat;
    }
}
