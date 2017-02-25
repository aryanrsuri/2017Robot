package org.usfirst.frc295.Grizzlynator2017.subsystems;

import edu.wpi.first.wpilibj.SensorBase;

/**
 * https://www.chiefdelphi.com/forums/showpost.php?p=1637362&postcount=1 It
 * appears as if the Read() and Transaction() always return the first value
 * returned by the device. I can confirm this is the pattern on the bus, due to
 * the logic analyser. So the problem has to be either the SDA pin is being
 * driven by the RoboRio (I2C Slave Periph is active on the same pins) or
 * somehow the Start/Stop/ReStart/ACK sequence is not being handled correctly
 * and the Lidar gets stuck in some way that repeats the answer to the first
 * request..which is really really weird.
 *
 * AddressOnly() // Doesn't appear to work at all Transaction() // Write portion
 * might work, but it reads back the same value all the time Read() // reads
 * back the same value all the time
 *
 * ReadOnly() // works fine WriteBulk() // Works fine Write() // Works fine, but
 * requires a write byte at a time
 *
 * I2CXL-MaxSonar
 */
public class MaxSonarI2CXL extends SensorBase
{
	private AddressibleI2C _i2cMaster;


	public MaxSonarI2CXL(int iDeviceAddress)
	{
		_i2cMaster = new AddressibleI2C(AddressibleI2C.Port.kOnboard, iDeviceAddress);
	}


	public void startRanging(byte bAddress)
	{
		boolean bWriteError = false;
		byte[] bRangeCommands = { (byte) 81 };

		// System.out.println("Start Ranging");
		bWriteError = _i2cMaster.writeBulk(bAddress, bRangeCommands);
		if (bWriteError)
		{
			System.out.println("I2C Sensor: Write Failed!");
		}
	}


	public int getDistance(byte bAddress)
	{
		boolean bReadError = false;
		byte[] bRangeReads = new byte[2];

		// System.out.println("Get Distance");
		bReadError = _i2cMaster.readOnly(bAddress, bRangeReads, 2);
		if (bReadError)
		{
			System.out.println("Read failed");
		}
		return (bRangeReads[0] << 8) | (bRangeReads[1] & 0xFF);
	}
}
