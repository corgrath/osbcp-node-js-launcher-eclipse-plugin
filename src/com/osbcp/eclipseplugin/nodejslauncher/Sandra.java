package com.osbcp.eclipseplugin.nodejslauncher;

import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;

public class Sandra implements ILaunchShortcut {

	@Override
	public void launch(final ISelection selection, final String mode) {
		System.out.println("selection=" + selection);
		System.out.println("mode=" + mode);

	}

	@Override
	public void launch(final IEditorPart editor, final String mode) {
		System.out.println("editor=" + editor);
		System.out.println("mode=" + mode);

	}

	//	protected void launch() {
	//		try {
	//			ILaunchConfiguration config = findLaunchConfiguration(type, mode);
	//			if (config != null) {
	//				config.launch(mode, null);
	//			}
	//		} catch (CoreException e) {
	//			/* Handle exceptions*/
	//		}
	//	}

}
