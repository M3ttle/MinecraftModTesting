package nonni.tutorialmod.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class BloodOre extends OreBlock {
	public BloodOre() {
		super(
				Properties.create(Material.IRON)
				.hardnessAndResistance(15, 2000.0f)// Hardness = -1 fyrir unbreakable
				//.hardnessAndResistance(5.0f, 6.0f)// Hardness = harder to break, resistance = explode resist
				.sound(SoundType.STONE)
				.harvestLevel(4) // 0 == wood, 1 == stone, 2 == iron, 3 = diamond
				.harvestTool(ToolType.PICKAXE)
				.setRequiresTool()
				);
		
	}

	@Override
	public int getExpDrop(BlockState state, IWorldReader, BlockPos pos, int fortune, int silktouch) {
		return 1;
	}
}