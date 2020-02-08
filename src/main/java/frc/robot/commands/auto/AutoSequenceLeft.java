package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoSequenceLeft extends CommandGroup {

    public AutoSequenceLeft(){
        addSequential(new ResetEncoderCounts());
        addSequential(new AutoAim());
        addSequential(new StraightenOut());
        addSequential(new MoveToPoint(2.3177499999796));
        addSequential(new ResetEncoderCounts());
//        addSequential(new MoveToPoint(-1.4097));
        addSequential(new MoveToPoint(-2.3177499999796));
        addSequential(new ResetEncoderCounts());
        addSequential(new AutoAim());
        addSequential(new StraightenOut());
    }

}
