package com.Lantz.service.impl;

import com.Lantz.bean.Clothes;
import com.Lantz.service.ClothesService;
import com.Lantz.utils.BusinessException;
import com.Lantz.utils.ClothesIO;
import com.Lantz.utils.ProductsXmlUtils;

import java.util.List;

public class ClothesServiceImpl implements ClothesService {

    private ClothesIO clothesIO = new ClothesIO();

    @Override
    public List<Clothes> list() throws BusinessException {
//        List<Clothes> clothes = ProductsXmlUtils.parserProductFormXml();
        return clothesIO.list();
    }

    @Override
    public Clothes findById(int cid) throws BusinessException {
        return clothesIO.findById(String.valueOf(cid));
    }

    public void update() throws BusinessException{
        clothesIO.update();
    }
}
