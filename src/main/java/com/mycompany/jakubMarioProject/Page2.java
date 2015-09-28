package com.mycompany.jakubMarioProject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class Page2 extends WebPage {
    private static final long serialVersionUID = 1L;
    private WizardData wizardData;

    public Page2(final PageParameters parameters) {
        super(parameters);
        wizardData = setFields(parameters);
        add(new FeedbackPanel("feedback"));

        final TextField<String> street = new TextField<String>("street", new PropertyModel<String>(wizardData,"username"));
        final TextField<String> tel = new TextField<String>("tel", new PropertyModel<String>(wizardData,"username"));
        final TextField<String> zip = new TextField<String>("zip", new PropertyModel<String>(wizardData,"username"));
        street.setRequired(true);

        zip.add(new ZipValidator());

        Form<?> form = new Form<Void>("step2");

        add(form);
        form.add(street);
        form.add(tel);
        form.add(zip);
        form.add(new Button("step2Button"){
            public void onSubmit() {
                final String streetValue = street.getModelObject();
                PageParameters pageParameters = new PageParameters(parameters);
                pageParameters.set("street", street.getConvertedInput());
                pageParameters.set("tel", tel.getConvertedInput());
                pageParameters.set("zip", zip.getConvertedInput());
                setResponsePage(Page3.class, pageParameters);
            }
        });
        form.add(new Button("backButton"){
            public void onSubmit() {

                setResponsePage(Page1.class, parameters);
            }
        });
    }

    private WizardData setFields(PageParameters parameters){
        WizardData wizardData = new WizardData();
        wizardData.setLastname(parameters.get("lastname").toString());
        wizardData.setUsername(parameters.get("username").toString());
        wizardData.setBirth(parameters.get("birth").toString());
        wizardData.setEmail(parameters.get("email").toString());
        wizardData.setLastname(parameters.get("street").toString());
        wizardData.setUsername(parameters.get("tel").toString());
        wizardData.setBirth(parameters.get("zip").toString());
        return wizardData;
    }
}
