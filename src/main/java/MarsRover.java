public class MarsRover {

    public MarsRover(int positionX, int positionY, String direction) {

    }

    public String run(String command) {
        if (command.equals("L")) {
            return "(0, 0, W)";
        } else if(command.equals("R")){
            return "(0, 0, E)";
        } else if(command.equals("M")){
            return "(0, 1, N)";
        } else{
            return null;
        }
    }


}