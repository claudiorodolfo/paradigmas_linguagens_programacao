package PLP;

import robocode.*;
import robocode.util.Utils;
import java.awt.Color;

public class Grupo_2 extends AdvancedRobot {

    private static final double WALL_MARGIN = 50.0;
    private boolean targetLocked = false;  // Indica se há um alvo travado
    private boolean avoidingWall = false;  // Indica se o robô está evitando uma parede
    private double lastEnemyBearing = 0;  // Armazena a última posição do inimigo
    private double lastEnemyDistance = 0;  // Armazena a última distância do inimigo

    public void run() {
        setColors(Color.blue, Color.gray, Color.white);
        setRadarColor(Color.yellow); 

        setAdjustRadarForGunTurn(true);
        setAdjustRadarForRobotTurn(true);
        setAdjustGunForRobotTurn(true); 

        while (true) {
            if (!targetLocked) {
                setTurnRadarRight(360);
            }
            if (!avoidingWall) {
                moveSafely();  
            }
            execute();
        }
    }

    // Método para movimentar o robô de maneira segura, evitando paredes
    private void moveSafely() {
        double futureX = getX() + Math.sin(Math.toRadians(getHeading())) * 100;
        double futureY = getY() + Math.cos(Math.toRadians(getHeading())) * 100;
        double battlefieldWidth = getBattleFieldWidth();
        double battlefieldHeight = getBattleFieldHeight();

        if (futureX <= WALL_MARGIN || futureX >= battlefieldWidth - WALL_MARGIN || 
            futureY <= WALL_MARGIN || futureY >= battlefieldHeight - WALL_MARGIN) {
            setTurnRight(90);  // Faz um giro de 90 graus para evitar colisão
            setAhead(150);  // Aumenta a distância de afastamento
        } else {
            setAhead(100);  // Continua movendo para frente
            if (getDistanceRemaining() == 0) {
                setTurnRight(Math.random() * 90 - 45);  // Gira em uma direção aleatória
            }
        }
    }

    public void onHitWall(HitWallEvent event) {
        avoidingWall = true;

        back(100);  // Recuar uma distância maior
        setTurnRight(90);  // Gira 90 graus para longe da parede
        setAhead(150);  // Move para longe da parede

        avoidingWall = false;
    }

    public void onScannedRobot(ScannedRobotEvent event) {
        // Indica que um alvo foi encontrado
        targetLocked = true;
        lastEnemyBearing = event.getBearing();  // Armazena o ângulo do inimigo
        lastEnemyDistance = event.getDistance();  // Armazena a distância do inimigo

        double absoluteBearing = getHeading() + event.getBearing();  // Obtém a direção absoluta do inimigo
        double bulletPower = Math.min(3, Math.max(1, 400 / lastEnemyDistance));  // Ajusta a força do tiro com base na distância

        // Ajusta o radar para se focar mais no inimigo, com pequenas varreduras ao redor do alvo
        double radarTurn = Utils.normalRelativeAngleDegrees(absoluteBearing - getRadarHeading());
        setTurnRadarRight(radarTurn * 2);  // Gira o radar mais rapidamente para focar no inimigo

        // Ajusta a mira para atirar no inimigo com mais precisão
        double gunTurn = Utils.normalRelativeAngleDegrees(absoluteBearing - getGunHeading());
        setTurnGunRight(gunTurn);  // Alinha o canhão com o inimigo

        // Atira apenas quando a arma estiver alinhada com o inimigo
        if (getGunHeat() == 0 && Math.abs(gunTurn) < 5) {  // Só atira se o ajuste do canhão for pequeno
            setFire(bulletPower);
        }
    }

    // Método modificado para continuar buscando inimigos ao perder a visão
    public void onRobotDeath(RobotDeathEvent event) {
        targetLocked = false;  // Quando o inimigo é destruído, o radar volta ao estado normal
    }

    public void onStatus(StatusEvent e) {
        // Se não houver alvo detectado, continuar procurando
        if (!targetLocked) {
            setTurnRadarRight(360);  // Radar continua girando enquanto procura o inimigo
        }
    }

    public void onHitByBullet(HitByBulletEvent event) {
        setTurnRight(90 - getHeading());  // Muda de direção
        setAhead(100);  // Continua em movimento
    }
}
