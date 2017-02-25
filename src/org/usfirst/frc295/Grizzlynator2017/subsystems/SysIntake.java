//always have someone else makes commands for the subsystems
//you make, so that way the subsystem is versatile and can
//work with any command that is made for it; you don't want to
//make a command to fit exclusively to the functions within your subsystem
package org.usfirst.frc295.Grizzlynator2017.subsystems;

import org.usfirst.frc295.Grizzlynator2017.RobotMap;
import org.usfirst.frc295.Grizzlynator2017.commands.CmdIntakeDefault;
import org.usfirst.frc295.Grizzlynator2017.commands.CmdLiftDefault;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SysIntake extends SysCANTalonMotor
{
	public SysIntake()
	{

		super();

		_talonMaster = new CANTalon(RobotMap.CAN_ESC_INTAKE);
		_talonMaster.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		_talonMaster.reverseSensor(false);
		_talonMaster.configEncoderCodesPerRev(4096);
		_talonMaster.configNominalOutputVoltage(+0.0f, -0.0f);
		_talonMaster.configPeakOutputVoltage(12.0f, -12.0f);

		_talonMaster.setProfile(0);
		/*
		 * _talonMaster.setPID( RobotMap.FLYWHEEL_KP, RobotMap.FLYWHEEL_KI,
		 * RobotMap.FLYWHEEL_KD, RobotMap.FLYWHEEL_KF, RobotMap.FLYWHEEL_IZONE,
		 * RobotMap.FLYWHEEL_RAMP_RATE, 0);
		 */

		_talonMaster.setVoltageRampRate(36.0);
		_talonMaster.clearStickyFaults();
		_talonMaster.enableBrakeMode(false);
		_talonMaster.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

	}


	@Override
	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// DEFAULT FOR THIS SUBSYSTEM IS TO STOP THE LIFT
		setDefaultCommand(new CmdIntakeDefault());
	}


	public void outputToSmartDashboard()
	{
		SmartDashboard.putNumber("intake_rpm", getRpm());
		SmartDashboard.putNumber("intake_setpoint", _talonMaster.getSetpoint());
		// SmartDashboard.putBoolean("intake_on_target", isOnTarget());
		SmartDashboard.putNumber("intake_master_current", _talonMaster.getOutputCurrent());
	}

}