package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunIndexerAuto extends Command {

    @Override
    protected void execute(){
        if(Robot.shooter.shooterUpToSpeed()) {
            Robot.shooter.runIndexer();
            Robot.hopper.runWashingMachineShoot();
        } else  Robot.hopper.stopWashingMachine();
    }

    @Override
    protected void end() {
        Robot.hopper.stopWashingMachine();
        Robot.shooter.stopIndexer();
        super.end();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
