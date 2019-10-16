package com.Decorator;

import com.APachetTunning;
import com.Decorator.DecoratorPachetTunning;

public class DecoratorTunningAerodinamic extends DecoratorPachetTunning {
    public DecoratorTunningAerodinamic(APachetTunning pachetTunning) {
        super(pachetTunning);
    }

    @Override
    public String obtineOptiuni() {
        return super.obtineOptiuni() + ", caroserie cu profil aerodinamic";
    }
}
