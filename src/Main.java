public class Main
{
    public static void main(String[] args){
        World Monde1 = new World(-10, 10, -10, 10);
        Robot Robot1 = Robot.CreateRobot("Devastator", "1.12", -1,1, Monde1, "l'Omnimessie", 10);
        Robot Robot2 = Robot.CreateRobot("STOMPA", "117", 1,1, Monde1, "Gork", 10);

  

        Monde1.LaunchWar();
        for (int i = 0; i < 10; i++) {
            Robot1.ActionMvt(Monde1);
            Robot2.ActionMvt(Monde1);
        }
    }
}
