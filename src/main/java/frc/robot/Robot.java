package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.commands.auto.AutoSequence;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

  public static Shooter shooter;
  private Scheduler scheduler;
  public static Drive drive;

  public void robotInit() {


    scheduler = Scheduler.getInstance();
    Drive.leftParent.setSensorPhase(false);
    Drive.leftChild.setSensorPhase(false);
    Drive.rightParent.setSensorPhase(false);
    Drive.rightChild.setSensorPhase(false);

    Drive.leftParent.setInverted(false);
    Drive.leftChild.setInverted(false);
    Drive.rightParent.setInverted(true);
    Drive.rightChild.setInverted(true);


    drive = new Drive();
    shooter = new Shooter();
    Drive.leftChild.follow(Drive.leftParent);
    Drive.rightChild.follow(Drive.rightParent);
  }

  @Override
  public void robotPeriodic() {
    scheduler.run();
  }

  @Override
  public void autonomousInit() {
    new AutoSequence().start();
  }

  @Override
  public void autonomousPeriodic() {
    
  }

  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void testInit(){

  }

  @Override
  public void testPeriodic() {
  }
}
