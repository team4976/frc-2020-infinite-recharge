package frc.robot.commands.auto;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.drive.ShiftGearHigh;
import frc.robot.commands.drive.ShiftGearLow;
import frc.robot.subsystems.Drive;

public class MoveToPoint extends Command {

    int counts;
    boolean hasMoved;
    String message;

    public MoveToPoint(String message, double distance){
        this.message = message;
        counts = (int)(11583.333333333333333 * distance);
    }
    public void initialize(){
        System.out.println(message);
        hasMoved = false;
        Drive.leftParent.selectProfileSlot(0, 0);
        Drive.rightParent.selectProfileSlot(0, 0);
        Drive.leftParent.configMotionCruiseVelocity(2000);
        Drive.leftParent.configMotionAcceleration(2000);
        Drive.rightParent.configMotionAcceleration(2000);
        Drive.rightParent.configMotionCruiseVelocity(2000);

        double leftStart = Drive.leftParent.getSelectedSensorPosition();
        double rightStart = Drive.rightParent.getSelectedSensorPosition();

        Drive.leftParent.set(ControlMode.MotionMagic, counts + leftStart);
        Drive.rightParent.set(ControlMode.MotionMagic, counts + rightStart);
    }

    @Override
    protected void end() { }

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
