package lokko12.berriespp.crops.BoP;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.ConfigValures;
import lokko12.berriespp.crops.abstracts.BasicBerryCrop;
import net.minecraft.item.ItemStack;

public class BoPBerryCrop extends BasicBerryCrop {


	public BoPBerryCrop ()
	{
		super();
	}
	
	@Override
    public String name() {
        return "Berry";
    }
    
    @Override
    public int tier() {
        return 2;
    }

    @Override
    public int stat(int n) {
        switch(n) {
        case 0: return 0;   // not chemical
        case 1: return 4;   // very edible
        case 2: return 0;   // no defensive properties
        case 3: return 4;   // quite colorful
        case 4: return 0;   // not particularly weed-like
        default: return 0;
        }
    }

    @Override
    public boolean canGrow(ICropTile crop) {
        return crop.getSize() < 3;
    }

    @Override
    public int getOptimalHavestSize(ICropTile crop) {
        return 3;
    }

    
    @Override
    public boolean canBeHarvested(ICropTile crop) {
        return crop.getSize() == 3;
    }

    @Override
    public int weightInfluences(ICropTile crop, float humidity, float nutrients, float air) {
        // Requires more humidity than nutrients or air, but not much more
        return (int)((double)humidity*1.2 + (double)nutrients*0.9 + (double)air*0.9);
    }

    @Override
    public int growthDuration(ICropTile crop) {
    	int r;
        // Same growth stages as melons and pumpkins
    	if (ConfigValures.Debug == true)
    		r = 1;
    	else if (crop.getSize() == 2) {
            // Ripens quickly
            r = 200;
        } else {
            // Takes a while to grow from seed
            r = 700;
        }
    	return r;
    }

    @Override
    public byte getSizeAfterHarvest(ICropTile crop) {
        // return to partially grown state when harvested
        return 2;
    }
    
	@Override
	public int maxSize() {
		return 3;
	}

	@Override
	public ItemStack getGain(ICropTile crop) {
		return new ItemStack(biomesoplenty.api.content.BOPCItems.food,3,0);
	}

	@Override
	public String[] attributes() {
		return new String[] {"Berry", "Edible", "Red", "Ingredient"};
	}
	
    @Override
    public String discoveredBy() {
        return "bartimaeusnek";
    }

	@Override
	public ItemStack getDisplayItem() {
		return new ItemStack(biomesoplenty.api.content.BOPCItems.food,3,0);
	}

}