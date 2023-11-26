package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import frc.robot.Constants;

public class Clamp {
    private Victor clampmotor;
    private Timer time = new Timer();

    public Clamp() {
        clampmotor = new Victor(Constants.CLAMPMOTORPORT);
    }

    public void open() { // lets motor run for a bit and then stops it
        clampmotor.set(0.2);
        time.delay(0.2); // might adjust this value
        clampmotor.set(0);
    }

    public void close() {
        clampmotor.set(-0.2);
        time.delay(0.2);
        clampmotor.set(0);
    }
}
