package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class StopWashingMachine extends Command {

    @Override
    protected void initialize(){
        Robot.hopper.stopWashingMachine();
        Robot.intake.retractIntake();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
