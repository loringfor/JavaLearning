package com.loring.spring.myIOC.xml;

import com.loring.spring.myIOC.BeanDefinition;
import com.loring.spring.myIOC.BeanDefinitionReader;
import com.loring.spring.myIOC.BeanReference;
import com.loring.spring.myIOC.PropertyValue;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class XmlBeanDefinitionReader implements BeanDefinitionReader {

    private Map<String, BeanDefinition> registry;

    public XmlBeanDefinitionReader(){
        registry = new HashMap<>();
    }

    @Override
    public void loadBeanDefinitions(String location) throws FileNotFoundException, Exception {
        InputStream inputStream = new FileInputStream(location);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputStream);
        Element root = doc.getDocumentElement();
        parseBeanDefinitions(root);
    }

    private void parseBeanDefinitions(Element root) throws Exception{
        NodeList nodes = root.getChildNodes();
        for(int i=0;i<nodes.getLength();i++){
            Node node = nodes.item(i);
            if(node instanceof Element){
                Element element = (Element)node;
                parseBeanDefinition(element);
            }
        }
    }

    public void parseBeanDefinition(Element element){
        String name = element.getAttribute("id");
        String classNmae = element.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        //设置className,并反射获得对应的Class对象
        beanDefinition.setBeanClassName(classNmae);
        //解析属性
        processProperty(element,beanDefinition);
        registry.put(name,beanDefinition);
    }

    private void processProperty(Element element,BeanDefinition beanDefinition){
        NodeList propertyNodes = element.getElementsByTagName("property");
        for (int i = 0; i < propertyNodes.getLength(); i++) {
            Node propertyNode = propertyNodes.item(i);
            if (propertyNode instanceof Element) {
                Element propertyElement = (Element) propertyNode;
                String name = propertyElement.getAttribute("name");
                String value = propertyElement.getAttribute("value");
                if (value != null && value.length() > 0) {
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
                } else {
                    String ref = propertyElement.getAttribute("ref");
                    if (ref == null || ref.length() == 0) {
                        throw new IllegalArgumentException("ref config error");
                    }
                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
                }
            }
        }
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }
}
