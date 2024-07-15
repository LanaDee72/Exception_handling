import java.time.LocalDate;

public class UserService {

    public User create(String lastname, String name, String patronymic, LocalDate birthDate, long phoneNumber, char gender){
        User user = new User(lastname, name, patronymic, birthDate, phoneNumber, gender);
        return user;
    }
}
