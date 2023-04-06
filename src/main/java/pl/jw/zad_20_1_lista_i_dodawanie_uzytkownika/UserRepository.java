package pl.jw.zad_20_1_lista_i_dodawanie_uzytkownika;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> userList = new ArrayList<>();

    public UserRepository(List<User> userList) {
        this.userList = userList;
        userList.add(new User("Jan", "Kowalski", 22));
        userList.add(new User("Ewa", "Nowak", 42));
        userList.add(new User("Tomasz", "Kubica", 8));
    }

    public List<User> getAll() {
        return userList;
    }

    public void add(User user) {
        userList.add(user);
    }

}
