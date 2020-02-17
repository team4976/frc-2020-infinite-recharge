package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CompressorToggle extends Command {

    @Override
    protected void initialize(){
        Robot.airCompressor.compressorOn();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted(){
        Robot.airCompressor.compressorOff();
    }
}
