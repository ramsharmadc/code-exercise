package home.apps.springboot.userdemo;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    Integer userId;
    String userName;
    List<SkillDTO> skillDtos = new ArrayList<>();

    public UserDTO(Integer userId, String userName, List<SkillDTO> skillDtos) {
        this.userId = userId;
        this.userName = userName;
        this.skillDtos = skillDtos;
    }

    public UserDTO() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<SkillDTO> getSkillDtos() {
        return skillDtos;
    }

    public void setSkillDtos(List<SkillDTO> skillDtos) {
        this.skillDtos = skillDtos;
    }
}
