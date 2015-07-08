package org.cytoscape.intern;

import org.cytoscape.io.write.CyNetworkViewWriterFactory;
import org.cytoscape.io.write.CyWriter;
import org.cytoscape.io.CyFileFilter;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.application.CyApplicationManager;

import java.io.OutputStream;

/**
 * Task factory that creates the file writing task.
 * 
 * @author Massoud Maher
 * @author Braxton Fitts
 * @author Ziran Zhang
 */
public class DotWriterFactory implements CyNetworkViewWriterFactory {
	
	// used to get Network/Node/Edge data from Cytoscape
	CyApplicationManager cyAppMgr;
	// TODO
	CyFileFilter fileFilter;
	
	/**
	 * Constructs a DotWriterFactory object with a given CyApplicationManager
	 * 
	 * @param cyAppMgr CyApplicationManager used in this factory to get network data
	 */
	public DotWriterFactory(CyApplicationManager cyAppMgr, CyFileFilter fileFilter) {
		// TODO
		super();
	}

	/**
	 * Returns CyFileFilter associated with this factory-- must be overridden
	 * 
	 * @return CyFileFilter for this factory
	 */
	@Override
	public CyFileFilter getFileFilter() {
		// TODO
		// to prevent compiler error
		return null;
	}
	
	/**
	 * Creates a task that writes a specified network to a specified stream
	 * 
	 * @param outStream stream that this writer writes to
	 * @param network CyNetwork that is being written
	 * 
	 * @return CyWriter that writes properties of network parameter to ostream parameter
	 */
	@Override
	public CyWriter createWriter(OutputStream outStream, CyNetwork network) {
		// TODO
		// to prevent compiler error
		return null;
	}
	
	/**
	 * Creates a task that writes a specified network to a specified stream
	 * 
	 * @param outStream stream that this writer writes to
	 * @param view CyNetworkView that is being written
	 *
	 * @return CyWriter that writes properties of network parameter to ostream parameter
	 */
	@Override
	public CyWriter createWriter(OutputStream outStream, CyNetworkView view) {
		// TODO
		// to prevent compiler error
		return null;
	}
	
}
