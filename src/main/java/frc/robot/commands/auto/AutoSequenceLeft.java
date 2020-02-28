package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.intake.RunIntake;
import frc.robot.commands.intake.StopIntake;

public class AutoSequenceLeft extends CommandGroup {

    public AutoSequenceLeft(){

        addSequential(new ResetEncoderCounts());
        addSequential(new Shoot());
        addSequential(new StraightenOut());
        addSequential(new RunIntake());
        addSequential(new MoveToPoint("", 3));
        addSequential(new Delay(500));
        addSequential(new StopIntake());
        addSequential(new MoveToPoint("",-3));
        addSequential(new Shoot());
    }

}
