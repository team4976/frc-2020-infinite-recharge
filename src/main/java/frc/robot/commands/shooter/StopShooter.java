package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class StopShooter extends Command {

    @Override
    protected void initialize(){
        Robot.intake.stopIntakeMotors();
        Robot.intake.retractIntake();
        new HoodDownToLimitSwitch().start();
        Robot.shooter.turnOffLimelight();
        Robot.intake.stopIntakeMotors();
        Robot.intake.retractIntake();
        Robot.shooter.stopShoot();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
