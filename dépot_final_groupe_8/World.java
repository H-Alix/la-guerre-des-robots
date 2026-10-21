import java.util.ArrayList;
import java.util.List;

/**
 * Description générale de la classe World.
 * Représente un monde fonctionnel avec des robots, bonus et tourelles et des combats entre robots.
 * 
 * @author Alix
 * @version 1.0
 */
public class World {
    private final int minX;
    private final int maxX;
    private final int minY;
    private final int maxY;
    private final List<Robot> listRobots = new ArrayList<>();
    private final List<Bonus> listBonus = new ArrayList<>();
    private final List<Turret> listTurret = new ArrayList<>();

    /**
     * Constructeur de la classe World.
     * 
     * @param minX La coordonnée X minimale du monde.
     * @param maxX La coordonnée X maximale du monde.
     * @param minY La coordonnée Y minimale du monde.
     * @param maxY La coordonnée Y maximale du monde.
     */
    public World(int minX, int maxX, int minY, int maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    /**
     * Méthode de fabrique pour créer une instance de World avec vérification des bornes.
     * 
     * @param minX La coordonnée X minimale du monde.
     * @param maxX La coordonnée X maximale du monde.
     * @param minY La coordonnée Y minimale du monde.
     * @param maxY La coordonnée Y maximale du monde.
     * @return Une instance de World si minX &lt; maxX et minY &lt; maxY, sinon null.
     */
    public static World createWolrd(int minX, int maxX, int minY, int maxY) {
        if (minX < maxX && minY < maxY) {
            return (new World(minX, maxX, minY, maxY));
        } else {
            return (null);
        }
    }

    /**
     * @return La coordonnée X minimale du monde.
     */
    public int getMinX() {
        return minX;
    }

    /**
     * @return La coordonnée X maximale du monde.
     */
    public int getMaxX() {
        return maxX;
    }

    /**
     * @return La coordonnée Y minimale du monde.
     */
    public int getMinY() {
        return minY;
    }

    /**
     * @return La coordonnée Y maximale du monde.
     */
    public int getMaxY() {
        return maxY;
    }

    /**
     * Déclenche un tour de combat entre les robots du monde, en gérant les mouvements,
     * les attaques et les interactions avec les bonus et les tourelles.
     */
    public void LaunchWar() {
        int Xcoords;
        int Ycoords;
        for (Robot robot : listRobots) {
            if (robot.GetLive() == true) {
                Robot Cible = null;
                Xcoords = robot.GetNextX();
                Ycoords = robot.GetNextY();
                for (Robot robotcible : listRobots) {
                    if (robotcible.GetPositionX() == Xcoords && robotcible.GetPositionY() == Ycoords) {
                        Cible = robotcible;
                        break;
                    }
                }
                if (Cible == null) {
                    if (turretOnNextCase(robot) == true) {
                        robot.reverseMvt();
                    } else {
                        robot.ActionMvt(this);
                    }

                } else if (Cible.GetLive() == true) {
                    robot.RobotAttack(Cible);
                    if (Cible.GetLive() == false && turretOnNextCase(robot) == false) {
                        robot.ActionMvt(this);
                    }
                } else if (turretOnNextCase(robot) == true) {
                    robot.reverseMvt();
                }

            }
            CaseBonus(robot);
        }
    }

    /**
     * Ajoute un robot à la liste des robots du monde.
     * 
     * @param robot Le robot à ajouter au monde.
     */
    public void AddRobot(Robot robot) {
        listRobots.add(robot);
    }

    /** 
     * @return La liste des robots du monde.
     */
    public List<Robot> GetListRobots() {
        return (this.listRobots);
    }

    /** 
     * @return La liste des bonus du monde.
     */
    public List<Bonus> GetListBonus() {
        return (this.listBonus);
    }

    /**
     * Ajoute un bonus à la liste des bonus du monde.
     * 
     * @param p_bonus Le bonus à ajouter au monde.
     */
    public void AddBonus(Bonus p_bonus) {
        listBonus.add(p_bonus);
    }

    /**
     * Applique l'effet d'un bonus si un robot se trouve sur la même case.
     * 
     * @param p_robot Le robot sur la case.
     */
    public void CaseBonus(Robot p_robot) {
        for (Bonus bonus : listBonus) {
            if (p_robot.GetPositionX() == bonus.GetX() && p_robot.GetPositionY() == bonus.GetY()) {
                bonus.effet(p_robot);
            }
        }
    }

    /**
     * Ajoute une tourelle à la liste des tourelles du monde.
     * 
     * @param p_t La tourelle à ajouter au monde.
     */
    public void AddTurrets(Turret p_t) {
        listTurret.add(p_t);
    }

    /**
     * @return La liste des tourelles du monde.
     */
    public List<Turret> getListTurrets() {
        return (this.listTurret);
    }

    /**
     * Permet de lancer le combat dans le monde pour un nombre de tours donné,
     * en appelant la méthode LaunchWar et en gérant les tours des tourelles.
     * 
     * @param p_tours Le nombre de tours à exécuter dans le monde.
     */
    public void start(int p_tours) {
        for (int i = 0; i < p_tours; i++) {
            this.LaunchWar();
            for (Turret turret : listTurret) {
                turret.TurretTurn(i);
            }
        }
    }

    /**
     * Vérifie si la prochaine case du robot est occupée par une tourelle dans le monde.
     * 
     * @param p_r Robot à vérifier pour la présence d'une tourelle sur sa prochaine case.
     * @return {@code true} si une tourelle est sur la prochaine case, {@code false} sinon.
     */
    public boolean turretOnNextCase(Robot p_r) {
        for (Turret turret : listTurret) {
            if (p_r.GetNextX() == turret.getPosX() && p_r.GetNextY() == turret.getPosY()) {
                return (true);
            }
        }
        return (false);
    }

}