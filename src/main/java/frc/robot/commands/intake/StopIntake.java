package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class StopIntake extends Command {

    @Override
    protected void initialize(){
        Robot.intake.stopIntakeMotors();
        Robot.intake.stopWashingMachine();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
