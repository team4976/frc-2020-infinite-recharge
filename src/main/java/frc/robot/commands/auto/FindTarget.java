package frc.robot.commands.auto;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Drive;

public class FindTarget extends Command {

    @Override
    protected void initialize() {
        Robot.shooter.hoodUp();
    }

    @Override
    protected void execute() {
        Drive.leftParent.set(ControlMode.PercentOutput, -0.3);
        Drive.rightParent.set(ControlMode.PercentOutput, 0.3);
    }

    @Override
    protected boolean isFinished() {
        return Robot.shooter.canSeeTarget();
    }

    @Override
    protected void end() {
        Drive.leftParent.set(ControlMode.PercentOutput, 0);
        Drive.rightParent.set(ControlMode.PercentOutput, 0);
    }
}
