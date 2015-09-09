package org.cytoscape.intern.read.reader;

import static org.cytoscape.view.presentation.property.BasicVisualLexicon.NETWORK_BACKGROUND_PAINT;

import java.awt.Color;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.tuple.Pair;
import org.cytoscape.model.CyIdentifiable;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;
import org.cytoscape.view.model.VisualProperty;
import org.cytoscape.view.presentation.RenderingEngineManager;
import org.cytoscape.view.vizmap.VisualStyle;

import com.alexmerz.graphviz.objects.Graph;

/**
 * Class that contains definitions and some implementation for converting a
 * dot graph to a CyNetwork. Data is passed in as a JPGD Graph object.
 * This subclass handles importing of network/graph properties
 * 
 * @author Massoud Maher
 * @author Braxton Fitts
 * @author Ziran Zhang
 */
public class NetworkReader extends Reader{


	// JPGD object that contains visual information for this network view
	private Graph graph;

	/**
	 * Constructs an object of type Reader.
	 * 
	 * 
	 * @param networkView view of network we are creating/modifying
	 * @param vizStyle VisualStyle that we are applying to the network
	 * @param defaultAttrs Map that contains default attributes for Reader of this type
	 * eg. for NodeReader will be a list of default
	 * @param rendEngMgr RenderingEngineManager that contains the default
	 * VisualLexicon needed for gradient support
	 */
	public NetworkReader(CyNetworkView networkView, VisualStyle vizStyle, Map<String, String> defaultAttrs, Graph graph, RenderingEngineManager rendEngMgr) {
		super(networkView, vizStyle, defaultAttrs, rendEngMgr);
		this.graph = graph;
	}

	/**
	 * Does nothing. A network view has no GraphViz attributes that correspond
	 * to a single Cytoscape VisualProperty
	 */
	@Override
	@SuppressWarnings("rawtypes")
	protected Pair<VisualProperty, Object> convertAttribute(String name, String val) {
		return null;
	}

	/**
	 * Overwrites the default VisualProperty values for the Cytoscape VisualStyle
	 * that came from converting the default attribute list with new values from
	 * converting the attribute list from the JPGD object that corresponds to
	 * the network view.
	 */
	@Override
	protected void setBypasses() {
		//Network doesn't set bypass value with the Graph object's attributes
		//overrides the defaults set in setDefault()
		LOGGER.info("Setting the Bypass values for Visual Style...");

		String colorScheme = graph.getAttributes().get("colorscheme");
		for (Entry<String, String> attrEntry : graph.getAttributes().entrySet()) {
			String attrKey = attrEntry.getKey();
			String attrVal = attrEntry.getValue();
			if (attrKey.equals("bgcolor")) {
				setColor(attrVal, vizStyle, ColorAttribute.BGCOLOR, colorScheme);
			}
		}
	}

	/**
	 * Does nothing. A network view does not set a color attribute with a
	 * bypass.
	 */
	@Override
	protected void setColor(String attrVal,
			View<? extends CyIdentifiable> elementView, ColorAttribute attr, String colorScheme) {
		//Network doesn't set Background color with bypass
	}

	@Override
	protected void setColor(String attrVal, VisualStyle vizStyle,
			ColorAttribute attr, String colorScheme) {
		Color color = convertColor(attrVal, colorScheme);
		switch (attr) {
			case BGCOLOR: {
				vizStyle.setDefaultValue(NETWORK_BACKGROUND_PAINT, color);
				break;
			}
			default: {
				break;
			}
		}
	}

	@Override
	protected void setColorDefaults(VisualStyle vizStyle, String colorScheme) {
		String colorAttribute = defaultAttrs.get("bgcolor");
		if (colorAttribute != null) {
			List<Pair<Color, Float>> colorListValues = convertColorList(colorAttribute, colorScheme);
			if (colorListValues != null) {
				Color color = colorListValues.get(0).getLeft();
				colorAttribute = String.format("#%2x%2x%2x%2x", color.getRed(), color.getGreen(),
						color.getBlue(), color.getAlpha());
			}
			setColor(colorAttribute, vizStyle, ColorAttribute.BGCOLOR, colorScheme);
		}
		
	}

	/**
	 * Does nothing. The GraphViz style attribute does not affect the
	 * network view
	 */
	@Override
	protected void setStyle(String attrVal,
			View<? extends CyIdentifiable> elementView) {
		//Network doesn't have properties set with style attribute
	}

	/**
	 * Does nothing. The GraphViz style attribute does not affect the
	 * network view
	 */
	@Override
	protected void setStyle(String attrVal, VisualStyle vizStyle) {
		//Network doesn't have properties set with style attribute
	}
}
