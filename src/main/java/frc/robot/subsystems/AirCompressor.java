package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class AirCompressor extends Subsystem {

    Compressor compressor = new Compressor(10);

    public void compressorOn(){
        compressor.start();
    }

    public void compressorOff(){
        compressor.stop();
    }

    @Override
    protected void initDefaultCommand() {

    }
}
