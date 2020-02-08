package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoSequence extends CommandGroup {

    public AutoSequence(){
        addSequential(new AutoAim());
        addSequential(new MoveToPoint(2.3177499999796));
        addSequential(new ResetEncoderCounts());
        addSequential(new MoveToPoint(-1.4097));
        addSequential(new AutoAim());
    }

}
