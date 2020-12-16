package nonni.tutorialmod;


import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.fml.DeferredWorkQueue;
import nonni.tutorialmod.entities.HogEntity;
import nonni.tutorialmod.init.ModBlocks;
import nonni.tutorialmod.init.ModEntityTypes;
import nonni.tutorialmod.init.ModItems;
import nonni.tutorialmod.world.gen.ModOreGen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// Tells Forge that this is a mod
// ctrl + shift + o to automatically import package
@Mod("tutorialmodnonna")// MOD ID. lowercase
public class TutorialMod {
	
	public static TutorialMod instance;
	public static final String MODID = "tutorialmodnonna";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	public static final int  oneSec = 20;
	
	// Ctrl + space, create constructor
	public TutorialMod() {
		// How we can reference out main mod class outside of it
		instance = this;
		
		// So functions will be loaded when we load the mod
		// Sets listener to setup()
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

		// Register blocks first since Items use Blocks
		ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	// Setup function
	private void setup(final FMLCommonSetupEvent event) {
		LOGGER.info("Setup method registered.");
		ModOreGen.registerOres();
		DeferredWorkQueue.runLater(() -> {
			// Add all new entities here
			// blockbench to create your own entity
			GlobalEntityTypeAttributes.put(ModEntityTypes.HOG.get(), HogEntity.setCustomAttributes().create());
		});
	}
	
	// Client Registers
	private void clientRegistries(final FMLClientSetupEvent event) {
		LOGGER.info("Client method registered.");
	}
	
	// Create a new Item Group TAB
	public static final ItemGroup TAB = new ItemGroup("bloodTab") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModItems.BLOOD_INGOT.get());// items.Apple, Blocks.Grass
		}
		
	};
	

}
