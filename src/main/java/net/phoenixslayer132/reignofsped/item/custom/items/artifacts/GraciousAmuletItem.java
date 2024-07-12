package net.phoenixslayer132.reignofsped.item.custom.items.artifacts;

import net.minecraft.block.*;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.phoenixslayer132.reignofsped.item.ModItems;
import net.phoenixslayer132.reignofsped.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;


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
                if (player.isCreative()){
                    context.getPlayer().addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 999999999, 1, true, false, true));
                }
                else if (player.experienceLevel >= 50) {
                    player.addExperience(-5345); //50 levels
                    context.getPlayer().addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 999999999, 1, true, false, false));
                    context.getStack().damage(9, context.getPlayer(), playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
                    player.getItemCooldownManager().set(this, 999);
                    player.sendMessage(Text.literal("You understand its hidden use.. you bring it closer to the block and shave a bit of it on the Amulet."));
                    player.sendMessage(Text.literal("It releases a blinding light that pierces into your eyes, after checking yourself you realize you can see into the night."));
                }
                else {
                    player.sendMessage(Text.literal("You sense a hidden reaction coming from the Amulet, its as if it has a strange connection with this block.."));
                    player.sendMessage(Text.literal("However you do not seem to have enough wisdom to understand how to use it."));
                }
            }
            if (blockState.isIn(ModTags.Blocks.PHOEN_ORE_BLOCK)){
                context.getPlayer().setHealth(50.0f);
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
                user.addExperience(-55);//
                user.getMainHandStack().damage(1, user, playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
                user.getItemCooldownManager().set(this, 20);//2000
            }
            if (user.getMainHandStack().getNbt().contains("active")){
                user.getMainHandStack().setCount(0);
                user.setStackInHand(hand, ModItems.UNKNOWN_ITEM.getDefaultStack());
            }

        }
        return super.use(world, user, hand);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.reignofsped.gracious_amulet_item.tooltip.shift"));
        } else {
            tooltip.add(Text.translatable("tooltip.reignofsped.gracious_amulet_item.tooltip"));
        }
    }
}
