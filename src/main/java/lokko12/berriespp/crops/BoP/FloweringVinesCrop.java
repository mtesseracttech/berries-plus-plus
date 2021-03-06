package lokko12.berriespp.crops.BoP;
	import biomesoplenty.api.content.BOPCBlocks;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.bpp.VineCrop;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

	public class FloweringVinesCrop extends VineCrop {
	    public FloweringVinesCrop() {
	    	super();
	    	}

	    @Override
	    public int tier() {
	        return 3;
	    }	
	    
	    @Override
	    public boolean canGrow(ICropTile crop) {
	    	return crop.getSize() < 4;
	    }
		
	    @Override
		public int maxSize() {
			return 4;
		}
	    
	    @Override
	    public String name() {
	        return "Flowering Vines";
	    }

	    @Override
	    public String discoveredBy() {
	        return "bartimaeusnek";
	    }

	    @Override
	    public String[] attributes() {
	        return new String[] {"Green", "Tendrilly", "Flower"};
	    }
	    @Override
	    public int getOptimalHavestSize(ICropTile crop) {
	        return 4;
	    }

	    
	    @Override
	    public boolean canBeHarvested(ICropTile crop) {
	        return crop.getSize() >= 3;
	    }

	    @Override
	    public ItemStack getGain(ICropTile crop) {
	    	if (crop.getSize() == 3)
	        return new ItemStack(Item.getItemById(106),2,0);
	    	else if (crop.getSize() == 4)
	    		return new ItemStack(BOPCBlocks.flowerVine,2,0);
	    	else 
	    		return null;
	    }

		@Override
		public ItemStack getDisplayItem() {
			return new ItemStack(BOPCBlocks.flowerVine,2,0);
		}

	}
