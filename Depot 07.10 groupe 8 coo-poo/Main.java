
public class Main
{
    public static void main(String[] args){
        World Monde1 = new World(-10, 10, -10, 10);
        Robolix Robot1 = Robolix.CreateRobolix("Devastator", "1.12", Monde1, 10, DamageTypes.POSITRONNIQUE);
        RobolixV2 Robot2 = RobolixV2.CreateRobolixV2("STOMPA", "117", Monde1, 10, DamageTypes.POSITRONNIQUE);

  
        Bonus bonus1 = new Bonus(Monde1);
        Bonus bonus2 = new Bonus(Monde1);
        Bonus bonus3 = new Bonus(Monde1);
        Bonus bonus4 = new Bonus(Monde1);
        Trap Trap1 = new Trap(Monde1);
        Trap Trap2 = new Trap(Monde1);
        Trap Trap3 = new Trap(Monde1);
        Trap Trap4 = new Trap(Monde1);

        Monde1.LaunchWar();

        
    }
}
