package org.usfirst.frc.team5419.robot.subsystems;

import org.usfirst.frc.team5419.robot.OI;
import org.usfirst.frc.team5419.robot.RobotMap;

import org.usfirst.frc.team5419.robot.commands.DriveCommand;
import org.usfirst.frc.team5419.robot.commands.intakeCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Intake extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	WPI_TalonSRX intake = new WPI_TalonSRX(RobotMap.intakeLeft);
	WPI_TalonSRX intakeReversed = new WPI_TalonSRX(RobotMap.intakeRight);
	

	public void run(int direction) {
		if (direction == 0) {
			intake.set(0.6);
			intakeReversed.set(-0.6);
		} else {
			intake.set(-0.5);
			intakeReversed.set(0.5);
		}
	}
	
	public void outtakeAuto() {
		intake.set(-0.5);
		intakeReversed.set(0.5);
	}

	public void stop() {
		intake.set(0);
		intakeReversed.set(0);
	}

	public void initDefaultCommand() {
		// setDefaultCommand(new DriveCommand());
	}
}