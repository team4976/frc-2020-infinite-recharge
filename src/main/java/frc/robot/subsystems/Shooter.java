package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.Robot;

public class Shooter extends Subsystem {
    public TalonSRX ShooterParent  = new TalonSRX(47);
    public TalonSRX ShooterChild = new TalonSRX(60);
    public TalonSRX Indexer = new TalonSRX(62);
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

    public double getThor (){
        NetworkTableEntry thor = table.getEntry("thor0");
        return thor.getDouble(0.0);
    }

    public void getPID() {

    }

    double distanceRPM = getThor()*41.18;

    public void target (){
        System.out.println("Shooter can see target " + canSeeTarget());
        if (canSeeTarget()){
            double x = getX();
            double output = -controller.calculate(x, 0);
            Robot.rightFront.set(ControlMode.PercentOutput, output);
            Robot.rightBack.set(ControlMode.PercentOutput,output);
            Robot.leftBack.set(ControlMode.PercentOutput,output);
            Robot.leftFront.set(ControlMode.PercentOutput,output);

            double shooterOutput =  shooter.calculate(((-ShooterParent.getSelectedSensorPosition()/2048)*600)/1.75,  distanceRPM);
            System.out.println("RPM boi is " + distanceRPM);
            //ShooterParent.set(ControlMode.PercentOutput, .9);
            //ShooterChild.set(ControlMode.PercentOutput, .9);

        }else{
            //ShooterParent.set(ControlMode.PercentOutput, 0);
            //ShooterChild.set(ControlMode.PercentOutput, 0);
            Robot.leftFront.set(ControlMode.PercentOutput,0);
            Robot.leftBack.set(ControlMode.PercentOutput,0);
            Robot.rightBack.set(ControlMode.PercentOutput,0);
            Robot.rightFront.set(ControlMode.PercentOutput,0);
        }
    }

    @Override
    protected void initDefaultCommand() {

    }
}