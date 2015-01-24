package naval.direction;

import naval.Direction;
import naval.Position;

public class DirectionEst implements Direction {
    public Position positionSuivante(Position p) {
	Position east = new Position(p.getX()+1,p.getY());
	return east;
    }
}