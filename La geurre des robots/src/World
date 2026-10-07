
import java.util.ArrayList;
import java.util.List;

public class World {
    private final int minX;
    private final int maxX;
    private final int minY;
    private final int maxY;
    private final List<Robot> listRobots = new ArrayList<>();
    private final List<Bonus> listBonus = new ArrayList<>();

    public World(int minX, int maxX, int minY, int maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

   
    public int getMinX() {
        return minX;
    }
    public int getMaxX() {
        return maxX;
    }
    public int getMinY() {
        return minY;
    }
    public int getMaxY() {
        return maxY;
    }

    public void LaunchWar(){
        int Xcoords;
        int Ycoords;
        for (int i = 0; i < 10; i++) {
            for (Robot robot : listRobots){
                if (robot.GetLive()== true){
                    Robot Cible = null;
                    Xcoords = robot.GetNextX();
                    Ycoords = robot.GetNextY();
                    for (Robot robotcible : listRobots){
                        if (robotcible.GetPositionX() == Xcoords && robotcible.GetPositionY() == Ycoords){
                            Cible = robotcible;
                            break;
                        }
                    }
                    if (Cible == null){
                        robot.ActionMvt(this);
                        System.out.println("La position du robot : " + robot.GetRobotName() + " est : X = " + robot.GetPositionX() + ", Y = " + robot.GetPositionY());
                    } else if(Cible.GetLive() == true ) {
                        robot.RobotAttack(Cible);
                        if(Cible.GetLive()== false){
                            robot.ActionMvt(this);
                            System.out.println("La position du robot : " + robot.GetRobotName() + " est : X = " + robot.GetPositionX() + ", Y = " + robot.GetPositionY());
                        }
                    }
                    
                }
                CaseBonus(robot);
            }
            
        }
    }

    public void AddRobot(Robot robot){
        listRobots.add(robot);
    }

    public List<Robot> GetListRobots (){
        return(this.listRobots);
    }

    public void AddBonus(Bonus p_bonus){
        listBonus.add(p_bonus);
    }

    public void CaseBonus(Robot p_robot){
        for (Bonus bonus : listBonus){
            if (p_robot.GetPositionX() == bonus.GetX() && p_robot.GetPositionY() == bonus.GetY()){
                bonus.effet(p_robot);
            }
        }
    }

}
