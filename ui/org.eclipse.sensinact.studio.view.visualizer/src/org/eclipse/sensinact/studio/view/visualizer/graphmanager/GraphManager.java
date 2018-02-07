/**
 * Copyright (c) 2018 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     CEA - initial API and implementation and/or initial documentation
 */
package org.eclipse.sensinact.studio.view.visualizer.graphmanager;

import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.nebula.visualization.xygraph.dataprovider.CircularBufferDataProvider;
import org.eclipse.nebula.visualization.xygraph.figures.Trace;
import org.eclipse.nebula.visualization.xygraph.figures.Trace.PointStyle;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.nebula.visualization.xygraph.figures.XYGraph;
import org.eclipse.swt.widgets.Display;

/**
 * @author Etienne Gandrille
 */
public class GraphManager {

	private final XYGraph graph;
	private final AtomicBoolean isRuning;
	private double value;
	private final CircularBufferDataProvider traceDataProvider;
	private final Trace trace;

	private final double Y_MIN_INIT = 0;
	private final double Y_MAX_INIT = 1;
	private double yMin = Y_MIN_INIT;
	private double yMax = Y_MAX_INIT;

	private final int TIMER_PERIOD_MS = 250;
	private final int NUMBER_OF_VALUES = 100;
	
	public GraphManager(XYGraph graph) {
		this.graph = graph;
		this.isRuning = new AtomicBoolean(false);

		graph.setTitle("");
		graph.primaryXAxis.setTitle("Time");
		graph.primaryXAxis.setDateEnabled(true);
		graph.primaryXAxis.setFormatPattern("HH:mm:ss");
		
		
		graph.primaryYAxis.setTitle("value");
		graph.primaryYAxis.setAutoScale(false);
		graph.primaryXAxis.setAutoScale(true);
		
		traceDataProvider = new CircularBufferDataProvider(true);
		traceDataProvider.setBufferSize(NUMBER_OF_VALUES);

		trace = new Trace("values", graph.primaryXAxis, graph.primaryYAxis, traceDataProvider);
		trace.setPointStyle(PointStyle.POINT);
		graph.addTrace(trace);
		graph.setShowLegend(false);
	}

	public void start(ResourceDescriptor rDescriptor) {
		if (!isRuning.getAndSet(true)) {
			traceDataProvider.clearTrace();

			graph.setTitle(rDescriptor.getDevice() + "/" + rDescriptor.getService() + "/" + rDescriptor.getResource());
			yMin = Y_MIN_INIT;
			yMax = Y_MAX_INIT;
			trace.getYAxis().setRange(Y_MIN_INIT,Y_MAX_INIT);
						
			Runnable updater = new Runnable() {
				public void run() {
					double curVal = value; // local copy
					traceDataProvider.setCurrentYData(curVal, System.currentTimeMillis());
					
					if (yMin > curVal) {
						yMin = curVal;
						trace.getYAxis().setRange(yMin, yMax);
					} else if (yMax < curVal) {
						yMax = curVal;
						trace.getYAxis().setRange(yMin, yMax);
					}

					if (isRuning.get()) {
						Display.getDefault().timerExec(TIMER_PERIOD_MS, this);
					}
				}
			};

			Display.getDefault().timerExec(0, updater);
		}
	}

	public void stop() {
		isRuning.set(false);
	}

	public void setValue(double newValue) {
		value = newValue;
	}

	boolean isRunning() {
		return isRuning.get();
	}
}
