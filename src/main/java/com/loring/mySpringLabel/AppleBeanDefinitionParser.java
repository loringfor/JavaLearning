package com.loring.mySpringLabel;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class AppleBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return Apple.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String price = element.getAttribute("price");
        String origin = element.getAttribute("origin");
        if (StringUtils.hasText(price)) {
            builder.addPropertyValue("price", Integer.parseInt(price));
        }

        if (StringUtils.hasText(origin)) {
            builder.addPropertyValue("origin", origin);
        }
    }
}
