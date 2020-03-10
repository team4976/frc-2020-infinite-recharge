package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ToggleShooter extends Command {

    @Override
    protected void initialize(){
        Robot.intake.runIntakeMotorsShooting();
        Robot.intake.extendIntake();
        Robot.shooter.turnOnLimelight();
        if(Robot.oi.driver.getPOV() == 180){
            new HoodDownToLimitSwitch().start();
            System.out.println("Hood should be down now");
//            Robot.shooter.shootClose(SmartDashboard.getNumber("shooterCloseSpeed", SmartDashboard.getNumber("shooterCloseSpeed", 0)));
            Robot.shooter.shoot(28000);
        } else {
            new HoodUpToLimitSwitch().start();
            System.out.println("Hood should be up now");
//            Robot.shooter.shoot(SmartDashboard.getNumber("shooterFarSpeed", SmartDashboard.getNumber("shooterFarSpeed", 0)));
            Robot.shooter.shoot(38500);
//            Robot.shooter.shoot(40250);
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
        new HoodDownToLimitSwitch().start();
        Robot.shooter.turnOffLimelight();
    }
}
