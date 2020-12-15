package nonni.tutorialmod;

import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import nonni.tutorialmod.init.ModItems;

public class Tags {
    // Just to show how tags can be used within a class
    ResourceLocation myTagId = new ResourceLocation(TutorialMod.MODID, "gems"); // modID, tagID (vanilla modid = "minecraft")

    Item testItem = ModItems.BLOOD_INGOT.get();
    boolean isInGroup = ItemTags.getCollection().getTagByID(myTagId).contains(testItem);
}
