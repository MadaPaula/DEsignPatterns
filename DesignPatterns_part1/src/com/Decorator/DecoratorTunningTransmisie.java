package com.Decorator;

import com.APachetTunning;
import com.Decorator.DecoratorPachetTunning;

public class DecoratorTunningTransmisie extends DecoratorPachetTunning {

    public DecoratorTunningTransmisie(APachetTunning pachetTunning) {
        super(pachetTunning);
    }

    @Override
    public String obtineOptiuni() {
        return super.obtineOptiuni() + ", transmisie de tip racing";
    }
}
