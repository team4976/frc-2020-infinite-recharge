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

    int A = 1, B = 2, X = 3, Y = 4, LEFTBUMPER = 5, RIGHTBUMPER = 6, BACK = 7, START = 8, LEFTJOYSTICK = 9, RIGHTJOYSTICK = 10, DPADUP = 0, DPADRIGHT = 90, DPADDOWN = 180, DPADLEFT = 270;
    public Joystick driver = new Joystick(0);
    public Joystick operator = new Joystick(1);
    public Joystick test = new Joystick(2);

    //A & X - Climber
    //Right Bumper - Intake
    //Y - Shoot
    //B - Indexer
    //Triggers & Left Joystick - Drive

    OI(){
        //Driver

        //Running and stopping shooter and washing machine (A)
        new JoystickButton(driver, A).toggleWhenPressed(new ToggleShooter());
       // new JoystickButton(driver, 1).whenPressed(new RunShooter());
       // new JoystickButton(driver, 1).whenReleased(new StopShooter());

        //Running and stopping indexer and washing machine (B)
        new JoystickButton(driver, B).whileHeld(new RunIndexerAuto());
        new JoystickButton(driver, B).whenReleased(new StopIndexer());

        new JoystickButton(driver, X).whileHeld(new Aim());

        //Shifting from high gear to low gear (Y)
        new JoystickButton(driver, Y).whenPressed(new ShiftGearHigh());
        new JoystickButton(driver, Y).whenReleased(new ShiftGearLow());

        //Operator

        //Running and stopping intake (A)
        new JoystickButton(operator, A).whileHeld(new RunIntake());

        //Running and stopping intake reverse (B)
        new JoystickButton(operator, B).whenPressed(new RunIntakeReverse());
        new JoystickButton(operator, B).whenReleased(new StopIntake());

        //Running and stopping washing machine shoot (X)
        new JoystickButton(operator, X).whenPressed(new RunWashingMachineShoot());
        new JoystickButton(operator, X).whenReleased(new StopWashingMachine());

        //Running and stopping washing machine store (Y)
        new JoystickButton(operator, Y).whenPressed(new RunWashingMachineStore());
        new JoystickButton(operator, Y).whenReleased(new StopWashingMachine());

        // Run Climber down and stop (LEFT BUMPER)
        new JoystickButton(operator, LEFTBUMPER).whenPressed(new RunClimberDown());
        new JoystickButton(operator, LEFTBUMPER).whenReleased(new StopClimber());

        // Run Climber up and stop (RIGHT BUMPER)
        new JoystickButton(operator, RIGHTBUMPER).whenPressed(new RunClimberUp());
        new JoystickButton(operator, RIGHTBUMPER).whenReleased(new StopClimber());

        //new JoystickButton(operator, 8).toggleWhenPressed(new CompressorToggle());

        new POVButton(operator, DPADUP).whenPressed(new TurnBrakeOn());
        new POVButton(operator, DPADDOWN).whenPressed(new TurnBrakeOff());

        new POVButton(operator, DPADLEFT).whenPressed(new IncreaseShooterSpeed());
        new POVButton(operator, DPADRIGHT).whenPressed(new DecreaseShooterSpeed());

        //Testing joystick
    }

}
