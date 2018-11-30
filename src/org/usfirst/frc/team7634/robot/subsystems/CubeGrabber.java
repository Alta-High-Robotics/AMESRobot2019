package org.usfirst.frc.team7634.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team7634.robot.RobotMap;

public class CubeGrabber extends Subsystem {

    Victor claw1 = new Victor(RobotMap.GRABBER_MOTOR1);
    Victor claw2 = new Victor(RobotMap.GRABBER_MOTOR2);
    SpeedControllerGroup grabber = new SpeedControllerGroup(claw1, claw2);

    public void grab() {

    }

    public void release() {

    }

    @Override
    protected void initDefaultCommand() {

    }
}
