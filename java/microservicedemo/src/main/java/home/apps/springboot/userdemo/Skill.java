package home.apps.springboot.userdemo;


import javax.persistence.*;
import javax.persistence.Entity;

@Entity
public class Skill {

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer skillId;
    @Column
    private String skillName;
    @ManyToOne
    private User user;

    public Skill(String skillName) {
        this.skillName = skillName;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Skill() {
    }

    public Skill(String skillName, User user) {
        this.skillName = skillName;
        this.user = user;
    }
}

