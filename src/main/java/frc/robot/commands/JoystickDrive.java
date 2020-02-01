package frc.robot.commands;

import edu.wpi.first.wpilibj.RobotState;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.*;

public class JoystickDrive extends Command {

    public JoystickDrive(){requires(Robot.drive);};

    @Override protected void execute() {
        if(!RobotState.isAutonomous())Robot.drive.teleopDrive();
    }
    
    protected boolean isFinished(){return false;}
}