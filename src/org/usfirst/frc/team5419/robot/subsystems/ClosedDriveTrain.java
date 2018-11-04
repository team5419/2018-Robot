package org.usfirst.frc.team5419.robot.subsystems;

import org.usfirst.frc.team5419.robot.OI;
import org.usfirst.frc.team5419.robot.RobotMap;

import org.usfirst.frc.team5419.robot.commands.DriveCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ClosedDriveTrain extends Subsystem {
	TalonSRX leftBackMotor = new TalonSRX(RobotMap.leftBackMotor);	
	TalonSRX rightBackMotor = new TalonSRX(RobotMap.rightBackMotor);
	TalonSRX leftFrontMotor = new TalonSRX(RobotMap.leftFrontMotor);
	TalonSRX rightFrontMotor = new TalonSRX(RobotMap.rightFrontMotor);
	
	public ClosedDriveTrain() {
		super();
		
		this.setUpTalon(rightBackMotor);
		this.setUpTalon(leftBackMotor);
		
		leftBackMotor.setSensorPhase(true);
		rightBackMotor.setInverted(true);
		
		rightFrontMotor.set(ControlMode.Follower, RobotMap.rightBackMotor);
		leftFrontMotor.set(ControlMode.Follower, RobotMap.leftBackMotor);
	}
	
	private void setUpTalon(TalonSRX talon) {
		talon.configSelectedFeedbackSensor(
				FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.PIDLoopIdx, RobotMap.TimeoutMs
		);
		
		talon.configNominalOutputForward(0, RobotMap.TimeoutMs);
		talon.configNominalOutputReverse(0, RobotMap.TimeoutMs);
		talon.configPeakOutputForward(1, RobotMap.TimeoutMs);
		talon.configPeakOutputReverse(-1, RobotMap.TimeoutMs);
		
		talon.selectProfileSlot(RobotMap.SlotIdx, RobotMap.PIDLoopIdx);
		talon.config_kF(0, 1023.0 / 5500, RobotMap.TimeoutMs);
		talon.config_kP(0, .1, RobotMap.TimeoutMs);
		talon.config_kI(0, 0, RobotMap.TimeoutMs);
		talon.config_kD(0, 0, RobotMap.TimeoutMs);
	}
	
	public void drive() {
		this.setMotors(OI.driverStick.getRawAxis(1), OI.driverStick.getRawAxis(4));
		
		SmartDashboard.putNumber("Current Speed Right", rightBackMotor.getSelectedSensorVelocity(RobotMap.PIDLoopIdx));
	}
	
	public void driveForward(){
		this.setMotors(0.5, 0);
	}
	
	public void turn(int direction) {
		if(direction==1) {
			this.setMotors(0, 0.6);
		} else {
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