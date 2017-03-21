package fr.techad.edc.showcase.mailreader.ui;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import fr.techad.edc.showcase.mailreader.help.HelpKey;

public class View extends ViewPart {

	public static final String ID = "edc.view";

	/**
	 * The text control that's displaying the content of the email message.
	 */
	private Text messageText;

	public void createPartControl(Composite parent) {
		Composite top = new Composite(parent, SWT.NONE);

		// Register the edc keys.
		PlatformUI.getWorkbench().getHelpSystem().setHelp(top, HelpKey.VIEW);

		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		top.setLayout(layout);
		// top banner
		Composite banner = new Composite(top, SWT.NONE);
		banner.setLayoutData(
				new GridData(GridData.HORIZONTAL_ALIGN_FILL, GridData.VERTICAL_ALIGN_BEGINNING, true, false));
		layout = new GridLayout();
		layout.marginHeight = 5;
		layout.marginWidth = 10;
		layout.numColumns = 2;
		banner.setLayout(layout);

		// setup bold font
		Font boldFont = JFaceResources.getFontRegistry().getBold(JFaceResources.DEFAULT_FONT);

		Label l = new Label(banner, SWT.NONE);
		l.setText("Subject:");
		l.setFont(boldFont);
		l.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false));

		l = new Label(banner, SWT.WRAP);
		l.setText("This is a message about the cool edc!");
		l.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false));

		l = new Label(banner, SWT.NONE);
		l.setText("From:");
		l.setFont(boldFont);
		l.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false));

		final Link link = new Link(banner, SWT.NONE);
		link.setText("<a>support@easydoccontents.com</a>");
		link.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(getSite().getShell(), "Not Implemented",
						"Imagine the address book or a new message being created now.");
			}
		});
		link.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false));

		l = new Label(banner, SWT.NONE);
		l.setText("Date:");
		l.setFont(boldFont);
		l.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false));

		l = new Label(banner, SWT.WRAP);
		l.setText("10:34 am");
		l.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false));

		// message contents
		messageText = new Text(top, SWT.MULTI | SWT.WRAP);
		messageText.setText("Your product is awesome:\n" + "- create brick from IDE to collaborate with developpers\n"
				+ "- create article in some clicks\n" + "- create easier an architecture for your application\n"
				+ "- publish your documentation in several format without change anything\n" + "- DELIVER A CONTEXTUAL DOCUMENTATION INSIDE MY PRODUCT\n\n"
				+ "Thxs for all!\n");
		messageText.setLayoutData(new GridData(GridData.FILL_BOTH));
	}

	public void setFocus() {
		messageText.setFocus();
	}
}
