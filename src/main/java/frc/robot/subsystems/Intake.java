package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

    //48 and 49
//    public TalonSRX intakeLeft = new TalonSRX(51);
    public TalonSRX intakeRight = new TalonSRX(50);

    //6
    public Solenoid intakeSolenoid = new Solenoid(10,6);

    public void runIntakeMotors(){
//        intakeLeft.set(ControlMode.PercentOutput, 0.6);
        intakeRight.set(ControlMode.PercentOutput, 0.6);
    }

    public void runIntakeMotorsShooting(){
//        intakeLeft.set(ControlMode.PercentOutput, 0.25);
        intakeRight.set(ControlMode.PercentOutput, 0.25);
    }

    public void runIntakeMotorsReverse(){
//        intakeLeft.set(ControlMode.PercentOutput, -0.6);
        intakeRight.set(ControlMode.PercentOutput, -0.6);
    }

    public void extendIntake(){
        intakeSolenoid.set(true);
    }

    public void retractIntake(){
        intakeSolenoid.set(false);
    }

    public void stopIntakeMotors(){
//        intakeLeft.set(ControlMode.PercentOutput, 0);
        intakeRight.set(ControlMode.PercentOutput, 0);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
