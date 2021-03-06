package lokko12.berriespp.crops.TC;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.ConfigValures;
import lokko12.berriespp.crops.abstracts.BasicTinkerBerryCrop;
import lokko12.croploadcore.Operators;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.oredict.OreDictionary;

public class MagicMetalBerryCrop extends BasicTinkerBerryCrop{
			
				public MagicMetalBerryCrop()
				{
					super();
				}

				@Override
				public String name() {
					return "Magic Metal Berry";
				}
			       
				@Override
				public int tier() {
			        return 7;
			    }
			    @Override
			    public ItemStack getGain(ICropTile crop) {
			    	if (Operators.OR(crop.isBlockBelow("blockThaumium"),crop.isBlockBelow("blockIron")))
			    	{
			    		return OreDictionary.getOres("nuggetThaumium").get(OreDictionary.getOres("nuggetThaumium").size()-1);
			        }
			    	if ((crop.isBlockBelow("blockVoid") == true||ConfigValures.Debug == true) && OreDictionary.getOres("nuggetVoid").size()!= 0)
			    	{
			            return OreDictionary.getOres("nuggetVoid").get(OreDictionary.getOres("nuggetVoid").size()-1);
			        }
			    	else 
			    		return null;
			    }
			    
			    @Override
			    public int growthDuration(ICropTile crop) {
			    	if (ConfigValures.Debug == true)
			    		return 1;
			        if (crop.getSize() == 2)
			            return 1200;
			        else
			        if (Operators.AND(crop.getSize() == 3,Operators.OR(crop.isBlockBelow("blockThaumium"),crop.isBlockBelow("blockIron"))))
			        	return 1800;     	
			        else
			        if (Operators.AND(crop.getSize() == 3,crop.isBlockBelow("blockVoid")))
			            return 3300;
			        else
			    	return 500;
			    }
			    
				@Override
				public String[] attributes() {
			        return new String[] {"OreBerry", "Magic", "Metal", "Thaumium", "Void"};
				}
				
			    @Override
				public boolean onEntityCollision(ICropTile crop, Entity entity) {
			    	if (!(entity instanceof EntityItem))
			            entity.attackEntityFrom(DamageSource.magic, 1);
			    	if (entity instanceof EntityLivingBase) {
						return ((EntityLivingBase) entity).isSprinting();
					}
					return false;
				}
			    
				@Override
				public ItemStack getDisplayItem() {
					return thaumcraft.api.ItemApi.getItem("itemResource", 17);
				}

	}
