package com.Command;

import com.Defectiune;
import com.specialisti.AHandler;

public class ComandaReparatieTinichigiu implements IComandaReparatie {
    private double cost;
    private Defectiune defectiune;

    private AHandler specialist;

    public ComandaReparatieTinichigiu(double cost, Defectiune defectiune, AHandler specialist) {
        this.cost = cost;
        this.defectiune = defectiune;
        this.specialist = specialist;
    }

    @Override
    public double getCost() {
        return this.cost;
    }

    @Override
    public void efectueazaReparatii() {
        this.specialist.reparare(defectiune);
    }

    @Override
    public String toString() {
        return "Tip reparatie: Tinichigerie, Cost: " + cost;
    }
}
