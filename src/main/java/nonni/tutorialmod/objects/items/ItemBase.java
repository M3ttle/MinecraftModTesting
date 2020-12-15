package nonni.tutorialmod.objects.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {
	public ItemBase() {
		super(new Item.Properties().group(ItemGroup.MATERIALS));//ItemGroup.MISC
	}
	
	public ItemBase(ItemGroup itemGroup) {
		super(new Item.Properties().group(itemGroup));
	}

}
