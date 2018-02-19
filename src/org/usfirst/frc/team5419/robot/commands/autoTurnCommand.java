/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5419.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5419.robot.OI;
import org.usfirst.frc.team5419.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class autoTurnCommand extends Command {
	int degrees;
	int direction;
	//1 for right, -1 for left
	public autoTurnCommand(int degrees, int direction) {
		requires(Robot.driveTrain);
		this.direction = direction;
		this.degrees = degrees;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		OI.gyro.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.driveTrain.turn(direction);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		int turned = (int) OI.gyro.getAngle();
		if(turned > degrees) {
			return true;
		}
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
