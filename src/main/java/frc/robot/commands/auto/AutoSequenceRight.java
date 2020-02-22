package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoSequenceRight extends CommandGroup {

    int i;

    public AutoSequenceRight(){

        addSequential(new ResetEncoderCounts());
        addSequential(new Shoot());
        addSequential(new AngleOfAttack());
        addSequential(new MoveToPoint("", 4.1));
        addSequential(new StraightenOut());

        addSequential(new MoveToPoint("",3));
        addSequential(new MoveToPoint("", (-5.9)));

        addSequential(new Shoot());
        addSequential(new StraightenOut());

//        addSequential(new ResetEncoderCounts());
//        addSequential(new Delay(50));
//        addSequential(new MoveToPoint(1.33));
//        addSequential(new Delay(500));
//
//        addSequential(new ResetEncoderCounts());
//        addSequential(new Delay(50));
//        addSequential(new TurnToDegrees(-80));
//
//        addSequential(new ResetEncoderCounts());
//        addSequential(new Delay(50));
//        addSequential(new MoveToPoint(1.81));
//        addSequential(new Delay(500));
//
//        addSequential(new ResetEncoderCounts());
//        addSequential(new Delay(50));
//        addSequential(new TurnToDegrees(-80));
//
//        addSequential(new ResetEncoderCounts());
//        addSequential(new Delay(50));
//        addSequential(new MoveToPoint(2.81));
//        addSequential(new Delay(500));
//
//        addSequential(new ResetEncoderCounts());
//        addSequential(new Delay(50));
//        addSequential(new TurnToDegrees(80));
//
//        addSequential(new ResetEncoderCounts());
//        addSequential(new Delay(50));
//        addSequential(new MoveToPoint(1.81));
//        addSequential(new Delay(500));
//
//        addSequential(new ResetEncoderCounts());
//        addSequential(new Delay(50));
//        addSequential(new TurnToDegrees(80));
//
//        addSequential(new ResetEncoderCounts());
//        addSequential(new Delay(50));
//        addSequential(new MoveToPoint(2.81));
//        addSequential(new Delay(500));
//
//        addSequential(new ResetEncoderCounts());
//        addSequential(new Delay(50));
//        addSequential(new TurnToDegrees(-80));
//
//        addSequential(new ResetEncoderCounts());
//        addSequential(new Delay(50));
//        addSequential(new MoveToPoint(1.81));
//        addSequential(new Delay(500));
//        addSequential(new ResetEncoderCounts());
    }

}
