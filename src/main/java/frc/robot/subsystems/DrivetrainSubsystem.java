package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.swerve.SwerveDriveModule;
import frc.robot.Constants.SwerveConstants.Channels;

public class DrivetrainSubsystem extends SubsystemBase {

    private final SwerveDriveModule frontLeftWheel;
    private final SwerveDriveModule frontRightWheel;
    private final SwerveDriveModule backLeftWheel;
    private final SwerveDriveModule backRightWheel;

    private final SwerveDriveKinematics kinematics;

    public DrivetrainSubsystem () {
        frontLeftWheel = new SwerveDriveModule(Channels.FRONT_LEFT_DRIVE_MOTOR_CHANNEL, Channels.FRONT_LEFT_STEER_MOTOR_CHANNEL, Channels.FRONT_LEFT_CANCODER_CHANNEL);
        frontRightWheel = new SwerveDriveModule(Channels.FRONT_RIGHT_DRIVE_MOTOR_CHANNEL, Channels.FRONT_RIGHT_STEER_MOTOR_CHANNEL, Channels.FRONT_RIGHT_CANCODER_CHANNEL);
        backLeftWheel = new SwerveDriveModule(Channels.BACK_LEFT_DRIVE_MOTOR_CHANNEL, Channels.BACK_LEFT_STEER_MOTOR_CHANNEL, Channels.BACK_LEFT_CANCODER_CHANNEL);
        backRightWheel = new SwerveDriveModule(Channels.BACK_RIGHT_DRIVE_MOTOR_CHANNEL, Channels.BACK_RIGHT_STEER_MOTOR_CHANNEL, Channels.BACK_RIGHT_CANCODER_CHANNEL);

        kinematics = new SwerveDriveKinematics(
            new Translation2d(0.4, 0.4), //front left
            new Translation2d(0.4, -0.4), //front right
            new Translation2d(-0.4, 0.4), //back left
            new Translation2d(-0.4, -0.4) //back right
        );
    }
    
    public void drive(double xSpeed, double ySpeed, double radians) {
        ChassisSpeeds speeds = new ChassisSpeeds(xSpeed, ySpeed, radians);
        SwerveModuleState[] states = kinematics.toSwerveModuleStates(speeds);
        setModuleStates(states);
    }

    public void setModuleStates(SwerveModuleState[] states) {
        frontLeftWheel.setState(states[0]);
        frontRightWheel.setState(states[1]);
        backLeftWheel.setState(states[2]);
        backRightWheel.setState(states[3]);
    }

    public void stop() {
        //stop motors;
    }
}