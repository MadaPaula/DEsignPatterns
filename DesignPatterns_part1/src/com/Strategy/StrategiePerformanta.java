package com.Strategy;

import com.APachetTunning;
import com.Decorator.DecoratorPachetTunning;
import com.Decorator.DecoratorTunningMotor;
import com.Decorator.DecoratorTunningTransmisie;
import com.PachetTunnigDeBaza;
import com.Strategy.IStrategieTunning;

public class StrategiePerformanta implements IStrategieTunning {
    @Override
    public APachetTunning getPachetTunning() {
        APachetTunning aPachetTunning = new PachetTunnigDeBaza();
        DecoratorPachetTunning decorator = new DecoratorPachetTunning(aPachetTunning);
        DecoratorPachetTunning motor = new DecoratorTunningMotor(decorator);
        DecoratorPachetTunning transmisie = new DecoratorTunningTransmisie(motor);

        return transmisie;
    }
}
