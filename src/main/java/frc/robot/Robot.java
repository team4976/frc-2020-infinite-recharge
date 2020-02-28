package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.auto.AutoSequenceCentre;
import frc.robot.commands.auto.AutoSequenceLeft;
import frc.robot.commands.auto.AutoSequenceRight;
import frc.robot.commands.auto.AutoSequenceTest;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

  private Scheduler scheduler;
  public static Shooter shooter;
  public static Drive drive;
  public static Intake intake;
  public static Climber climber;
  public static Hopper hopper;
  public static AirCompressor airCompressor;
  public static OI oi;

  PowerDistributionPanel PDP = new PowerDistributionPanel(2);

  public void robotInit() {
    SmartDashboard.putNumber("autoPos", SmartDashboard.getNumber("autoPos", 0));

    scheduler = Scheduler.getInstance();
    drive = new Drive();
    shooter = new Shooter();
    intake = new Intake();
    climber = new Climber();
    hopper = new Hopper();
    airCompressor = new AirCompressor();
    oi = new OI();

    Drive.leftParent.setSensorPhase(false);
    Drive.rightParent.setSensorPhase(false);

    Drive.leftParent.setInverted(false);
    Drive.leftChild.setInverted(false);
    Drive.rightParent.setInverted(true);
    Drive.rightChild.setInverted(true);

    shooter.indexer.setInverted(true);
    shooter.shooterChild.setInverted(true);
    shooter.shooterParent.setInverted(true);

    Drive.leftChild.follow(Drive.leftParent);
    Drive.rightChild.follow(Drive.rightParent);

    climber.leftClimber.setInverted(true);

    shooter.shooterParent.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    shooter.shooterParent.configContinuousCurrentLimit(42);
    shooter.shooterParent.configPeakCurrentLimit(60);
    shooter.shooterParent.configPeakCurrentDuration(300);
    shooter.shooterChild.configContinuousCurrentLimit(42);
    shooter.shooterChild.configPeakCurrentLimit(60);
    shooter.shooterChild.configPeakCurrentDuration(300);

    intake.intakeRight.setInverted(true);
    hopper.washingMachine.setInverted(true);

    shooter.shooterChild.follow(shooter.shooterParent);

    shooter.shooterParent.setSensorPhase(true);
  }

  @Override
  public void robotPeriodic() {
    scheduler.run();

    Robot.climber.turnBrakeOff();

    double climberSpeedUp = oi.operator.getRawAxis(3);
    double climberSpeedDown = oi.operator.getRawAxis(2);

//    System.out.println("Speed down: "+ climberSpeedDown);
//    System.out.println("Current draw: " + climber.leftClimber.getOutputCurrent());
//    System.out.println("Current draw pdp: " + PDP.getCurrent(14));

    if(climberSpeedUp > 0.03 && climberSpeedDown == 0){
      //Robot.climber.turnBrakeOff();
      Robot.climber.runClimberUp(climberSpeedUp);
    }

    if(climberSpeedDown > 0.03 && climberSpeedUp == 0){
      Robot.climber.runClimberDown(climberSpeedDown);
    }

    if(climberSpeedDown == 0 && climberSpeedUp == 0){
      //Robot.climber.turnBrakeOn();
      Robot.climber.stopClimber();
    }

//    if(oi.operator.getRawButton(4)){
//      Robot.climber.turnBrakeOff();
//    } else {
//      Robot.climber.turnBrakeOn();
//    }

    SmartDashboard.putNumber("UPS", shooter.shooterParent.getSelectedSensorVelocity());
    SmartDashboard.putNumber("RPM", ((-shooter.shooterParent.getSelectedSensorVelocity()/4096.0)*600)*1.75);
    //System.out.println(Drive.leftParent.getSelectedSensorPosition());
  }

  @Override
  public void autonomousInit() {

    new AutoSequenceLeft().start();

//    int position = (int) SmartDashboard.getNumber("autoPos", 0);
//
//    if (position == 0){
//      new AutoSequenceLeft().start();
//    }else if (position == 1){
//      new AutoSequenceCentre().start();
//    }else if (position == 2){
//      new AutoSequenceRight().start();
//    }else{
//      new AutoSequenceTest().start();
//    }
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

  @Override
  public void disabledInit() {
    Robot.climber.turnBrakeOn();
    intake.retractIntake();
    intake.stopIntakeMotors();
    shooter.hood.set(false);
    Drive.leftParent.set(ControlMode.PercentOutput, 0);
    Drive.rightParent.set(ControlMode.PercentOutput, 0);
    shooter.shooterParent.set(ControlMode.PercentOutput, 0);
    shooter.indexer.set(ControlMode.PercentOutput, 0);
    hopper.washingMachine.set(ControlMode.PercentOutput, 0);
  }
}