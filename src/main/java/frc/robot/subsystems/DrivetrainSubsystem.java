package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.swerve.SwerveDriveModule;
import frc.robot.Constants.SwerveConstants;

public class DrivetrainSubsystem extends SubsystemBase {

    private final SwerveDriveModule frontLeftWheel;
    private final SwerveDriveModule frontRightWheel;
    private final SwerveDriveModule backLeftWheel;
    private final SwerveDriveModule backRightWheel;

    private final Translation2d frontLeftLocation;
    private final Translation2d frontRightLocation;
    private final Translation2d backLeftLocation;
    private final Translation2d backRightLocation;

    private final SwerveDriveKinematics kinematics;

    public DrivetrainSubsystem () {
        frontLeftWheel = new SwerveDriveModule(0, 0, 0);
        frontRightWheel = new SwerveDriveModule(0, 0, 0);
        backLeftWheel = new SwerveDriveModule(0, 0, 0);
        backRightWheel = new SwerveDriveModule(0, 0, 0);

        //stole these from WPILib docs so should make sense
        frontLeftLocation = new Translation2d(0.4, 0.4);
        frontRightLocation = new Translation2d(0.4, -0.4);
        backLeftLocation = new Translation2d(-0.4, 0.4);
        backRightLocation = new Translation2d(-0.4, -0.4);
        
        kinematics = new SwerveDriveKinematics(
            frontLeftLocation, frontRightLocation, backLeftLocation, backRightLocation
        );
    }
    
    public void drive(double forwardSpeed, double rightSpeed, double radians) {
        ChassisSpeeds speeds = new ChassisSpeeds(forwardSpeed, rightSpeed, radians);
        SwerveModuleState[] states = kinematics.toSwerveModuleStates(speeds);

        frontLeftWheel.setState(states[0]);
        frontRightWheel.setState(states[1]);
        backLeftWheel.setState(states[2]);
        backRightWheel.setState(states[3]);
    }

    //TESTING STUFF
    public void testing() {

        ChassisSpeeds testSpeed = new ChassisSpeeds(1.0, 3.0, 1.5); //(1 m/s forward, 3 m/s to the left, rotation at 1.5 radians/s)
        SwerveModuleState[] moduleStates = kinematics.toSwerveModuleStates(testSpeed);

        frontLeftWheel.setState(moduleStates[0]);
        frontRightWheel.setState(moduleStates[1]);
        backLeftWheel.setState(moduleStates[2]);
        backRightWheel.setState(moduleStates[3]);
    }
}