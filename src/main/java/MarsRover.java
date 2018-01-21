public class MarsRover {


    private int positionX;
    private int positionY;
    private String direction;

    public MarsRover(int positionX, int positionY, String direction) {

        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
    }

    public String run(String command) {
        if (command.equals("L")) {
            return "(0, 0, W)";
        } else if(command.equals("R")){
            return "(0, 0, E)";
        } else if(command.equals("M")){
             move();
            return String.format("(%d, %d, %s)", positionX, positionY, direction);
        } else{
            return null;
        }
    }

    private void move() {
        if (direction.equals("N")) {
            positionY += 1;
        }
    }


}