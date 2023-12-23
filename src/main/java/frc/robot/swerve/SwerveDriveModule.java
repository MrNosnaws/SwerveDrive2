package frc.robot.swerve;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.sensors.CANCoderConfiguration;
import com.ctre.phoenix.sensors.SensorInitializationStrategy;

import edu.wpi.first.math.geometry.Rotation2d;
//import edu.wpi.first.math.kinematics.ChassisSpeeds;
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

    public void setState(SwerveModuleState state) {
        SwerveModuleState actualState = SwerveModuleState.optimize(state, getCurrentState().angle);

        double desiredMetersPerSecond = actualState.speedMetersPerSecond;       
        double desiredRadians = actualState.angle.getRadians();

        
        //take desired velocity and divide it by our max velocity to make a percentage
        driveMotor.set(TalonFXControlMode.PercentOutput, 
        desiredMetersPerSecond / SwerveConstants.MAX_VELOCITY
        );

        /* set steer motor:
        in constants, we take 2π/ticksPerRotation, which finds the radians per motor tick.
        we then multiply that by steer reduction which scales it to the correct gear ratio.

        we take our desired radians and divide by the steer conversion to convert desiredRadians to motor ticks.
        */
        steerMotor.set(TalonFXControlMode.Position, 
        desiredRadians / SwerveConstants.STEER_CONVERTION
        );
    }

    public SwerveModuleState getCurrentState() {
        /* to get drive motor value:
        in constants, we take π*wheelDiameter, which finds the circumference of the wheel in meters.
        we take that and divide it by ticksPerRotation, which gives us the number of meters it moves per tick.
        we multiply it by drive reduction which scales it to the correct gear ratio.

        we take all that and divide it by 60 to get m/s/tick. This assumed that the first value represents one minute.
        we multiply desiredM/S by this value to convert desiredMetersPerSecond to motor ticks.
        */
        return new SwerveModuleState(
            driveMotor.getSelectedSensorVelocity() * SwerveConstants.DRIVE_VELOCITY_CONVERSION,
            new Rotation2d(steerMotor.getSelectedSensorPosition() * SwerveConstants.STEER_CONVERTION)
            );
    }
}