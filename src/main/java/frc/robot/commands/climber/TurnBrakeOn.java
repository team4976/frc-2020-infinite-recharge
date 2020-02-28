package frc.robot.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TurnBrakeOn extends Command {

    @Override
    protected void initialize(){
        Robot.climber.turnBrakeOn();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}
