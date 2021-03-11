package home.apps.springboot.userdemo;

import java.util.stream.Collectors;

public class UserConverter {
    public static User dtoToEntity(UserDTO userDto) {
        User user = new User(userDto.getUserName(), null);
        user.setUserId(userDto.getUserId());
        user.setSkills(userDto.getSkillDtos().stream().
                map(SkillConverter::dtoToEntity).collect(Collectors.toList()));
        return user;
    }

    public static UserDTO entityToDto(User user) {
        UserDTO userDto = new UserDTO(user.getUserId(), user.getUserName(), null);
        userDto.setSkillDtos(user.getSkills().stream().map(SkillConverter::entityToDto).collect(Collectors.toList()));
        return userDto;
    }
}

