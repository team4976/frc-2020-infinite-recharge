package frc.robot.commands.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Drive;

public class Aim extends Command {


    @Override
    protected void initialize(){
        Robot.drive.disabled = true;
    }

    @Override
    protected void execute(){
        Robot.shooter.target();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end(){
        Robot.drive.disabled = false;
        Drive.leftParent.set(ControlMode.PercentOutput, 0);
        Drive.rightParent.set(ControlMode.PercentOutput, 0);
    }
}
