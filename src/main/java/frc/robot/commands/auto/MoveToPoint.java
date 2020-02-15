package frc.robot.commands.auto;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drive;

public class MoveToPoint extends Command {

    int counts;
    boolean hasMoved;

    Integer leftStart = null;
    Integer rightStart = null;

    public MoveToPoint(double distance){
        counts = (int)(-(15177.36 * distance));
    }
    public void initialize(){
        Drive.shifter.set(DoubleSolenoid.Value.kReverse);
        Drive.leftParent.selectProfileSlot(0, 0);
        Drive.rightParent.selectProfileSlot(0, 0);
        Drive.leftParent.configMotionCruiseVelocity(2500);
        Drive.leftParent.configMotionAcceleration(3000);
        Drive.rightParent.configMotionAcceleration(3000);
        Drive.rightParent.configMotionCruiseVelocity(2500);

        leftStart = Drive.leftParent.getSelectedSensorPosition();
        rightStart = Drive.rightParent.getSelectedSensorPosition();

        Drive.leftParent.set(ControlMode.MotionMagic, counts + leftStart);
        Drive.rightParent.set(ControlMode.MotionMagic, counts + rightStart);
    }

    @Override
    protected void end() {
        Drive.leftParent.setSelectedSensorPosition(0);
        Drive.rightParent.setSelectedSensorPosition(0);
        Drive.leftParent.set(ControlMode.PercentOutput, 0);
        Drive.rightParent.set(ControlMode.PercentOutput, 0);
    }

    @Override
    protected boolean isFinished() {
        if (leftStart == null) return false;

        int target = Math.abs(counts);
        int diff = Math.abs(leftStart - Drive.leftParent.getSelectedSensorPosition());

        return Math.abs(diff - target) < 100;
    }
}
