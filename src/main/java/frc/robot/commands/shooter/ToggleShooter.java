package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class ToggleShooter extends Command {

    @Override
    protected void initialize(){
        Robot.intake.runIntakeMotorsShooting();
        Robot.intake.extendIntake();
        Robot.shooter.turnOnLimelight();
        if(Robot.oi.driver.getPOV() == 180){
            Robot.shooter.hoodDown();
//            Robot.shooter.shootClose(SmartDashboard.getNumber("shooterCloseSpeed", SmartDashboard.getNumber("shooterCloseSpeed", 0)));
            Robot.shooter.shoot(28000);
        } else {
            Robot.shooter.hoodUp();
//            Robot.shooter.shoot(SmartDashboard.getNumber("shooterFarSpeed", SmartDashboard.getNumber("shooterFarSpeed", 0)));
            Robot.shooter.shoot(37500);
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
        Robot.shooter.turnOffLimelight();
    }
}
