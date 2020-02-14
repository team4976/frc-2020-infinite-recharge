package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

    //Fix CAN IDs
    public CANSparkMax climberParent = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    //public CANSparkMax climberChild = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);

    public CANEncoder climberEncoder = new CANEncoder(climberParent);

    //current encoder values are placeholders
    public void runClimberUp(){
        if(climberEncoder.getPosition() < 500){
            climberParent.set(0.05);
            //climberChild.set(-0.05);
        }
    }

    public void runClimberDown(){
        if(climberEncoder.getPosition() > -500){
            climberParent.set(-0.05);
            //climberChild.set(0.05);
        }
    }

    public void stopClimber(){
        climberParent.set(0);
        //climberChild.set(0);
    }

    public void printClimberValues(){
        System.out.println(climberEncoder.getVelocity() + " Velocity");
        System.out.println(climberEncoder.getPosition() + " Position");
    }

    @Override
    protected void initDefaultCommand() {

    }
}
