import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class robotTest {
    @Test
    void testCreateRobotVALIDE() {
        World monde = new World(-10, 10, -10, 10);
        Robot robot = Robot.CreateRobot("EvaLemoine", "v1", monde, 100, DamageTypes.MAGIQUE);
        assertTrue(robot != null);
        assertTrue(robot.GetRobotName().length() > 5);
    }

    @Test
    void testCreateRobotERREURS() {
        World monde = new World(-10, 10, -10, 10);
        Robot robot = Robot.CreateRobot("Eva", "v1", monde, 100, DamageTypes.MAGIQUE);
        assertFalse(robot != null);
        assertNull(robot);
    }
    @Test
    void testRobotDescVALIDE() {
        World monde = new World(-10, 10, -10, 10);
        Robot robot = Robot.CreateRobot("EvaLemoine", "v1", monde , 100, DamageTypes.MAGIQUE);
        robot.SetPositionX(1);
        robot.SetPositionY(2);
        assertTrue(robot.GetRobotName().equals("EvaLemoine1"));
        assertTrue(robot.GetHP() == 100);
        assertTrue(robot.GetPositionX()==1);
        assertTrue(robot.GetPositionY()==2);
    }

    @Test
    void testRobotDescERREUR() {
        World monde = new World(-10, 10, -10, 10);
        Robot robot = Robot.CreateRobot("EvaLemoine", "v1", monde , 100, DamageTypes.MAGIQUE);
        robot.SetPositionX(1);
        robot.SetPositionY(2);
        assertFalse(robot.GetRobotName().equals("EvaLemo"));
        assertFalse(robot.GetHP() == 90);
        assertFalse(robot.GetPositionX()== 2);
        assertFalse(robot.GetPositionY()== 3);
    }
    @Test
    void testActionMvtVALIDE() {
        World monde = new World(-10, 10, -10, 10);
        Robot robot = Robot.CreateRobot("EvaLemoine", "v1", monde , 100, DamageTypes.MAGIQUE);
        robot.SetPositionX(1);
        robot.SetPositionY(2);
        robot.SetmvtY(3);
        robot.SetmvtX(3);

        assertTrue(robot.GetNextY() == 4);
        assertTrue(robot.GetNextX() == 5);
    }

    @Test
    void testActionMvtIDENTIQUE() {
        World monde = new World(-10, 10, -10, 10);
        Robot robot = Robot.CreateRobot("EvaLemoine", "v1", monde , 100, DamageTypes.MAGIQUE);
        robot.SetPositionX(1);
        robot.SetPositionY(2);
        robot.SetmvtX(10);
        robot.SetmvtY(10);

        robot.ActionMvt(monde);
        assertTrue(robot.GetPositionX() == 1);  
        assertTrue(robot.GetPositionY() == 2);
    }

        @Test
        void testDamageBotVIE() {
            World monde = new World(-10, 10, -10, 10);
            Robot robot = Robot.CreateRobot("EvaLemoine", "v1", monde , 100, DamageTypes.MAGIQUE);
            robot.DamageBot(10);
            assertTrue(robot.GetHP()==90);
    }

        @Test
        void testDamageBotMORT() {
            World monde = new World(-10, 10, -10, 10);
            Robot robot = Robot.CreateRobot("EvaLemoine", "v1", monde , 100, DamageTypes.MAGIQUE);
            robot.DamageBot(101);
            assertTrue(robot.GetHP()==-1);
    }
        @Test
        void testHealBot() {
            World monde = new World(-10, 10, -10, 10);
            Robot robot = Robot.CreateRobot("EvaLemoine", "v1", monde , 100, DamageTypes.MAGIQUE);
            robot.HealBot(50);
            assertTrue(robot.GetHP()==150);
    }

        @Test
        void testHealBotNEG() {
            World monde = new World(-10, 10, -10, 10);
            Robot robot = Robot.CreateRobot("EvaLemoine", "v1", monde , 100, DamageTypes.MAGIQUE);
            robot.HealBot(-50);
            assertTrue(robot.GetHP()==100);
    }
        @Test
        void testReverseMvt() {
            World monde = new World(-10, 10, -10, 10);
            Robot robot = Robot.CreateRobot("EvaLemoine", "v1", monde , 100, DamageTypes.MAGIQUE);
            robot.SetmvtX(5);
            robot.SetmvtY(8);
            robot.reverseMvt();
            assertTrue(robot.GetMvtX()== -5);
            assertTrue(robot.GetMvtY()== -8);

        }
       @Test
        void testRobotAttackMaj() {
            World monde = new World(-10, 10, -10, 10);
            Robot robot = Robot.CreateRobot("EvaLemoine", "v1", monde , 100, DamageTypes.MAGIQUE);
            Robot robotbis = Robot.CreateRobot("EvaLemoine", "v1", monde , 100, DamageTypes.MAGIQUE);
            Robot robot1 = Robot.CreateRobot("EvaLemoinee", "v1", monde , 100, DamageTypes.PHYSIQUE);
            Robot robot2 = Robot.CreateRobot("EvaLemoineee", "v1", monde , 100, DamageTypes.POSITRONNIQUE);
            robot.RobotAttack(robot1);
            robot.RobotAttack(robot2);
            robot.RobotAttack(robotbis);
            assertTrue(robot1.GetHP()== 95);
            assertTrue(robot2.GetHP()==95);
            assertTrue(robotbis.GetHP()== 100);

        }

        @Test
        void testRobotAttackPH() {
            World monde = new World(-10, 10, -10, 10);
            Robot robot = Robot.CreateRobot("EvaLemoine", "v1", monde , 100, DamageTypes.MAGIQUE);
            Robot robotbis = Robot.CreateRobot("EvaLemoine", "v1", monde , 100, DamageTypes.PHYSIQUE);
            Robot robot1 = Robot.CreateRobot("EvaLemoinee", "v1", monde , 100, DamageTypes.PHYSIQUE);
            Robot robot2 = Robot.CreateRobot("EvaLemoineee", "v1", monde , 100, DamageTypes.POSITRONNIQUE);
            robot1.RobotAttack(robot);
            robot1.RobotAttack(robot2);
            robot1.RobotAttack(robotbis);
            assertTrue(robot.GetHP()==95);
            assertTrue(robot2.GetHP()==95);
            assertTrue(robotbis.GetHP()==95);

        }
        @Test
        void testRobotAttackPosi() {
            World monde = new World(-10, 10, -10, 10);
            Robot robot = Robot.CreateRobot("EvaLemoine", "v1", monde , 100, DamageTypes.MAGIQUE);
            Robot robotbis = Robot.CreateRobot("EvaLemoine", "v1", monde , 100, DamageTypes.POSITRONNIQUE);
            Robot robot1 = Robot.CreateRobot("EvaLemoinee", "v1", monde , 100, DamageTypes.PHYSIQUE);
            Robot robot2 = Robot.CreateRobot("EvaLemoineee", "v1", monde , 100, DamageTypes.POSITRONNIQUE);
            robot2.RobotAttack(robot);
            robot2.RobotAttack(robot1);
            robot2.RobotAttack(robotbis);
            assertTrue(robot1.GetHP()== 95);
            assertTrue(robot.GetHP()== 95);
            System.out.println(robotbis.GetHP());
            assertTrue(robotbis.GetHP()== 90);

        }
}
