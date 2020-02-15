package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunClimberDown extends Command {

    @Override
    protected void initialize(){
        Robot.climber.runClimberDown();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
