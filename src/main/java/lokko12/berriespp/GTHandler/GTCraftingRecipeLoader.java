package lokko12.berriespp.GTHandler;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import ic2.core.Ic2Items;
import lokko12.berriespp.items.BppItems;

public class GTCraftingRecipeLoader implements Runnable {

	public GTCraftingRecipeLoader() {
		super();
	}
	
	public void run() {
		CustomItemList.weedingTrowel.set(Ic2Items.weedingTrowel);
		CustomItemList.Spade.set(BppItems.itemSpadeStack);
		GT_ModHandler.addCraftingRecipe(BppItems.itemSpadeStack,GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE,new Object[] {"fPh", "PWP", " S ", 'P',OrePrefixes.plateDense.get(Materials.Steel), 'W',CustomItemList.weedingTrowel ,'S',OrePrefixes.stickLong.get(Materials.Wood)});
	}
}
