import static tw.learn.game.location.Direction.*;

import tw.learn.game.location.Direction;

public class MarsRover {

    private int positionX;
    private int positionY;
    private Direction direction;

    public MarsRover(int positionX, int positionY, String direction) {

        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = Direction.valueOf(direction);
    }

    public String run(String command) {

        for (int i = 0; i < command.length(); i++) {

            String singleCommand = command.substring(i, i + 1);

            if ("M".equals(singleCommand)) {
                move();
            } else if ("L".equals(singleCommand)) {

                this.direction = this.direction.left();
            } else if ("R".equals(singleCommand)) {

                this.direction = this.direction.right();
            }
        }

        return String.format("(%d, %d, %s)", this.positionX, this.positionY, direction);
    }

    private void move() {
        if (direction.equals(N)) {
            positionY += 1;
        } else if (direction.equals(W)) {
            positionX -= 1;
        } else if (direction.equals(E)) {
            positionX += 1;
        }

    }


}