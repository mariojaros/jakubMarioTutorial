package com.mycompany.jakubMarioProject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class Page2 extends WebPage {
    private static final long serialVersionUID = 1L;

    public Page2(final PageParameters parameters) {
        super(parameters);

        add(new FeedbackPanel("feedback"));

        final TextField<String> street = new TextField<String>("street", Model.of(""));
        final TextField<String> tel = new TextField<String>("tel", Model.of(""));
        final TextField<String> zip = new TextField<String>("zip", Model.of(""));
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
                pageParameters.add("street", streetValue);
            }
        });
        form.add(new Button("backButton"){
            public void onSubmit() {
                setResponsePage(Page1.class, parameters);
            }
        });
    }
}
