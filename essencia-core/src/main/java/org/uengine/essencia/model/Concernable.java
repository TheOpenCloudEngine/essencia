package org.uengine.essencia.model;

import org.metaworks.component.SelectBox;

public interface Concernable {
    String getConcern();

    void setConcern(String concern);

    SelectBox getConcernBox();

    void setConcernBox(SelectBox concern);
}
