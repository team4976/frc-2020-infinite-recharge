package frc.robot.commands.auto;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.subsystems.Drive;

public class AngleOfAttack extends Command {

    @Override
    protected void initialize() {
        Drive.shifter.set(DoubleSolenoid.Value.kForward);
        Drive.leftParent.configMotionCruiseVelocity(1653);
        Drive.leftParent.configMotionAcceleration(500);
        Drive.rightParent.configMotionAcceleration(500);
        Drive.rightParent.configMotionCruiseVelocity(1653);
        Drive.leftParent.selectProfileSlot(1, 0);
        Drive.rightParent.selectProfileSlot(1, 0);
        Drive.leftParent.set(ControlMode.MotionMagic, Drive.leftParent.getSelectedSensorPosition() * -1);
        Drive.rightParent.set(ControlMode.MotionMagic, Drive.rightParent.getSelectedSensorPosition() * -1);
    }

    @Override
    protected boolean isFinished() {
        return Math.abs(Drive.leftParent.getSelectedSensorPosition()) < 100;
    }

}
