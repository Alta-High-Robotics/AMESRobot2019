package org.usfirst.frc.team7634.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team7634.robot.RobotMap;

public class BallReleaser extends Subsystem {

    Servo releaser = new Servo(RobotMap.SERVO_MOTOR);

    public void open() {
        releaser.set(1.0);
    }

    public void close() {
        releaser.set(0);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
