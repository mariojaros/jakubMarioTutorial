package com.mycompany.jakubMarioProject;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Created by mariojaros on 25.9.15.
 */
public class WizardDataForm extends Form {
    private TextField<String> userName;
    private TextField<String> lastName;
    private TextField<String> birth;
    private TextField<String> email;
    private WizardData wizardData;
    public WizardDataForm(String id,WizardData wizardData) {
        super(id);
        this.wizardData = wizardData;
        add(new FeedbackPanel("feedback"));
        userName = new TextField<String>("username", new PropertyModel<String>(wizardData,"username"));
        lastName = new TextField<String>("lastName", new PropertyModel<String>(wizardData,"lastname"));
        birth= new TextField<String>("birth", new PropertyModel<String>(wizardData,"birth"));
        email= new TextField<String>("email", new PropertyModel<String>(wizardData,"email"));
        birth.add(new BirtDateValidator());
        userName.setRequired(true);
        add(userName);
        add(lastName);
        add(birth);
        add(email);
    }

    @Override
    protected void onSubmit() {
        PageParameters pageParameters = new PageParameters();
        pageParameters.set("username", userName.getConvertedInput());
        pageParameters.set("lastname", lastName.getConvertedInput());
        pageParameters.set("birth", birth.getConvertedInput());
        pageParameters.set("email", email.getConvertedInput());
        setResponsePage(Page2.class, pageParameters);
    }
}
