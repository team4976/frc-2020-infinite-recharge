package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunIntake extends Command {

    @Override
    protected void initialize(){
        Robot.intake.runIntakeMotors();
        Robot.intake.runWashingMachine();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
