package PLP;
import robocode.*; 
import robocode.util.Utils;
import java.awt.Color;

public class VascoDaGama extends AdvancedRobot {
    double energiaAnterior = 100;
    int direcaoMovimento = 1;

    public void run() {
        setBodyColor(new Color(0, 0, 0));
        setGunColor(new Color(255, 255, 255));
        setRadarColor(new Color(0, 0, 0));
        setBulletColor(new Color(255, 0, 0));
        setScanColor(new Color(255, 255, 255));
        
        setAdjustRadarForRobotTurn(true);
        setAdjustRadarForGunTurn(true);
        
        while (true) {
            turnRadarRight(360);
        }
    }

    public void onScannedRobot(ScannedRobotEvent eventoEscaneado) {
        double mudancaEnergia = energiaAnterior - eventoEscaneado.getEnergy();
        if (mudancaEnergia > 0 && mudancaEnergia <= 3) {
            direcaoMovimento = -direcaoMovimento;
            setAhead((eventoEscaneado.getDistance() / 4 + 25) * direcaoMovimento);
        }
        
        energiaAnterior = eventoEscaneado.getEnergy();

        double anguloAbsoluto = getHeadingRadians() + eventoEscaneado.getBearingRadians();
        double velocidadeInimigo = eventoEscaneado.getVelocity();
        double direcaoInimigo = eventoEscaneado.getHeadingRadians();

        double posicaoPrevistaX = getX() + eventoEscaneado.getDistance() * Math.sin(anguloAbsoluto);
        double posicaoPrevistaY = getY() + eventoEscaneado.getDistance() * Math.cos(anguloAbsoluto);
        double tempo = 0;

        while (tempo < 2) {
            posicaoPrevistaX += Math.sin(direcaoInimigo) * velocidadeInimigo;
            posicaoPrevistaY += Math.cos(direcaoInimigo) * velocidadeInimigo;
            tempo++;
        }

        double mira = Utils.normalRelativeAngle(Math.atan2(posicaoPrevistaX - getX(), posicaoPrevistaY - getY()));
        setTurnGunRightRadians(Utils.normalRelativeAngle(mira - getGunHeadingRadians()));

        if (getGunHeat() == 0 && Math.abs(getGunTurnRemaining()) < 10) {
            if (eventoEscaneado.getDistance() < 150) {
                fire(3);
            } else if (eventoEscaneado.getDistance() < 500) {
                fire(2);
            } else {
                fire(1);
            }
        }

        setTurnRadarRightRadians(Utils.normalRelativeAngle(anguloAbsoluto - getRadarHeadingRadians()) * 2);
    }

    public void onHitByBullet(HitByBulletEvent eventoTiro) {
        direcaoMovimento = -direcaoMovimento;
        setAhead(100 * direcaoMovimento);
    }

    public void onHitWall(HitWallEvent eventoParede) {
        direcaoMovimento = -direcaoMovimento;
        setAhead(100 * direcaoMovimento);
    }
}
