package lokko12.berriespp.crops.witchery;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicWitcheryCrop;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;

public class EmberMossCrop extends BasicWitcheryCrop {
		public EmberMossCrop() {
			super();
			OreDict.BSget("crop"+name().replaceAll(" ", ""),this );
		}
		 	
		@Override
		public String name() {
		    return "Ember Moss";
		}
		
		@Override
		public int tier() {
			return 7;
		}
		
		@Override
	    public String[] attributes() {
			return new String[] {"Fire", "Ingredient", "Bad", "Climbable"};
		}

	    @Override
	    public ItemStack getGain(ICropTile crop) {
	    	return OreDict.ISget("crop"+name().replaceAll(" ", ""));
	    }
	    
		@Override
		public ItemStack getDisplayItem() {
			return OreDict.ISget("crop"+this.name().replaceAll(" ", ""));
		}	
	
}
