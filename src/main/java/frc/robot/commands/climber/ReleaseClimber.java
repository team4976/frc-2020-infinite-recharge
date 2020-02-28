package frc.robot.commands.climber;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.auto.Delay;

public class ReleaseClimber extends CommandGroup {

    public ReleaseClimber() {
        addSequential(new RunClimberDown());
        addSequential(new Delay(300));
        addSequential(new StopClimber());
    }

}

