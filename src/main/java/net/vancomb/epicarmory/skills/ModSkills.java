package net.vancomb.epicarmory.skills;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.vancomb.epicarmory.EpicArmory;
import yesman.epicfight.api.data.reloader.SkillManager;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillCategories;

public class ModSkills {
    public static Skill SENTO_PASSIVE;

    public ModSkills() {}

    public static void registerSkills() {
        SkillManager.register(SentoPassive::new, Skill.createBuilder().setCategory(SkillCategories.WEAPON_PASSIVE).setActivateType(Skill.ActivateType.ONE_SHOT)
                .setResource(Skill.Resource.COOLDOWN), EpicArmory.MOD_ID, "sento_passive");
    }

    @SubscribeEvent
    public static void buildSkillEvent(SkillBuildEvent onBuild) {
        SENTO_PASSIVE = onBuild.build(EpicArmory.MOD_ID, "sento_passive");
    }
}
