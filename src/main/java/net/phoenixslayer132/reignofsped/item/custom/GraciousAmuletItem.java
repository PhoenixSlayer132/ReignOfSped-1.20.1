package net.phoenixslayer132.reignofsped.item.custom;

import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class GraciousAmuletItem extends Item {


    public GraciousAmuletItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient) {
            BlockPos posClicked = context.getBlockPos();
            BlockState blockState = context.getWorld().getBlockState(posClicked);
            PlayerEntity player = context.getPlayer();

            if (blockState.isOf(Blocks.RED_SANDSTONE)) {
                context.getPlayer().addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 999999999, 1, true, false, false));
                player.addExperience(-5345); //50 levels
                context.getStack().damage(9, context.getPlayer(), playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
                player.getItemCooldownManager().set(this, 999);
            }
        }
        return super.useOnBlock(context);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient())
        {
            if (user.isSneaking()){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 2));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 1800, 2));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40, 90));
                user.addExperience(-55);
                user.getMainHandStack().damage(1, user, playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
                user.getItemCooldownManager().set(this, 2000);
            }
        }
        return super.use(world, user, hand);
    }
}