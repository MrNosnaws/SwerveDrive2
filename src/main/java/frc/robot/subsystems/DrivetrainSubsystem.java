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
        SwerveModuleState testState = new SwerveModuleState("test");
        SwerveModulePosition testPosition = new SwerveModulePosition("okay");
    }
    

//what ive found so i remember:
//Translation2d object is an object that's declared with two ints, that represent the module's location relative to the center of the chassis. 
//the Kinematics objects is made of 4 Translation2d objects.


}