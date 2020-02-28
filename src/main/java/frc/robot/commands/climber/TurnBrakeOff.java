package frc.robot.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TurnBrakeOff extends Command {

    @Override
    protected void initialize(){
        Robot.climber.turnBrakeOff();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
