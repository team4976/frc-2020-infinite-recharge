package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoSequenceLeft extends CommandGroup {

    int i;

    public AutoSequenceLeft(){

        addSequential(new ResetEncoderCounts());
        addSequential(new AutoAim());
        addSequential(new StraightenOut());
        addSequential(new MoveToPoint("", -5));
        addSequential(new ResetEncoderCounts());

//        addSequential(new MoveToPoint(-1.4097));
//        addSequential(new MoveToPoint(-2.3177499999796));

        addSequential(new MoveToPoint("",5));

        addSequential(new ResetEncoderCounts());
        addSequential(new AutoAim());
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
