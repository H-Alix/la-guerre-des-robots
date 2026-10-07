public class robotduane2 extends Robot{
    private static String CreatorName = "Duane";


    public robotduane2(String p_name, String p_version, World p_world, int p_HP, DamageTypes p_dmg){
        super(p_name, p_version, p_world, p_HP, p_dmg);
        this.mvtX = -3;
        this.mvtY = 3;
    }

    

    public static robotduane2 createrobotduane2(String p_name, String p_version, World p_world, int p_HP, DamageTypes p_dmg) {
    if (p_name == null || p_name.length() < 5) {
        System.out.println("Nom trop court");
        return null;
    } else {
        return new robotduane2(p_name, p_version, p_world, p_HP, p_dmg);
    }
    }

}

