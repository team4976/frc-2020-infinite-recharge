package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunWashingMachineStore extends Command {

    @Override
    protected void initialize(){
        Robot.hopper.runWashingMachineStore();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
