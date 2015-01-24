package pfc;

public interface Strategie {
    /**
     * @return a <code>Coup</code> according the rules of the strategy implemented.
     */
    public Coup choixCoup();
}