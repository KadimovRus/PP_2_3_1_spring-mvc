package jm.task.mvc.controller;

import jm.task.mvc.model.User;
import jm.task.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/users/index");
        List<User> userList = userService.listAll();
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }

    @RequestMapping("/add")
    public String newUser(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "/users/add";
    }

    @RequestMapping("/edit")
    public ModelAndView editCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("/users/edit_user");
        User user = userService.getUserById(id);
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/users";
    }

    @RequestMapping("/delete")
    public String deleteUserForm(@RequestParam long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
