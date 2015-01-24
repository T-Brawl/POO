package naval.direction;

import naval.Direction;
import naval.Position;

public class DirectionSud implements Direction {
    public Position positionSuivante(Position p) {
	Position south = new Position(p.getX(),p.getY()+1);
	return south;
    }
}