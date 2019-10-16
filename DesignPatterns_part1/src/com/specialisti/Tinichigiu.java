package com.specialisti;

import com.*;
import com.Command.ComandaReparatieTinichigiu;
import com.Command.IComandaReparatie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Madalina on 27.04.2017.
 */
public class Tinichigiu extends AHandler {

    @Override
    public List<IComandaReparatie> verificare(Masina masina) {
        List<IComandaReparatie> comenzi = new ArrayList<>();
        for(Defectiune defectiune :  masina.getDefectiuni()) {
            if(defectiune.getTip() == EDefectiune.TINICHIGERIE) {
                defectiune.verifica();
                IComandaReparatie reparatie = new ComandaReparatieTinichigiu(40,defectiune,this);
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
