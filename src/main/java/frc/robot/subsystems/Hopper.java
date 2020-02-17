package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Hopper extends Subsystem {

    public TalonSRX washingMachine = new TalonSRX(52);

    public void runWashingMachineShoot(){
        washingMachine.set(ControlMode.PercentOutput, 0.45);
    }

    public void runWashingMachineStore(){
        washingMachine.set(ControlMode.PercentOutput, -0.45);
    }

    public void stopWashingMachine(){
        washingMachine.set(ControlMode.PercentOutput, 0);
        System.out.println("Stop washing machine");
    }

    @Override
    protected void initDefaultCommand() {

    }
}
