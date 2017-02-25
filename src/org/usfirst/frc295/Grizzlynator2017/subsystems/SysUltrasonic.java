package org.usfirst.frc295.Grizzlynator2017.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SysUltrasonic
{

	boolean isPerpendicular = false;
	double conversionfactor = .009765625;

	AnalogInput UltrasonicSensor1 = new AnalogInput(0);
	int iUltrasonicSensor1raw;
	double UltrasonicSensor1volts;
	public double USsensor1DistanceInches;

	AnalogInput UltrasonicSensor2 = new AnalogInput(1);
	int UltrasonicSensor2raw;
	double UltrasonicSensor2volts;
	public double USsensor2DistanceInches;

	public static double FinalSensor1;
	public static double FinalSensor2;
	// public static SysVision sysVision;

	int _Cycles = 0;
	int _ErrorCycles = 0;


	public double SysUltrasonic()
	{
		// sysVision = new SysVision();
		iUltrasonicSensor1raw = UltrasonicSensor1.getValue();
		UltrasonicSensor1volts = UltrasonicSensor1.getVoltage();
		USsensor1DistanceInches = UltrasonicSensor1volts / conversionfactor;
		SmartDashboard.putNumber("Sensor1", USsensor1DistanceInches);
		System.out.println("Sensor1 " + USsensor1DistanceInches);

		UltrasonicSensor2raw = UltrasonicSensor2.getValue();
		UltrasonicSensor2volts = UltrasonicSensor2.getVoltage();
		USsensor2DistanceInches = UltrasonicSensor2volts / conversionfactor;
		SmartDashboard.putNumber("Sensor2", USsensor2DistanceInches);
		System.out.println("Sensor2 " + USsensor2DistanceInches);

		if ((Math.abs(FinalSensor1 - USsensor1DistanceInches) < 15)
				&& (Math.abs(FinalSensor2 - USsensor2DistanceInches) < 15))
		{
			if ((_Cycles == 0) || (_ErrorCycles > 5))
			{

				FinalSensor1 = USsensor1DistanceInches;
				FinalSensor2 = USsensor2DistanceInches;

				_ErrorCycles = 0;
			}
		}
		else
		{
			_ErrorCycles = _ErrorCycles + 1;
		}

		double dAvgDist = ((USsensor1DistanceInches + USsensor1DistanceInches) / 2);

		System.out.println(dAvgDist);
		// sysVision.Method1();
		// sysVision.Method2();
		SmartDashboard.putNumber("Sensor Reading", dAvgDist);
		return USsensor2DistanceInches;
	}
}
