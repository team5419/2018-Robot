package org.usfirst.frc.team5419.robot.subsystems;

import org.usfirst.frc.team5419.robot.OI;
import org.usfirst.frc.team5419.robot.RobotMap;

import org.usfirst.frc.team5419.robot.commands.DriveCommand;
import org.usfirst.frc.team5419.robot.commands.intakeCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class intakeArm extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	WPI_TalonSRX intakeArm = new WPI_TalonSRX(RobotMap.intakeArm);
	

	public void run(int direction) {
		if (direction == 0) {
			intakeArm.set(0.25);
		} else {
			intakeArm.set(-0.25);
		}
	}

	public void stop() {
		intakeArm.set(0);
	}

	public void initDefaultCommand() {
		// setDefaultCommand(new DriveCommand());
	}
}