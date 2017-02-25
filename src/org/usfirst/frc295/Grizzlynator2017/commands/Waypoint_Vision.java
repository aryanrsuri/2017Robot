package org.usfirst.frc295.Grizzlynator2017.commands;

import org.usfirst.frc295.Grizzlynator2017.Robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
*
*/
public class Waypoint_Vision extends Command
{

	private double _dTargetAngle;
	private double _dMove;
	private double _dRotation;
	public double _dCurvecurve;
	static double Kp = .04;
	static double START_TIME;
	public boolean _dTrack;
	static double INITIAL_ANGLE =15;
	public double _dDistanceTarget;
	static int WHEEL_SIZE;
	private double _dDistanceStart;
	public static NetworkTable oNetTable;
	

	public Waypoint_Vision(/* double time */double dDistance, double dMove, boolean dTrack)
	{

		_dMove = dMove;
		_dDistanceTarget = dDistance;
		_dTrack = dTrack;
		requires(Robot.sysDriveTrain);

		
		
		WHEEL_SIZE = 8;
		_dDistanceTarget = _dDistanceTarget / (WHEEL_SIZE * Math.PI);
		_dDistanceTarget = _dDistanceTarget * 4096;
		SmartDashboard.putNumber("TicksWanted", _dDistanceTarget);
		
	}


	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{

		// START_TIME = Timer.getFPGATimestamp();
		_dDistanceStart = Robot.sysDriveTrain.getDistance();
		oNetTable = NetworkTable.getTable("VisionBoard");
		
		
		
		Robot.ahrs.reset();
		Robot.ahrs.getYaw();
		
		Robot.sysDriveTrain.reset();
		
		_dTargetAngle = INITIAL_ANGLE;
	}


	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
		double dReadAngle;
		dReadAngle = oNetTable.getNumber("dAngle", 999);
		if(dReadAngle != 999){
			_dTargetAngle = dReadAngle;
		}
		SmartDashboard.putNumber("Aunr-rrauag Angle", _dTargetAngle );
		_dCurvecurve = _dTargetAngle - Robot.ahrs.getYaw(); 
		_dCurvecurve = (_dCurvecurve) * Kp;
		
		SmartDashboard.putNumber("Curve", -_dCurvecurve);
		SmartDashboard.putNumber("Angle", Robot.ahrs.getAngle());
		SmartDashboard.putNumber("Yaw", Robot.ahrs.getYaw());
		SmartDashboard.putNumber("_dTargetAngle", _dTargetAngle);

		// System.out.println("Fix Left Right Turning");
		if ((Math.abs(_dTargetAngle) > 2.0))
		{
			Robot.sysDriveTrain.arcadeDrive(_dMove, -_dCurvecurve);
		}
		else
		{
			Robot.sysDriveTrain.stop();
		}
		
		SmartDashboard.putNumber("Error", _dCurvecurve);
		SmartDashboard.putNumber("Rotation", _dRotation);
		System.out.println("Curve is  " + _dCurvecurve);
		System.out.print("Target angle is " + _dTargetAngle);

	}


	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished()
	{
			if (Math.abs(_dCurvecurve / Kp) < 2.0)
			{
				System.out.println("Found Gear Peg, now Giving Gear");
				
				return true;
			}
			else
			{
				return false;
			}
		}

//		if (_dTrack)
//		{
//			if (Robot.sysUltrasonic.SysUltrasonic() <= 15)
//			{
//				return true;
//			}
//		}
//		return ((Robot.sysDriveTrain.getDistance() - _dDistanceStart) >= _dDistanceTarget);
		

		  
	


	//Called once after isFinished returns true
	@Override
	protected void end()
	{
		Robot.sysDriveTrain.stop();
	}


	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
	}
}
