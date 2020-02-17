package frc.robot.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunClimberUp extends Command {

    @Override
    protected void initialize(){
        Robot.climber.turnBrakeOff();
        Robot.climber.runClimberUp();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
