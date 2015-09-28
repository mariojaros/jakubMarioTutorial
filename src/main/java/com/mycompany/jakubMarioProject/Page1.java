package com.mycompany.jakubMarioProject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class Page1 extends WebPage {
    private static final long serialVersionUID = 1L;

    public Page1(final PageParameters parameters) {
        super(parameters);

        final WizardData wizardData = setFields(parameters);

        add(new FeedbackPanel("feedback"));

        final TextField<String> userName = new TextField<String>("username", new PropertyModel<String>(wizardData,"username"));
        final TextField<String> lastName = new TextField<String>("lastName", new PropertyModel<String>(wizardData,"lastname"));
        final TextField<String> birth = new TextField<String>("birth", new PropertyModel<String>(wizardData,"birth"));
        final TextField<String> email = new TextField<String>("email", new PropertyModel<String>(wizardData,"email"));


        birth.add(new BirtDateValidator());
        Form<?> form = new Form<Void>("step1") {

            @Override
            protected void onSubmit() {
                PageParameters pageParameters = new PageParameters();
                pageParameters.set("username", wizardData.getUsername());
                pageParameters.set("lastname", wizardData.getLastname());
                pageParameters.set("birth", wizardData.getBirth());
                pageParameters.set("email", wizardData.getEmail());
                setResponsePage(Page2.class, pageParameters);
            }
        };
        userName.setRequired(true);
        form.add(userName);
        form.add(lastName);
        form.add(birth);
        form.add(email);
        add(form);
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
