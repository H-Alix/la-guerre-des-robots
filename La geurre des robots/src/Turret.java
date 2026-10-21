public class Turret {
    private int range;
    private final int posX;
    private final int posY;
    private final World world;
    private int damage;
    private int reload;
    private int reloadCount = 0;
    private String TurretName;
    // private DamageTypes dmgtype;

    public Turret(int p_r, World p_world, String p_name){
        this.range = p_r;
        this.posX =  (int) (Math.random() * (Math.abs(p_world.getMaxX()) + Math.abs(p_world.getMinX()))) - (Math.abs(p_world.getMaxX()) - Math.abs(p_world.getMinX()))/2;
        this.posY =  (int) (Math.random() * (Math.abs(p_world.getMaxX()) + Math.abs(p_world.getMinX()))) - (Math.abs(p_world.getMaxX()) - Math.abs(p_world.getMinX()))/2;
        this.world = p_world;
        p_world.AddTurrets(this);
        this.reload = (int) (Math.random() * 4);
        this.damage = (int) (Math.random() * 6);
        this.TurretName = p_name;
    }

    public boolean robotIsTarget(Robot p_r){
        if ((p_r.GetPositionX() > posX - range && p_r.GetPositionX() < posX + range) && (p_r.GetPositionY() > posY - range && p_r.GetPositionY() < posY+range)){
                return (true);
        } else {
            return (false);
        }
    }

    public void setReloadCount(int p_r){
        this.reloadCount = p_r;
    }

    public void TurretAttack(){
        if (reloadCount == 0){
            for (Robot cible : world.GetListRobots()){
                if (robotIsTarget(cible) == true){
                    cible.DamageBot(damage);
                    setReloadCount(reload);
                    System.out.println(cible.GetRobotName() + " a subit " + damage + " degats de la part de la tourelle " + this.TurretName);
                }
            }
        }
    }

    public void TurretTurn(int p_t){
        if (this.reloadCount > 0){
            reloadCount--;
        }
        TurretAttack();
    }

    public int getRange() {
        return range;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public World getWorld() {
        return world;
    }

    public int getDamage() {
        return damage;
    }

    public int getReload() {
        return reload;
    }

    public int getReloadCount() {
        return reloadCount;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setReload(int reload) {
        this.reload = reload;
    }

    public String getTurretName() {
        return TurretName;
    }

    public void setTurretName(String TurretName) {
        this.TurretName = TurretName;
    }
    
}

