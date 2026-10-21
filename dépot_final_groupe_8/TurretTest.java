import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TurretTest {
    private World world;
    private Turret turret;
    private Robot robot;

    @BeforeEach
    public void setUp() {
        world = new World(-100, 100, -100, 100);
        turret = new Turret(10, world, "tourEVA1");
        turret.setDamage(10);
        turret.setReload(2);

        robot = new Robot("dudutest", "v1", world, 100, DamageTypes.PHYSIQUE);
        robot.SetPositionX(0);
        robot.SetPositionY(0);
        robot.DamageBot(50); 
    }

    @Test
    void testTurretDansLeMonde() {
    assertTrue(turret.getPosX() >= world.getMinX()); 
    assertTrue(turret.getPosX() <= world.getMaxX());

    assertTrue(turret.getPosY() >= world.getMinY());
    assertTrue(turret.getPosY() <= world.getMaxY());
    }

    @Test
    void testPorterTourellePILE() {
        turret.setRange(10);

        robot.SetPositionX(turret.getPosX());
        robot.SetPositionY(turret.getPosY());
        assertTrue(turret.robotIsTarget(robot));
    }

    @Test
    void testPorterTourelleExtremiter() {
        turret.setRange(10);

        robot.SetPositionX(turret.getPosX() + 9);
        robot.SetPositionY(turret.getPosY());
        assertTrue(turret.robotIsTarget(robot));
    }

    @Test
    void testPorterToureAttaque() {

    }

}