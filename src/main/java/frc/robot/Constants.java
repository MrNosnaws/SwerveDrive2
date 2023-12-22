// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Rotation2d;
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
    public static double TALONFX_TICKS_PER_ROTATION = 1;
    public static double MAX_VELOCITY = (FALCON300_ROUNDS_PER_MINUTE / 60) * DRIVE_REDUCTION * WHEEL_DIAMETER * Math.PI; //need real

    public static double NEO_ROUNDS_PER_MINUTE = 5676;
    public static double CICADA_MAX_VELOCITY = (NEO_ROUNDS_PER_MINUTE / 60) * DRIVE_REDUCTION * WHEEL_DIAMETER * Math.PI;
    
    public static double STEER_CONVERTION = ((2 * Math.PI) / TALONFX_TICKS_PER_ROTATION) * STEER_REDUCTION;
    public static double DRIVE_POSITION_CONVERSION = ((Math.PI*WHEEL_DIAMETER) / TALONFX_TICKS_PER_ROTATION) * DRIVE_REDUCTION;
    public static double DRIVE_VELOCITY_CONVERSION = DRIVE_POSITION_CONVERSION / 60; //assumes encoder ticks represent one minute
    public static double CICADA_DRIVETRAIN_TRACKWIDTH_METERS = 0;
    public static double CICADA_DRIVETRAIN_WHEELBASE_METERS = 0;
    public static double MAX_ANGULAR_VELOCITY = Math.PI * 6;

    public static Translation2d frontLeftTranslation = new Translation2d(0.4, 0.4);
    public static Translation2d frontRightTranslation = new Translation2d(0.4, -0.4);
    public static Translation2d backLeftTranslation = new Translation2d(-0.4, 0.4);
    public static Translation2d backRightTranslation = new Translation2d(-0.4, -0.4);

    public static Translation2d cicadaFrontLeftTranslation = new Translation2d(CICADA_DRIVETRAIN_TRACKWIDTH_METERS / 2.0, CICADA_DRIVETRAIN_WHEELBASE_METERS / 2.0);
    public static Translation2d cicadaFrontRightTranslation = new Translation2d(CICADA_DRIVETRAIN_TRACKWIDTH_METERS / 2.0, CICADA_DRIVETRAIN_WHEELBASE_METERS / 2.0);
    public static Translation2d cicadaBackLeftTranslation = new Translation2d(CICADA_DRIVETRAIN_TRACKWIDTH_METERS / 2.0, CICADA_DRIVETRAIN_WHEELBASE_METERS / 2.0);
    public static Translation2d cicadaBackRightTranslation = new Translation2d(CICADA_DRIVETRAIN_TRACKWIDTH_METERS / 2.0, CICADA_DRIVETRAIN_WHEELBASE_METERS / 2.0);

    public static boolean driveInverted = true;
    public static boolean steerInverted = true;



    public static class CicadaCANIDs {
        public static final int FRONT_LEFT_MODULE_DRIVE_MOTOR = 12;
        public static final int FRONT_LEFT_MODULE_STEER_MOTOR = 11;
        public static final int FRONT_LEFT_MODULE_STEER_ENCODER = 10;
        public static final Rotation2d FRONT_LEFT_MODULE_STEER_OFFSET_RADIANS = new Rotation2d(4.335 - (Math.PI / 2));

        public static final int FRONT_RIGHT_MODULE_DRIVE_MOTOR = 3;
        public static final int FRONT_RIGHT_MODULE_STEER_MOTOR = 2;
        public static final int FRONT_RIGHT_MODULE_STEER_ENCODER = 1;
        public static final Rotation2d FRONT_RIGHT_MODULE_STEER_OFFSET_RADIANS = new Rotation2d(4.858 - (Math.PI / 2));

        public static final int BACK_LEFT_MODULE_DRIVE_MOTOR = 9;
        public static final int BACK_LEFT_MODULE_STEER_MOTOR = 8;
        public static final int BACK_LEFT_MODULE_STEER_ENCODER = 7;
        public static final Rotation2d BACK_LEFT_MODULE_STEER_OFFSET_RADIANS = new Rotation2d(1.612 - (Math.PI / 2));

        public static final int BACK_RIGHT_MODULE_DRIVE_MOTOR = 6;
        public static final int BACK_RIGHT_MODULE_STEER_MOTOR = 5;
        public static final int BACK_RIGHT_MODULE_STEER_ENCODER = 4;
        public static final Rotation2d BACK_RIGHT_MODULE_STEER_OFFSET_RADIANS = new Rotation2d(1.179 - (Math.PI / 2));
    }

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
