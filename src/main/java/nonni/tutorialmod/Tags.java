package nonni.tutorialmod;

import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import nonni.tutorialmod.util.RegisterItems;

public class Tags {
    // Just to show how tags can be used within a class
    ResourceLocation myTagId = new ResourceLocation(TutorialMod.modid, "gems"); // modID, tagID (vanilla modid = "minecraft")

    Item testItem = RegisterItems.BLOOD_INGOT.get();
    boolean isInGroup = ItemTags.getCollection().getTagByID(myTagId).contains(testItem);
}
