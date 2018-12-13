package org.usfirst.frc.team7634.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7634.robot.Robot;
import org.usfirst.frc.team7634.robot.RobotSettings;

public class AutoLauncherCommand extends Command {

    public AutoLauncherCommand() {
        requires(Robot.ballReleaser);
        requires(Robot.ballLauncher);
    }

    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.ballLauncher.spin(RobotSettings.LAUNCHER_SPEED * RobotSettings.LAUNCHER_DIRECTION);
        if (this.spinningFinish()) {
            Robot.ballReleaser.open();
        }
    }

    @Override
    protected boolean isFinished() {
        return checkForFinish();
    }

    private boolean checkForFinish() {
        int trial_one = RobotSettings.convertSecondsToTimerUnit(RobotSettings.TRIAL_ONE);
        int ball_launch = RobotSettings.convertSecondsToTimerUnit(RobotSettings.BALL_LAUNCH);
        if (Robot.timer > (trial_one + ball_launch)) {
            return true;
        }
        return false;
    }

    private boolean spinningFinish() {
        int trial_one = RobotSettings.convertSecondsToTimerUnit(RobotSettings.TRIAL_ONE);
        int ball_launch = RobotSettings.convertSecondsToTimerUnit(RobotSettings.BALL_LAUNCH);
        if (Robot.timer > (trial_one + (ball_launch * 0.3))) {
            return true;
        }
        return false;
    }

    @Override
    protected void end() {
        Robot.ballLauncher.stop();
        Robot.ballReleaser.close();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
