package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class StopIntakeMotors extends Command {

    @Override
    protected void initialize(){
        if(!Robot.oi.operator.getRawButton(1)) {
            Robot.intake.stopIntakeMotors();
            Robot.hopper.stopWashingMachine();
        }
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
