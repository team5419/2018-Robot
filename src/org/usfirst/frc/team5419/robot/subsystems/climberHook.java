package org.usfirst.frc.team5419.robot.subsystems;

import org.usfirst.frc.team5419.robot.OI;
import org.usfirst.frc.team5419.robot.RobotMap;

import org.usfirst.frc.team5419.robot.commands.climberHookCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;


import edu.wpi.first.wpilibj.command.Subsystem;

public class climberHook extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	WPI_TalonSRX climberHook = new WPI_TalonSRX(RobotMap.climberHook);
	
	
	public void run() {
		climberHook.set(OI.operatorStick.getRawAxis(5)*1/4);
	}
	
	

	public void stop() {
		climberHook.set(0);
		
	}

	public void initDefaultCommand() {
		 setDefaultCommand(new climberHookCommand());
	}
}