package frc.robot.swerve;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.CANCoder;


public final class SwerveDriveModule {
    protected final CANCoder cancoder = new CANCoder(0);

    private final TalonFX driveMotor1 = new TalonFX(1);
    private final TalonFX driveMotor2 = new TalonFX(2);    
    private final TalonFX driveMotor3 = new TalonFX(3);
    private final TalonFX driveMotor4 = new TalonFX(4);

    private final TalonFX steerMotor1 = new TalonFX(5);
    private final TalonFX steerMotor2 = new TalonFX(6);
    private final TalonFX steerMotor3 = new TalonFX(7);
    private final TalonFX steerMotor4 = new TalonFX(8);


}