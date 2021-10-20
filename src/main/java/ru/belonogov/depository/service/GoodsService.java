package ru.belonogov.depository.service;

import ru.belonogov.depository.models.Goods;

import java.util.List;

public interface GoodsService {

    //создание нового товара - доступно кладовщику
    void createGoods(Goods goods);

    //показать все товары на складе - доступно кладовщику
    List<Goods> readAllGoods();

    //показать по свойствам (наименованию) товара
    Goods read(String s);

    //показать по id - доступно кладовщику
    Goods read(int id);

    //изменить свойства товара - доступно кладовщику
    boolean updateGoods(Goods goods, int id);

    //удалить товар - доступно кладовщику
    boolean deleteGoods(int id);
}
