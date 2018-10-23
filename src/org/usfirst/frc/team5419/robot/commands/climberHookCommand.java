/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5419.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5419.robot.Robot;

public class climberHookCommand extends Command {
	

	public climberHookCommand() {
		requires(Robot.climberHook);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.climberHook.run();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.climberHook.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}
}