package frc.robot.commands.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class BringHoodUp extends Command {

    @Override
    protected void initialize() {
        Robot.shooter.hoodMotor.set(ControlMode.PercentOutput, .5);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
