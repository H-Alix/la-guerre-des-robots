public class Robot_Ramy extends Robot{
    private static String CreatorName = "Ramy";


    public Robot_Ramy(String p_name, String p_version, World p_world, int p_HP, DamageTypes p_dmg){
        super(p_name, p_version, p_world, p_HP, p_dmg);
        super.mvtX = 3;
        super.mvtY = -5;
    }

    public static Robot_Ramy CreateRobot_Ramy(String p_name, String p_version, World p_world, int p_HP, DamageTypes p_dmg) {
    if (p_name == null || p_name.length() < 5) {
        System.out.println("Nom trop court");
        return null;
    } else {
        return new Robot_Ramy (p_name, p_version, p_world, p_HP, p_dmg);
    }
    }

}