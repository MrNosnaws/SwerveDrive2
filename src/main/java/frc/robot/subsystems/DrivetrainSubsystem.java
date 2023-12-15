package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.swerve.SwerveDriveModule;

public class DrivetrainSubsystem extends SubsystemBase {

    private final SwerveDriveModule frontLeftWheel;
    private final SwerveDriveModule frontRightWheel;
    private final SwerveDriveModule backLeftWheel;
    private final SwerveDriveModule backRightWheel;

    public DrivetrainSubsystem () {

        frontLeftWheel = new SwerveDriveModule(0, 0, 0);
        frontRightWheel = new SwerveDriveModule(0, 0, 0);
        backLeftWheel = new SwerveDriveModule(0, 0, 0);
        backRightWheel = new SwerveDriveModule(0, 0, 0);
        
        //stole these from WPIlib docs so they should make sense
        Translation2d frontLeftLocation = new Translation2d(0.4, 0.4);
        Translation2d frontRightLocation = new Translation2d(0.4, -0.4);
        Translation2d backLeftLocation = new Translation2d(-0.4, 0.4);
        Translation2d backRightLocation = new Translation2d(-0.4, -0.4);
    }

    public void testRunSteerMotor() {
        frontLeftWheel.runSteerMotor(45);
    }

    //TESTING STUFF
    public void testing() {
        //"The SwerveDriveKinematics class accepts a variable number of constructor arguments, with each argument 
        //being the location of a swerve module relative to the robot center as a Translation2d object. "\

        SwerveDriveKinematics testKinematics = new SwerveDriveKinematics(
            frontLeftLocation, frontRightLocation, backLeftLocation, backRightLocation
        );

        //talking abt chassisspeeds: "This is useful in situations where you have to convert a forward velocity, sideways velocity, and an angular velocity into individual module states."
        ChassisSpeeds speeds = new ChassisSpeeds(1.0, 3.0, 1.5) //(1 m/s forward, 3 m/s to the left, rotation at 1.5 radians/s)
        SwerveModuleStates[] moduleStates = testKinematics.toSwerveModuleStates(speeds); //this takes the kinematics with our 4 modules and converts the forwards and sideways velocities we want to a SwerveModuleState to be applied to the modules.
        SwerveModuleState frontLeftState = moduleStates[0];
        SwerveMOduleState backRightLocation = moduleStates[3];
    }
    
    public void setModuleStates() {
        //given 4 SwerveModuleStates, use wheel.setState(speed, angle) to set them all
    }
}