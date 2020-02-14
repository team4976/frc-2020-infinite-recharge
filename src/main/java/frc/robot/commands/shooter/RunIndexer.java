package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunIndexer extends Command {

    @Override
    protected void initialize(){
        Robot.shooter.runIndexer();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
