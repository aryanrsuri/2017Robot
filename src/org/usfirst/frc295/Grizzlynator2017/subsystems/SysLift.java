package org.usfirst.frc295.Grizzlynator2017.subsystems;

import org.usfirst.frc295.Grizzlynator2017.RobotMap;
import org.usfirst.frc295.Grizzlynator2017.commands.CmdLiftDefault;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//when you're done with any subsystem you make
//make sure to add it into the Robot.java

//now that some of the functions in this subsystem are
//in the SysCANMotor, we don't have to repeat it here
//instead of extends subsystem, we use extends SysCANMotor
public class SysLift extends SysCANTalonMotor
{

	// since this subsystem uses two talons, you have to identify
	// it here and what their CAN ID number is on the robot
	private CANTalon _talonFollower;


	public SysLift()
	{
		super();
		_talonMaster = new CANTalon(RobotMap.CAN_ESC_LIFT_MASTER);
		_talonFollower = new CANTalon(RobotMap.CAN_ESC_LIFT_FOLLOWER);

		_talonMaster.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		_talonMaster.reverseSensor(false);
		_talonMaster.configEncoderCodesPerRev(1024);
		_talonMaster.configNominalOutputVoltage(+0.0f, -0.0f);
		_talonMaster.configPeakOutputVoltage(12.0f, 0);

		_talonMaster.setProfile(0);

		// PID stands for Proportional Integral Derivative
		// PID tuning helps control oscillations of the motor
		// and keeps the motor spinning at a constant speed
		// for a long period of time, helps it run smoothly

		// P value stands for proportional gain. (error)*100/(proportional band)
		// I value adds up all the past errors

		_talonMaster.setP(0.04);
		_talonMaster.setD(0);
		_talonMaster.setI(0.0002);
		// _talonMaster.setF(0.0342507);
		_talonMaster.setF(0.024);
		//
		// _talonMaster.setPID(
		// RobotMap.FLYWHEEL_KP,
		// RobotMap.FLYWHEEL_KI,
		// RobotMap.FLYWHEEL_KD,
		// RobotMap.FLYWHEEL_KF,
		// RobotMap.FLYWHEEL_IZONE,
		// RobotMap.FLYWHEEL_RAMP_RATE,
		// 0);

		_talonMaster.setVoltageRampRate(36.0);
		_talonMaster.clearStickyFaults();
		_talonMaster.enableBrakeMode(false);
		_talonMaster.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

		// this is to make sure that whatever mode we set for
		// the _talonMaster is the same for the _talonFollower
		_talonFollower.changeControlMode(CANTalon.TalonControlMode.Follower);
		_talonFollower.set(_talonMaster.getDeviceID());
	}


	@Override
	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// DEFAULT FOR THIS SUBSYSTEM IS TO STOP THE LIFT
		setDefaultCommand(new CmdLiftDefault());
	}


	public void outputToSmartDashboard()

	{
		SmartDashboard.putNumber("lift_rpm", getRpm());
		SmartDashboard.putNumber("lift_setpoint", _talonMaster.getSetpoint());
		// SmartDashboard.putBoolean("lift_on_target", isOnTarget());
		SmartDashboard.putNumber("lift_master_current", _talonMaster.getOutputCurrent());
	}

}