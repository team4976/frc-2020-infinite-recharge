package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunIntake extends Command {

    @Override
    protected void initialize(){
        Robot.intake.extendIntake();
    }

    @Override
    protected void execute(){
        Robot.intake.runIntakeMotors();
        Robot.hopper.runWashingMachineStore();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end(){
        new StopIntake().start();
    }
}
