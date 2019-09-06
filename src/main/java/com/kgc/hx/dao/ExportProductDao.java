package com.kgc.hx.dao;

import com.kgc.hx.pojo.ExportProduct;


public interface ExportProductDao extends BaseDao<ExportProduct> {
    ExportProduct get(String s);
}
