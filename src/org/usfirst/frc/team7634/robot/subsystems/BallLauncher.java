package org.usfirst.frc.team7634.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team7634.robot.RobotMap;

public class BallLauncher extends Subsystem {

    Victor launcher = new Victor(RobotMap.LAUNCHER_VICTOR);
    public boolean spinning = false;

    public void spin(double speed) {
        launcher.set(speed);
    }

    public void stop() {
        launcher.set(0);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
