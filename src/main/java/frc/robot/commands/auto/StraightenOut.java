package frc.robot.commands.auto;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drive;

public class StraightenOut extends Command {

    boolean hasMoved;

    @Override
    protected void initialize() {
        Drive.shifter.set(true);
        Drive.leftParent.configMotionCruiseVelocity(1296);
        Drive.leftParent.configMotionAcceleration(1296);
        Drive.rightParent.configMotionAcceleration(1296);
        Drive.rightParent.configMotionCruiseVelocity(1296);
        Drive.leftParent.selectProfileSlot(1, 0);
        Drive.rightParent.selectProfileSlot(1, 0);
        Drive.leftParent.set(ControlMode.MotionMagic, 0);
        Drive.rightParent.set(ControlMode.MotionMagic, 0);
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
