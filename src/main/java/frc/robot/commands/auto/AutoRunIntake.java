package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.commands.intake.StopIntake;

public class AutoRunIntake extends Command {

    @Override
    protected void initialize(){
        Robot.intake.extendIntake();
        Robot.intake.runIntakeMotors();
        Robot.hopper.runWashingMachineStore();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
