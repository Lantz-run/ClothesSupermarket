package com.Lantz.utils;

import com.Lantz.bean.Clothes;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsXmlUtils {

    public static List<Clothes> parserProductFormXml(){
        List<Clothes> products = new ArrayList<>();
        XStream xStream = new XStream(new Xpp3Driver());
        xStream.alias("list", products.getClass());
        xStream.alias("clothes", Clothes.class);
        xStream.useAttributeFor(Clothes.class, "id");

        try {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("src/com/Lantz/products.xml"));
            products = (List<Clothes>) xStream.fromXML(inputStream);
            inputStream.close();
        } catch(FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    public static void writeProductToXml(List<Clothes> products){
        XStream xStream = new XStream(new Xpp3Driver());
        xStream.alias("list", products.getClass());
        xStream.alias("clothes", Clothes.class);
        xStream.useAttributeFor(Clothes.class, "id");
        try {
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("src/com/Lantz/products.xml"));
            outputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>".getBytes());
            xStream.toXML(products, outputStream);
            outputStream.close();
        } catch(FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

}
