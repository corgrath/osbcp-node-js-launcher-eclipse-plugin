package com.osbcp.eclipseplugin.nodejs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

/**
 * The activator class controls the plug-in life cycle
 */
public class Erik implements ILaunchConfigurationDelegate {

	@Override
	public void launch(final ILaunchConfiguration configuration, final String mode, final ILaunch launch, final IProgressMonitor monitor) throws CoreException {
		System.out.println(configuration);
		System.out.println(configuration.getAttribute(IJavaLaunchConfigurationConstants.ATTR_APPLET_NAME, "default"));
		System.out.println(mode);
		System.out.println(launch);
		System.out.println(monitor);

	}

}
