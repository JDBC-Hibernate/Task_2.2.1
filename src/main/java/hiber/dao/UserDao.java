package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
    <T> void add(T t);

    List<User> listUsers();

    User getUserByCar(String model, int series);
}
