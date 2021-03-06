package org.usfirst.frc295.Grizzlynator2017.subsystems;

import org.usfirst.frc295.Grizzlynator2017.RobotMap;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
*
*/
public class SysDriveTrainProto extends SysDriveTrain
{
	// DRIVE
	private SpeedController _escLeftFront;
	private SpeedController _escLeftBack;
	private SpeedController _escRightFront;
	private SpeedController _escRightBack;


	public SysDriveTrainProto()
	{
		super();

		// ==========================================================
		// SYS DRIVE TRAIN
		// ==========================================================
		_escLeftFront = new VictorSP(RobotMap.PWM_ESC_DRIVE_LEFT_FRONT);
		LiveWindow.addActuator("SysDriveTrain", "Esc Left Front", (VictorSP) _escLeftFront);

		_escLeftBack = new VictorSP(RobotMap.PWM_ESC_DRIVE_LEFT_BACK);
		LiveWindow.addActuator("SysDriveTrain", "Esc Left Back", (VictorSP) _escLeftBack);

		_escRightFront = new VictorSP(RobotMap.PWM_ESC_DRIVE_RIGHT_FRONT);
		LiveWindow.addActuator("SysDriveTrain", "Esc Right Front", (VictorSP) _escRightFront);

		_escRightBack = new VictorSP(RobotMap.PWM_ESC_DRIVE_RIGHT_BACK);
		LiveWindow.addActuator("SysDriveTrain", "Esc Right Back", (VictorSP) _escRightBack);

		_robotDrive = new RobotDrive(_escLeftFront, _escLeftBack, _escRightFront, _escRightBack);

		_robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		_robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		_robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		_robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

		_robotDrive.setSafetyEnabled(true);
		_robotDrive.setExpiration(0.1);
		_robotDrive.setSensitivity(0.5);
		_robotDrive.setMaxOutput(1.0);

		// DEFINE ENCODERS FOR THE DRIVETRAIN
		_encoDriveRight = new Encoder(RobotMap.DIO_ENC_DRIVE_RIGHT_CHAN1, RobotMap.DIO_ENC_DRIVE_RIGHT_CHAN2, false,
				EncodingType.k4X);
		LiveWindow.addSensor("SysDriveTrain", "Enco Drive Right", _encoDriveRight);
		_encoDriveRight.setDistancePerPulse(1.0);
		_encoDriveRight.setPIDSourceType(PIDSourceType.kRate);

		_encoDriveLeft = new Encoder(RobotMap.DIO_ENC_DRIVE_LEFT_CHAN1, RobotMap.DIO_ENC_DRIVE_LEFT_CHAN2, false,
				EncodingType.k4X);
		LiveWindow.addSensor("SysDriveTrain", "Enco Drive Left", _encoDriveLeft);
		_encoDriveLeft.setDistancePerPulse(1.0);
		_encoDriveLeft.setPIDSourceType(PIDSourceType.kRate);
	}
}
