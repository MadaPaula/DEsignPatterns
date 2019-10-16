package com;

import com.Decorator.VersiuneTunning;

import java.util.ArrayList;
import java.util.List;

public class ManagerVersiuniTunning {
    private List<VersiuneTunning> versiuniTunning;

    public ManagerVersiuniTunning() {
        this.versiuniTunning = new ArrayList<>();
    }

    public void adaugaVersiune(VersiuneTunning versiuneTunning) {
        this.versiuniTunning.add(versiuneTunning);
    }

    public VersiuneTunning obtineVersiune(int pozitie) {
        if (pozitie > -1 && pozitie < this.versiuniTunning.size()) {
            VersiuneTunning vers =  this.versiuniTunning.get(pozitie);
            this.versiuniTunning.remove(pozitie);
            return vers;
        }
        return null;
    }

    public void afisareVersiuni() {
        int idx = 1;
        for (VersiuneTunning ver : versiuniTunning) {
            System.out.println(idx + ". " + ver.getVersiuneOptiuni());
            idx++;
        }
    }
}
