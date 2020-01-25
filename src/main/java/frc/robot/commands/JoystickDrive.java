package frc.robot.commands;

import frc.robot.*;
import edu.wpi.first.wpilibj.command.*;

public class JoystickDrive extends Command{

    @Override protected void execute() { 
        Robot.drive.teleopDrive(); 
    }
    
    protected boolean isFinished(){return false;}
}