package org.usfirst.frc.team7634.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7634.robot.Robot;
import org.usfirst.frc.team7634.robot.RobotSettings;
import org.usfirst.frc.team7634.robot.subsystems.DriveTrain;

public class DriveStraightCommand extends Command {

    public DriveTrain drive = Robot.driveTrain;
    public static double error_integral = 0.0;
    private int seconds_run;
    private boolean shouldReset = false;
    private double driveSpeed = RobotSettings.DEFAULT_AUTONOMOUS_DRIVE_SPEED;
    /**
     * @param secs Input as seconds for how long to drive straight for.
     * */
    public DriveStraightCommand(double secs, double speed, boolean resetGyro) {
        this.seconds_run = (int) (secs * 50);  //converts argument to seconds (which is 1/50 of a sec), refer to Robot#timer for information
        this.shouldReset = resetGyro;
        this.driveSpeed = speed;
        requires(Robot.driveTrain);
    }

    public DriveStraightCommand(double secs) {
        this.seconds_run = (int) (secs * 50); //converts argument to seconds (which is 1/50 of a sec), refer to Robot#timer for information
        this.shouldReset = false;
        requires(Robot.driveTrain);
    }


    protected void initialize() {
        Robot.timer = 0;
        if (shouldReset) {
            drive.gyro.reset();
        }
    }

    /**
     * Calculates deviation from correct angle (0 degrees) and corrects it using PID.
     * */
    @Override
    protected void execute() {
        drive.error_angle = -drive.gyro.getAngle();
        this.error_integral += (drive.error_angle * 0.02);
        double output = (drive.kP * drive.error_angle) + (drive.kI * this.error_integral);
        drive.driveStraight(this.driveSpeed, output);

        //System.out.println("error angle: " + drive.error_angle);
        //System.out.println("Injected drive: " + output);
        //System.out.println("@ " + drive.error_angle + "degrees | " + this.error_integral + " integral");
        //System.out.println("Current heading: " + drive.gyro.getAngle());
    }

    @Override
    protected boolean isFinished() {
        return stop();
    }

    private boolean stop() {
        if (Robot.timer > this.seconds_run) {
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
