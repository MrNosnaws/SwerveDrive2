package frc.robot.swerve;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.sensors.CANCoderConfiguration;
import com.ctre.phoenix.sensors.SensorInitializationStrategy;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import frc.robot.Constants;
import frc.robot.Constants.SwerveConstants;


public final class SwerveDriveModule {
    protected final CANCoder canCoder;
    private final TalonFX driveMotor;
    private final TalonFX steerMotor;

    public SwerveDriveModule (int driveMotorChannel, int steerMotorChannel, int canCoderChannel) {

        CANCoderConfiguration canCoderConfiguration = new CANCoderConfiguration();
        canCoderConfiguration.absoluteSensorRange = AbsoluteSensorRange.Unsigned_0_to_360;        
        canCoderConfiguration.magnetOffsetDegrees = 0;
        canCoderConfiguration.initializationStrategy = SensorInitializationStrategy.BootToAbsolutePosition;

        driveMotor = new TalonFX(driveMotorChannel);
        steerMotor = new TalonFX(steerMotorChannel);
        canCoder = new CANCoder(canCoderChannel);

        driveMotor.setInverted(Constants.SwerveConstants.driveInverted);
        steerMotor.setInverted(Constants.SwerveConstants.steerInverted);
    }

    //should setState take a SwerveModuleState or a speed value and rotation value? swervemodulestates for now.
    //also make rotation into radians wtf are radians
    public void setState(SwerveModuleState state) {
        Rotation2d testRotation = new Rotation2d(Math.toRadians(45));
        SwerveModuleState actualState = SwerveModuleState.optimize(state, testRotation);
        System.out.println(actualState.speedMetersPerSecond);
        System.out.println(actualState.angle);
        //set move motor
        //set rotation motor
    }
}