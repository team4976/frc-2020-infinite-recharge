package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunShooter extends Command {

    int fireRPM = 0;

    public RunShooter(int rpm){
        fireRPM = rpm;
    }

    @Override
    protected void initialize(){
        Robot.intake.runIntakeMotorsShooting();
        Robot.intake.extendIntake();
        Robot.shooter.hoodUp();
        Robot.intake.runIntakeMotorsShooting();
        Robot.intake.extendIntake();
        Robot.shooter.shoot(fireRPM);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
