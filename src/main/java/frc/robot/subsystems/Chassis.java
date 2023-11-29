package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import frc.robot.Constants;

public class Chassis {
    private Victor drivemotor; // the motor that powers the speed
    private Victor rotatemotor; // the motor for turning the robot
    private Timer timer;
    private int time = 0;
    private int prevdirect = 0;

    public Chassis() {
        drivemotor = new Victor(Constants.DRIVEMOTORPORT);
        rotatemotor = new Victor(Constants.ROTATEMOTORPORT);
    }

    public void setspeed(double speed) {
        drivemotor.set(speed); // should theoretically work
    }

    public void turn(double direction) {
        time += 1;

        if (direction != 0) {
            if (time > Constants.MAXTURNVALUE) {
                time = Constants.MAXTURNVALUE;
                rotatemotor.set(0);
            } else {
                if (direction > 0) {
                    rotatemotor.set(.1);
                    prevdirect = 1;
                } else {
                    rotatemotor.set(-.1);
                    prevdirect = -1;
                }
            }
        } else {
            rotatemotor.set(-1 * prevdirect);
            timer.delay(time / 0.2);
            rotatemotor.set(0);

        }

    }
}