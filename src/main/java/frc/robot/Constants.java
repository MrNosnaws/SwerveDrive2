// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    double drivetrainTrackwidthMeters = Units.inchesToMeters(22.5);
    double drivetrainWheelBaseMeters = Units.inchesToMeters(23.25);

    int frontLeftModuleDriveMotor = 4;
    int frontLeftModuleSteerMotor = 6;
    int frontLeftModuleEncoder = 5;
    double frontLeftModuleSteerOffsetRadians = Math.toRadians(217.6);
  }
  public static class SwerveConstants {
    public double wheelDiamiter = 0.1016;
    public double driveReduction = (14.0 / 50.0) * (28.0 / 16.0) * (15.0 / 60.0);
    public static boolean driveInverted = true;
    public static boolean steerInverted = true;
    double steerReduction = (15.0 / 32.0) * (10.0 / 60.0);
    double falcon300RoundsPerMinute = 6380;
    double ticksPerRotations = 2048;


  }
}
