package org.usfirst.frc.team5419.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5419.robot.OI;
import org.usfirst.frc.team5419.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class autoDriveGroupLeft extends CommandGroup {
	public autoMap autoMap;
	String gameData;

	public autoDriveGroupLeft() {

		autoMap = new autoMap();
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.charAt(0) == 'L')
		{
			SmartDashboard.putBoolean("Left", true);

			addSequential(new autoDriveCommand(autoMap.midSwitchDistance));
			addSequential(new autoTurnCommand(90, 1));
			addSequential(new autoDriveCommand(24, 2));

			addSequential(new outtakeAutoCommand(autoMap.outtake_time));

		} else {
			
			SmartDashboard.putBoolean("Left", false);
			
			addSequential(new autoDriveCommand(autoMap.midSwitchDistance));
			
		}
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		//Robot.driveTrain.drive();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.driveTrain.stop();
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}