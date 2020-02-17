package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ToggleShooter extends Command {

    @Override
    protected void initialize(){
        if(Robot.oi.driver.getPOV() == 180){
            Robot.shooter.hoodDown();
        } else {
            Robot.shooter.hoodUp();
        }
        Robot.intake.runIntakeMotorsShooting();
        Robot.intake.extendIntake();
        Robot.shooter.shoot();
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
