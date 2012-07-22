package com.osbcp.eclipseplugin.nodejslauncher;


import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.internal.ui.SWTFactory;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

public class AppletMainTab extends AbstractLaunchConfigurationTab {

	private Text fNameText;

	@Override
	public String getName() {
		return "Apple tommy name";
	}

	@Override
	public void initializeFrom(final ILaunchConfiguration config) {

		try {
			fNameText.setText(config.getAttribute(IJavaLaunchConfigurationConstants.ATTR_APPLET_NAME, "may_default?"));
		} catch (CoreException CE) {
			fNameText.setText("");
		}
	}

	@Override
	public void performApply(final ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(IJavaLaunchConfigurationConstants.ATTR_APPLET_NAME, fNameText.getText());
	}

	@Override
	public void setDefaults(final ILaunchConfigurationWorkingCopy arg0) {
	}

	@Override
	public boolean isValid(final ILaunchConfiguration launchConfig) {
		setErrorMessage(null);
		if (fNameText.getText().trim().isEmpty()) {
			setErrorMessage("Height is not an integer");
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void createControl(final Composite parent) {
		Composite comp = SWTFactory.createComposite(parent, 1, 1, GridData.FILL_HORIZONTAL);
		setControl(comp);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(), "this is help system");
		Composite namecomp = SWTFactory.createComposite(comp, comp.getFont(), 4, 1, GridData.FILL_HORIZONTAL, 0, 0);
		SWTFactory.createLabel(namecomp, "label1", 1);
		fNameText = SWTFactory.createSingleText(namecomp, 1);
		//		fNameText.addModifyListener(fListener);

		//		SWTFactory.createLabel(namecomp, LauncherMessages.appletlauncher_argumenttab_heightlabel_text, 1);
		//		fHeightText = SWTFactory.createSingleText(namecomp, 1);
		//		fHeightText.addModifyListener(fListener);
		//		Label blank = new Label(namecomp, SWT.NONE);
		//		blank.setText(EMPTY_STRING);
		//		Label hint = SWTFactory.createLabel(namecomp, LauncherMessages.AppletParametersTab__optional_applet_instance_name__1, 1);
		//		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		//		hint.setLayoutData(gd);
		//		SWTFactory.createVerticalSpacer(comp, 1);
		//		Composite paramcomp = SWTFactory.createComposite(comp, comp.getFont(), 2, 1, GridData.FILL_BOTH, 0, 0);
		//		SWTFactory.createLabel(paramcomp, LauncherMessages.appletlauncher_argumenttab_parameterslabel_text, 2);
		//		Table ptable = new Table(paramcomp, SWT.FULL_SELECTION | SWT.BORDER);
		//		fViewer = new TableViewer(ptable);
		//		gd = new GridData(GridData.FILL_BOTH);
		//		ptable.setLayoutData(gd);
		//		TableColumn column1 = new TableColumn(ptable, SWT.NONE);
		//		column1.setText(LauncherMessages.appletlauncher_argumenttab_parameterscolumn_name_text);
		//		TableColumn column2 = new TableColumn(ptable, SWT.NONE);
		//		column2.setText(LauncherMessages.appletlauncher_argumenttab_parameterscolumn_value_text);
		//		TableLayout tableLayout = new TableLayout();
		//		ptable.setLayout(tableLayout);
		//		tableLayout.addColumnData(new ColumnWeightData(100));
		//		tableLayout.addColumnData(new ColumnWeightData(100));
		//		ptable.setHeaderVisible(true);
		//		ptable.setLinesVisible(true);
		//		ptable.addSelectionListener(fListener);
		//		ptable.addMouseListener(new MouseAdapter() {
		//
		//			@Override
		//			public void mouseDoubleClick(final MouseEvent e) {
		//				setParametersButtonsEnableState();
		//				if (fParametersEditButton.isEnabled()) {
		//					handleParametersEditButtonSelected();
		//				}
		//			}
		//		});
		//		fViewer.setContentProvider(new IStructuredContentProvider() {
		//
		//			public Object[] getElements(final Object inputElement) {
		//				Map params = (Map) inputElement;
		//				return params.keySet().toArray();
		//			}
		//
		//			public void dispose() {
		//			}
		//
		//			public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
		//			}
		//		});
		//		fViewer.setLabelProvider(new ITableLabelProvider() {
		//
		//			public Image getColumnImage(final Object element, final int columnIndex) {
		//				return null;
		//			}
		//
		//			public String getColumnText(final Object element, final int columnIndex) {
		//				if (columnIndex == 0) {
		//					return element.toString();
		//				}
		//				String key = (String) element;
		//				Map params = (Map) fViewer.getInput();
		//				Object object = params.get(key);
		//				if (object != null)
		//					return object.toString();
		//				return null;
		//			}
		//
		//			public void addListener(final ILabelProviderListener listener) {
		//			}
		//
		//			public void dispose() {
		//			}
		//
		//			public boolean isLabelProperty(final Object element, final String property) {
		//				return false;
		//			}
		//
		//			public void removeListener(final ILabelProviderListener listener) {
		//			}
		//		});
		//		fViewer.setComparator(new ViewerComparator());
		//		Composite envcomp = SWTFactory.createComposite(paramcomp, paramcomp.getFont(), 1, 1, GridData.VERTICAL_ALIGN_BEGINNING | GridData.HORIZONTAL_ALIGN_FILL, 0, 0);
		//		fParametersAddButton = createPushButton(envcomp, LauncherMessages.appletlauncher_argumenttab_parameters_button_add_text, null);
		//		fParametersAddButton.addSelectionListener(fListener);
		//		fParametersEditButton = createPushButton(envcomp, LauncherMessages.appletlauncher_argumenttab_parameters_button_edit_text, null);
		//		fParametersEditButton.addSelectionListener(fListener);
		//		fParametersRemoveButton = createPushButton(envcomp, LauncherMessages.appletlauncher_argumenttab_parameters_button_remove_text, null);
		//		fParametersRemoveButton.addSelectionListener(fListener);
		//		setParametersButtonsEnableState();
		//		Dialog.applyDialogFont(parent);

	}
}
