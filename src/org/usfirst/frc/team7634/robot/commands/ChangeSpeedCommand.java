package org.usfirst.frc.team7634.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7634.robot.Robot;

public class ChangeSpeedCommand extends Command {

	private double speed;

	public ChangeSpeedCommand(double designatedSpeed) {
		speed = designatedSpeed;
		requires(Robot.speedChanger);
	}

	protected void initialize() {

	}

	@Override
	protected void execute() {
		Robot.speedChanger.setSpeed(speed);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {
		end();
	}
}
