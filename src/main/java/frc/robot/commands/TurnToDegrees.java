package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drive;

public class TurnToDegrees extends Command {

    int counts;
    boolean hasMoved;

    public TurnToDegrees(double degrees){
        counts = (int)(degrees * 238.352777777777778);
    }

    public void initialize(){
        Drive.leftParent.selectProfileSlot(1, 1);
        Drive.rightParent.selectProfileSlot(1, 1);
        Drive.leftParent.setSelectedSensorPosition(0);
        Drive.rightParent.setSelectedSensorPosition(0);
        Drive.leftParent.configMotionCruiseVelocity(6215);
        Drive.leftParent.configMotionAcceleration(4000);
        Drive.rightParent.configMotionAcceleration(4000);
        Drive.rightParent.configMotionCruiseVelocity(6215);
        Drive.leftParent.set(ControlMode.MotionMagic, 24500);
        Drive.rightParent.set(ControlMode.MotionMagic, -24500);
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
