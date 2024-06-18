package net.whenbellstoll.aggressivepigs.handler;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.whenbellstoll.aggressivepigs.goals.MobMeleeAttackGoal;

public class PigHandler {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void entityJoinLevel(EntityJoinLevelEvent event){
        Entity entity = event.getEntity();
        if (entity instanceof Pig) {
            Pig pig = (Pig)entity;
            if(!pig.isAggressive()) {
                pig.setAggressive(true);
                pig.goalSelector.addGoal(1, new MobMeleeAttackGoal(pig, 0.9, 2, 5, false));
                pig.targetSelector.addGoal(1, new NearestAttackableTargetGoal(pig, Player.class, true));
            }
        }
    }
}
