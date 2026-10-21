
public class Main
{
    public static void main(String[] args){
        World Monde1 = World.createWolrd(-10, 10, -10, 10);



        Turret tourelle1 = new Turret(3, Monde1, "Gilles de la tourelle");
        Turret tourelle2 = new Turret(3, Monde1, "Ramyssile");
        Turret tourelle3 = new Turret(3, Monde1, "InterContinentalBallisticDuane");
        Robolix Robot1 = Robolix.CreateRobolix("Devastator", "1.12", Monde1, 10, DamageTypes.POSITRONNIQUE);
        RobolixV2 Robot2 = RobolixV2.CreateRobolixV2("STOMPA", "117", Monde1, 10, DamageTypes.POSITRONNIQUE);
        robotduane Roboduane1 = new robotduane("Pududu", "1.8.9", Monde1, 6, DamageTypes.POSITRONNIQUE);
        robotduane2 Roboduane2 = new robotduane2("Technoblade", "1.7.2", Monde1, 20, DamageTypes.PHYSIQUE);
        RobotEVA robotEVA = new RobotEVA("EVAporateur","50.1",Monde1,15,DamageTypes.MAGIQUE);
        RobotEVAbis robotEVAbis = new RobotEVAbis("EVA.0","67.67", Monde1, 5, DamageTypes.MAGIQUE);
        Robot_Ramy robot_Ramy1 = new Robot_Ramy("Ramitraillette", "0.1", Monde1, 30, DamageTypes.POSITRONNIQUE); 
        Robot_Ramy2 robot_Ramy2 = new Robot_Ramy2("RAMIFICATOR","1.feur",Monde1, 10, DamageTypes.PHYSIQUE);

  
        Bonus bonus1 = new Bonus(Monde1);
        Bonus bonus2 = new Bonus(Monde1);
        Bonus bonus3 = new Bonus(Monde1);
        Bonus bonus4 = new Bonus(Monde1);
        Trap Trap1 = new Trap(Monde1);
        Trap Trap2 = new Trap(Monde1);
        Trap Trap3 = new Trap(Monde1);
        Trap Trap4 = new Trap(Monde1);

        Monde1.start(20);
    }
}