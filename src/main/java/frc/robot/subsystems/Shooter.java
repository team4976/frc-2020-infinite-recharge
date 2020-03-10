package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem {
    public TalonSRX shooterParent = new TalonSRX(45);
    public TalonSRX shooterChild = new TalonSRX(46);
    public TalonSRX indexer = new TalonSRX(47);

    public Solenoid hood = new Solenoid(10, 5);

    public boolean isShooting = false;
    public boolean isAiming;

    public PIDController controller = new PIDController(0.085, 0.0085, 0);//p = .1, i = 0, d = 0
    public int speedMultiplier = 1;

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

    public double getX(){
        NetworkTableEntry tx = table.getEntry("tx");
        return tx.getDouble(0.0);
    }

    public void turnOnLimelight(){
        NetworkTableEntry ledMode = table.getEntry("ledMode");
        ledMode.setValue(0);
    }

    public void turnOffLimelight(){
        NetworkTableEntry ledMode = table.getEntry("ledMode");
        ledMode.setValue(1);
    }

    public boolean canSeeTarget () {
        NetworkTableEntry tv = table.getEntry("tv");
        return tv.getDouble(0) > 0;
    }

    public void hoodUp(){
        hood.set(true);
    }

    public void hoodDown(){
        hood.set(false);
    }

    public void shoot(double rpm){
        shooterParent.set(ControlMode.Velocity, rpm);

        //RPM:
        //TRENCH SHOT tested @ 42500UPS
        //INITIATION LINE SHOT tested @ 39000UPS

        //shooterParent.set(ControlMode.Velocity, 50000 * (1 + (speedMultiplier * .02)));
        //System.out.println("Set shooter to: " + 50000 * (1 + (speedMultiplier * .02)));
    }

    public void shootClose(double rpm){
        shooterParent.set(ControlMode.Velocity, rpm);
    }

    public void stopShoot(){
        shooterParent.set(ControlMode.PercentOutput, 0);
    }

    public boolean withinDeadband(){
        NetworkTableEntry tx = table.getEntry("tx");
        return (tx.getDouble(0.0) > -5 && tx.getDouble(0.0) < 5 && canSeeTarget());
    }

    public boolean shooterUpToSpeed(){
        double error = Math.abs(shooterParent.getClosedLoopError());
        System.out.println("Error: " + error);
        if(error < 250){
            return true;
        }
        return false;
    }

    public void target () {
        isAiming = true;
        System.out.println("Shooter can see target " + canSeeTarget());
        //controller = new PIDController(SmartDashboard.getNumber("shooterP", 0.1),SmartDashboard.getNumber("shooterI", 0.01),SmartDashboard.getNumber("shooterD", 0));

        if (canSeeTarget()) {
            double x = getX();
            double output = controller.calculate(x, 0);
            if (output > 0.6) output = 0.6;
            if (output < -0.6) output = -0.6;

            Drive.rightParent.set(ControlMode.PercentOutput, -output);
            Drive.leftParent.set(ControlMode.PercentOutput, output);

        } else {
            Drive.leftParent.set(ControlMode.PercentOutput, 0);
            Drive.rightParent.set(ControlMode.PercentOutput, 0);
            System.out.println("Set");
        }
    }

    public void runIndexer(){
        indexer.set(ControlMode.PercentOutput, .7);
    }

    public void stopIndexer(){
        indexer.set(ControlMode.PercentOutput, 0);
    }

    public double getThor (){
        NetworkTableEntry thor = table.getEntry("thor0");
        return thor.getDouble(0.0);
    }

    @Override
    protected void initDefaultCommand() {

    }
}