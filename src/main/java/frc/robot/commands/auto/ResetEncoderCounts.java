package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drive;

public class ResetEncoderCounts extends Command {

    @Override
    protected void execute() {
        Drive.leftParent.setSelectedSensorPosition(0);
        Drive.rightParent.setSelectedSensorPosition(0);
    }

    @Override
    protected boolean isFinished() {
        return Drive.leftParent.getSelectedSensorPosition() < 10;
    }
}
