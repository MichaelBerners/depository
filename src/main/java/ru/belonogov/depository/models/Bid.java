package ru.belonogov.depository.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
//заявка
public class Bid {

    private int id;
    private StatusBidType statusBidType;
    private String name; //наименование
    private String units; //единицы измерения 1шт = ?
    private double price; //цена
    private int amount; //количество
}
