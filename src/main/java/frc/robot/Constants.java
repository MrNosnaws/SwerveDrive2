// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
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
    public static double WHEEL_DIAMETER = 0.1016;
    public static double DRIVE_REDUCTION = (14.0 / 50.0) * (28.0 / 16.0) * (15.0 / 60.0);
    public static double STEER_REDUCTION = (15.0 / 32.0) * (10.0 / 60.0);
    public static double FALCON300_ROUNDS_PER_MINUTE = 6380;
    public static double TALONFX_VELOCITY_CONSTANT = 217;
    public static double TALONFX_TICKS_PER_ROTATION = 1; //need real
    public static double MAX_VELOCITY = (FALCON300_ROUNDS_PER_MINUTE / 60) * DRIVE_REDUCTION * WHEEL_DIAMETER * Math.PI; //need real

    public static double STEER_CONVERTION = ((2 * Math.PI) / TALONFX_TICKS_PER_ROTATION) * STEER_REDUCTION;
    public static double DRIVE_POSITION_CONVERSION = ((Math.PI*WHEEL_DIAMETER) / TALONFX_TICKS_PER_ROTATION) * DRIVE_REDUCTION;
    public static double DRIVE_VELOCITY_CONVERSION = DRIVE_POSITION_CONVERSION / 60; //assumes encoder ticks represent one minute
    
    public static Translation2d frontLeftTranslation = new Translation2d(0.4, 0.4);
    public static Translation2d frontRightTranslation = new Translation2d(0.4, -0.4);
    public static Translation2d backLeftTranslation = new Translation2d(-0.4, 0.4);
    public static Translation2d backRightTranslation = new Translation2d(-0.4, -0.4);

    public static boolean driveInverted = true;
    public static boolean steerInverted = true;

    public static class Channels {
      public static int FRONT_LEFT_DRIVE_MOTOR_CHANNEL = 0;
      public static int FRONT_RIGHT_DRIVE_MOTOR_CHANNEL = 0;
      public static int BACK_LEFT_DRIVE_MOTOR_CHANNEL = 0;
      public static int BACK_RIGHT_DRIVE_MOTOR_CHANNEL = 0;

      public static int FRONT_LEFT_STEER_MOTOR_CHANNEL = 0;
      public static int FRONT_RIGHT_STEER_MOTOR_CHANNEL = 0;
      public static int BACK_LEFT_STEER_MOTOR_CHANNEL = 0;
      public static int BACK_RIGHT_STEER_MOTOR_CHANNEL = 0;

      public static int FRONT_LEFT_CANCODER_CHANNEL = 0;
      public static int FRONT_RIGHT_CANCODER_CHANNEL = 0;
      public static int BACK_LEFT_CANCODER_CHANNEL = 0;
      public static int BACK_RIGHT_CANCODER_CHANNEL = 0;
      }
  }
}
