import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorldTest {
    private World world;

    @BeforeEach
    public void setUp() {
        world = new World(-50, 50, -50, 50);
    }

    @Test
    public void testConstructor() {
        assertEquals(-50, world.getMinX());
        assertEquals(50, world.getMaxX());
        assertEquals(-50, world.getMinY());
        assertEquals(50, world.getMaxY());
        assertNotNull(world.GetListRobots());
        assertTrue(world.GetListRobots().isEmpty());
    }

    @Test
    public void testConstructorZero() {
        World w = new World(0, 0, 0, 0);
        assertEquals(0, w.getMinX());
        assertEquals(0, w.getMaxX());
    }

    @Test
    public void testAdd() {
        Robot r = new Robot("dudutest", "v1", world, 100, DamageTypes.PHYSIQUE);
        assertEquals(1, world.GetListRobots().size());
        assertEquals(r, world.GetListRobots().get(0));
    }

    @Test
    public void testAddNull() {
        world.AddRobot(null);
        assertTrue(world.GetListRobots().contains(null));
    }

    @Test
    public void testLaunchWar() {
        Robot r1 = new Robot("dudutest", "v1", world, 100, DamageTypes.PHYSIQUE);
        r1.SetPositionX(0);
        r1.SetPositionY(0);
        r1.mvtX = 1;
        r1.mvtY = 0;
        
        Robot r2 = new Robot("dudutest", "v1", world, 5, DamageTypes.PHYSIQUE);
        r2.SetPositionX(1);
        r2.SetPositionY(0);
        r2.mvtX = 0;
        r2.mvtY = 0;

        world.LaunchWar();
        
        assertFalse(r2.GetLive(), "Le robot 2 aurait dû être tué par le robot 1");
        assertTrue(r1.GetLive(), "Le robot 1 devrait toujours être en vie");
        assertTrue(r1.GetPositionX() > 0, "Le robot 1 devrait avoir avancé après avoir tué");
    }

    @Test
    public void testLaunchWarNull() {
        world.AddRobot(null);
        assertThrows(NullPointerException.class, () -> {
            world.LaunchWar();
        });
    }
}
