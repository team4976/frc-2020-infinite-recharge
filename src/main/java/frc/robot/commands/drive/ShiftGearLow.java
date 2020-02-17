package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ShiftGearLow extends Command {

    @Override
    protected void initialize(){
        Robot.drive.shiftGearLow();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
