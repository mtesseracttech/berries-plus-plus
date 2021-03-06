package lokko12.berriespp.crops.bpp;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicDecorationCrop;
import lokko12.croploadcore.MyRandom;
import lokko12.croploadcore.Operators;
import lokko12.croploadcore.OreDict;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class GrassCrop extends BasicDecorationCrop{
	private int random;
	 public GrassCrop() {
		 super();
		 OreDict.BSget("cropGrass", this);
	 }

	    @Override
	    public int tier() {
	        return 0;
	    }
	    
	    @Override
	    public int stat(int n) {
	        switch(n) {
	        case 0: return 0;   // not chemical
	        case 1: return 0;   // not edible
	        case 2: return 0;   // no defensive properties
	        case 3: return 3;   // primarily decorative
	        case 4: return 4;   // weed-like
	        default: return 0;
	        }
	    }
	 
	    @Override
	    public String name() {
	        return "Grass";
	    }
	    
	    @Override
	    public int getOptimalHavestSize(ICropTile crop) {
	        return 1;
	    }

	    @Override
		public boolean isWeed(ICropTile crop) {
			return true;
		}
	    
	    @Override
		public boolean onEntityCollision(ICropTile crop, Entity entity) {
	    	if (Operators.AND((Operators.NOT(entity instanceof EntityItem)),crop.getSize()==4))
	            entity.attackEntityFrom(DamageSource.cactus, 1);
			return false;
		}
	    @Override
	    public boolean leftclick(ICropTile crop, EntityPlayer player) {
	    	return false;
		}
		@Override
		public float dropGainChance() { 
			return (float) 1;
		}
		
	    @Override
		public int maxSize() {
				return 4;
			}
	    
	    @Override
	    public boolean canBeHarvested(ICropTile crop) {
	    	return crop.getSize() > 1;
	    }
	    
	    @Override
	    public String[] attributes() {
	        return new String[] {"Green", "Bad"};
	    }

	    @Override
	    public ItemStack getGain(ICropTile crop) {
	    	if (crop.getSize() == 4)
	    	return new ItemStack(Item.getItemById(32),1,0);	
	    	if (crop.getSize() == 3) {
	    	random = MyRandom.intrandom(0,10);
	    	switch (random){
	    		case 9:
	    			return new ItemStack(Item.getItemById(175),1,3);
	    		default:
	    			return new ItemStack(Item.getItemById(31),1,2);
	    		}
	    	}
	    	random = MyRandom.intrandom(0,10);
	    	switch (random){
	    		case 9:
	    			return new ItemStack(Item.getItemById(175),1,2);
	    		default:
	    			return new ItemStack(Item.getItemById(31),1,1);
	    		}
	    }
	    
	    @Override
	    public boolean canGrow(ICropTile crop) {
	    	return crop.getSize() < 4;
	    }
	    
	    @Override
	    public byte getSizeAfterHarvest(ICropTile crop) {
	        return (byte)((int)crop.getSize()-1);
	    }

		@Override
		public ItemStack getDisplayItem() {
			return new ItemStack(Item.getItemById(31),1,1);
		}
}
