package net.vancomb.epicarmory.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.vancomb.epicarmory.EpicArmory;
import net.vancomb.epicarmory.item.ModItems;
import yesman.epicfight.world.item.EpicFightItems;


public class MaskedGuard extends AbstractKombatantEntity {

    public MaskedGuard(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);      //Constructor


        spawnEntityWithRandomWeapon(); //Calling the method
    }
        //This method gives the Masked Guard a chance to spawn with a variety of weapons.
        // Ideally, it will work based off Mod Compat.
        public void spawnEntityWithRandomWeapon(){
            Item[] weaponOptions = {
                    ModItems.NAGINATA.get(),
                    EpicFightItems.IRON_SPEAR.get(),
                    EpicFightItems.IRON_TACHI.get(),
                    EpicFightItems.UCHIGATANA.get(),
                    //IF use EFM, can also spawn with SPEAR + TACHI
                    //IF use WOM, can also spawn with STAFF
            };

            int randomIndex = this.random.nextInt(weaponOptions.length);
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(weaponOptions[randomIndex]));
        }

    @Override
    public ResourceLocation getResourceLoaction() {
        return new ResourceLocation(EpicArmory.MOD_ID, "textures/entity/maskedguard.png");
    }

}

// this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.NAGINATA.get()));
//int randomIndex = this.random.nextInt(0, weaponOptions.length);