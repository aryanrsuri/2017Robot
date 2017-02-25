////if and when you receive a warning sign on any of
////these imports, just float over it and press on
////organize imports
//
//package org.usfirst.frc295.Grizzlynator2017.subsystems;
//
//import org.usfirst.frc295.Grizzlynator2017.RobotMap;
//
//import edu.wpi.first.wpilibj.Spark;
//import edu.wpi.first.wpilibj.command.Subsystem;
//
//public class SysAgitator extends Subsystem
//{
//
//	// agitator motors for 2017 build season is using two sparks
//	// instead of two Talons, sparks do not need any code to work
//	//private Spark _sparkMaster = new Spark(RobotMap.PWM_ESC_AGITATOR_MASTER);
////	private Spark _sparkFollower = new Spark(RobotMap.CAN_ESC_AGITATOR_FOLLOWER);
//
//
//	public SysAgitator()
//	{
//
//		super();
//
//		//_sparkMaster.getSpeed();
////		_sparkFollower.getSpeed();
//
//	}
//
//
//	@Override
//	protected void initDefaultCommand()
//	{
//
//	}
//
//
//	public synchronized double getRpm()
//	{
//		//return _sparkMaster.getSpeed();
//	}
//
//
//	public void Raiselift()
//	{
//
//	}
//
//	// SPEED IS [-1,1] AND DOES NOT UTILIZE THE ENCODERS
//
//	// since the agitator needs two motors to spin and
//	// both are going in opposite directions, set the speed
//	// of one talon as a regular speed, and the other as a
//	// negative speed in order to spin the other way
//
//
//	// negative speeds always spin left
//	// while positive speeds spin right
//	public synchronized void setOpenLoop(double speed)
//	{
//		//_sparkMaster.set(speed);
//		//_sparkFollower.set(-speed);
//	}
//
//
//	public synchronized void stop()
//	{
//		setOpenLoop(0);
//	}
//
//
//	public void outputToSmartDashboard()
//	{
//
//	}
//
//}
