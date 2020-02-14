package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

    //48 and 49
    TalonSRX intakeLeft = new TalonSRX(48);
    TalonSRX intakeRight = new TalonSRX(49);

    //52
    VictorSPX washingMachine = new VictorSPX(52);

    //2,3 4,5
    DoubleSolenoid leftIntakeSolenoid = new DoubleSolenoid(40,2, 3);
    DoubleSolenoid rightIntakeSolenoid = new DoubleSolenoid(40, 4, 5);

    public void runIntakeMotors(){
        intakeLeft.set(ControlMode.PercentOutput, 0.25);
        intakeRight.set(ControlMode.PercentOutput, 0.25);
        //extendIntakeParent.set(DoubleSolenoid.Value.kForward);
        //extendIntakeChild.set(DoubleSolenoid.Value.kForward);
    }

    public void stopIntakeMotors(){
        intakeLeft.set(ControlMode.PercentOutput, 0);
        intakeRight.set(ControlMode.PercentOutput, 0);
        //extendIntakeParent.set(DoubleSolenoid.Value.kReverse);
        //extendIntakeChild.set(DoubleSolenoid.Value.kReverse);
    }

    public void runWashingMachine(){
        washingMachine.set(ControlMode.PercentOutput, .25);
    }

    public void stopWashingMachine(){
        washingMachine.set(ControlMode.PercentOutput, 0);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
