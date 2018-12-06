package org.usfirst.frc.team7634.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team7634.robot.Robot;
import org.usfirst.frc.team7634.robot.RobotMap;
import org.usfirst.frc.team7634.robot.RobotSettings;

public class SpeedChanger extends Subsystem {

	public void setSpeed(double speed) {
		RobotSettings.setDriveSpeed(speed);
	}

	public void setDefaultSpeed() {
		setSpeed(Robot.driveTrain.initSpeed);
	}

	@Override
	protected void initDefaultCommand() {
		//perhaps put a lower command, but for now the lifter has to be at the bottom or code will break.
	}
}
