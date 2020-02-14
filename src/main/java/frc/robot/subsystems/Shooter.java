package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Shooter extends Subsystem {
    public TalonSRX shooterParent = new TalonSRX(45);
    public TalonSRX shooterChild = new TalonSRX(46);
    public TalonSRX indexer = new TalonSRX(47);
    public boolean isAiming;
    public PIDController controller = new PIDController(0.1,0,0.01); //p = .1, i = 0, d = 0
    public PIDController shooter = new PIDController(0.1, 0, 0);

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

    public double getX(){
        NetworkTableEntry tx = table.getEntry("tx");
        return tx.getDouble(0.0);
    }

    public boolean canSeeTarget (){
        NetworkTableEntry tv = table.getEntry("tv");
        return tv.getDouble(0) > 0;
    }

    public void shoot(){
        shooterParent.set(ControlMode.PercentOutput, 0.7);
        shooterChild.set(ControlMode.PercentOutput, 0.7);
    }

    public void stopShoot(){
        shooterParent.set(ControlMode.PercentOutput, 0);
        shooterChild.set(ControlMode.PercentOutput, 0);
    }

    public boolean withinDeadband(){
        NetworkTableEntry tx = table.getEntry("tx");
        return (tx.getDouble(0.0) > -5 && tx.getDouble(0.0) < 5 && canSeeTarget());
    }

    public void target () {
        isAiming = true;
        System.out.println("Shooter can see target " + canSeeTarget());
        if (canSeeTarget()) {
            double x = getX();
            double output = controller.calculate(x, 0);
            if (output > 0.5) output = 0.5;
            if (output < -0.5) output = -0.5;

            Drive.rightParent.set(ControlMode.PercentOutput, output);
            Drive.leftParent.set(ControlMode.PercentOutput, -output);

//            double shooterOutput =  shooter.calculate(((-indexer.getSelectedSensorPosition()/2048)*600)/1.75,  11000);
//            shooterParent.set(ControlMode.PercentOutput, .7);
//            shooterChild.set(ControlMode.PercentOutput, .7);

        } else {
            shooterParent.set(ControlMode.PercentOutput, 0);
            shooterChild.set(ControlMode.PercentOutput, 0);
            Drive.leftParent.set(ControlMode.PercentOutput, 0);
            Drive.rightParent.set(ControlMode.PercentOutput, 0);
            System.out.println("Set");
        }
    }

    public void runIndexer(){
        indexer.set(ControlMode.PercentOutput, 1);
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