package com.Decorator;

import com.APachetTunning;
import com.Decorator.DecoratorPachetTunning;

public class DecoratorTunningMotor extends DecoratorPachetTunning {

    public DecoratorTunningMotor(APachetTunning pachetTunning) {
        super(pachetTunning);
    }

    @Override
    public String obtineOptiuni() {
        return super.obtineOptiuni() + ", reglaje superioare motor";
    }
}
