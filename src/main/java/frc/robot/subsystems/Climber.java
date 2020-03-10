package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

    //Fix CAN IDs
    public CANSparkMax rightClimber = new CANSparkMax(49, CANSparkMaxLowLevel.MotorType.kBrushless);
    public CANSparkMax leftClimber = new CANSparkMax(48, CANSparkMaxLowLevel.MotorType.kBrushless);

    public CANEncoder climberEncoderRight = new CANEncoder(rightClimber);
    public CANEncoder climberEncoderLeft = new CANEncoder(leftClimber);

    Solenoid climberBrake = new Solenoid(10, 4);

    //current encoder values are placeholders
    public void runClimberUp(double speed){
        rightClimber.set(speed);
        leftClimber.set(speed);
    }

    public void runClimberDown(double speed){
        rightClimber.set(-speed);
        leftClimber.set(-speed);
    }

    public void stopClimber(){
        rightClimber.set(-0.02);
        leftClimber.set(-0.02);
        //System.out.println("Current Draw Right: " + rightClimber.getOutputCurrent() + " Current Draw Left: " + leftClimber.getOutputCurrent());
    }

    public void turnBrakeOff(){
        climberBrake.set(true);
    }

    public void turnBrakeOn(){
        climberBrake.set(false);
    }


    public void printClimberValues(){
        System.out.println(climberEncoderRight.getPosition() + " Position");
    }

    @Override
    protected void initDefaultCommand() {

    }
}
