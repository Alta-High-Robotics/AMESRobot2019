package org.usfirst.frc.team7634.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team7634.robot.RobotMap;
import org.usfirst.frc.team7634.robot.RobotSettings;
import org.usfirst.frc.team7634.robot.commands.ClawMovementCommand;

public class CubeGrabber extends Subsystem {

    Victor claw1 = new Victor(RobotMap.GRABBER_MOTOR1);
    Victor claw2 = new Victor(RobotMap.GRABBER_MOTOR2);
    SpeedControllerGroup grabber = new SpeedControllerGroup(claw1, claw2);

    public void grab(double speed) {
		grabber.set(speed * RobotSettings.GRABBER_INTAKE_SPEED);
    }

    public void release(double speed) {
		grabber.set(-speed * RobotSettings.GRABBER_RELEASE_SPEED);
    }

    @Override
    protected void initDefaultCommand() {
		setDefaultCommand(new ClawMovementCommand());
    }
}
