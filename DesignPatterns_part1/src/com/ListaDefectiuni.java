package com;

import com.Command.IComandaReparatie;
import com.specialisti.AHandler;

import java.util.ArrayList;
import java.util.List;

public class ListaDefectiuni {
    private Masina masina;
    private List<IComandaReparatie> reparatiiNecesare;
    private AHandler primEvaluator;

    public ListaDefectiuni(Masina masina, AHandler evaluator) {
        this.masina = masina;
        this.reparatiiNecesare = new ArrayList<>();
        this.primEvaluator = evaluator;
    }
//
//    public void adaugareDefectiune(Defectiune defectiune) {
//        this.listaDefectiuni.add(defectiune);
//    }

    public void efectueazaReparatii() {
        for (IComandaReparatie comanda : this.reparatiiNecesare) {
            comanda.efectueazaReparatii();
        }
    }

    public void generareRaport() {
        if (this.reparatiiNecesare != null) {
            for (IComandaReparatie reparatie : this.reparatiiNecesare) {
                System.out.println(reparatie.toString());
            }
        }
    }

    public void efectueazaVerificare() {
        this.reparatiiNecesare = primEvaluator.verificare(masina);
    }

    public double getCostTotal() {
        double cost = 0;
        for (IComandaReparatie reparatie : this.reparatiiNecesare) {
            cost += reparatie.getCost();
        }
        return cost;
    }

}
