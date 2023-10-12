package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.model.User;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserDao userDaoImp = new UserDaoImp();

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userDaoImp.users());
        return "users";
    }

    @GetMapping("/user")
    public String show(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", userDaoImp.show(id));
        return "id";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userDaoImp.add(user);
        return "redirect:users";
    }
}
