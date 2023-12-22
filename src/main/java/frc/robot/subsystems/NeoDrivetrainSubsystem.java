package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.swerve.SwerveDriveModule;
import frc.robot.swerve.SwerveModuleNeos;
import frc.robot.Constants.SwerveConstants;
import frc.robot.Constants.SwerveConstants.Channels;
import frc.robot.Constants.SwerveConstants.CicadaCANIDs;

public class NeoDrivetrainSubsystem extends SubsystemBase {

    private final SwerveModuleNeos frontLeftWheel;
    private final SwerveModuleNeos frontRightWheel;
    private final SwerveModuleNeos backLeftWheel;
    private final SwerveModuleNeos backRightWheel;

    private final SwerveDriveKinematics kinematics;

    public NeoDrivetrainSubsystem() {
        frontLeftWheel = new SwerveModuleNeos(CicadaCANIDs.FRONT_LEFT_MODULE_DRIVE_MOTOR, CicadaCANIDs.FRONT_LEFT_MODULE_STEER_MOTOR, Channels.FRONT_LEFT_CANCODER_CHANNEL, CicadaCANIDs.FRONT_LEFT_MODULE_STEER_OFFSET_RADIANS);
        frontRightWheel = new SwerveModuleNeos(CicadaCANIDs.FRONT_RIGHT_MODULE_DRIVE_MOTOR, CicadaCANIDs.FRONT_RIGHT_MODULE_STEER_MOTOR, CicadaCANIDs.FRONT_RIGHT_MODULE_STEER_ENCODER, CicadaCANIDs.FRONT_RIGHT_MODULE_STEER_OFFSET_RADIANS);
        backLeftWheel = new SwerveModuleNeos(CicadaCANIDs.BACK_LEFT_MODULE_DRIVE_MOTOR, CicadaCANIDs.BACK_LEFT_MODULE_STEER_MOTOR, CicadaCANIDs.BACK_LEFT_MODULE_STEER_ENCODER, CicadaCANIDs.BACK_LEFT_MODULE_STEER_OFFSET_RADIANS);
        backRightWheel = new SwerveModuleNeos(CicadaCANIDs.BACK_RIGHT_MODULE_DRIVE_MOTOR, CicadaCANIDs.BACK_RIGHT_MODULE_STEER_MOTOR, CicadaCANIDs.BACK_RIGHT_MODULE_STEER_ENCODER, CicadaCANIDs.BACK_RIGHT_MODULE_STEER_OFFSET_RADIANS);        
        
        kinematics = new SwerveDriveKinematics(
            SwerveConstants.cicadaFrontLeftTranslation,
            SwerveConstants.cicadaFrontRightTranslation,
            SwerveConstants.cicadaBackLeftTranslation,
            SwerveConstants.cicadaBackRightTranslation
        );
    }
    
    public void drive(double xSpeed, double ySpeed, double rotationSpeed) {
        xSpeed = Math.copySign(
            Math.min(Math.abs(xSpeed), 1.0),
            xSpeed
        );
        ySpeed = Math.copySign(
            Math.min(Math.abs(ySpeed), 1.0),
            ySpeed
        );
        rotationSpeed = Math.copySign(
            Math.min(Math.abs(rotationSpeed), 1.0),
            rotationSpeed
        );
        ChassisSpeeds speeds = new ChassisSpeeds(
        xSpeed * SwerveConstants.MAX_VELOCITY,
        ySpeed * SwerveConstants.MAX_VELOCITY,
        rotationSpeed * SwerveConstants.MAX_ANGULAR_VELOCITY);
        System.out.println("XSpeed: "+xSpeed*SwerveConstants.MAX_VELOCITY+" YSpeed: "+ySpeed*SwerveConstants.MAX_VELOCITY+" RotationSpeed: "+rotationSpeed*SwerveConstants.MAX_ANGULAR_VELOCITY);
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