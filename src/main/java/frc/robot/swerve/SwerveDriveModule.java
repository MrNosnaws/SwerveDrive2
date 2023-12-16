package frc.robot.swerve;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.sensors.CANCoderConfiguration;
import com.ctre.phoenix.sensors.SensorInitializationStrategy;

import frc.robot.Constants;


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

    public final void runSteerMotor(double desiredAngle) {
        double currentAngle = canCoder.getAbsolutePosition();
        double velocity = currentAngle - desiredAngle;
        steerMotor.set(TalonFXControlMode.Velocity, velocity);
    }

    public void setState(SwerveModuleState state) {
        state.speed;
    }
}