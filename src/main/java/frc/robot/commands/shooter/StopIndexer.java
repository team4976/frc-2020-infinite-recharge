package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class StopIndexer extends Command {

    @Override
    protected void initialize(){
        Robot.shooter.stopIndexer();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
