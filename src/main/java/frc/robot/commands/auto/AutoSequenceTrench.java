package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.intake.RunIntake;
import frc.robot.commands.intake.StopIntake;

public class AutoSequenceTrench extends CommandGroup {

    public AutoSequenceTrench() {
        addSequential(new ResetEncoderCounts());
//        addSequential(new Shoot(SmartDashboard.getNumber("shooterCloseSpeed", SmartDashboard.getNumber("shooterCloseSpeed", 0))));
        addSequential(new Shoot(39000));
        addSequential(new AngleOfAttack(0), 1);
        addSequential(new AutoRunIntake());
        addSequential(new MoveToPoint("", 3.75));
        addSequential(new StopIntake());
//       ddSequential(new Shoot(SmartDashboard.getNumber("shooterFarSpeed", SmartDashboard.getNumber("shooterFarSpeed", 0))));

//        final shot...
        addSequential(new Shoot(40250));
    }

}
