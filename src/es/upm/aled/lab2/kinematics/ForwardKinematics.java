package es.upm.aled.lab2.kinematics;

import es.upm.aled.lab2.gui.Node;

/**
 * This class implements a forward kinematics algorithm using recursion. It
 * expects a tree of Segments (defined by its length and angle with respect to
 * the previous Segment in the tree) and returns a tree of Nodes (defined by
 * their absolute coordinates in a 2-dimensional space).
 * 
 * @author rgarciacarmona
 */
public class ForwardKinematics {

	/**
	 * Returns a tree of Nodes to be used by SkeletonPanel to draw the position of
	 * an exoskeleton. This method is the public facade to a recursive method that
	 * builds the result from a tree of Segments defined by their angle and length,
	 * and the relationship between them (which Segment is children of which).
	 * 
	 * @param root    The root of the tree of Segments.
	 * @param originX The X coordinate for the origin point of the tree.
	 * @param originY The Y coordinate for the origin point of the tree.
	 * @return The tree of Nodes that represent the exoskeleton position in absolute
	 *         coordinates.
	 */
	// Public method: returns the root of the position tree
	// Fachada pública
	public static Node computePositions(Segment root, double originX, double originY) {
	    return computePositions(root, originX, originY, 0.0); // acumulado en radianes
	}

	// Recursivo (ángulos EN RADIANES)
	private static Node computePositions(Segment link, double baseX, double baseY, double accumulatedAngle) {
	    // actualizar ángulo acumulado (link.getAngle() devuelve radianes)
	    accumulatedAngle += link.getAngle();

	    double length = link.getLength();
	    double x = baseX + length * Math.cos(accumulatedAngle);
	    double y = baseY + length * Math.sin(accumulatedAngle);

	    Node node = new Node(x, y);

	    // si tiene hijos, procesarlos y añadirlos
	    for (Segment child : link.getChildren()) {
	        Node childNode = computePositions(child, x, y, accumulatedAngle);
	        node.addChild(childNode);
	    }

	    return node;
	}

}