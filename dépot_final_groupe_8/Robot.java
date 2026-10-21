
/**
 * Classe contenant les attributs méthodes communes a tous les types de robots
 * @author Alix
 * @version J'ai pas compté
 * Robot
 */
public class Robot {
    private final String robotName;
    private int positionX = 0;
    private int positionY = 0;
    private final String robotVersion;
    private static int COMPTEUR =0;
    protected int mvtX;
    protected int mvtY;
    private World worldName;
    private int HP;
    private int HPMAX;
    private DamageTypes DmgType;
    private boolean alive = true;
    protected int Damage = 5;
    // protected String spritePath = "assets/STOMPA.png";

    /**
     * Constructeur de la classe robot, les valeurs de positions du robot sont générées aléatoirement en fonction de la taille du monde.
     * @param p_name Nom qui sera donné au robot (String)
     * @param p_version Version attribuée au robot, sous forme de String
     * @param p_world Monde dans lequel le robot évolue (Référence a une classe de type monde)
     * @param p_HP Points de vie maximaux du robot (int)
     * @param p_dmg Le type de dégats infligé par le robot (enum DamageTypes)
     */
    public Robot(String p_name, String p_version, World p_world, int p_HP, DamageTypes p_dmg) {
        COMPTEUR ++;
        this.robotName = p_name+COMPTEUR;
        this.robotVersion = p_version;
        this.worldName = p_world;
        this.HP = p_HP;
        this.HPMAX = p_HP;
        p_world.AddRobot(this);
        this.DmgType = p_dmg;
        this.positionX = (int) (Math.random() * (Math.abs(p_world.getMaxX()) + Math.abs(p_world.getMinX()))) - (Math.abs(p_world.getMaxX()) + Math.abs(p_world.getMinX()))/2;
        this.positionY = (int) (Math.random() * (Math.abs(p_world.getMaxX()) + Math.abs(p_world.getMinX()))) - (Math.abs(p_world.getMaxX()) + Math.abs(p_world.getMinX()))/2;
    }

    public String getRobotName() {
        return robotName;
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


    public String getRobotVersion() {
        return robotVersion;
    }


    public static int getCOMPTEUR() {
        return COMPTEUR;
    }


    public static void setCOMPTEUR(int cOMPTEUR) {
        COMPTEUR = cOMPTEUR;
    }


    public int getMvtX() {
        return mvtX;
    }


    public void setMvtX(int mvtX) {
        this.mvtX = mvtX;
    }


    public int getMvtY() {
        return mvtY;
    }


    public void setMvtY(int mvtY) {
        this.mvtY = mvtY;
    }


    public World getWorldName() {
        return worldName;
    }


    public void setWorldName(World worldName) {
        this.worldName = worldName;
    }


    public int getHP() {
        return HP;
    }


    public void setHP(int hP) {
        HP = hP;
    }


    public int getHPMAX() {
        return HPMAX;
    }


    public void setHPMAX(int hPMAX) {
        HPMAX = hPMAX;
    }


    public DamageTypes getDmgType() {
        return DmgType;
    }


    public void setDmgType(DamageTypes dmgType) {
        DmgType = dmgType;
    }


    public boolean isAlive() {
        return alive;
    }


    public void setAlive(boolean alive) {
        this.alive = alive;
    }


    public int getDamage() {
        return Damage;
    }


    public void setDamage(int damage) {
        Damage = damage;
    }



    /**
     *Donne une description basique du robot (Nom, vie, position X et Y)
     */
    public void RobotDesc(){
        System.out.println("Robot name : " + this.robotName);
        System.out.println("Robot health : " + this.HP);
        System.out.println("Robot position - X : " + this.positionX + "Y : " + this.positionY);  
    }

    public void SetPositionX(int p_posX){
        this.positionX = p_posX;
    }

    public void SetPositionY(int p_posY) {
        this.positionY = p_posY;
    }

    public int GetPositionX() {
        return(positionX);
    }

    public int GetPositionY() {
        return(positionY);
    }

    public String GetRobotName() {
        return(this.robotName);
    }

    public String GetRobotVersion(){
        return(this.robotVersion);
    }

   

    public int GetMvtX() {
        return(this.mvtX);
    }

    public int GetMvtY() {
        return(this.mvtY);
    }

    

    public int GetNextX(){
        return(this.positionX + mvtX);
    }
    public int GetNextY() {
        return(this.positionY + mvtY);
    }

    public boolean GetLive() {
        return (this.alive);
    }

    public int GetHP(){
        return(this.HP);
    }

    /**
     * Méthode permettant mettre a jour la position X et Y du robot grâce aux integer de mouvement X et Y
     */
    public void RobotDeplacement() {
        this.positionY += mvtY;
        this.positionX += mvtX;
    }

    /**
     * Méthode permettant de réaliser l'appel de constructeur de la classe robot tout en s'assurant que la taille du string de nom est conforme
     * @param p_name Nom qui sera donné au robot (String)
     * @param p_version Version attribuée au robot, sous forme de String
     * @param p_world Monde dans lequel le robot évolue (Référence a une classe de type monde)
     * @param p_HP Points de vie maximaux du robot (int)
     * @param p_dmg Le type de dégats infligé par le robot (enum DamageTypes)
     * @return Retourne un null si le robot n'a pas une taille de nom conforme
     */
    public static Robot CreateRobot(String p_name, String p_version, World p_world, int p_HP, DamageTypes p_dmg) {
    if (p_name == null || p_name.length() < 5) {
        System.out.println("Nom trop court");
        return null;
    } else {
        return new Robot(p_name, p_version, p_world, p_HP, p_dmg);
    }
    }

    /**
     * Méthode permettant de vérifier si les mouvements du robot ne dépassent pas de la taille du monde avant de les effectuer. Si le robot dépasse le déplacement n'a pas lieu et le robot inverse sa méthode dé déplacement
     * @param world Monde dans lequel le robot se déplace (Class World)
     */
    public void ActionMvt(World world) {
        if (this.positionY + this.mvtY > world.getMinY() && this.positionY + this.mvtY < world.getMaxY() && this.positionX + mvtX > world.getMinX() &&  this.positionX + mvtX < world.getMaxX()) {
            RobotDeplacement();
        } else {
            System.out.println(this.robotName + " a fait demi tour");
            this.reverseMvt();
            RobotDeplacement();
        }
    }

    
    /**
     * Méthode permettant d'infliger des dégats et réduire les points de vie du robot
     * @param p_dgt Integer représentant le nombre de point de vie qui vont être soustraits au robot
     */
    public void DamageBot(int p_dgt){
        this.HP = this.HP - p_dgt;
        if (this.HP <= 0){
            this.alive = false;
            this.SetPositionX(100);
            this.SetPositionY(100);
            System.out.println(this.robotName + " est mort");
        }
    }

    /**
     * Méthode permettant de soigner le robot, augmentant ses points de vie sans pour autant  dépasser ses point de vie maximaux
     * @param p_heal Integer représentant la quantité de point de vie qui vont être restauré au robot
     */
    public void HealBot (int p_heal){
        if (p_heal > 0) {
            this.HP = this.HP + p_heal;
            if(this.HP > this.HPMAX){
                this.HP = this.HPMAX;
            }
        }
    }

    /**
     * Méthode inversant les valeurs de mouvement du robot
     */
    public void reverseMvt(){
        this.mvtX = 0 - this.mvtX;
        this.mvtY = 0 - this.mvtY;
    }

    /**
     * Méthode permettant de réaliser d'infliger des dégats a un autre robot en fonction du type de dégats.
     * @param p_cible Robot cible qui va subir les dégats infligés.
     */
    public void RobotAttack (Robot p_cible){
        if (p_cible.DmgType == DamageTypes.MAGIQUE && this.DmgType == DamageTypes.MAGIQUE) {
            System.out.println("Les deux robots sont magiques, les dégats s'annulent !");
        } else if (p_cible.DmgType == DamageTypes.POSITRONNIQUE && this.DmgType == DamageTypes.POSITRONNIQUE) {
            p_cible.DamageBot(this.Damage*2);
            System.out.println(p_cible.GetRobotName() + " a subit " + this.Damage*2 + " " + DmgType.name() + " de l'attaque de " + this.GetRobotName());
        } else {
            p_cible.DamageBot(this.Damage);
            System.out.println(p_cible.GetRobotName() + " a subit " + this.Damage + " " + DmgType.name() + " de l'attaque de " + this.GetRobotName());
        }
    }

}
