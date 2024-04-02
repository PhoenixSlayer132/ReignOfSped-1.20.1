package net.phoenixslayer132.reignofsped.item.custom;


import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent PHOEN_CARROT = new FoodComponent.Builder().hunger(20).saturationModifier(1.4f).alwaysEdible().snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20000, 0), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20000, 3), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 10, 1), 0.02f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20000, 3), 1.0f)
            .build();


}
