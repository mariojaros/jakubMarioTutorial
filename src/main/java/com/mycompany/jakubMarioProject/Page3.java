package com.mycompany.jakubMarioProject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.INamedParameters;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Created by mariojaros on 25.9.15.
 */
public class Page3 extends WebPage {
    private static final long serialVersionUID = 1L;

    public Page3(final PageParameters parameters) {
        super(parameters);

        final WizardData wizardData = setFields(parameters);

        for(INamedParameters.NamedPair param : parameters.getAllNamed()) {
            add(new Label(param.getKey(),param.getValue()));
        }

    }

    private WizardData setFields(PageParameters parameters){
        WizardData wizardData = new WizardData();
        wizardData.setLastname(parameters.get("lastname").toString());
        wizardData.setUsername(parameters.get("username").toString());
        wizardData.setBirth(parameters.get("birth").toString());
        wizardData.setEmail(parameters.get("email").toString());
        return wizardData;
    }
}

