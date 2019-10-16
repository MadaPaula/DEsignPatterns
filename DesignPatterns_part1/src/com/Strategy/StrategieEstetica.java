package com.Strategy;

import com.APachetTunning;
import com.Decorator.DecoratorPachetTunning;
import com.Decorator.DecoratorTunningAerodinamic;
import com.Decorator.DecoratorTunningCaroserie;
import com.PachetTunnigDeBaza;

public class StrategieEstetica implements IStrategieTunning {
    @Override
    public APachetTunning getPachetTunning() {
        APachetTunning pachetTunning = new PachetTunnigDeBaza();
        DecoratorPachetTunning caroserie = new DecoratorTunningCaroserie(pachetTunning);
        DecoratorPachetTunning tunningAerodinamic = new DecoratorTunningAerodinamic(caroserie);
        return tunningAerodinamic;
    }
}
