package pl.jw.zad_20_1_lista_i_dodawanie_uzytkownika;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/index")
    public String addUserList(@RequestParam String firstname, @RequestParam String lastname, @RequestParam Integer age) {
        if (firstname.equals("")) {
            return "redirect:/err.html";
        } else {
            User user = new User(firstname, lastname, age);
            userRepository.add(user);
            return "redirect:/success.html";
        }

    }

    @RequestMapping("/add")
    public String addUser(@RequestParam String imie, @RequestParam String nazwisko, @RequestParam Integer wiek) {
        if (imie.equals("")) {
            return "redirect:/err.html";
        } else {
            User user = new User(imie, nazwisko, wiek);
            userRepository.add(user);
            return "redirect:/success.html";
        }
    }

    @ResponseBody
    @RequestMapping("/users")
    public String showUserList() {
        List<User> userList = userRepository.getAll();
        String result = "";
        for (User user : userList) {
            result += user.getFirstName() + " " + user.getLastName() + " wiek: " + user.getAge() + "<br/>";
        }
        return result;
    }
}
