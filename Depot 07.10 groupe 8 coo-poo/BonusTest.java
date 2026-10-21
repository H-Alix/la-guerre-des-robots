import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BonusTest {
    private World world;
    private Bonus bonus;
    private Robot robot;

    @BeforeEach
    public void setUp() {
        world = new World(-100, 100, -100, 100);
        bonus = new Bonus(world);
        bonus.valeurBonus = 20;
        bonus.QuantiteBonus = 1;

        robot = new Robot("dudutest", "v1", world, 100, DamageTypes.PHYSIQUE);
        robot.SetPositionX(0);
        robot.SetPositionY(0);
        robot.DamageBot(50); 
    }


    @Test
    public void testAplyEffectsSoigne() {
        int hpAvant = robot.GetHP();
        bonus.AplyEffects(robot);
        assertTrue(robot.GetHP() > hpAvant);
    }

    @Test
    public void testAplyEffectsInactif() {
        bonus.valeurBonus = 0;
        int hpAvant = robot.GetHP();
        bonus.AplyEffects(robot);
        assertEquals(hpAvant, robot.GetHP());
    }

    @Test
    public void testEffetActif() {
        int hpAvant = robot.GetHP();
        bonus.effet(robot);
        assertTrue(robot.GetHP() > hpAvant);
    }

    @Test
    public void testEffetEpuise() {
        bonus.effet(robot);
        int hpApremierUsage = robot.GetHP();
        bonus.effet(robot);
        assertEquals(hpApremierUsage, robot.GetHP());
    }
}
