package org.usfirst.frc295.Grizzlynator2017.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

//SysCANMotor is not a real subsystem since its abstract,
//but we can call it from other subsystems, if the functions
//are the same in all of the subsystems used
public abstract class SysCANTalonMotor extends Subsystem
{
	protected CANTalon _talonMaster;

	private double _dCurrentSetRpm = 0;
	private double _dCurrentSetPercentVbus = 0;


	@Override
	protected void initDefaultCommand()
	{

	}


	public synchronized double getRpm()
	{
		return _talonMaster.getSpeed();
	}


	/**
	 * Sets the RPM of the CAN Talon Controlled motor. The motor will then spin
	 * up to the set speed within a preset tolerance. Remember the the current
	 * speed of the motor so we can addRpm()
	 * 
	 * @param Set
	 *            flywheel RPM
	 */
	//
	//
	public synchronized void setRpm(double dRpm)
	{
		_talonMaster.changeControlMode(CANTalon.TalonControlMode.Speed);
		_dCurrentSetRpm = dRpm;
		_talonMaster.set(dRpm);
	}


	// this adds speed to the motor by taking the current speed and adding on a
	// new speed
	public synchronized void addRpm(double dAddRpm)
	{
		_dCurrentSetRpm = _dCurrentSetRpm + dAddRpm;
		_talonMaster.set(_dCurrentSetRpm);
	}


	// Do the same as above, but for the PercentVbusMode
	// dPercentVbus IS [-1,1] AND DOES NOT UTILIZE THE ENCODERS
	public synchronized void setPercentVbus(double dPercentVbus)
	{
		_talonMaster.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		_dCurrentSetPercentVbus = dPercentVbus;
		_talonMaster.set(_dCurrentSetPercentVbus);
	}


	public synchronized void addPercentVbus(double dAddPercentVbus)
	{
		_dCurrentSetPercentVbus = _dCurrentSetPercentVbus + dAddPercentVbus;
		_talonMaster.set(_dCurrentSetPercentVbus);
	}

	// from here down, we copied and pasted all of the common functions
	// between the subsystems we are using when we call SysCANMotor and
	// deleted it in those subsystems because we don't want to repeat it


	public synchronized double getSetpoint()
	{
		return _talonMaster.getSetpoint();
	}


	public synchronized void stop()
	{
		setPercentVbus(0);
	}


	public void zeroSensors()
	{
		// no-op
	}

	// you don't copy and paste the smart dashboard function
	// because the subsystems will have different outputs
	// exclusive to only that specific subsystem
	// for ex: SmartDashboard.putNumber("lift_rpm", getRpm());
	// will only work on the SysLift subsystem
}
