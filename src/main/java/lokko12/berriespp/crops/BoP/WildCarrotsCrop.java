package lokko12.berriespp.crops.BoP;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicFoodCrop;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;

public class WildCarrotsCrop extends BasicFoodCrop {
	public WildCarrotsCrop()
	{
		super();
		OreDict.BSget("cropWildcarrots",this);
		OreDict.BSget("seedWildcarrots",this);
	}
	
	@Override
    public String name() {
        return "Wild Carrots";
    }
	
	@Override
	public ItemStack getGain(ICropTile crop) {
		return OreDict.ISget("cropWildcarrots");
	}
	
	@Override
	public String[] attributes() {
        return new String[]{"Food", "White", "Carrots"};
	}

	@Override
	public ItemStack getDisplayItem() {
		return OreDict.ISget("cropWildcarrots");
	}
}
