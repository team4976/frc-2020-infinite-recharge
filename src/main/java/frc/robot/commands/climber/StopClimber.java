package frc.robot.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class StopClimber extends Command {

    @Override
    protected void initialize(){
        Robot.climber.stopClimber();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
