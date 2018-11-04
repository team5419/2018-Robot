package org.usfirst.frc.team5419.robot.subsystems;

import org.usfirst.frc.team5419.robot.OI;
import org.usfirst.frc.team5419.robot.RobotMap;

import org.usfirst.frc.team5419.robot.commands.DriveCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class ClosedDriveTrain extends Subsystem {
	TalonSRX leftBackMotor = new TalonSRX(RobotMap.leftBackMotor);	
	TalonSRX rightBackMotor = new TalonSRX(RobotMap.rightBackMotor);
	TalonSRX leftFrontMotor = new TalonSRX(RobotMap.leftFrontMotor);
	TalonSRX rightFrontMotor = new TalonSRX(RobotMap.rightFrontMotor);
	
//	SpeedControllerGroup left = new SpeedControllerGroup(leftFrontMotor, leftBackMotor);
//	SpeedControllerGroup right = new SpeedControllerGroup(rightFrontMotor, rightBackMotor);
//	DifferentialDrive drive = new DifferentialDrive(left, right);
	
	public ClosedDriveTrain() {
		super();
		
		rightFrontMotor.set(ControlMode.Follower, RobotMap.rightBackMotor);
		leftFrontMotor.set(ControlMode.Follower, RobotMap.leftBackMotor);
	}
	
	public void drive() {
		this.setMotors(OI.driverStick.getRawAxis(1), OI.driverStick.getRawAxis(4));
	}
	
	public void driveForward(){
		this.setMotors(0.5, 0);
	}
	
	public void turn(int direction) {
		if(direction==1)
			this.setMotors(0, 0.6);
		else {
			this.setMotors(0, -0.6);
		}
	}
	
	public void stop() {
		this.setMotors(0, 0);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveCommand());
	}
	
	public void setMotors(double speed, double turn) {
		double targetPosRight = RobotMap.countsPerRev * 5.0 * (speed - turn);
		double targetPosLeft = RobotMap.countsPerRev * 5.0 * (speed + turn);
		
		rightBackMotor.set(ControlMode.MotionMagic, targetPosRight); 
		leftBackMotor.set(ControlMode.MotionMagic, targetPosLeft);
	}
}