package com.mycompany.jakubMarioProject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class Page3 extends WebPage {
    private static final long serialVersionUID = 1L;

    public Page3(final PageParameters parameters) {
        super(parameters);

        add(new FeedbackPanel("feedback"));

        Form<?> form = new Form<Void>("step3");

        add(form);

        form.add(new Label("usernameResult", Page1.getWizardData().getUsername()));
        form.add(new Label("lastNameResult", Page1.getWizardData().getLastname()));
        form.add(new Label("birthResult", Page1.getWizardData().getBirth()));
        form.add(new Label("emailResult", Page1.getWizardData().getEmail()));

        form.add(new Label("streetResult", Page1.getWizardData().getStreet()));
        form.add(new Label("telResult", Page1.getWizardData().getTel()));
        form.add(new Label("zipResult", Page1.getWizardData().getZip()));

        form.add(new Button("backButton") {
            public void onSubmit() {
                setResponsePage(Page2.class, parameters);
            }
        });
    }
}