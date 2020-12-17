package nonni.tutorialmod.entities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import nonni.tutorialmod.TutorialMod;
import nonni.tutorialmod.init.ModEntityTypes;

import javax.annotation.Nullable;

// Or creatureEntity
public class HogEntity extends AnimalEntity {

    public static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.CARROT, Items.POTATO, Items.BEETROOT);

    // If we want to make the enitiy eat grass
    private EatGrassGoal eatGrassgoal;
    private int hogTimer;

    public HogEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()// registerAttributes() mapping
                .createMutableAttribute(Attributes.MAX_HEALTH, 12.9F)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.250F);
    }

    // Goals for the mob (The ai. or the brain)
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.eatGrassgoal = new EatGrassGoal(this);
        this.goalSelector.addGoal(0, new SwimGoal(this)); // 0 is highest priority
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.250F));// If you hit the entity it will panic and run around
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0F));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1F, TEMPTATION_ITEMS, false));// Follow you on Item. False = is scared by player movement
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1F));
        this.goalSelector.addGoal(5, this.eatGrassgoal);
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0F));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));// distance 6
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    }

    // Drops default 2-3 exp orbs by default (From AnimalEntity)
    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        //return super.getExperiencePoints(player);
        return 1 + this.world.rand.nextInt(4);// Returns random from 1-4
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_PIG_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() { return SoundEvents.ENTITY_PIG_DEATH; }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return SoundEvents.ENTITY_PIG_HURT; }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_DOLPHIN_SPLASH, 0.15F, 1.0F);
    }

    @Nullable
    @Override// createChild mapping
    public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return ModEntityTypes.HOG.get().create(this.world);
    }


    // If we want to make our entity eat grass
    @Override
    protected void updateAITasks() {
        this.hogTimer = this.eatGrassgoal.getEatingGrassTimer();
        super.updateAITasks();
    }

    @Override
    public void livingTick() {
        super.livingTick();
        if (this.world.isRemote) {
            this.hogTimer = Math.max(0, this.hogTimer-1);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate (byte id) {
        //TODO remove

        TutorialMod.LOGGER.info("!!!!!!!!!!!!    id: " + id);

        if (id == 10) {

            TutorialMod.LOGGER.info("Came into handleStatusUpdate");

            this.hogTimer = 40;
            this.handleRunningEffect();
        } else {
            super.handleStatusUpdate(id);
        }
    }

}
