public class Robot{

    private String name;
    private String nameVersion;
    private int version;
    private int xpos;
    private int ypos;
    private static int counter = 0;
    
    // ---------------------------------------------------------
    // Constructor
    private Robot(String name, int version, int xpos, int ypos){
        incrementCounter();
        this.name = name;
        this.nameVersion = name + getCounter();
        this.version = version;
        this.xpos = xpos;
        this.ypos = ypos;
    }
    
    public static Robot createRobot(String name, int version, int xpos, int ypos){
        if (name.length() > 5) {
            Robot robot = new Robot(name,version,xpos,ypos);
            return robot;
        }
        return null;
    }
    // ----------------------------------------------------------
    
    // ----------------------------------------------------------
    // Getter Setter
    private String getBaseName(){
        return this.name;
    }

    public String getName(){
        return this.nameVersion;
    }

    public int getVersion(){
        return this.version;
    }

    public int getXPos(){
        return this.xpos;
    }

    public void setXPos(int xpos){
        this.xpos = xpos;
    }

    public int getYPos(){
        return this.ypos;
    }

    public void setYPos(int ypos){
        this.ypos = ypos;
    }

    public static int getCounter(){
        return counter;
    }

    public static void incrementCounter(){
        counter++;
    }
    // ----------------------------------------------------------
    
    // ----------------------------------------------------------
    // Other Methods
    public void defaultMove(){
        setXPos(this.xpos + 1);
        setYPos(this.ypos - 1);
    }
    // ----------------------------------------------------------
    

}