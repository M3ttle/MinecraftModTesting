package nonni.tutorialmod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BloodBlock extends Block {
	public BloodBlock() {
		super(
				Block.Properties.create(Material.IRON)
				.hardnessAndResistance(50, 2000.0f)// Hardness = -1 fyrir unbreakable
				//.hardnessAndResistance(5.0f, 6.0f)// Hardness = harder to break, resistance = explode resist
				.sound(SoundType.METAL)
				.harvestLevel(3) // 0 == wood, 1 == stone, 2 == iron, 3 = diamond
				.harvestTool(ToolType.PICKAXE)
				.setLightLevel(value -> 15) // Makes it glow
				.setRequiresTool()
				);
		
	}
}