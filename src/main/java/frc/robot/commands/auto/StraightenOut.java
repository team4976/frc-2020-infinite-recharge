package frc.robot.commands.auto;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drive;

public class StraightenOut extends Command {

    @Override
    protected void initialize() {
        Drive.shifter.set(DoubleSolenoid.Value.kForward);
        Drive.leftParent.configMotionCruiseVelocity(1653);
        Drive.leftParent.configMotionAcceleration(500);
        Drive.rightParent.configMotionAcceleration(500);
        Drive.rightParent.configMotionCruiseVelocity(1653);
        Drive.leftParent.selectProfileSlot(1, 0);
        Drive.rightParent.selectProfileSlot(1, 0);
        Drive.leftParent.set(ControlMode.MotionMagic, 0);
        Drive.rightParent.set(ControlMode.MotionMagic, 0);
    }

    @Override
    protected boolean isFinished() {
        return Math.abs(Drive.leftParent.getSelectedSensorPosition()) < 100;
    }
}
