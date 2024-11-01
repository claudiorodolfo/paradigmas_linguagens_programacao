package PLP;
import robocode.*;
import java.awt.*;


public class BobbyFisher extends AdvancedRobot {
    int moveDirection=1;//which way to move
	
    /**
     * run:  Bobby's main run function
     */
    public void run() {
        setAdjustRadarForRobotTurn(true);//keep the radar still while we turn
        setBodyColor(Color.green);
        setGunColor(Color.black);
        setRadarColor(Color.black);
        setScanColor(Color.white);
        setBulletColor(Color.red);
        setAdjustGunForRobotTurn(true); // Keep the gun still when we turn
        turnRadarRightRadians(Double.POSITIVE_INFINITY);//keep turning radar right
    }

    /**
     * onScannedRobot:  Here's the good stuff
     */
    public void onScannedRobot(ScannedRobotEvent e) {
		double distance = e.getDistance();
        double absBearing=e.getBearingRadians()+getHeadingRadians();//enemies absolute bearing
        double latVel=e.getVelocity() * Math.sin(e.getHeadingRadians() -absBearing);//enemies later velocity
        double gunTurnAmt;//amount to turn our gun
        setTurnRadarLeftRadians(getRadarTurnRemainingRadians());//lock on the radar
        if(Math.random()>.5){
            setMaxVelocity(4*Math.random()+4);//randomly change speed
        }
		// Dinamic Adjust for divisor
		double divisor = Math.max(10, Math.min(30, distance / 10));
		gunTurnAmt = robocode.util.Utils.normalRelativeAngle(absBearing- getGunHeadingRadians()+latVel/divisor);
		setTurnGunRightRadians(gunTurnAmt); //turn our gun
        if (e.getDistance() > 150) {//if distance is greater than 150
            //amount to turn our gun, lead just a little bit
            setTurnRightRadians(robocode.util.Utils.normalRelativeAngle(absBearing-getHeadingRadians()+latVel/getVelocity()));//drive towards the enemies predicted future location
			setAhead((e.getDistance() - 150)*moveDirection); //move forward
            setFire(1);//fire

        }
        else{//if we are close enough...
            setTurnLeft(-90-e.getBearing()); //turn perpendicular to the enemy
            setAhead(20*moveDirection); //move forward
            setFire(3);//fire

        }
    }
    public void onHitWall(HitWallEvent e){
        moveDirection=-moveDirection;//reverse direction upon hitting a wall
    }
	
	public void onHitRobot(HitRobotEvent e){
		moveDirection=-moveDirection;
	}

    /**
     * onWin:  Do a victory dance
     */
    public void onWin(WinEvent e) {
        for (int i = 0; i < 50; i++) {
            turnRight(30);
            turnLeft(30);
        }
    }
}