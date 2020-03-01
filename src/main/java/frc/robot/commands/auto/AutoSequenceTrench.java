package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.intake.RunIntake;
import frc.robot.commands.intake.StopIntake;

public class AutoSequenceTrench extends CommandGroup {

    public AutoSequenceTrench() {
        addSequential(new ResetEncoderCounts());
        addSequential(new ShootQuickly(39000));
        addSequential(new AngleOfAttack(0), 1);
        addSequential(new MoveToPoint("", 3.75));
        addSequential(new ShootQuickly(40250));
        addSequential(new StopIntake());
    }

}
