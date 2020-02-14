package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunShooter extends Command {

    @Override
    protected void initialize(){
        Robot.shooter.shoot();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
