public class Bonus {
    private int positionX;
    private int positionY;
    private int valeurBonusVie;
    private int QuantiteBonus;
    private boolean on = true;

    public Bonus(World p_world){
        this.positionX = (int) (Math.random() * 21) - 10; 
        this.positionY = (int) (Math.random() * 21) - 10;
        this.valeurBonusVie = (int) (Math.random() * 11);
        p_world.AddBonus(this);
    }

    public void effet(Robot p_robot){
        if (this.on == true){
        p_robot.HealBot(valeurBonusVie);
        this.QuantiteBonus -=1;
        System.out.println("Le robot " + p_robot.GetRobotName() + " a été soigné de " + this.valeurBonusVie + " points de vie");
        if (this.QuantiteBonus <= 0){
            this.on = false;
        }
        }
    }

    public int GetX(){
        return(this.positionX);
    }

    public int GetY(){
        return(this.positionY);
    }
}
