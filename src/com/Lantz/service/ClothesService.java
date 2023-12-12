package com.Lantz.service;

import com.Lantz.bean.Clothes;
import com.Lantz.utils.BusinessException;

import java.util.List;

public interface ClothesService {

    public List<Clothes> list() throws BusinessException;
    public Clothes findById(int cid) throws BusinessException;
    public void update()throws BusinessException;

}
