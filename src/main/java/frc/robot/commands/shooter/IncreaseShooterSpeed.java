package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class IncreaseShooterSpeed extends Command {

    @Override
    protected void initialize(){
        Robot.shooter.speedMultiplier++;
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
