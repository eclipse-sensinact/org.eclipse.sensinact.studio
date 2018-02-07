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
package org.eclipse.sensinact.studio.view.piax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.sensinact.studio.ui.common.widget.ComboField;
import org.eclipse.sensinact.studio.ui.common.widget.KeyValueEditor;
import org.eclipse.sensinact.studio.ui.common.widget.ListEditor;
import org.eclipse.sensinact.studio.ui.common.widget.TextField;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;

/**
 * @author Etienne Gandrille
 */
public class PiaxView {

	public static final String VIEW_ID = "org.eclipse.sensinact.studio.view.piax.view";

	/* Widgets and model */
	private Combo  typeCombo;
	private String[] typeValues = {"sensor", "gateway"};
	private Map<String, String> match = new HashMap<>();
	private Map<String, String> term = new HashMap<>();
	private List<String> range = new ArrayList<>();
	private Map<String, String> orderBy = new HashMap<>();
	private Spinner sizeEditor;
	private Spinner fromEditor;
	private Button piaxButton;

	
	public PiaxView() {
	}

	@PostConstruct
	public void createControls(final Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		// Tab folder
		CTabFolder folder = new CTabFolder(parent, SWT.BORDER);
		folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));	

		// General Tab
		final CTabItem generalTab = new CTabItem(folder, SWT.NONE);
		generalTab.setText("General");
		generalTab.setControl(getGeneralComposite(folder));

		// Pagination tab
		final CTabItem paginationTab = new CTabItem(folder, SWT.NONE);
		paginationTab.setText("Pagination");
		paginationTab.setControl(getPaginationComposite(folder));
		
		folder.setSelection(0);
		
		// Connect
		piaxButton = new Button(parent, SWT.NONE);
		piaxButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		piaxButton.setText("Import from PIAX");
		piaxButton.addMouseListener(new PiaxButtonListener(this));	
	}

	private Control getGeneralComposite(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
	
		composite.setLayout(new GridLayout(2, false));
		
		// type
		createLabel(composite, "Type", true, false);
		typeCombo = new Combo (composite, SWT.READ_ONLY);
		typeCombo.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		typeCombo.setItems(typeValues);
		typeCombo.select(0);
		
		// match
		createLabel(composite, "Match");
		KeyValueEditor matchEditor = new KeyValueEditor(composite, match, "key", "value", new TextField(), new TextField());
		matchEditor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		matchEditor.setKeyValidator(getNotEmptyValidator());
		matchEditor.setValueValidator(getNotEmptyValidator());
		
		// term
		createLabel(composite, "Term");
		KeyValueEditor termEditor = new KeyValueEditor(composite, term, "key", "value", new TextField(), new TextField());
		termEditor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		termEditor.setKeyValidator(getNotEmptyValidator());
		termEditor.setValueValidator(getNotEmptyValidator());
		
		// range
		createLabel(composite, "Range");
		ListEditor rangeEditor = new ListEditor(composite, range);
		rangeEditor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		rangeEditor.setValidator(new  IInputValidator() {
			@Override
			public String isValid(String newText) {
				try {
					RangeObject.build(newText);
					return null;
				} catch (Exception e) {
					return e.getMessage();
				}
			}
		});
		
		return composite;
	}

	private Control getPaginationComposite(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
	
		composite.setLayout(new GridLayout(2, false));
	
		// order By
		createLabel(composite, "OrderBy");
				
		KeyValueEditor orderByEditor = new KeyValueEditor(composite, orderBy, "key", "value", new TextField(), new ComboField(Arrays.asList("asc","desc")));
		orderByEditor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		orderByEditor.setKeyValidator(getNotEmptyValidator());
		orderByEditor.setValueValidator(getNotEmptyValidator());
		
		// size
		createLabel(composite, "Size", true, false);
		sizeEditor = createSpinner(composite, 0, 1000, 10, 1, 100);
		
		// from
		createLabel(composite, "From", true, false);
		fromEditor = createSpinner(composite, 0, 10000, 10, 1, 100);
	
		return composite;
	}
	
	private IInputValidator getNotEmptyValidator() {
		return new IInputValidator() {
			@Override
			public String isValid(String text) {
				if (text == null || text.isEmpty())
					return "Empty value is not allowed";
				else
					return null;
			}
		};
	}

	private static void createLabel(Composite parent, String text) {
		createLabel(parent, text, true, true);
	}
	
	private static void createLabel(Composite parent, String text, boolean grabExcessHorizontalSpace, boolean grabExcessVerticalSpace) {
		Label label = new Label(parent, SWT.LEFT);
		label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, grabExcessHorizontalSpace, grabExcessVerticalSpace, 1, 1));
		label.setText(text);
	}
	
	private static Spinner createSpinner(Composite parent, int min, int max, int sel, int inc, int page) {
		Spinner spinner = new Spinner (parent, SWT.BORDER);
		spinner.setMinimum(min);
		spinner.setMaximum(max);
		spinner.setSelection(sel);
		spinner.setIncrement(inc);
		spinner.setPageIncrement(page);
		spinner.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		
		return spinner;
	} 
	
	
	/* ============= */
	/* MODEL GETTERS */
	/* ============= */
	
	String getModelType() {
		int index = typeCombo.getSelectionIndex();
		if (index == -1)
			return null;
		else
			return typeValues[index];
	}
	
	Map<String, String> getModelMatch() {
		return match;
	}
	
	Map<String, String> getModelTerm() {
		return term;
	}
	
	List<RangeObject> getModelRange() {
		List<RangeObject> retval = new ArrayList<>();
		for (String str : range)
			retval.add(RangeObject.build(str));
		return retval;
	}
	
	Map<String, String> getOrderBy() {
		return orderBy;
	}
	
	int getSize() {
		return sizeEditor.getSelection(); 
	}
	
	int getFrom() {
		return fromEditor.getSelection();
	}	
}
