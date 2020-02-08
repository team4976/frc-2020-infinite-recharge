package frc.robot.commands.auto;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drive;

public class MoveToPoint extends Command {

    int counts;
    boolean hasMoved;

    public MoveToPoint(double distance){
        counts = (int)(15177.36 * distance);
    }
    public void initialize(){
        Drive.shifter.set(DoubleSolenoid.Value.kReverse);
        Drive.leftParent.selectProfileSlot(0, 0);
        Drive.rightParent.selectProfileSlot(0, 0);
        Drive.leftParent.configMotionCruiseVelocity(3416);
        Drive.leftParent.configMotionAcceleration(5000);
        Drive.rightParent.configMotionAcceleration(5000);
        Drive.rightParent.configMotionCruiseVelocity(3416);

        Drive.leftParent.setSelectedSensorPosition(0);
        Drive.rightParent.setSelectedSensorPosition(0);

        Drive.leftParent.set(ControlMode.MotionMagic, counts);
        Drive.rightParent.set(ControlMode.MotionMagic, counts);
    }

    @Override
    protected boolean isFinished() {
//        if (Drive.leftParent.getSelectedSensorVelocity() > 10){
//            hasMoved = true;
//        }
//        if (Drive.leftParent.getSelectedSensorVelocity() == 0 && hasMoved){
//            hasMoved = false;
//            return true;
//        }else{
//            return false;
//        }
        boolean finish = Math.abs(Drive.leftParent.getSelectedSensorPosition()) > (Math.abs(counts) - 100);


        System.out.println(finish + " " + counts + " " + Drive.leftParent.getSelectedSensorPosition());


        if(finish){
            Drive.leftParent.setSelectedSensorPosition(0);
            Drive.rightParent.setSelectedSensorPosition(0);
        }
        return finish;
    }
}