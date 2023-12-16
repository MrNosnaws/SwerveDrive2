package frc.robot.swerve;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.sensors.CANCoderConfiguration;
import com.ctre.phoenix.sensors.SensorInitializationStrategy;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;

import edu.wpi.first.math.geometry.Translation2d;
import frc.robot.Constants;


public final class SwerveDriveModule {
    protected final CANCoder canCoder;
    private final TalonFX driveMotor;
    private final TalonFX steerMotor;

    public SwerveDriveModule (int driveMotorChannel, int steerMotorChannel, int canCoderChannel, Translation2d translation2d) {

        CANCoderConfiguration canCoderConfiguration = new CANCoderConfiguration();
        canCoderConfiguration.absoluteSensorRange = AbsoluteSensorRange.Unsigned_0_to_360;        
        canCoderConfiguration.magnetOffsetDegrees = 0;
        canCoderConfiguration.initializationStrategy = SensorInitializationStrategy.BootToAbsolutePosition;
        
        driveMotor = new TalonFX(driveMotorChannel);

        steerMotor = new TalonFX(steerMotorChannel);

        canCoder = new CANCoder(canCoderChannel);

        driveMotor.setInverted(Constants.SwerveConstants.driveInverted);

        steerMotor.setInverted(Constants.SwerveConstants.steerInverted);
        
        steerMotor.setSelectedSensorPosition(canCoder.getPosition());

    }
}