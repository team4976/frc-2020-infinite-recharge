package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.intake.RunIntake;
import frc.robot.commands.intake.StopIntake;

public class AutoSequenceRight extends CommandGroup {

    public AutoSequenceRight(){
        addSequential(new ResetEncoderCounts());
        addSequential(new FindTarget());
        addSequential(new Shoot(39000));
        addSequential(new AngleOfAttack(70));
        addSequential(new MoveToPoint("", 1.5));
        addSequential(new TurnToDegrees("", -45));
        addSequential(new RunIntake());
        addSequential(new MoveToPoint("",1.8288));
        addSequential(new Delay(500));
        addSequential(new StopIntake());
        addSequential(new MoveToPoint("", (-1.8288)));
        addSequential(new Shoot(46000));
        addSequential(new StraightenOut());
    }

}
