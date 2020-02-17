package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ShiftGearHigh extends Command {

    @Override
    protected void initialize(){
        Robot.drive.shiftGearHigh();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
