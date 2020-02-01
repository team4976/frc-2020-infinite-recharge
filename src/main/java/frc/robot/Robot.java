package frc.robot;

import frc.robot.commands.PointMovement;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

  private Scheduler scheduler;
  public static Drive drive;

  public void robotInit() {
    scheduler = Scheduler.getInstance();
    Drive.leftParent.setSensorPhase(true);
    Drive.leftChild.setSensorPhase(true);
    Drive.rightParent.setSensorPhase(true);
    Drive.rightChild.setSensorPhase(true);

    Drive.leftParent.setInverted(false);
    Drive.leftChild.setInverted(false);
    Drive.rightParent.setInverted(true);
    Drive.rightChild.setInverted(true);


    drive = new Drive();
    Drive.leftChild.follow(Drive.leftParent);
    Drive.rightChild.follow(Drive.rightParent);
  }

  @Override
  public void robotPeriodic() {
    scheduler.run();
  }

  @Override
  public void autonomousInit() {
    new PointMovement().start();
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
