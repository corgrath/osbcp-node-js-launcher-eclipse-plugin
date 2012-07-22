package com.osbcp.eclipseplugin.nodejslauncher;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IOConsoleOutputStream;
import org.eclipse.ui.console.MessageConsole;

/**
 * The activator class controls the plug-in life cycle
 */
public class Erik extends LaunchConfigurationDelegate {

	@Override
	public void launch(final ILaunchConfiguration configuration, final String mode, final ILaunch launch, final IProgressMonitor monitor) throws CoreException {

		String command = NodeJSLauncherPlugin.getDefault().getPreferenceStore().getString(PreferenceStoreKeys.COMMAND_ACTION.name());
		String argument = configuration.getAttribute(IJavaLaunchConfigurationConstants.ATTR_APPLET_NAME, "--help");

		System.out.println("command=" + command);
		System.out.println("argument=" + argument);

		String[] commandLine = new String[] { command, argument };
		Process compilerProcess = DebugPlugin.exec(commandLine, new File("C:\\christoffer\\workspace_home\\git_java_whatboyswant_crawler\\whatboys_sexy\\"));

		IProcess dbgProcess = DebugPlugin.newProcess(launch, compilerProcess, "XVR Compiler");

		try {
			compilerProcess.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (compilerProcess.exitValue() != 0) {
			return;
		}
		launch.removeProcess(dbgProcess);

	}

	public void launch2(final ILaunchConfiguration configuration, final String mode, final ILaunch launch, final IProgressMonitor monitor) throws CoreException {

		final IOConsole myConsole = findConsole("elhohlh");

		ConsolePlugin.getDefault().getConsoleManager().showConsoleView(myConsole);
		ConsolePlugin.getDefault().getConsoleManager().refresh(myConsole);
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {

				try {
					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					String id = IConsoleConstants.ID_CONSOLE_VIEW;

					for (IViewPart view : page.getViews()) {
						System.out.println("viewpart=" + view.getTitle());
					}

					//					IConsoleView view = (IConsoleView) page.showView(id);
					IConsoleView view = (IConsoleView) page.showView(id);
					System.out.println("pre=" + view.getTitle());
					view.display(myConsole);
					System.out.println("post=" + view.getTitle());
					System.out.println("showing view");

				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		});

		//		MessageConsoleStream out = myConsole.newMessageStream();
		//		out.println("Hello from Generic console sample action\nkhjgdkfhg\nkdflgkdhfg");

		//				try {
		//					out.flush();
		//					out.close();
		//				} catch (IOException e) {
		//					// TODO Auto-generated catch block
		//					e.printStackTrace();
		//				}

		//		MessageConsole console = new MessageConsole(”System Output”, null);
		//		ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] { console });

		//		MessageConsoleStream stream = console.newMessageStream();
		//
		//		System.setOut(new PrintStream(stream));
		//		System.setErr(new PrintStream(stream));
		//		
		try {
			String command = "ping";
			Process process = Runtime.getRuntime().exec(command);
			OutputStream os = process.getOutputStream();
			InputStream ise = process.getErrorStream();
			InputStream is = process.getInputStream();
			IOConsoleOutputStream out = myConsole.newOutputStream();
			out.write("[OSBCP Node.js Launcher] Executing command '" + command + "'.");

			createPipe(is, out);

			//			String buffer = "";
			//			int nextChar;
			//			while ((nextChar = is.read()) != -1) {
			//				out.write(nextChar);
			//				buffer += (char) nextChar;
			//				System.out.println(buffer);
			//				//				os.flush();
			//			}
			//
			//			out.write("heheohelh");

			//			System.setOut(new PrintStream(os));
			//			os.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		System.out.println(configuration);
		System.out.println(configuration.getAttribute(IJavaLaunchConfigurationConstants.ATTR_APPLET_NAME, "default"));
		System.out.println(mode);
		System.out.println(launch);
		System.out.println(monitor);
	}

	private void createPipe(final InputStream is, final IOConsoleOutputStream out) {

		//		PipedInputStream pin = new PipedInputStream();
		//		PipedOutputStream pout = new PipedOutputStream(pin);
		//
		//		new Thread(new Runnable() {
		//
		//			public void run() {
		//				putDataOnOutputStream(out);
		//			}
		//		}).start();
		//		class2.processDataFromInputStream(in);

	}

	private IOConsole findConsole(final String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();

		IConsole[] existing = conMan.getConsoles();
		System.out.println("existing=" + existing.length);
		for (int i = 0; i < existing.length; i++) {
			System.out.println("found console: " + existing[i].getName());
			if (name.equals(existing[i].getName())) {

				return (MessageConsole) existing[i];
			}
		}
		//no console found, so create a new one
		IOConsole myConsole = new IOConsole(name, null);
		myConsole.activate();

		conMan.addConsoles(new IConsole[] { myConsole });
		//		conMan.refresh(myConsole);
		return myConsole;
	}

}
