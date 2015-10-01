package com.mycompany.jakubMarioProject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Created by lrelovsky on 29.09.2015.
 */
public class PageBootstrap extends WebPage {

    private static final long serialVersionUID = 1L;

    public PageBootstrap(final PageParameters parameters) {
        super(parameters);
        add(new BookmarkablePageLink<String>("register",Page1.class));
    }
}
