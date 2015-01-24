package naval.direction;

import naval.Direction;
import naval.Position;

public class DirectionOuest implements Direction {
    public Position positionSuivante(Position p) {
	Position west = new Position(p.getX()-1,p.getY());
	return west;
    }
}