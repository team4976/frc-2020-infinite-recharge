package frc.robot.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunClimberDown extends Command {

    @Override
    protected void initialize(){
        Robot.climber.runClimberDown(-0.15);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
