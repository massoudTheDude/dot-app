package org.cytoscape.intern;

import org.cytoscape.view.presentation.property.values.LineType;
import org.cytoscape.view.presentation.property.values.NodeShape;
import org.cytoscape.view.presentation.property.values.VisualPropertyValue;
import org.cytoscape.view.model.VisualProperty;

import java.util.HashMap;


/**
 * Handles mapping of CyNode properties to .dot equivalent Strings
 * 
 * @author Massoud Maher
 * @author Braxton Fitts
 * @author Ziran Zhang
 */
public class NodePropertyMapper extends Mapper {
	
	/**
	 * maps Cytoscape properties by their ID strings to their .dot equivalents if relationship is simple
	 */
	private HashMap< VisualProperty<Object>, String> simpleVisPropsToDot = new HashMap<VisualProperty<Object>, String>();
	
	/**
	 * maps Cytoscape VisualProperty TYPES by their String ID to a HashMap that contains the 
	 * cytoscape to *.dot mappings for that type
	 */
	private HashMap<String, HashMap<VisualPropertyValue, String> > discreteMappingTypes; // TODO
	
	/**
	 *  maps Cytoscape node shape types to the equivalent string used in .dot
	 */
	private HashMap<NodeShape, String> nodeShapeMap; // TODO
	
	public String mapDotStyle(LineType lineStyle, NodeShape nodeShape) {
		// TODO
		/**
		 * Pseudocode
		 * Call Mapper.mapDotStyle(lineStyle) to retrieve 'style="lineStyle"' string
		 * Ignore final " (get first n-1 characters of string)
		 * Join with "filled" and "rounded" separated by ","
		 * return created String
		 */
		return null;
	}

}
