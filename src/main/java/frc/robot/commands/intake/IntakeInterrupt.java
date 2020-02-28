package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class IntakeInterrupt extends Command {

    Boolean solenoidState;

    @Override
    protected void initialize(){
        solenoidState = Robot.intake.intakeSolenoid.get();

        Robot.intake.intakeSolenoid.set(!solenoidState);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end(){
        Robot.intake.intakeSolenoid.set(solenoidState);
    }
}
