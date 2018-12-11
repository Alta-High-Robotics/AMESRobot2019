package org.usfirst.frc.team7634.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7634.robot.Robot;
import org.usfirst.frc.team7634.robot.RobotSettings;
import org.usfirst.frc.team7634.robot.subsystems.DriveTrain;

public class DriveStraightCommand extends Command {

    public DriveTrain drive = Robot.driveTrain;
    public static double error_integral = 0.0;

    public DriveStraightCommand() {
        requires(Robot.ballReleaser);
    }

    protected void initialize() {
        drive.gyro.reset();
    }

    /**
     * Calculates deviation from correct angle (0 degrees) and corrects it using PID.
     * */
    @Override
    protected void execute() {
        drive.error_angle = -drive.gyro.getAngle();
        this.error_integral += (drive.error_angle * 0.02);
        //System.out.println("error angle: " + drive.error_angle);

        double output = (drive.kP * drive.error_angle) + (drive.kI * this.error_integral);
        drive.driveStraight(output);
        //System.out.println("Injected drive: " + output);
        //System.out.println("@ " + drive.error_angle + "degrees | " + this.error_integral + " integral");
        //System.out.println("Current heading: " + drive.gyro.getAngle());
    }

    @Override
    protected boolean isFinished() {
        return stop();
    }

    public boolean stop() {
        if (Robot.timer > RobotSettings.TRIAL_ONE) {
            return true;
        }
        return false;
    }

    @Override
    protected void end() {
        drive.drive.stopMotor();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
