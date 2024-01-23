package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    <T> void add(T t);

    List<User> listUsers();

    User getUserByCar(String model, int series);

}
