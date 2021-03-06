package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunIndexer extends Command {

    @Override
    protected void initialize(){
        if(Robot.shooter.shooterUpToSpeed()) {
            Robot.shooter.runIndexer();
            Robot.hopper.runWashingMachineShoot();
        }
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
