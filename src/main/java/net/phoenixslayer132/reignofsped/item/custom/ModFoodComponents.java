package net.phoenixslayer132.reignofsped.item.custom;


import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent GOLDEN_BAMBOO = new FoodComponent.Builder().hunger(20).saturationModifier(1.4f).alwaysEdible().snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,24000, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 24000, 3), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 6000, 0), 0.0002f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 6000, 5), 0.0002f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 24000, 2), 1.0f)
            .build();


}
