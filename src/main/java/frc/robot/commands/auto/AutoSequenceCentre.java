package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.intake.RunIntake;
import frc.robot.commands.intake.StopIntake;

public class AutoSequenceCentre extends CommandGroup {

    public AutoSequenceCentre(){

        addSequential(new ResetEncoderCounts());
        addSequential(new Shoot());
        addSequential(new AngleOfAttack(45));
        addSequential(new MoveToPoint("", 4.8768));
        addSequential(new TurnToDegrees("", -45));
        addSequential(new RunIntake());
        addSequential(new MoveToPoint("",1.8288));
        addSequential(new Delay(500));
        addSequential(new StopIntake());
        addSequential(new MoveToPoint("", (-1.8288)));
        addSequential(new Shoot());
    }

}
