package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.Robot;
import frc.robot.commands.auto.Delay;

public class StopIntake extends CommandGroup {

    public StopIntake(){
        addSequential(new RetractIntake());
        addSequential(new Delay(2000));
        addSequential(new StopIntakeMotors());
    }
}
