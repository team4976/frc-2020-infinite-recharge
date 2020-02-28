package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import frc.robot.commands.CompressorToggle;
import frc.robot.commands.auto.RunIndexerAuto;
import frc.robot.commands.climber.*;
import frc.robot.commands.drive.ShiftGearHigh;
import frc.robot.commands.drive.ShiftGearLow;
import frc.robot.commands.intake.*;
import frc.robot.commands.shooter.*;

public final class OI {

    public Joystick driver = new Joystick(0);
    public Joystick operator = new Joystick(1);

    //A & X - Climber
    //Right Bumper - Intake
    //Y - Shoot
    //B - Indexer
    //Triggers & Left Joystick - Drive

    OI(){
        //Driver

        //Running and stopping shooter and washing machine (A)
        new JoystickButton(driver, 1).toggleWhenPressed(new ToggleShooter());
       // new JoystickButton(driver, 1).whenPressed(new RunShooter());
       // new JoystickButton(driver, 1).whenReleased(new StopShooter());

        //Running and stopping indexer and washing machine (B)
        new JoystickButton(driver, 2).whileHeld(new RunIndexerAuto());
        new JoystickButton(driver, 2).whenReleased(new StopIndexer());

        //Shifting from high gear to low gear (Y)
        new JoystickButton(driver, 4).whenPressed(new ShiftGearHigh());
        new JoystickButton(driver, 4).whenReleased(new ShiftGearLow());

        new JoystickButton(driver, 3).whileHeld(new Aim());

        //Operator

        //Running and stopping intake (A)
        new JoystickButton(operator, 1).whenPressed(new RunIntake());
        new JoystickButton(operator, 1).whenReleased(new StopIntake());

        //Running and stopping intake reverse (B)
        new JoystickButton(operator, 2).whenPressed(new RunIntakeReverse());
        new JoystickButton(operator, 2).whenReleased(new StopIntake());

        //Running and stopping washing machine shoot (X)
        new JoystickButton(operator, 3).whenPressed(new RunWashingMachineShoot());
        new JoystickButton(operator, 3).whenReleased(new StopWashingMachine());

        //Running and stopping washing machine store (Y)
//        new JoystickButton(operator, 4).whenPressed(new RunWashingMachineStore());
//        new JoystickButton(operator, 4).whenReleased(new StopWashingMachine());

        // Run Climber down and stop (LEFT BUMPER)
        new JoystickButton(operator, 5).whenPressed(new RunClimberDown());
        new JoystickButton(operator, 5).whenReleased(new StopClimber());

        // Run Climber up and stop (RIGHT BUMPER)
        new JoystickButton(operator, 6).whenPressed(new RunClimberUp());
        new JoystickButton(operator, 6).whenReleased(new StopClimber());

        new JoystickButton(operator, 8).toggleWhenPressed(new CompressorToggle());

        new POVButton(operator, 0).whenPressed(new TurnBrakeOn());
        new POVButton(operator, 180).whenPressed(new TurnBrakeOff());

        new POVButton(operator, 90).whenPressed(new IncreaseShooterSpeed());
        new POVButton(operator, 270).whenPressed(new DecreaseShooterSpeed());
    }

}
