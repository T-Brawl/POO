package naval.direction;

import naval.Direction;
import naval.Position;

public class DirectionNord implements Direction {
    public Position positionSuivante(Position p) {
	Position north = new Position(p.getX(),p.getY()-1);
	return north;
    }
}