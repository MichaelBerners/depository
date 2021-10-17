package ru.belonogov.depository.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
//товары
public class Goods {

    private int id;
    private String name; //наименование
    private String units; //единицы измерения 1шт = ?
    private double price; //цена
    private int amount; //количество

}
