package frc.robot.swerve;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.sensors.CANCoderConfiguration;
import com.ctre.phoenix.sensors.SensorInitializationStrategy;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.math.geometry.Rotation2d;
//import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import frc.robot.Constants;
import frc.robot.Constants.SwerveConstants;


public final class SwerveModuleNeos {
    protected final CANCoder canCoder;
    private final CANSparkMax driveMotor;
    private final CANSparkMax steerMotor;

    public SwerveModuleNeos (int canCoderChannel, int driveCanCoderChannel, int steerCanCoderChannel, Rotation2d steerOffset) {

        CANCoderConfiguration canCoderConfiguration = new CANCoderConfiguration();
        canCoderConfiguration.absoluteSensorRange = AbsoluteSensorRange.Unsigned_0_to_360;        
        canCoderConfiguration.magnetOffsetDegrees = -steerOffset.getDegrees();
        canCoderConfiguration.initializationStrategy = SensorInitializationStrategy.BootToAbsolutePosition;

        driveMotor = new CANSparkMax(driveCanCoderChannel, CANSparkMaxLowLevel.MotorType.kBrushless);
        steerMotor = new CANSparkMax(driveCanCoderChannel, CANSparkMaxLowLevel.MotorType.kBrushless);
        canCoder = new CANCoder(canCoderChannel);

        driveMotor.setInverted(Constants.SwerveConstants.driveInverted);
        steerMotor.setInverted(Constants.SwerveConstants.steerInverted);
    }

    public void setState(SwerveModuleState state) {
        SwerveModuleState actualState = SwerveModuleState.optimize(state, getCurrentState().angle);

        double desiredMetersPerSecond = actualState.speedMetersPerSecond;       
        double desiredRadians = actualState.angle.getRadians();

        
        //take desired velocity and divide it by our max velocity to make a percentage
        driveMotor.set(
            desiredMetersPerSecond / SwerveConstants.MAX_VELOCITY);

        steerMotor.getPIDController().setReference( 
        desiredRadians, CANSparkMax.ControlType.kPosition
        );
    }

    public SwerveModuleState getCurrentState() {
        return new SwerveModuleState(
            driveMotor.getEncoder().getVelocity(),
            new Rotation2d(
                steerMotor.getEncoder().getPosition() % (Math.PI * 2)) //keeps the radians < 2pi
            );
    }
}