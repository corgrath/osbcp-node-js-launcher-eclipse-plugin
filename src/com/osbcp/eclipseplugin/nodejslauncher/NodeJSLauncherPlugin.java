package com.osbcp.eclipseplugin.nodejslauncher;

import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.console.ConsolePlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class NodeJSLauncherPlugin extends ConsolePlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "github_eclipse_plugin_osbcp_nodejs"; //$NON-NLS-1$

	// The shared instance
	private static NodeJSLauncherPlugin plugin;

	/**
	 * The constructor
	 */
	public NodeJSLauncherPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(final BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static NodeJSLauncherPlugin getDefault() {
		return plugin;
	}

	public void setBadWordsPreference(final Text newEntryText) {
		// TODO Auto-generated method stub

	}

}
