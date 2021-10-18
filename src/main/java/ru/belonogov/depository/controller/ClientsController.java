package ru.belonogov.depository.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.belonogov.depository.models.Client;
import ru.belonogov.depository.service.ClientsServiceInt;

import javax.validation.Valid;

@Controller
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientsController {

    private ClientsServiceInt clientsServiceInt;

    @GetMapping()
    public String readAll(Model model) {
        model.addAttribute("clients", clientsServiceInt.readAll());
        return "clients/readAll";
    }

    @GetMapping("/{id}")
    public String read(@PathVariable("id") int id, Model model) {
        model.addAttribute("client", clientsServiceInt.read(id));
        return "clients/read";
    }

    @GetMapping("/new")
    public String newClient(@ModelAttribute("client") Client client) {
//        public String newClient(Model model) {
//            model.addAttribute("newClient", new Client());
        return "clients/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("client") @Valid Client client,
                         BindingResult bindingResult) {  //получаем данные из формы(/new) по ключу client(имя не важно)
        if (bindingResult.hasErrors())
            return "clients/new";

        clientsServiceInt.create(client);
        return "redirect:/clients";

    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("client", clientsServiceInt.read(id));
        return "clients/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("client") @Valid Client client,
                         BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "clients/edit";

        clientsServiceInt.update(client, id);
        return "redirect:/clients";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        clientsServiceInt.delete(id);
        return "redirect:/clients";
    }


}
