package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car1 = new Car("Toyota", 15);
        Car car2 = new Car("Honda", 123);
        Car car3 = new Car("Nissan", 95);
        Car car4 = new Car("Audi", 100);

        User user1 = new User(
                "User1", "Lastname1", "user1@mail.ru", car1
        );
        User user2 = new User(
                "User2", "Lastname2", "user2@mail.ru", car2
        );
        User user3 = new User(
                "User3", "Lastname3", "user3@mail.ru", car3
        );
        User user4 = new User(
                "User4", "Lastname4", "user4@mail.ru", car4
        );

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        String model = "Nissan";
        int series = 95;
        for (User user: users) {
            if (user.getCar().getModel().equals(model) &&
                    user.getCar().getSeries() == series) {
                System.out.println(user);
            }
        }

        context.close();
    }
}
