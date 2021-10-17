package ru.belonogov.depository.models;

//создание, проверка, оплаты нет, оплата есть, не выполнен
public enum StatusBidType {
    BUILD, VERIFICATION, PAYMENT_NO, PAYMENT_YES, NOT_EXECUTED
}
