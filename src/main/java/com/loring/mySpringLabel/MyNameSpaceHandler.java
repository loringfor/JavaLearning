package com.loring.mySpringLabel;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

// MyNameSpaceHandler只是注册了apple的标签的处理逻辑，
// 真正的转换逻辑在AppleBeanDefinitionParser中。

public class MyNameSpaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("apple", new AppleBeanDefinitionParser());
    }
}
