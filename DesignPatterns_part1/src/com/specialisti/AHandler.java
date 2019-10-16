package com.specialisti;

import com.Defectiune;
import com.Command.IComandaReparatie;
import com.Masina;

import java.util.List;

/**
 * Created by Madalina on 27.04.2017.
 */
public abstract class AHandler {
    protected AHandler succesor;

    public void setSuccesor(AHandler succesor){this.succesor=succesor;}

    public abstract List<IComandaReparatie> verificare(Masina masina);
    public abstract void reparare(Defectiune defectiune);

}
