/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5419.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;


import org.usfirst.frc.team5419.robot.OI;
import org.usfirst.frc.team5419.robot.Robot;
import org.usfirst.frc.team5419.robot.RobotMap;

/**
 * An example command.  You can replace me with your own command.
 */
public class autoDriveCommand extends Command {
	double distance;
	int time_max;
	Timer timer;
	
	public autoDriveCommand(double distance) {
		requires(Robot.driveTrain);
		this.distance = distance;

	}
	
	public autoDriveCommand(double distance, int time) {
		// todo: remove
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		//Robot.driveTrain.leftBackMotor.reset();
		//Robot.driveTrain.rightBackMotor.reset();
		Robot.driveTrain.drive(this.distance);
	}

	@Override
	protected void execute() {
		//Robot.driveTrain.drive(this.distance);
		Robot.driveTrain.update();
	}

	@Override
	protected boolean isFinished() {
		return Robot.driveTrain.isFinished();
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
