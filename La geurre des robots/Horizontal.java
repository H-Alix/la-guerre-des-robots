
public class Horizontal extends robot {
    public Horizontal (String p_name,String p_version,World p_world,String p_creator,int p_HP) {
    super(p_name, p_version, 2, 0, p_world, p_creator, p_HP);}

    public void DisplayMovement() {
        System.out.println(GetRobotName());
    }
    
}
