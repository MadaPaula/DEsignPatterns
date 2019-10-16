package com.specialisti;

import com.*;
import com.Command.ComandaReparatieMecanica;
import com.Command.IComandaReparatie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Madalina on 27.04.2017.
 */
public class Mecanic extends AHandler{
    @Override
    public List<IComandaReparatie> verificare(Masina masina) {
        List<IComandaReparatie> comenzi = new ArrayList<>();
        for(Defectiune defectiune : masina.getDefectiuni()) {
            if(defectiune.getTip() == EDefectiune.MECANICA) {
                defectiune.verifica();
                IComandaReparatie reparatie = new ComandaReparatieMecanica(50,defectiune,this);
                comenzi.add(reparatie);
            }
        }
        if(succesor != null && masina.areDefectiuniNeverificate()) {
            comenzi.addAll(succesor.verificare(masina));
        }
        return comenzi;
    }

    @Override
    public void reparare(Defectiune defectiune) {
        defectiune.efectueazaReparatii();
    }
}
