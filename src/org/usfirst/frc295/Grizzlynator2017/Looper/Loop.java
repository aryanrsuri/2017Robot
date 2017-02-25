package org.usfirst.frc295.Grizzlynator2017.Looper;

/**
 * Interface for loops, which are routine that run periodically in the robot
 * code (such as periodic gyroscope calibration, etc.)
 */

public interface Loop
{
	public void onStart();


	public void onLoop();


	public void onStop();
}
