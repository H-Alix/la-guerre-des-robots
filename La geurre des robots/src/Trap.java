public class Trap extends Bonus {

    public Trap(World p_world){
        super(p_world);
        this.valeurBonus = (int) (Math.random() * 11) -10;
    }

    @Override 
    public void AplyEffects(Robot p_robot){
        if(valeurBonus < 0){
            p_robot.DamageBot(-valeurBonus);
            this.QuantiteBonus -=1;
            System.out.println("Le robot " + p_robot.GetRobotName() + " a activé un piège et a été blessé a hauteur de " + -this.valeurBonus + " points de vie");
        }
    }
    
}
