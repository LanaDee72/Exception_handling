import java.time.LocalDate;

public class UserController {

    private UserService userService = new UserService();

    public User create(String lastname, String name, String patronymic, LocalDate birthDate, long phoneNumber, char gender){
        return userService.create(lastname, name, patronymic, birthDate, phoneNumber, gender);
    }

}
