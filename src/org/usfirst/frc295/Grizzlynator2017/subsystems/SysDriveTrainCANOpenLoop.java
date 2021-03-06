package org.usfirst.frc295.Grizzlynator2017.subsystems;

import org.usfirst.frc295.Grizzlynator2017.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
*
*/
public class SysDriveTrainCANOpenLoop extends SysDriveTrain
{
	// DECLARE COMPONENTS OF THE DRIVETRAIN
	private CANTalon _escLeftFront;
	private CANTalon _escLeftBack;
	private CANTalon _escRightFront;
	private CANTalon _escRightBack;


	public SysDriveTrainCANOpenLoop()
	{
		super();

		// ==========================================================
		// SYS DRIVE TRAIN
		// ==========================================================
		_escLeftFront = new CANTalon(RobotMap.CAN_ESC_DRIVE_LEFT_FRONT);
		LiveWindow.addActuator("SysDriveTrain", "Esc Left Front", _escLeftFront);

		_escLeftBack = new CANTalon(RobotMap.CAN_ESC_DRIVE_LEFT_BACK);
		LiveWindow.addActuator("SysDriveTrain", "Esc Left Back", _escLeftBack);

		_escRightFront = new CANTalon(RobotMap.CAN_ESC_DRIVE_RIGHT_FRONT);
		LiveWindow.addActuator("SysDriveTrain", "Esc Right Front", _escRightFront);

		_escRightBack = new CANTalon(RobotMap.CAN_ESC_DRIVE_RIGHT_BACK);
		LiveWindow.addActuator("SysDriveTrain", "Esc Right Back", _escRightBack);

		_robotDrive = new RobotDrive(_escLeftFront, _escLeftBack, _escRightFront, _escRightBack);

		_robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
		_robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
		_robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		_robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);

		// If SetSafetyEnabled is false, then the SetExpiration doesn't matter.
		// These are safeties for the drive motors that shut them down if the
		// code goes for too long (1 second as specified by SetExpiration)
		// without setting the motor power.
		// It's there to protect you, from infinite code loops or usually during
		// debugging when you could set the motor speed and have a breakpoint
		// that
		// allows the robot to keep running without stopping or responding to
		// driver controls.
		_robotDrive.setSafetyEnabled(true);
		_robotDrive.setExpiration(0.25);

		// When using drive() -- The algorithm for steering provides a constant
		// turn radius for any normal speed range, both forward and backward.
		// Increasing m_sensitivity causes sharper turns for fixed values of
		// curve.
		// This function will most likely be used in an autonomous routine.
		// Not used in any other "drive" functions like tankDrive(),
		// arcadeDrive() ...
		_robotDrive.setSensitivity(0.5);

		// Used to scale the output - The values to drive the motor will be
		// scaled
		// by the value passed.
		_robotDrive.setMaxOutput(1.0);

		// DEFINE ENCODERS FOR THE DRIVETRAIN
		_encoDriveLeft = new Encoder(RobotMap.DIO_ENC_DRIVE_LEFT_CHAN1, RobotMap.DIO_ENC_DRIVE_LEFT_CHAN2, false,
				EncodingType.k4X);
		_encoDriveLeft.setDistancePerPulse(1.0);
		_encoDriveLeft.setPIDSourceType(PIDSourceType.kRate);
		LiveWindow.addSensor("SysDriveTrain", "Enco Drive Left", _encoDriveLeft);

		_encoDriveRight = new Encoder(RobotMap.DIO_ENC_DRIVE_RIGHT_CHAN1, RobotMap.DIO_ENC_DRIVE_RIGHT_CHAN2, false,
				EncodingType.k4X);
		_encoDriveRight.setDistancePerPulse(1.0);
		_encoDriveRight.setPIDSourceType(PIDSourceType.kRate);
		LiveWindow.addSensor("SysDriveTrain", "Enco Drive Right", _encoDriveRight);

	}
}
