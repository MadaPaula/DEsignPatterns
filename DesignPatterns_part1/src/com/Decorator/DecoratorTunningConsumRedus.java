package com.Decorator;

import com.APachetTunning;
import com.Decorator.DecoratorPachetTunning;

public class DecoratorTunningConsumRedus extends DecoratorPachetTunning {
    public DecoratorTunningConsumRedus(APachetTunning pachetTunning) {
        super(pachetTunning);
    }

    @Override
    public String obtineOptiuni() {
        return super.obtineOptiuni() + ", setare motor pentru consum redus";
    }
}
