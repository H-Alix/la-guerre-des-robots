import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class WorldTest {
    @Test
    void testCreateWorldVALIDE() {
        World monde = new World(-10, 10, -100, 100);
        assertTrue(monde.getMaxX() == 10);
        assertTrue(monde.getMaxY() == 100);
        assertTrue(monde.getMinY() == -100);
        assertTrue(monde.getMinX() == -10);
    }

    @Test
    void testCreateWorldERREUR() {
        World monde = World.createWolrd(100, 10, 10, 100);
        assertTrue(monde == null);
    }

    @Test
    void testLaunchWarDestructio() {
        World monde = new World(-100, 100, -10, 100);   
        Robot robot = Robot.CreateRobot("EvaLemoinee", "v1", monde , 100, DamageTypes.PHYSIQUE);
        Robot robot2 = Robot.CreateRobot("EvaLemoineee", "v1", monde , 1, DamageTypes.POSITRONNIQUE);
        robot.SetPositionX(1);
        robot.SetPositionY(2);
        robot.SetmvtX(10);
        robot.SetmvtY(5);

        robot2.SetPositionX(11);
        robot2.SetPositionY(7);

 
        monde.LaunchWar();
        assertTrue(robot2.GetLive() == false);
        assertTrue(robot.GetPositionX()==11);
        assertTrue(robot.GetPositionY()==7);
    }

    @Test
    void testLaunchWarNONdestruction() {
        World monde = new World(-100, 100, -10, 100);   
        Robot robot = Robot.CreateRobot("EvaLemoinee", "v1", monde , 100, DamageTypes.PHYSIQUE);
        Robot robot2 = Robot.CreateRobot("EvaLemoineee", "v1", monde , 100, DamageTypes.POSITRONNIQUE);
        robot.SetPositionX(1);
        robot.SetPositionY(2);
        robot.SetmvtX(10);
        robot.SetmvtY(5);

        robot2.SetPositionX(11);
        robot2.SetPositionY(7);

 
        monde.LaunchWar();
        assertTrue(robot2.GetLive() == true);
        assertTrue(robot.GetPositionX()==1);
        assertTrue(robot.GetPositionY()==2);
    }

    @Test
    void testLaunchWarPasrencontre() {
        World monde = new World(-100, 100, -10, 100);   
        Robot robot = Robot.CreateRobot("EvaLemoinee", "v1", monde , 100, DamageTypes.PHYSIQUE);
        Robot robot2 = Robot.CreateRobot("EvaLemoineee", "v1", monde , 100, DamageTypes.POSITRONNIQUE);
        robot.SetPositionX(1);
        robot.SetPositionY(2);
        robot.SetmvtX(10);
        robot.SetmvtY(5);

        robot2.SetPositionX(10);
        robot2.SetPositionY(5);
 
        monde.LaunchWar();
        assertTrue(robot2.GetLive() == true);
        assertTrue(robot.GetPositionX()==11);
        assertTrue(robot.GetPositionY()==7);
    }
   @Test
    void testAddRobot() {
        World monde = new World(-100, 100, -10, 100);   
        Robot robot = Robot.CreateRobot("EvaLemoinee", "v1", monde , 100, DamageTypes.PHYSIQUE);
        Robot robot2 = Robot.CreateRobot("EvaLemoineee", "v1", monde , 100, DamageTypes.POSITRONNIQUE);
        assertTrue(monde.GetListRobots().contains(robot));
        assertTrue(monde.GetListRobots().contains(robot2));
    }
    @Test
    void testAddBonus() {
        World monde = new World(-100, 100, -10, 100);   
        Robot robot = Robot.CreateRobot("EvaLemoinee", "v1", monde , 100, DamageTypes.PHYSIQUE);
        Robot robot2 = Robot.CreateRobot("EvaLemoineee", "v1", monde , 100, DamageTypes.POSITRONNIQUE);
        Bonus bonus = new Bonus();
        monde.AddBonus(bonus);
        assertTrue(monde.GetListBonus().contains(bonus));
        
    }
}
