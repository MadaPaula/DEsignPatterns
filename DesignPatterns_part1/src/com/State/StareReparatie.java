package com.State;

import com.State.IStareMasina;

public class StareReparatie implements IStareMasina {

    @Override
    public void verificaStare() {
        System.out.println("Masina se afla in curs de reparatie. Se estimeaza ca va fi gata intre una si trei zile lucratoare.");
    }
}
