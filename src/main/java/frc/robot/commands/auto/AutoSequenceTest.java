package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoSequenceTest extends CommandGroup {

    int i;

    public AutoSequenceTest(){

        addSequential(new ResetEncoderCounts());
        addSequential(new MoveToPoint(5));
        addSequential(new ResetEncoderCounts());
        addSequential(new MoveToPoint(-5));
        addSequential(new ResetEncoderCounts());

    }

}
