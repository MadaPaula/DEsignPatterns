package com;

import com.Decorator.DecoratorTunningConsumRedus;
import com.Decorator.VersiuneTunning;
import com.State.StareFinalizata;
import com.State.StareReparatie;
import com.Strategy.IStrategieTunning;
import com.Strategy.StrategieEstetica;
import com.Strategy.StrategiePerformanta;
import com.specialisti.AHandler;
import com.specialisti.Electrician;
import com.specialisti.Mecanic;
import com.specialisti.Tinichigiu;

public class Main {
    public static void main(String[] args) {
        AHandler mecanic = new Mecanic();
        AHandler tinichigiu = new Tinichigiu();
        AHandler electrician = new Electrician();

        mecanic.setSuccesor(tinichigiu);
        tinichigiu.setSuccesor(electrician);

        Masina masina = new Masina();
        masina.adaugaDefectiune(new Defectiune(EDefectiune.ELECTRICA, "Instalatie electrica arsa"));
        masina.adaugaDefectiune(new Defectiune(EDefectiune.MECANICA, "Transmisie defecta"));
        masina.adaugaDefectiune(new Defectiune(EDefectiune.TINICHIGERIE, "Portiera lovita"));
        masina.adaugaDefectiune(new Defectiune(EDefectiune.ELECTRICA, "Far dreapta ars"));
        masina.adaugaDefectiune(new Defectiune(EDefectiune.MECANICA, "Scurgeri ulei"));

        ListaDefectiuni listaDefectiuni = new ListaDefectiuni(masina, mecanic);

        listaDefectiuni.efectueazaVerificare();
        listaDefectiuni.generareRaport();

        masina.setStare(new StareReparatie());

        masina.verificaStare();

        masina.setStare(new StareFinalizata(listaDefectiuni));
        masina.verificaStare();


        IStrategieTunning strategiePerformanta = new StrategiePerformanta();
        IStrategieTunning strategieEstetica = new StrategieEstetica();

        APachetTunning pachetTunning = strategiePerformanta.getPachetTunning();
        APachetTunning pachetEstetica = strategieEstetica.getPachetTunning();

        APachetTunning pachetCustom = new DecoratorTunningConsumRedus(pachetEstetica);

        ManagerVersiuniTunning managerVersiuniTunning = new ManagerVersiuniTunning();

        managerVersiuniTunning.adaugaVersiune(new VersiuneTunning(pachetTunning.obtineOptiuni()));
        managerVersiuniTunning.adaugaVersiune(new VersiuneTunning(pachetEstetica.obtineOptiuni()));
        managerVersiuniTunning.adaugaVersiune(new VersiuneTunning(pachetCustom.obtineOptiuni()));
        System.out.println("\nOptiuni salvate in memento:\n");
        managerVersiuniTunning.afisareVersiuni();

        masina.restaurareVersiuneTunning(managerVersiuniTunning.obtineVersiune(1));

        System.out.println("\nOptiuni salvate in memento:\n");
        managerVersiuniTunning.afisareVersiuni();

        System.out.println("\nPe masina sunt instalate optiunile:");
        System.out.println(masina.getOptiuniTunning());
    }
}
