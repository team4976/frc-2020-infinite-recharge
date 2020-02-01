package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drive;

public class MoveToSecondPoint extends Command {
    boolean hasMoved = false;

    public void initialize(){
        Drive.leftParent.selectProfileSlot(0, 0);
        Drive.rightParent.selectProfileSlot(0, 0);
        Drive.leftParent.setSelectedSensorPosition(0);
        Drive.rightParent.setSelectedSensorPosition(0);
        Drive.leftParent.configMotionCruiseVelocity(11476);
        Drive.leftParent.configMotionAcceleration(8000);
        Drive.rightParent.configMotionAcceleration(8000);
        Drive.rightParent.configMotionCruiseVelocity(11476);
        Drive.leftParent.set(ControlMode.MotionMagic, 80435);
        Drive.rightParent.set(ControlMode.MotionMagic, 80435);
    }

    @Override
    protected boolean isFinished() {
        if (Drive.leftParent.getSelectedSensorVelocity() != 0){
            hasMoved = true;
        }
        if (Drive.leftParent.getSelectedSensorVelocity() == 0 && hasMoved){
            hasMoved = false;
            return true;
        }else{
            return false;
        }
    }
}
