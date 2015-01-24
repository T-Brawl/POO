package naval;

public interface Direction {
    /**
     * fournit la position suivante de p dans cette direction
     * 
     * @return la position suivante de p dans cette direction
     */
    public Position positionSuivante(Position p);
}
