package lokko12.berriespp.crops.natura;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.ConfigValures;
import lokko12.berriespp.crops.bpp.CactiCrop;
import mods.natura.common.NContent;
import net.minecraft.item.ItemStack;

public class SaguaroCrop extends CactiCrop {
		
		public SaguaroCrop() {
			super();
		}

	    @Override
	    public int tier() {
	        return 4;
	    }
	    
		@Override
		public String name() {
			return "Saguaro Cactus";
		}

		@Override
		public String[] attributes() {
			return new String[] {"Green","Edible","Cactus"};
		}
		
		@Override
		public ItemStack getGain(ICropTile crop) {
			if (crop.getSize()==2)
			return new ItemStack(NContent.saguaro,2,0);
			else 
			return new ItemStack(NContent.seedFood,3,0);
		}
		
		@Override
	    public int growthDuration(ICropTile crop) {
			int r;
	    	if (ConfigValures.Debug == true)
	    		r = 1;
	    	else if (crop.getSize() > 2)
	        r = 450;
	    	else
	    	r = 225;
	    	return r;
	    }
		
	    @Override
	    public boolean canBeHarvested(ICropTile crop) {
	        return crop.getSize() >= 2;
	    }

	    @Override
	    public byte getSizeAfterHarvest(ICropTile crop) {
	        if (crop.getSize() == 2)
	    	return 1;
	        else
	        return 2;
	    }
		@Override
		public ItemStack getDisplayItem() {
			return new ItemStack(NContent.seedFood,3,0);
		}
	    
	    @Override
	    public int weightInfluences(ICropTile crop, float humidity, float nutrients, float air) {
	        // Requires more humidity than nutrients or air, but not much more
	        return (int)((double)humidity*0.5 + (double)nutrients*1.25 + (double)air*1.25);
	    }
}
