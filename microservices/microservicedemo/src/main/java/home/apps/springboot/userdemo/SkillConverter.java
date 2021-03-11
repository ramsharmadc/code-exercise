package home.apps.springboot.userdemo;

public class SkillConverter {
    public static Skill dtoToEntity(SkillDTO SkillDto) {
        Skill Skill = new Skill(SkillDto.getSkillName(), null);
        Skill.setSkillId(SkillDto.getSkillId());
        return Skill;
    }
    public static SkillDTO entityToDto(Skill skill) {
        return new SkillDTO(skill.getSkillId(), skill.getSkillName());
    }
}
