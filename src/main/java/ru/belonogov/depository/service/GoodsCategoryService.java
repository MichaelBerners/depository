package ru.belonogov.depository.service;

import ru.belonogov.depository.models.GoodsCategory;

import java.util.List;

public interface GoodsCategoryService {

    //создать новую категорию товара
    void create(GoodsCategory goodsCategory);

    //показать категорию товара по названию (может и клиент)
    GoodsCategory readGoodsCategory(String s);

    //показать категорию товара по id
    GoodsCategory readGoodsCategory(int id);

    //показать весь список категорий
    List<GoodsCategory> readAllGoodsCategory();

    //редактировать категорию
    boolean updateGoodsCategory(GoodsCategory goodsCategory, int id);

    //удалить категорию
    boolean deleteGoodsCategory(int id);
}
