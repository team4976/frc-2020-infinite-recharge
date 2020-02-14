package frc.robot.commands.auto;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Index extends Command {

    @Override
    protected void execute() {
        if (Math.abs(Robot.shooter.shooterParent.getSelectedSensorVelocity()) > 30000){
            Robot.shooter.indexer.set(ControlMode.PercentOutput, 0.7);
            System.out.println(Robot.shooter.indexer.getSelectedSensorVelocity());
        }
    }

    @Override
    protected boolean isFinished() {
        return Robot.shooter.indexer.getMotorOutputPercent() > 0;
    }
}
