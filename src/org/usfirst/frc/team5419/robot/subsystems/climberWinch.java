package org.usfirst.frc.team5419.robot.subsystems;

import org.usfirst.frc.team5419.robot.OI;
import org.usfirst.frc.team5419.robot.RobotMap;

import org.usfirst.frc.team5419.robot.commands.DriveCommand;
import org.usfirst.frc.team5419.robot.commands.intakeArmCommand;
import org.usfirst.frc.team5419.robot.commands.intakeCommand;
import org.usfirst.frc.team5419.robot.commands.climberHookCommand;
import org.usfirst.frc.team5419.robot.commands.climberWinchCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class climberWinch extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	WPI_TalonSRX climberWinch = new WPI_TalonSRX(RobotMap.climberWinch);
	
	public void run(int whichWay) {
		//0 is winding up
		//1 is unwinding
		//climberWinch.set(0.5);
		if(whichWay == 0){
			climberWinch.set(-1.0);
		}
		else{
			climberWinch.set(0.75);
		}
		
	}

	public void stop() {
		climberWinch.set(0);
	}

	public void initDefaultCommand() {
		//setDefaultCommand(new climberWinchCommand());
	}
}