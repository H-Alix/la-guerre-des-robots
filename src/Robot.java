public class robot {
    private final String robotName;
    private int positionX = 0;
    private int positionY = 0;
    private final String robotVersion;

    public robot(String p_name, String p_version) {
        this.robotName = p_name;
        this.robotVersion = p_version;
    }

    public void setpositionX(int p_positionX) {
        this.positionX = p_positionX;
    }
    public int getpositionX() {
        return this.positionX;
    }

    public void setpositionY(int p_positionY) {
        this.positionY = p_positionY;
    }
    public int getpositionY() {
        return this.positionY;
    }

    public void getrobotName() {
        System.out.println("Robot Name: " + this.robotName);
    }

    public void getrobotVersion() {
        System.out.println("Robot Version: " + this.robotVersion);
    }

}

