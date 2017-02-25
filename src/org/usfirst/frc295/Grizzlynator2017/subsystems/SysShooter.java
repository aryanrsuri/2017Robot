package org.usfirst.frc295.Grizzlynator2017.subsystems;

import org.usfirst.frc295.Grizzlynator2017.RobotMap;
import org.usfirst.frc295.Grizzlynator2017.commands.CmdShooterDefault;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The flywheel has several parameters: the RPM speed, the setpoint, and the RPM
 * tolerance. When told to, the flywheel will try to spin up to the setpoint
 * within the set RPM tolerance.
 */
public class SysShooter extends SysCANTalonMotor
{

	public SysShooter()
	{
		super();

		/*
		 * if (_talonMaster.isSensorPresent(CANTalon.FeedbackDevice.QuadEncoder)
		 * != CANTalon.FeedbackDeviceStatus.FeedbackStatusPresent) {
		 * DriverStation.reportError("Could not detect Flywheel encoder!",
		 * false); } else { DriverStation.reportError("Found Flywheel encoder!",
		 * false); }
		 */

		_talonMaster = new CANTalon(RobotMap.CAN_ESC_FLYWHEEL);
		_talonMaster.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		_talonMaster.reverseSensor(false);
		_talonMaster.configEncoderCodesPerRev(4096);

		_talonMaster.configNominalOutputVoltage(+0.0f, -0.0f);
		_talonMaster.configPeakOutputVoltage(12.0f, -12.0f);

		_talonMaster.setProfile(0);

		_talonMaster.setPID(RobotMap.FLYWHEEL_KP, RobotMap.FLYWHEEL_KI, RobotMap.FLYWHEEL_KD, RobotMap.FLYWHEEL_KF,
				RobotMap.FLYWHEEL_IZONE, RobotMap.FLYWHEEL_RAMP_RATE, 0);

		_talonMaster.setP(0.04);
		_talonMaster.setD(0);
		_talonMaster.setI(0.0002);
		// _talonMaster.setF(0.0342507);
		_talonMaster.setF(0.024);

		_talonMaster.clearStickyFaults();
		_talonMaster.enableControl();
		_talonMaster.setSafetyEnabled(false);

		_talonMaster.setVoltageRampRate(36.0);
		_talonMaster.clearStickyFaults();
		_talonMaster.enableBrakeMode(false);
		_talonMaster.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

		// IF WE HAVE A SLAVE CANTalon AS PART OF OUR FLYWHEEL
		/*
		 * _talonSlave = new CANTalon(RobotMap.CAN_ESC_FLYWHEEL_SLAVE);
		 * _talonSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		 * _talonSlave.set(RobotMap.CAN_ESC_FLYWHEEL_MASTER);
		 * _talonSlave.reverseOutput(true);
		 * _talonSlave.setVoltageRampRate(36.0);
		 * _talonSlave.enableBrakeMode(false); _talonSlave.clearStickyFaults();
		 */
	}


	@Override
	protected void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// DEFAULT FOR THIS SUBSYSTEM IS TO STOP THE Shooter
		setDefaultCommand(new CmdShooterDefault());

	}


	/**
	 * @return If the flywheel RPM is within the tolerance to the specified set
	 *         point.
	 */
	public synchronized boolean isOnTarget()
	{
		return ((_talonMaster.getControlMode() == CANTalon.TalonControlMode.Speed)
				&& (Math.abs(getRpm() - getSetpoint()) < RobotMap.FLYWHEEL_ONTARGET_TOLERANCE));
	}


	public void outputToSmartDashboard()
	{
		SmartDashboard.putNumber("flywheel_rpm", getRpm());
		SmartDashboard.putNumber("flywheel_setpoint", _talonMaster.getSetpoint());
		SmartDashboard.putBoolean("flywheel_on_target", isOnTarget());
		SmartDashboard.putNumber("flywheel_master_current", _talonMaster.getOutputCurrent());
	}
}
