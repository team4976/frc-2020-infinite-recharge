package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

    //Fix CAN IDs
    public CANSparkMax rightClimber = new CANSparkMax(49, CANSparkMaxLowLevel.MotorType.kBrushless);
    public CANSparkMax leftClimber = new CANSparkMax(48, CANSparkMaxLowLevel.MotorType.kBrushless);

    public CANEncoder climberEncoder = new CANEncoder(rightClimber);

    Solenoid climberBrake = new Solenoid(10, 4);

    //current encoder values are placeholders
    public void runClimberUp(){
        rightClimber.set(0.05);
        leftClimber.set(0.05);
    }

    public void runClimberDown(){
        rightClimber.set(-0.05);
        leftClimber.set(-0.05);
    }

    public void stopClimber(){
        rightClimber.set(0);
        leftClimber.set(0);
    }

    public void turnBrakeOff(){
        climberBrake.set(true);
    }

    public void turnBrakeOn(){
        climberBrake.set(false);
    }


    public void printClimberValues(){
        System.out.println(climberEncoder.getVelocity() + " Velocity");
        System.out.println(climberEncoder.getPosition() + " Position");
    }

    @Override
    protected void initDefaultCommand() {

    }
}
