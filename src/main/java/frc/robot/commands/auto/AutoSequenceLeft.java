package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.intake.RunIntake;
import frc.robot.commands.intake.StopIntake;

public class AutoSequenceLeft extends CommandGroup {

    public AutoSequenceLeft(){

        addSequential(new ResetEncoderCounts());
        addSequential(new Shoot(39000));
        addSequential(new AngleOfAttack(0));
        addSequential(new ResetEncoderCounts());
        addSequential(new RunIntake());
        addSequential(new MoveToPoint("", 3));
        addSequential(new StopIntake());
        addSequential(new Shoot(46000));
    }

}
