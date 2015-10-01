package com.mycompany.jakubMarioProject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class Page2 extends WebPage {
    private static final long serialVersionUID = 1L;

    public Page2(final PageParameters parameters) {
        super(parameters);

        add(new FeedbackPanel("feedback"));

        final TextField<String> street = new TextField<String>("street", new PropertyModel<String>(Page1.getWizardData(), "street"));
        final TextField<String> tel = new TextField<String>("tel", new PropertyModel<String>(Page1.getWizardData(), "tel"));
        final TextField<String> zip = new TextField<String>("zip", new PropertyModel<String>(Page1.getWizardData(), "zip"));
        //street.setRequired(true);
        zip.add(new ZipValidator());

        Form<?> form = new Form<Void>("step2");
        add(form);
        form.add(street);
        form.add(tel);
        form.add(zip);
        form.add(new Button("step2Button") {
            public void onSubmit() {
                if (Page1.getWizardData().getStreet() != null) {
                    setResponsePage(Page3.class, parameters);
                }
            }
        });

        form.add(new Button("backButton") {
            public void onSubmit() {
                setResponsePage(Page1.class, parameters);
            }
        });
    }
}
