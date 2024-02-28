package net.phoenixslayer132.reignofsped.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class LammothStakeItem extends Item{
    public LammothStakeItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient){
            BlockPos abovePositionClicked = context.getBlockPos().add(0, 1,0);


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

        return super.useOnBlock(context);
    }
}
