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

        double metersPerSecond = actualState.speedMetersPerSecond;
        double RPM = (metersPerSecond*60)/SwerveConstants.WHEEL_DIAMETER;
        double 
        
        double degreesOrSomething = (actualState.angle).getDegrees();

        //set move motor
        driveMotor.set(TalonFXControlMode.Velocity, metersPerSecond);
        //set rotation motor
        steerMotor.set(TalonFXControlMode.Velocity, degreesOrSomething);
    }

    public SwerveModuleState getCurrentState() { //how to convert between TICKSPERSECOND and METERSPERSECOND?
        // return new SwerveModuleState( 

        //     new Rotation2d(

        //     )
        // );
        return new SwerveModuleState();
    }
}

//todo
//how to convert between ticks/s to m/s and convert between radians and degrees or something
//what to put into drivemotor and setmotor in terms of ControlMode and what unit to use in ControlMode