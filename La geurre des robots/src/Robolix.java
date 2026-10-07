public class Robolix extends Robot{
    private static String CreatorName = "Alix";


    public Robolix(String p_name, String p_version, World p_world, int p_HP, DamageTypes p_dmg){
        super(p_name, p_version, p_world, p_HP, p_dmg);
        this.mvtX = 3;
        this.mvtY = -1;
    }

    public static Robolix CreateRobolix(String p_name, String p_version, World p_world, int p_HP, DamageTypes p_dmg) {
    if (p_name == null || p_name.length() < 5) {
        System.out.println("Nom trop court");
        return null;
    } else {
        return new Robolix(p_name, p_version, p_world, p_HP, p_dmg);
    }
    }

}