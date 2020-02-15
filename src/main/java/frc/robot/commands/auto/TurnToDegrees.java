package frc.robot.commands.auto;

import com.ctre.phoenix.ParamEnum;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXPIDSetConfiguration;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drive;

public class TurnToDegrees extends Command {

    int counts;
    boolean hasMoved;

    public TurnToDegrees(double degrees){
        counts = (int)(degrees * 105);
    }

    public void initialize(){
        Drive.shifter.set(true);
        Drive.leftParent.setSelectedSensorPosition(0);
        Drive.rightParent.setSelectedSensorPosition(0);
        Drive.leftParent.configMotionCruiseVelocity(1653);
        Drive.leftParent.configMotionAcceleration(500);
        Drive.rightParent.configMotionAcceleration(500);
        Drive.rightParent.configMotionCruiseVelocity(1653);
        Drive.leftParent.selectProfileSlot(1, 0);
        Drive.rightParent.selectProfileSlot(1, 0);
        Drive.leftParent.set(ControlMode.MotionMagic, counts);
        Drive.rightParent.set(ControlMode.MotionMagic, -counts);
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
