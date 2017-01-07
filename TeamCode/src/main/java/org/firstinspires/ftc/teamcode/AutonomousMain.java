package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name="MainAutonomous", group ="Autonomous")
//@Disabled
public class AutonomousMain extends OpMode {

    AutoLib.Sequence mSequence;     // the root of the sequence tree
    boolean bDone;                  // true when the programmed sequence is done
    hardwareDeclare hw;

    public AutonomousMain() {
    }

    public void init() {
        // Get our hardware
        hw = new hardwareDeclare(this);

        // create the root Sequence for this autonomous OpMode
        mSequence = new AutoLib.LinearSequence();

        mSequence.add(new AutoLib.MoveByTimeStep(hw.motors,-0.5,.8,true));
        mSequence.add(new AutoLib.TimedMotorStep(hw.liftMotors[2],1.0,2,true));
        mSequence.add(new AutoLib.TimedMotorStep(hw.liftMotors[1],1.0,2,true));
        mSequence.add(new AutoLib.TimedMotorStep(hw.liftMotors[2],1.0,2,true));
        mSequence.add(new AutoLib.MoveByTimeStep(hw.motors,-0.5,.8,true));

//        mSequence.add(new AutoLib.BeaconPushStep(hw.mColorSensor,0,hw.servos));
//        mSequence.add(new AutoLib.MoveByTimeStep(hw.motors,-0.5,.8,true));

        // start out not-done
        bDone = false;
    }

    public void loop() {
        // until we're done, keep looping through the current Step(s)
        if (!bDone)
            bDone = mSequence.loop();       // returns true when we're done
    }

    public void stop() {
        telemetry.addData("stop() called", "");
    }
}
