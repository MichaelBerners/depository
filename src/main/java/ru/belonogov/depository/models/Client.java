package ru.belonogov.depository.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
@AllArgsConstructor
//пользователь
public class Client {

    public Client() {}//для создания клиента с дефолтными полями

    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 20, message = "Некорректное имя")
    private String firstName;
    @NotEmpty(message = "Фамилия не должна быть пустой")
    private String lastName;
    @NotEmpty(message = "Отчество не должно быть пустым")
    private String patronymic;
    @NotEmpty(message = "Email не должен быть пустым")
    @Email
    private String email;
    private String password; //временно
    private String clientType; //временно
    //private ClientType clientType;
}
