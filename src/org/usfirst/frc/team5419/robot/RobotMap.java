package org.usfirst.frc.team5419.robot;

public class RobotMap {
	 public static int SlotIdx = 0;
	 public static int TimeoutMs = 10;
	 
	 public static int maxSpeed = 5189; // sensor units / 100ms
	 public static int Acceleration = 1000; // sensor units / 100ms / sec
	 
	 //PID Constants
	 
	 public static int PIDLoopIdx = 0;
	 public static double PIDkF = .1989;
	 public static double PIDkP = 1.111958 * .25;
	 public static double PIDkI = 0;
	 public static double PIDkD = 0;
	
	 public static int leftBackMotor = 9;   // 9
	 public static int rightBackMotor = 2;  // 2
	 public static int leftFrontMotor = 0;  // 0
	 public static int rightFrontMotor = 5; // ?
	 //When looking at robot from front
	 public static int intakeLeft = 3;    //3
	 public static int intakeRight = 8; //?
	 public static int intakeArm = 6;  //6
	 public static int climberWinch = 7; // not sure if this is right
	 public static int climberHook = 10;
	 public static int countsPerRev = 1024;
	 public static final double CIRCUMFERENCE = 5.0 * Math.PI;
}
