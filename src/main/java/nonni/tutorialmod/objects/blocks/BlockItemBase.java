package nonni.tutorialmod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class BlockItemBase extends BlockItem {

	public BlockItemBase(ItemGroup itemGroup, Block block) {
		super(block, new Item.Properties().group(itemGroup));
	}

}
