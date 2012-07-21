package com.osbcp.eclipseplugin.nodejs;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;


public class TabGroup extends AbstractLaunchConfigurationTabGroup {

	@Override
	public void createTabs(final ILaunchConfigurationDialog dialog, final String mode) {

		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] { new AppletMainTab(), new CommonTab() };
		setTabs(tabs);

	}

}
