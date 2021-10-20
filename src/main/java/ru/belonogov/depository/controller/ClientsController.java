package ru.belonogov.depository.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.belonogov.depository.models.Client;
import ru.belonogov.depository.service.ClientsService;

import javax.validation.Valid;

@Controller
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientsController {

    private ClientsService clientsService;

    //получить список всех клиентов
    @GetMapping()
    public String readAll(Model model) {
        model.addAttribute("clients", clientsService.readAll());
        return "clients/readAll";
    }

    //получить конкретного клиента по id
    @GetMapping("/{id}")
    public String read(@PathVariable("id") int id, Model model) {
        model.addAttribute("client", clientsService.read(id));
        return "clients/read";
    }

    //создать клиента (шаг 1) передать дефолтного клиента в модель
    @GetMapping("/new")
    public String newClient(@ModelAttribute("client") Client client) {
//        public String newClient(Model model) {
//            model.addAttribute("newClient", new Client());
        return "clients/new";
    }

    //создать клиента (шаг 2) передать данные клиента в объект клиент и добавить его в таблицу
    @PostMapping()
    public String create(@ModelAttribute("client") @Valid Client client, BindingResult bindingResult) {  //получаем данные из формы(/new) по ключу client(имя не важно)
        if (bindingResult.hasErrors())
            return "clients/new";

        clientsService.create(client);
        return "redirect:/clients";

    }

    //редактировать клиента (шаг 1) заполнить модель клиентом по конкретному id
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("client", clientsService.read(id));
        return "clients/edit";
    }

    //редактировать клиента (шаг 2) передать данные клиента в объект клиент и добавить его в таблицу
    @PostMapping("/{id}")
    public String update(@ModelAttribute("client") @Valid Client client,
                         BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "clients/edit";

        clientsService.update(client, id);
        return "redirect:/clients";
    }

    //удалить клиента по конкретному id
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        clientsService.delete(id);
        return "redirect:/clients";
    }


}
