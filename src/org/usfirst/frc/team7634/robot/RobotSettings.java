package org.usfirst.frc.team7634.robot;

public class RobotSettings {
    public static double
        //1.0 is equivalent to 100% speed.
        DRIVE_SPEED = 0.75, //1.0 max (100% of top speed)
        DRIVE_DIRECTION = -1, //negative to invert wheels
        DRIVE_SPEED_SLOW = 0.50, //slow speed is usually used when cube raiser is high

        GRABBER_INTAKE_SPEED = 0.6,
        GRABBER_RELEASE_SPEED = 0.7,

        LAUNCHER_SPEED = 0.85,
        LAUNCHER_DIRECTION = -1;

    public static void setDriveSpeed(double speed) {
        DRIVE_SPEED = speed;
    }
}
