package nonni.tutorialmod;


import nonni.tutorialmod.util.RegisterItems;
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
import nonni.tutorialmod.util.RegistryHandler;

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
		
		RegistryHandler.init();
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	// Setup function
	private void setup(final FMLCommonSetupEvent event) {
		LOGGER.info("Setup method registered.");
		ModOreGen.registerOres();
	}
	
	// Client Registers
	private void clientRegistries(final FMLClientSetupEvent event) {
		LOGGER.info("Client method registered.");
	}
	
	// Create a new Item Group TAB
	public static final ItemGroup TAB = new ItemGroup("bloodTab") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(RegisterItems.BLOOD_INGOT.get());// items.Apple, Blocks.Grass
		}
		
	};
	

}
