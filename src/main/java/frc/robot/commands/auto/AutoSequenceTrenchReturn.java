package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.intake.StopIntake;

public class AutoSequenceTrenchReturn extends CommandGroup {

    public AutoSequenceTrenchReturn(){

        addSequential(new ResetEncoderCounts());
//        addSequential(new Shoot(SmartDashboard.getNumber("shooterCloseSpeed", SmartDashboard.getNumber("shooterCloseSpeed", 0))));
        addSequential(new Shoot(40500));
        addSequential(new AngleOfAttack(0), 1);
        addSequential(new ResetEncoderCounts());
        addSequential(new AutoRunIntake());
        addSequential(new MoveToPoint("", 3.75));
        addSequential(new StopIntake());
        addSequential(new MoveToPointFast("", 5.96));
        addSequential(new Shoot(40500));
//        addSequential(new Shoot(SmartDashboard.getNumber("shooterFarSpeed", SmartDashboard.getNumber("shooterFarSpeed", 0))));

//        final shot...
//        addSequential(new Shoot(40500));
    }

}
