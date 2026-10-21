public class Bonus {
    protected int positionX = 1;
    protected int positionY = 1;
    protected int valeurBonus;
    protected int QuantiteBonus;
    private boolean on = true;
    protected String Heal = "Assets/heal.png";

    public Bonus(World p_world){
        this.positionX = (int) (Math.random() * (Math.abs(p_world.getMaxX()) + Math.abs(p_world.getMinX()))) - (Math.abs(p_world.getMaxX()) + Math.abs(p_world.getMinX()))/2; 
        this.positionY = (int) (Math.random() * (Math.abs(p_world.getMaxY()) + Math.abs(p_world.getMinY()))) - (Math.abs(p_world.getMaxY()) + Math.abs(p_world.getMinY()))/2;
        this.valeurBonus = (int) (Math.random() * 4);
        p_world.AddBonus(this);
    }

    public void effet(Robot p_robot){
        if (this.on == true){
            AplyEffects(p_robot);
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

    public void AplyEffects(Robot p_robot){
        if(valeurBonus > 0){
                p_robot.HealBot(valeurBonus);
                this.QuantiteBonus -=1;
                if (this.QuantiteBonus == 0 ){
                    this.positionX = 50;
                    this.positionY = 50;
                }
                System.out.println("Le robot " + p_robot.GetRobotName() + " a été soigné de " + this.valeurBonus + " points de vie");
        }
    }

    public String GetSpritePath() { 
        return Heal; 
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getValeurBonus() {
        return valeurBonus;
    }

    public void setValeurBonus(int valeurBonus) {
        this.valeurBonus = valeurBonus;
    }

    public int getQuantiteBonus() {
        return QuantiteBonus;
    }

    public void setQuantiteBonus(int quantiteBonus) {
        QuantiteBonus = quantiteBonus;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public String getHeal() {
        return Heal;
    }

    public void setHeal(String heal) {
        Heal = heal;
    }
