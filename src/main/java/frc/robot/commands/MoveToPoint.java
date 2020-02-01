package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drive;

public class MoveToPoint extends Command {

    int counts;
    boolean hasMoved;

    public MoveToPoint(double distance){
        counts = (int)(38355.333294978 * distance);
    }
    public void initialize(){
        Drive.leftParent.selectProfileSlot(0, 0);
        Drive.rightParent.selectProfileSlot(0, 0);
        Drive.leftParent.setSelectedSensorPosition(0);
        Drive.rightParent.setSelectedSensorPosition(0);
        Drive.leftParent.configMotionCruiseVelocity(11476);
        Drive.leftParent.configMotionAcceleration(8000);
        Drive.rightParent.configMotionAcceleration(8000);
        Drive.rightParent.configMotionCruiseVelocity(11476);
        Drive.leftParent.set(ControlMode.MotionMagic, counts);
        Drive.rightParent.set(ControlMode.MotionMagic, counts);
    }

    @Override
    protected boolean isFinished() {
        if (Drive.leftParent.getSelectedSensorVelocity() > 10){
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
