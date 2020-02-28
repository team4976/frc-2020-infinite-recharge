package frc.robot.commands.auto;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.subsystems.Drive;

public class AngleOfAttack extends Command {

    int counts;
    boolean hasMoved;
    String message;

    public AngleOfAttack(double degrees){
        counts = (int)(degrees * 60.302777777777778);
    }

    public void initialize(){
        System.out.println(message);
        Drive.leftParent.configMotionCruiseVelocity(1800);
        Drive.leftParent.configMotionAcceleration(1800);
        Drive.rightParent.configMotionAcceleration(1800);
        Drive.rightParent.configMotionCruiseVelocity(1800);
        Drive.leftParent.selectProfileSlot(1, 0);
        Drive.rightParent.selectProfileSlot(1, 0);

        Drive.leftParent.set(ControlMode.MotionMagic, counts);
        Drive.rightParent.set(ControlMode.MotionMagic, -counts);
    }

    int getVelocity() {
        return Math.abs(
                Drive.leftParent.getSelectedSensorVelocity()
        );
    }

    @Override
    protected boolean isFinished() {
//        return Math.abs(Drive.leftParent.getSelectedSensorPosition()) < 100;

        if (getVelocity() > 10) hasMoved = true;
        return hasMoved && getVelocity() == 0;
    }

}
