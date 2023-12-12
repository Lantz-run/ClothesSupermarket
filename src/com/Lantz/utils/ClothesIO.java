package com.Lantz.utils;

import com.Lantz.bean.Clothes;

import java.util.ArrayList;
import java.util.List;

public class ClothesIO {

    private static List<Clothes> list = new ArrayList<>();

    public Clothes findById(String cid) throws BusinessException{

        for (Clothes c : list
             ) {
            if (c.getId().equals(cid)){
                return c;
            }
        }
        return null;
    }

    public List<Clothes> list() throws BusinessException{
        if (list.size() == 0){
            list = ProductsXmlUtils.parserProductFormXml();
        }
        return list;
    }

    // 更新XMl文件
    public void update() throws BusinessException{
        ProductsXmlUtils.writeProductToXml(list);
    }

}
