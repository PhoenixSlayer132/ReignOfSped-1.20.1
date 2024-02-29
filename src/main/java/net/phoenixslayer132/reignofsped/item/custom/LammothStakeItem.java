package net.phoenixslayer132.reignofsped.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import static net.minecraft.block.FarmlandBlock.MOISTURE;

public class LammothStakeItem extends Item{
    public LammothStakeItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient){
            BlockPos positionClicked = context.getBlockPos();

            BlockPos abovePositionClicked = context.getBlockPos().add(0, 1,0);
            BlockState blockState = context.getWorld().getBlockState(positionClicked);
            Block block = blockState.getBlock();

            if(blockState.getBlock() == Blocks.FARMLAND){
                int i = blockState.get(MOISTURE);
                PlayerEntity player = context.getPlayer();
                player.sendMessage(Text.literal("This farmland's moisture is at " + i + "."));
                context.getStack().damage(1, context.getPlayer(), playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
            }
            else{
                if(context.getWorld().hasRain(abovePositionClicked)){
                    PlayerEntity player = context.getPlayer();
                    player.sendMessage(Text.literal("This block has rain above it."));
                    context.getStack().damage(1, context.getPlayer(), playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

                } else if (!context.getWorld().hasRain(abovePositionClicked)) {
                    PlayerEntity player = context.getPlayer();
                    player.sendMessage(Text.literal("This block does not have rain above it."));
                    context.getStack().damage(1, context.getPlayer(), playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
                }
            }

        }

        return super.useOnBlock(context);
    }
}
