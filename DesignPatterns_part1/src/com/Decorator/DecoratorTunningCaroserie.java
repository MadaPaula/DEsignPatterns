package com.Decorator;

import com.APachetTunning;
import com.Decorator.DecoratorPachetTunning;

public class DecoratorTunningCaroserie extends DecoratorPachetTunning {
    public DecoratorTunningCaroserie(APachetTunning pachetTunning) {
        super(pachetTunning);
    }

    @Override
    public String obtineOptiuni() {
        return super.obtineOptiuni() + ", face-lift caroserie";
    }
}
