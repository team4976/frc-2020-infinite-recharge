package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ToggleShooter extends Command {

    @Override
    protected void initialize(){
        Robot.intake.runIntakeMotorsShooting();
        Robot.intake.extendIntake();
        if(Robot.oi.driver.getPOV() == 180){
            Robot.shooter.hoodDown();
            Robot.shooter.shootClose();
        } else {
            Robot.shooter.hoodUp();
            Robot.shooter.shoot();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted(){
        Robot.shooter.stopShoot();
        Robot.intake.retractIntake();
        Robot.intake.stopIntakeMotors();
        Robot.shooter.hoodDown();
    }
}
