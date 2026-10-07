public class RobolixV2 extends Robot{
 
    private final String CreatorName = "Alix";


    public RobolixV2(String p_name, String p_version, World p_world, int p_HP, DamageTypes p_dmg){
        super(p_name, p_version, p_world, p_HP, p_dmg);
        this.mvtX = 4;
        this.mvtY = 3;
    }

    public static RobolixV2 CreateRobolixV2(String p_name, String p_version, World p_world, int p_HP, DamageTypes p_dmg) {
    if (p_name == null || p_name.length() < 5) {
        System.out.println("Nom trop court");
        return null;
    } else {
        return new RobolixV2 (p_name, p_version, p_world, p_HP, p_dmg);
    }
    }

}

