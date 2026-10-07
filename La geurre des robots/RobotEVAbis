public class RobotEVAbis extends Robot {
    private static String CreatorName = "EVALEM";


    public RobotEVAbis(String p_name, String p_version, World p_world, int p_HP, DamageTypes p_dmg){
        super(p_name, p_version, p_world, p_HP, p_dmg);
        this.mvtX = -2;
        this.mvtY = 2;
    }

    public static RobotEVAbis CreateRobotEVA(String p_name, String p_version, World p_world, int p_HP, DamageTypes p_dmg) {
    if (p_name == null || p_name.length() < 5) {
        System.out.println("Nom trop court");
        return null;
    } else {
        return new RobotEVAbis (p_name, p_version, p_world, p_HP, p_dmg);
    }
    }

}
