public class RobotEVA extends Robot{
    private static String CreatorName = "LEMOINE";


    public RobotEVA(String p_name, String p_version, World p_world, int p_HP, DamageTypes p_dmg){
        super(p_name, p_version, p_world, p_HP, p_dmg);
        this.mvtX = 2;
        this.mvtY = -2;
    }

    public static RobotEVA CreateRobotEVA(String p_name, String p_version, World p_world, int p_HP, DamageTypes p_dmg) {
    if (p_name == null || p_name.length() < 5) {
        System.out.println("Nom trop court");
        return null;
    } else {
        return new RobotEVA (p_name, p_version, p_world, p_HP, p_dmg);
    }
    }

}
