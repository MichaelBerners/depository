package ru.belonogov.depository.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
//заявка
public class Bid {

    private int id;
    private StatusBidType statusBidType;
}
