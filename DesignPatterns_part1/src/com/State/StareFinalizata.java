package com.State;

import com.ListaDefectiuni;
import com.State.IStareMasina;

public class StareFinalizata implements IStareMasina {
    private ListaDefectiuni listaDefectiuniReparate;

    public StareFinalizata(ListaDefectiuni listaDefectiuniReparate) {
        this.listaDefectiuniReparate = listaDefectiuniReparate;
    }

    @Override
    public void verificaStare() {
        System.out.println("Reparatia a fost finalizata cu succes. Costul total al reparatie a fost de " + listaDefectiuniReparate.getCostTotal() + " lei.\nReparatiile efectuate au fost:\n");
        listaDefectiuniReparate.generareRaport();
    }
}
