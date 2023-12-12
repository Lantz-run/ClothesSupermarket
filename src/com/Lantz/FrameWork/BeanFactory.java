package com.Lantz.FrameWork;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * 创建 Bean 的 factory 类
 */
public class BeanFactory {

    private RestartTable<org.dom4j.Element> iterator = null;

    public static BeanFactory beanFactory = null;


    public static BeanFactory init(){
        if (beanFactory == null){
            synchronized (BeanFactory.class){
                if (beanFactory == null){
                    beanFactory = new BeanFactory("com/Lantz/bean.xml");
                }
            }
        }
        return beanFactory;
    }

    private BeanFactory(String xml) {
        // 1、创建DOM4J的解析对象
        try {
            SAXReader reader = new SAXReader();
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(xml);
            if (is != null) {
                Document document = reader.read(is);
                Element rootElement = document.getRootElement();
                iterator = new RestartTable<>(rootElement.elements());
                is.close();
            }else {
                throw new RuntimeException("Unable to locate or open the XML file: " + xml);
            }
        } catch(DocumentException e) {
            throw new RuntimeException(e);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void restartIterator(){
        iterator.restart();
    }

    public Object getBean(String id){
        restartIterator();
        while (iterator.hasNext()){
            Element bean = iterator.next();
            String sid = bean.attributeValue("id");
            if (sid.equals(id)){
                String className = bean.attributeValue("class");
                try {
                    return Class.forName(className).newInstance();
                } catch(InstantiationException e) {
                    throw new RuntimeException(e);
                } catch(IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch(ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }

}

