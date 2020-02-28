package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.intake.RunIntake;
import frc.robot.commands.intake.StopIntake;

public class AutoSequenceCentre extends CommandGroup {

    public AutoSequenceCentre(){

        addSequential(new ResetEncoderCounts());
        addSequential(new Shoot(39000));
        addSequential(new AngleOfAttack(45));
        addSequential(new MoveToPoint("", 3));
        addSequential(new TurnToDegrees("", -45));
        addSequential(new RunIntake());
        addSequential(new MoveToPoint("",3));
        addSequential(new Delay(500));
        addSequential(new StopIntake());
        addSequential(new Shoot(46000));
    }

}
