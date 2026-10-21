public class Mohamed extends Robot{
 
    private final String CreatorName = "leroy9";


    public Mohamed(String p_name, String p_version, World p_world, int p_HP, DamageTypes p_dmg){
        super(p_name, p_version, p_world, p_HP, p_dmg);
        this.mvtX = -4;
        this.mvtY = 3;
    }

    public static Mohamed CreateMohamed(String p_name, String p_version, World p_world, int p_HP, DamageTypes p_dmg) {
    if (p_name == null || p_name.length() < 7) {
        System.out.println("Nom trop court");
        return null;
    } else {
        return new Mohamed (p_name, p_version, p_world, p_HP, p_dmg);
    }
    }

}
    
