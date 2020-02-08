package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutoAim extends Command {

    @Override
    protected void execute() {
        Robot.shooter.target();
        //TODO: Add code for firing shooter
    }

    @Override
    protected boolean isFinished() {
        return Robot.shooter.withinDeadband();
    }
}
