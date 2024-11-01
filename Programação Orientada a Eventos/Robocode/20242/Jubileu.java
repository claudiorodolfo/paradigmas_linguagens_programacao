package PLP;

import robocode.*;
import robocode.util.Utils;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Jubileu - a robot by (Equipe 1)*
 */

public class Jubileu extends AdvancedRobot {

    private double previousEnergy = 100; // Energia anterior do inimigo
    private int movementDirection = 1;  // Direção de movimento
    private boolean lostTarget = false; // Indica se o inimigo está fora do radar
    
    public void run() {
        // Configurações de cores e ajustes iniciais
        setColors(Color.red, Color.white, Color.green, Color.white, Color.red);
        setAdjustRadarForGunTurn(true);
        setAdjustGunForRobotTurn(true);
        
        // Mantém o radar sempre em movimento para detectar robôs
        setTurnRadarRight(Double.POSITIVE_INFINITY);

        while (true) {
            if (lostTarget) {
                // Se o alvo foi perdido, varrer mais rápido para encontrá-lo
                setTurnRadarRight(360); // Varrer o radar para reencontrar o alvo
                lostTarget = false; // Resetar a flag quando iniciar a varredura
            }
            execute();
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        double absoluteBearing = getHeading() + e.getBearing(); // Ângulo absoluto do inimigo
        double gunTurn = Utils.normalRelativeAngleDegrees(absoluteBearing - getGunHeading());
        
        // Detectar quando o inimigo atira para fazer movimentos evasivos
        double changeInEnergy = previousEnergy - e.getEnergy();
        if (changeInEnergy > 0 && changeInEnergy <= 3) {
            // O inimigo atirou, Jubileu deve evitar a linha de fogo
            movementDirection = -movementDirection; // Mudar a direção de movimento
            setAhead((e.getDistance() / 4 + 25) * movementDirection);
        }
        previousEnergy = e.getEnergy();

        // Mira adaptativa baseada na distância
        if (e.getDistance() > 150) {
            // Prever movimento para tiros a longa distância
            gunTurn += (e.getVelocity() * Math.sin(e.getHeadingRadians() - getGunHeadingRadians()) / 15);
            setTurnGunRight(gunTurn);
            fire(1); // Tiro leve para longa distância
        } else {
            // Tiros mais fortes a curta distância
            gunTurn += (e.getVelocity() * Math.sin(e.getHeadingRadians() - getGunHeadingRadians()) / 10);
            setTurnGunRight(gunTurn);
            fire(3); // Tiro mais forte
        }

        // Manter movimentação em arco ao redor do inimigo
        setTurnRight(Utils.normalRelativeAngleDegrees(e.getBearing() + 90 - (15 * movementDirection)));
        setAhead(150 * movementDirection);

        // Manter o radar focado no inimigo
        double radarTurn = Utils.normalRelativeAngleDegrees(absoluteBearing - getRadarHeading());
        setTurnRadarRight(radarTurn * 2.5); // Dobra a velocidade do radar para manter foco

        lostTarget = false; // O alvo foi detectado, então resetamos a flag
    }

    public void onRobotDeath(RobotDeathEvent e) {
        // Se o robô morreu, o alvo foi perdido
        lostTarget = true;
    }

    public void onHitByBullet(HitByBulletEvent e) {
        // Movimentos evasivos rápidos ao ser atingido
        setTurnRight(90 - e.getBearing()); // Rotaciona para perpendicular ao tiro
        setAhead(150 * movementDirection); // Se move rapidamente
        execute();
    }

    public void onHitWall(HitWallEvent e) {
        // Reagir à colisão com a parede
        setBack(50);  // Recuar ao colidir
        movementDirection = -movementDirection; // Inverter direção de movimento
        setTurnRight(90);  // Rotacionar 90 graus para evitar ficar preso
        execute();
    }

    public void onHitRobot(HitRobotEvent e) {
        if (e.isMyFault()) {
            // Se for culpa do Jubileu, recuar
            setBack(50);
            movementDirection = -movementDirection; // Mudar a direção de movimento
        } else {
            // Se o outro robô colidir, atirar com força
            fire(3);
        }
        execute();
    }
}
