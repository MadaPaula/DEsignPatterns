package com;

import com.Decorator.VersiuneTunning;
import com.State.IStareMasina;

import java.util.ArrayList;
import java.util.List;

public class Masina {
    private List<Defectiune> listaDefectiuni;
    private IStareMasina stare;
    private String optiuniTunning;


    public Masina() {
        listaDefectiuni = new ArrayList<>();
    }

    public void adaugaDefectiune(Defectiune def) {
        this.listaDefectiuni.add(def);
    }

    public List<Defectiune> getDefectiuni() {
        return this.listaDefectiuni;
    }

    public boolean areDefectiuniNeverificate() {
        for (Defectiune d : listaDefectiuni) {
            if (!d.esteVerificata()) {
                return true;
            }
        }
        return false;
    }

    public void setStare(IStareMasina stare) {
        this.stare = stare;
    }

    public void verificaStare() {
        if (this.stare != null) {
            this.stare.verificaStare();
        }
    }

    public void setareOptiuni(String optiunuTunning) {
        this.optiuniTunning = optiunuTunning;
    }

    public void restaurareVersiuneTunning(VersiuneTunning versiune) {
        this.optiuniTunning = versiune.getVersiuneOptiuni();
    }

    public String getOptiuniTunning() {
        return this.optiuniTunning;
    }
}
