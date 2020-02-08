package frc.robot.commands.auto;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Drive;

public class AutoAim extends Command {

    @Override
    protected void execute() {
        Robot.shooter.target();
    }

    @Override
    protected void end() {
        Drive.rightParent.set(ControlMode.PercentOutput, 0);
        Drive.leftParent.set(ControlMode.PercentOutput, 0);
    }

    @Override
    protected boolean isFinished() {
        return Robot.shooter.withinDeadband();
    }
}
