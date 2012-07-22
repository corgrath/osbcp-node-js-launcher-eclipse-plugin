package com.osbcp.eclipseplugin.nodejslauncher;

import org.eclipse.debug.internal.ui.SWTFactory;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PluginPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	private static String DEFAULT_COMMAND = "C:\\Program Files (x86)\\nodejs\\node.exe";

	private Text textCommand;

	@Override
	protected Control createContents(final Composite parent) {
		System.out.println("create contents");
		Composite comp = SWTFactory.createComposite(parent, 1, 1, GridData.FILL_BOTH);

		SWTFactory.createLabel(comp, "Command to launch node.js:", 2);
		this.textCommand = SWTFactory.createSingleText(comp, 2);
		textCommand.addModifyListener(new PreferenceInputListener());

		String storedValue = getPreferenceStore().getString(PreferenceStoreKeys.COMMAND_ACTION.name());

		if (!isValidCommand(storedValue)) {
			performDefaults();
		} else {
			textCommand.setText(storedValue);
		}

		return parent;
	}

	public void init(final IWorkbench workbench) {
		//		setPreferenceStore();
	}

	@Override
	public IPreferenceStore getPreferenceStore() {
		return NodeJSLauncherPlugin.getDefault().getPreferenceStore();
	}

	@Override
	protected void performDefaults() {
		this.textCommand.setText(DEFAULT_COMMAND);
	}

	@Override
	public boolean performOk() {
		getPreferenceStore().setValue(PreferenceStoreKeys.COMMAND_ACTION.name(), textCommand.getText());
		return super.performOk();
	}

	@Override
	public boolean isValid() {

		setErrorMessage(null);

		if (!hasValue(textCommand)) {

			setErrorMessage("Command cannot be empty.");
			return false;

		} else {

			return true;

		}

	}

	private boolean hasValue(final Text text) {
		return isValidCommand(text.getText());
	}

	private boolean isValidCommand(final String command) {
		return !command.trim().isEmpty();
	}

	private class PreferenceInputListener extends SelectionAdapter implements ModifyListener {

		public void modifyText(final ModifyEvent e) {
			updateApplyButton();
		}

	}

}