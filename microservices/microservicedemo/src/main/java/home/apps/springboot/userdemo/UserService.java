package home.apps.springboot.userdemo;

import java.util.List;

public interface UserService {

    UserDTO getUserById(Integer userId);

    void saveUser(UserDTO userDto);

    List<UserDTO> getAllUsers();
}
