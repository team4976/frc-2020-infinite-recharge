package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.intake.RunIntake;
import frc.robot.commands.intake.RunWashingMachine;
import frc.robot.commands.intake.StopIntake;
import frc.robot.commands.intake.StopWashingMachine;
import frc.robot.commands.shooter.RunIndexer;
import frc.robot.commands.shooter.RunShooter;
import frc.robot.commands.shooter.StopIndexer;
import frc.robot.commands.shooter.StopShooter;

public final class OI {

    public Joystick driver = new Joystick(0);
    public Joystick operator = new Joystick(1);

    //A & X - Climber
    //Right Bumper - Intake
    //Y - Shoot
    //B - Indexer
    //Triggers & Left Joystick - Drive

    OI(){
        //Running and stopping intake (RIGHT BUMPER)
        new JoystickButton(driver, 6).whenPressed(new RunIntake());
        new JoystickButton(driver, 6).whenReleased(new StopIntake());

        //Running and stopping indexer (B)
        new JoystickButton(driver, 2).whenPressed(new RunIndexer());
        new JoystickButton(driver, 2).whenReleased(new StopIndexer());

        //Running and stopping shooter (A)
        new JoystickButton(driver, 1).whenPressed(new RunShooter());
        new JoystickButton(driver, 1).whenReleased(new StopShooter());

        //Running and stopping washing machine (X)
        new JoystickButton(driver, 3).whenPressed(new RunWashingMachine());
        new JoystickButton(driver, 3).whenReleased(new StopWashingMachine());
    }

}
