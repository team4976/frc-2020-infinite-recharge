package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class StopShooterKeepIntaking extends Command {

    @Override
    protected void initialize(){
        Robot.shooter.hoodDown();
        Robot.shooter.turnOffLimelight();
        Robot.shooter.stopShoot();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
