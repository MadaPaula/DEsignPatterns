package com.Decorator;

import com.APachetTunning;

public class DecoratorPachetTunning extends APachetTunning {
    protected APachetTunning pachetTunning;

    public DecoratorPachetTunning(APachetTunning pachetTunning) {
        this.pachetTunning = pachetTunning;
    }

    @Override
    public String obtineOptiuni() {
        return pachetTunning.obtineOptiuni();
    }
}
