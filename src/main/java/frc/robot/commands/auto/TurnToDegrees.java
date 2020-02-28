package frc.robot.commands.auto;

import com.ctre.phoenix.ParamEnum;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXPIDSetConfiguration;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.drive.ShiftGearHigh;
import frc.robot.commands.drive.ShiftGearLow;
import frc.robot.subsystems.Drive;

public class TurnToDegrees extends Command {

    int counts;
    boolean hasMoved;
    String message;

    public TurnToDegrees(String message, double degrees){
        this.message = message;
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

        double leftStart = Drive.leftParent.getSelectedSensorPosition();
        double rightStart = Drive.rightParent.getSelectedSensorPosition();

        Drive.leftParent.set(ControlMode.MotionMagic, counts + leftStart);
        Drive.rightParent.set(ControlMode.MotionMagic, -counts + rightStart);
    }

    int getVelocity() {
        return Math.abs(
                Drive.leftParent.getSelectedSensorVelocity()
        );
    }

    @Override
    protected boolean isFinished() {
        if (getVelocity() > 10) hasMoved = true;
        return hasMoved && getVelocity() == 0;
    }
}
