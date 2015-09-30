package com.mycompany.jakubMarioProject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class Page1 extends WebPage {
    private static final long serialVersionUID = 1L;

    private static WizardData wizardData = new WizardData();

    public Page1(final PageParameters parameters) {
        super(parameters);

        add(new FeedbackPanel("feedback"));

        final TextField<String> userName = new TextField<String>("username", new PropertyModel<String>(Page1.getWizardData(), "username"));
        final TextField<String> lastName = new TextField<String>("lastName", new PropertyModel<String>(Page1.getWizardData(), "lastname"));
        final TextField<String> birth = new TextField<String>("birth", new PropertyModel<String>(Page1.getWizardData(), "birth"));
        final TextField<String> email = new TextField<String>("email", new PropertyModel<String>(Page1.getWizardData(), "email"));
        userName.setRequired(true);
        birth.add(new BirtDateValidator());

        Form<?> form = new Form<Void>("step1") {
            @Override
            protected void onSubmit() {
                setResponsePage(Page2.class, parameters);
            }
        };

        add(form);
        form.add(userName);
        form.add(lastName);
        form.add(birth);
        form.add(email);
    }

    public static WizardData getWizardData() {
        return wizardData;
    }
}
