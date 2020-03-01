package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.intake.StopIntake;

public class AutoSequenceTrench8Ball extends CommandGroup {

    public AutoSequenceTrench8Ball(){
        addSequential(new ResetEncoderCounts());
        addSequential(new ShootQuickly(39000));
        addSequential(new AngleOfAttack(0), 1);
        addSequential(new MoveToPoint("", 5));
        addSequential(new MoveToPointFast("", -1.25));
        addSequential(new Shoot(40250));
    }

}
