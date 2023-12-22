// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.team2052.swervemodule;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Swerve module implementation for swerve module with Neos
 */
public class TESTCicadaNeoSwerve extends SwerveModule {
    private final CANSparkMax driveMotor;
    private final CANSparkMax steerMotor;

    public TESTCicadaNeoSwerve(
        String debugName, 
        ModuleConfiguration moduleConfiguration,
        int driveMotorChannel,
        int steerMotorChannel,
        int canCoderChannel,
        Rotation2d steerOffset
    ) {
        super(debugName, moduleConfiguration, canCoderChannel, steerOffset);

        /*
         * Drive Motor Initialization
         */
        driveMotor = new CANSparkMax(driveMotorChannel, CANSparkMaxLowLevel.MotorType.kBrushless);

        // Reduce CAN status frame rates
        driveMotor.setInverted(moduleConfiguration.isDriveInverted());

        // Drive Motor encoder initialization
        RelativeEncoder driveEncoder = driveMotor.getEncoder();

        // Conversion factor for switching between ticks and meters in terms of meters per tick
        double drivePositionConversionFactor = Math.PI * moduleConfiguration.getWheelDiameter() * 
            moduleConfiguration.getDriveReduction();

        /*
         * Steer Motor Initialization
         */
        steerMotor = new CANSparkMax(steerMotorChannel, CANSparkMaxLowLevel.MotorType.kBrushless);

        steerMotor.setInverted(!moduleConfiguration.isSteerInverted());

        // Steer Motor encoder initialization
        RelativeEncoder steerEncoder = steerMotor.getEncoder();

        // Conversion factor for switching between ticks and radians in terms of radians per tick
        double steerPositionConversionFactor = 2.0 * Math.PI * moduleConfiguration.getSteerReduction();


        // Sets the steer motor encoder to the absolute position of the CANCoder for startup orientation
        SparkMaxPIDController steerController = steerMotor.getPIDController();
    }

    @Override
    public SwerveModuleState getState() {
        // Both encoder values are automatically in units of meters per second and
        // radians because of the position and velocity conversion factors
        return new SwerveModuleState(
            driveMotor.getEncoder().getVelocity(),
            new Rotation2d(
                steerMotor.getEncoder().getPosition() % (2.0 * Math.PI)
            )
        );
    }

    @Override
    public void setState(double velocityMetersPerSecond, Rotation2d steerAngle) {
        SwerveModuleState desiredState = new SwerveModuleState(velocityMetersPerSecond, steerAngle);
        // Reduce radians to 0 to 2pi range and simplify to nearest angle
        desiredState = SwerveModuleState.optimize(
            desiredState,
            getState().angle
        );

        // Set the motor to our desired velocity as a percentage of our max velocity
        driveMotor.set(
            desiredState.speedMetersPerSecond / getMaxVelocityMetersPerSecond(moduleConfiguration)
        );

        steerMotor.getPIDController().setReference(
            desiredState.angle.getRadians(), CANSparkMax.ControlType.kPosition
        );
    }

    @Override
    public SwerveModulePosition getPosition() {
        return new SwerveModulePosition(
            driveMotor.getEncoder().getPosition(),
            new Rotation2d(
                steerMotor.getEncoder().getPosition()
            )
        );
    }

    public static double getMaxVelocityMetersPerSecond(ModuleConfiguration moduleConfiguration) {
        /*
         * The formula for calculating the theoretical maximum velocity is:
         * [Motor free speed (RPM)] / 60 * [Drive reduction] * [Wheel diameter (m)] * pi
         * This is a measure of how fast the robot should be able to drive in a straight line.
         */
        return SwerveConstants.NeoSwerveModule.NEO_ROUNDS_PER_MINUTE / 60 * moduleConfiguration.getDriveReduction() * 
            moduleConfiguration.getWheelDiameter() * Math.PI;
    }
}