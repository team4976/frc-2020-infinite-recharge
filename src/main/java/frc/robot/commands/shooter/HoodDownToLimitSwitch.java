package frc.robot.commands.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class HoodDownToLimitSwitch extends Command {

    @Override
    protected void initialize() {
        Robot.shooter.hoodMotor.set(ControlMode.PercentOutput, -0.5);
    }

    @Override
    protected boolean isFinished() {
        return !Robot.shooter.bottomLimitSwitch.get();
    }

    @Override
    protected void end() {
        Robot.shooter.hoodMotor.set(ControlMode.PercentOutput, 0);
    }
}
