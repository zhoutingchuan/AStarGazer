package astargazer.map.neighbor;

import java.util.List;

import astargazer.map.TileMap;
import astargazer.map.WeightedPoint;
import astargazer.map.heuristic.HeuristicScheme;

/**
 * Selects the group of neighboring points to be considered in the next step of the algorithm
 * 
 * @author Matt Yanos
 */
public abstract class NeighborSelector
{
    /**
     * Returns a list of neighboring points to be considered in the next step of the algorithm
     * 
     * @param map
     * @param cursor
     * @param distanceCalculator
     * @return
     *         neighbors
     */
    public abstract List<WeightedPoint> getNeighbors(TileMap map, WeightedPoint cursor, HeuristicScheme distanceCalculator);

    /**
     * Get the label
     * 
     * @return label
     */
    public abstract String getLabel();

    /**
     * Get an HTML formatted String explaining the neighbor selector
     * 
     * @return explanation
     */
    public abstract String getExplanation();

    public String toString()
    {
        return getLabel();
    }

    /**
     * Get all the neighbor selectors that extend this base abstract class
     * 
     * @return neighborSelectors
     */
    public static NeighborSelector[] getAllNeighborSelectors()
    {
        return new NeighborSelector[] {new NeighborFourDirections(), new NeighborEightDirections(), new NeighborJumpPoint()};
    }
}
