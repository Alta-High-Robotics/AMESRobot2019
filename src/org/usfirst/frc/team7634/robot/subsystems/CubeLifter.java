package org.usfirst.frc.team7634.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team7634.robot.RobotMap;

public class CubeLifter extends Subsystem {

    public double liftPos = 0.0; //work on lift position later, for now, no function

    public Victor liftMotor = new Victor(RobotMap.WINCH_VICTOR);

    public void raise() {
        liftMotor.set(1);
    }

    public void lower() {
        liftMotor.set(-1);
    }

    public void stop() {
        liftMotor.set(0);
    }

    @Override
    protected void initDefaultCommand() {
        //perhaps put a lower command, but for now the lifter has to be at the bottom or code will break.
    }
}
