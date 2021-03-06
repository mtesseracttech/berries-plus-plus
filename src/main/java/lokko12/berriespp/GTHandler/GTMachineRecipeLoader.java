package lokko12.berriespp.GTHandler;

import java.util.Locale;

import gregtech.api.GregTech_API;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import ic2.api.item.IC2Items;
import lokko12.berriespp.fluids.BppFluids;
import lokko12.berriespp.items.BppItems;
import lokko12.berriespp.items.BppPotions;
import lokko12.croploadcore.ModsLoaded;
import lokko12.croploadcore.OreDict;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import mods.natura.common.NContent;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

public class GTMachineRecipeLoader implements Runnable{
	
	
	public GTMachineRecipeLoader(){
		super();
	}
	
    @Override
    public void run(){
    	
    	//Space Modifier = Space Plant (Tier13, Naquadah plant +1 tier)
    	//Magic Modifier = Primordial Pearl,
    	
    	//StonePlant
    	GT_Values.RA.addCompressorRecipe(Materials.Marble.getDust(9), Materials.Marble.getBlocks(1),300,2);// Materials.Marble.getPlates(1), 300, 2);
    	GT_Values.RA.addCompressorRecipe(Materials.GraniteRed.getDust(1), Materials.GraniteRed.getPlates(1), 300, 2);
    	GT_Values.RA.addCompressorRecipe(Materials.GraniteBlack.getDust(1), Materials.GraniteBlack.getPlates(1), 300, 2);
    	GT_Values.RA.addCompressorRecipe(Materials.Stone.getPlates(9), new ItemStack(Blocks.stone),300,2);
    	//GT_Values.RA.addCompressorRecipe(Materials.Marble.getPlates(9), Materials.Marble.getBlocks(1),300,2);
    	GT_Values.RA.addCompressorRecipe(Materials.GraniteRed.getPlates(9),  new ItemStack(GregTech_API.sBlockGranites,1,8),300,2);
    	GT_Values.RA.addCompressorRecipe(Materials.GraniteBlack.getPlates(9), new ItemStack(GregTech_API.sBlockGranites),300,2);
    	
    	
    	//honey related
    	GT_Values.RA.addCentrifugeRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 9), null, new FluidStack(FluidRegistry.getFluid("for.honey"), 1000), null, new ItemStack(Items.sugar,9,0), null, null, null, null, null, new int[] {10000}, 1020, 8, false);
    	if (ModsLoaded.BoP) {
    	GT_Values.RA.addCentrifugeRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 9), null, new FluidStack(FluidRegistry.getFluid("honey"), 1000), null, new ItemStack(Items.sugar,9,0), null, null, null, null, null, new int[] {10000}, 1020, 8, false);
    	GT_Values.RA.addCentrifugeRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 1), null, new FluidStack(FluidRegistry.getFluid("honey"),1000), new FluidStack(FluidRegistry.getFluid("for.honey"), 1000), null, null, null, null, null, null, null, 1020, 8, false);
    	}
    	
    	//Ethanol related
    	GT_Values.RA.addFluidCannerRecipe(new ItemStack(IC2Items.getItem("mugBooze").getItem(),1,2), IC2Items.getItem("mugEmpty"), null,new FluidStack(FluidRegistry.getFluid("potion.rum"), 250));
    	
    	for(int i=0;i<BppPotions.textureNames.length;i++) {
    		GT_Values.RA.addFluidCannerRecipe(new ItemStack(BppItems.BppPotions,1,i), new ItemStack(Items.glass_bottle), null,new FluidStack(FluidRegistry.getFluid("potion."+BppPotions.textureNames[i].toLowerCase(Locale.ENGLISH)), 250));
    		GT_Values.RA.addFluidCannerRecipe( new ItemStack(Items.glass_bottle),new ItemStack(BppItems.BppPotions,1,i),new FluidStack(FluidRegistry.getFluid("potion."+BppPotions.textureNames[i].toLowerCase(Locale.ENGLISH)),250), null);
    	}
    			
    	GT_Values.RA.addFermentingRecipe(new FluidStack(BppFluids.Mash,10), new FluidStack(BppFluids.Wash,8), 1000, false);
    	GT_Values.RA.addFermentingRecipe(new FluidStack(BppFluids.Wash,20), new FluidStack(FluidRegistry.getFluid("potion.wine"), 8), 1000, false);
    	GT_Values.RA.addFermentingRecipe(new FluidStack(FluidRegistry.getFluid("potion.wheatyjuice"),10), new FluidStack(BppFluids.FWheat,8), 1020, false);
    	GT_Values.RA.addFermentingRecipe(new FluidStack(FluidRegistry.getFluid("potion.reedwater"),10), new FluidStack(BppFluids.FReed,8), 1020, false);
    	
    	GT_Values.RA.addDistillationTowerRecipe(new FluidStack(FluidRegistry.getFluid("potion.rum"), 1000), new FluidStack[] {Materials.Ethanol.getFluid(580L),Materials.Water.getFluid(420L)}, new ItemStack(Items.sugar), 80, 180);
    	GT_Values.RA.addDistillationTowerRecipe(new FluidStack(FluidRegistry.getFluid("potion.piratebrew"), 1000), new FluidStack[] {Materials.Ethanol.getFluid(800L),Materials.Water.getFluid(200L)}, null, 80, 180);
    	GT_Values.RA.addDistillationTowerRecipe(new FluidStack(FluidRegistry.getFluid("potion.beer"), 1000), new FluidStack[] {Materials.Ethanol.getFluid(45L),Materials.Water.getFluid(955L)},IC2Items.getItem("fertilizer"), 80, 180);
    	GT_Values.RA.addDistillationTowerRecipe(new FluidStack(FluidRegistry.getFluid("potion.darkbeer"), 1000), new FluidStack[] {Materials.Ethanol.getFluid(75L),Materials.Water.getFluid(925L)}, IC2Items.getItem("fertilizer"), 80, 180);
    	GT_Values.RA.addDistillationTowerRecipe(new FluidStack(FluidRegistry.getFluid("potion.cider"), 1000), new FluidStack[] {Materials.Ethanol.getFluid(100L),Materials.Water.getFluid(900L)}, IC2Items.getItem("fertilizer"), 80, 180);
    	GT_Values.RA.addDistillationTowerRecipe(new FluidStack(FluidRegistry.getFluid("potion.wine"), 1000), new FluidStack[] {Materials.Ethanol.getFluid(120L),Materials.Water.getFluid(880L)}, IC2Items.getItem("fertilizer"), 80, 180);
    	GT_Values.RA.addDistillationTowerRecipe(new FluidStack(FluidRegistry.getFluid("potion.vodka"), 1000), new FluidStack[] {Materials.Ethanol.getFluid(400L),Materials.Water.getFluid(600L)}, null, 80, 180);
    	GT_Values.RA.addDistillationTowerRecipe(new FluidStack(FluidRegistry.getFluid("potion.alcopops"), 1000), new FluidStack[] {Materials.Ethanol.getFluid(160L),Materials.Water.getFluid(840L)}, new ItemStack(Items.sugar,8,0), 80, 180);
    	GT_Values.RA.addDistillationTowerRecipe(new FluidStack(BppFluids.Korn,1000), new FluidStack[] {Materials.Ethanol.getFluid(320L),Materials.Water.getFluid(680L)}, null, 80, 180);
    	GT_Values.RA.addDistillationTowerRecipe(new FluidStack(BppFluids.DKorn,1000), new FluidStack[] {Materials.Ethanol.getFluid(380L),Materials.Water.getFluid(620L)}, null, 80, 180);
    	GT_Values.RA.addDistillationTowerRecipe(new FluidStack(BppFluids.SWhine,1000), new FluidStack[] {Materials.Ethanol.getFluid(700L),Materials.Water.getFluid(300L)}, null, 80, 180);
    	GT_Values.RA.addDistillationTowerRecipe(new FluidStack(BppFluids.GHP,1000), new FluidStack[] {Materials.Ethanol.getFluid(750L),Materials.Water.getFluid(250L)}, null, 80, 180);
    	GT_Values.RA.addDistillationTowerRecipe(new FluidStack(BppFluids.jagi,1000), new FluidStack[] {Materials.Ethanol.getFluid(350L),Materials.Water.getFluid(650L)}, null, 80, 180);
    	GT_Values.RA.addDistillationTowerRecipe(new FluidStack(BppFluids.njagi,1000), new FluidStack[] {Materials.Ethanol.getFluid(350L),Materials.Water.getFluid(650L)}, null, 80, 180);
    	
    	GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 1), new FluidStack(FluidRegistry.getFluid("potion.rum"), 100), Materials.Ethanol.getFluid(50L), 16, 24, false);
    	GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 2), new FluidStack(FluidRegistry.getFluid("potion.rum"), 100), Materials.Water.getFluid(42L), 16, 24, false);
    	GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 1), new FluidStack(FluidRegistry.getFluid("potion.vodka"), 100), Materials.Ethanol.getFluid(35L), 16, 24, false);
    	GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 2), new FluidStack(FluidRegistry.getFluid("potion.vodka"), 100), Materials.Water.getFluid(60L), 16, 24, false);
    	GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 1), new FluidStack(BppFluids.Korn,100), Materials.Ethanol.getFluid(25L), 16, 24, false);
    	GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 2), new FluidStack(BppFluids.Korn,100), Materials.Water.getFluid(68L), 16, 24, false);
    	GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 1), new FluidStack(BppFluids.DKorn,100), Materials.Ethanol.getFluid(30L), 16, 24, false);
    	GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 2), new FluidStack(BppFluids.DKorn,100), Materials.Water.getFluid(62L), 16, 24, false);
    	GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 1), new FluidStack(BppFluids.FWheat,80), new FluidStack(BppFluids.Korn,1), 22, 24, false);
    	GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 2), new FluidStack(BppFluids.FWheat,95), new FluidStack(BppFluids.DKorn,1), 24, 24, false);
    	GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 3), new FluidStack(BppFluids.FWheat,100), new FluidStack(FluidRegistry.getFluid("potion.vodka"),1), 28, 64, false);
    	GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 4), new FluidStack(BppFluids.FWheat,200), new FluidStack(FluidRegistry.getFluid("fermentedbiomass"),3), 28, 64, false);
    	GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 5), new FluidStack(BppFluids.FWheat,1000), Materials.Ethanol.getFluid(4L), 220, 120, false);
    	GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 1), new FluidStack(BppFluids.FReed,100), new FluidStack(BppFluids.SWhine,7), 22, 24, false);
    	GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 4), new FluidStack(BppFluids.FReed,200), new FluidStack(FluidRegistry.getFluid("fermentedbiomass"),4), 24, 24, false);
      	GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 5), new FluidStack(BppFluids.FReed,1000), Materials.Ethanol.getFluid(5L), 220, 120, false);
    	//GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 1), new FluidStack(BppFluids.Mash,100), new FluidStack(FluidRegistry.getFluid("potion.wine"), 20), 22, 24, false);
    	GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 4), new FluidStack(BppFluids.Mash,200), new FluidStack(FluidRegistry.getFluid("biomass"),4), 24, 24, false);
    	GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 1), new FluidStack(BppFluids.Wash,100), new FluidStack(BppFluids.GHP,6), 22, 24, false);
    	GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 4), new FluidStack(BppFluids.Wash,100), new FluidStack(FluidRegistry.getFluid("fermentedbiomass"),14), 24, 24, false);
        	
    	GT_Values.RA.addMixerRecipe(new ItemStack(Items.sugar,32,0), new ItemStack(Items.dye,4,1), new ItemStack(Items.dye,4,11), new ItemStack(Items.dye,4,2), Materials.Water.getCells(4), null, new FluidStack(BppFluids.GHP,375), new FluidStack(FluidRegistry.getFluid("potion.alcopops"),4375), Materials._NULL.getCells(4), 10, 8);
    	GT_Values.RA.addMixerRecipe(new ItemStack(Items.sugar,8,0), new ItemStack(Items.dye,1,1), new ItemStack(Items.dye,1,11), new ItemStack(Items.dye,1,2), Materials.Water.getCells(1), null, new FluidStack(FluidRegistry.getFluid("potion.vodka"),500), new FluidStack(FluidRegistry.getFluid("potion.alcopops"),1500), Materials._NULL.getCells(1), 10, 8);
    	GT_Values.RA.addMixerRecipe(new ItemStack(Items.sugar,8,0), new ItemStack(Items.dye,1,1), new ItemStack(Items.dye,1,11), new ItemStack(Items.dye,1,2), Materials.Water.getCells(1), null, new FluidStack(BppFluids.Korn,1000), new FluidStack(FluidRegistry.getFluid("potion.alcopops"),2000), Materials._NULL.getCells(1), 10, 8);
    	GT_Values.RA.addMixerRecipe(new ItemStack(Items.sugar,8,0), new ItemStack(Items.dye,1,1), new ItemStack(Items.dye,1,11), new ItemStack(Items.dye,1,2), Materials.Water.getCells(1), null, new FluidStack(BppFluids.DKorn,750), new FluidStack(FluidRegistry.getFluid("potion.alcopops"),1750), Materials._NULL.getCells(1), 10, 8);
    	GT_Values.RA.addMixerRecipe(Materials.Water.getCells(1), null, null, null, Materials.Ethanol.getFluid(1000L),new FluidStack(FluidRegistry.getFluid("potion.vodka"),2500), Materials.Empty.getCells(1), 10, 8);
    	//GT_Values.RA.addMixerRecipe(new ItemStack(Items.reeds,64),null, null, null, null, null, Materials.Water.getFluid(1000L),new FluidStack(FluidRegistry.getFluid("potion.reedwater"),1000),null, 1200,8);
    	GT_Values.RA.addMixerRecipe(Materials.Water.getCells(1), new ItemStack(Items.sugar), null, null, new FluidStack(BppFluids.SWhine,5000),new FluidStack(FluidRegistry.getFluid("potion.rum"),6000), Materials.Empty.getCells(1), 10, 8);
    	GT_Values.RA.addMixerRecipe(new ItemStack(Items.sugar,8,0), OreDict.ISget("cropSpiceleaf"), OreDict.ISget("cropGinger"), new ItemStack(Items.dye,1,2), Materials.Water.getCells(1), null, new FluidStack(FluidRegistry.getFluid("potion.vodka"),4000), new FluidStack(BppFluids.njagi,5000), Materials._NULL.getCells(1), 10, 8);
    	
    	
    	if (ModsLoaded.dreamcraft)
    	GT_Values.RA.addMixerRecipe(ItemList.Crop_Drop_Chilly.get(1), Materials.CosmicNeutronium.getDustTiny(1), ItemList.Crop_Drop_Lemon.get(64), ItemList.Crop_Drop_TeaLeaf.get(64), BppItems.ModifierMagic.splitStack(8),BppItems.ModifierSpace.splitStack(9), new FluidStack(BppFluids.njagi,50000),new FluidStack(BppFluids.jagi,250), null, 1, 32832);
    	
    	
    	if (OreDictionary.getOres("listAllberry").size()>=1)
    		for (int i=0;i<OreDictionary.getOres("listAllberry").size();i++)
    			GT_Values.RA.addBrewingRecipe(OreDictionary.getOres("listAllberry").get(i).splitStack(16), Materials.Water.getFluid(1000L).getFluid(), BppFluids.Mash, false);
    	GT_Values.RA.addBrewingRecipe(new ItemStack(Items.sugar,8),FluidRegistry.getFluid("potion.weakness"), BppFluids.Mash, false);
    	
    	//Sugar Related
    	for (int i=0;i<OreDictionary.getOres("cropTurnip").size();i++)
    	GT_Values.RA.addExtractorRecipe(OreDictionary.getOres("cropTurnip").get(i), new ItemStack(Items.sugar,8,0), 160, 8);

    	//Dyes from Plants
    	for (int i=0;i<OreDictionary.getOres("cropBlackberry").size();i++)
    		GT_Values.RA.addChemicalRecipe(OreDictionary.getOres("cropBlackberry").get(i).splitStack(16), Materials.Salt.getDust(2), Materials.SulfuricAcid.getFluid(432L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblack"), 288), new ItemStack(Items.sugar), 600, 48 );
    	for (int i=0;i<OreDictionary.getOres("cropBlueberry").size();i++)
    		GT_Values.RA.addChemicalRecipe(OreDictionary.getOres("cropBlueberry").get(i).splitStack(16), Materials.Salt.getDust(2), Materials.SulfuricAcid.getFluid(432L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblue"), 288), new ItemStack(Items.sugar), 600, 48 );
    	for (int i=0;i<OreDictionary.getOres("cropRaspberry").size();i++)
    		GT_Values.RA.addChemicalRecipe(OreDictionary.getOres("cropRaspberry").get(i).splitStack(16), Materials.Salt.getDust(2), Materials.SulfuricAcid.getFluid(432L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyepink"), 288), new ItemStack(Items.sugar), 600, 48 );
    	for (int i=0;i<OreDictionary.getOres("cropVine").size();i++) {
    		if(!OreDictionary.getOres("cropVine").get(i).getUnlocalizedName().equals(NContent.thornVines.getUnlocalizedName()))
    		GT_Values.RA.addChemicalRecipe(OreDictionary.getOres("cropVine").get(i).splitStack(16), Materials.Salt.getDust(2), Materials.SulfuricAcid.getFluid(432L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyegreen"), 288), null, 600, 48 );
    		else
    		GT_Values.RA.addChemicalRecipe(OreDictionary.getOres("cropVine").get(i).splitStack(16), Materials.Salt.getDust(2), Materials.SulfuricAcid.getFluid(432L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeyellow"), 288), null, 600, 48 );	
    	}
    	for (int i=0;i<OreDictionary.getOres("cropCacti").size();i++)
    		GT_Values.RA.addChemicalRecipe(OreDictionary.getOres("cropCacti").get(i).splitStack(16), Materials.Salt.getDust(2), Materials.SulfuricAcid.getFluid(432L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyegreen"), 288), null, 600, 48 );
    	for (int i=0;i<OreDictionary.getOres("cropGooseberry").size();i++)
    		GT_Values.RA.addChemicalRecipe(OreDictionary.getOres("cropGooseberry").get(i).splitStack(16), Materials.Salt.getDust(2), Materials.SulfuricAcid.getFluid(432L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeyellow"), 288), new ItemStack(Items.sugar), 600, 48 );
    	for (int i=0;i<OreDictionary.getOres("cropStrawberry").size();i++)
    		GT_Values.RA.addChemicalRecipe(OreDictionary.getOres("cropStrawberry").get(i).splitStack(16), Materials.Salt.getDust(2), Materials.SulfuricAcid.getFluid(432L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyered"), 288), new ItemStack(Items.sugar), 600, 48 );
    	
    	if (ModsLoaded.BoP)
    		GT_Values.RA.addChemicalRecipe(new ItemStack(biomesoplenty.api.content.BOPCItems.food,16,0), Materials.Salt.getDust(2), Materials.SulfuricAcid.getFluid(432L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyered"), 288), new ItemStack(Items.sugar), 600, 48 );
    	
    	GT_Values.RA.addChemicalRecipe(new ItemStack(BppItems.BppBerries,16,0), Materials.Salt.getDust(2), Materials.SulfuricAcid.getFluid(432L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyepurple"), 288), new ItemStack(Items.sugar), 600, 48 );
    	
    	if (ModsLoaded.Natura) {
    	GT_Values.RA.addChemicalRecipe(new ItemStack(NContent.netherBerryItem,16,0), Materials.Salt.getDust(2), Materials.SulfuricAcid.getFluid(432L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyelime"), 288), new ItemStack(Items.sugar), 600, 48 );
    	GT_Values.RA.addChemicalRecipe(new ItemStack(NContent.netherBerryItem,16,1), Materials.Salt.getDust(2), Materials.SulfuricAcid.getFluid(432L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyelightgray"), 288), new ItemStack(Items.sugar), 600, 48 );
    	GT_Values.RA.addChemicalRecipe(new ItemStack(NContent.netherBerryItem,16,2), Materials.Salt.getDust(2), Materials.SulfuricAcid.getFluid(432L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyelightblue"), 288), new ItemStack(Items.sugar), 600, 48 );
    	GT_Values.RA.addChemicalRecipe(new ItemStack(NContent.netherBerryItem,16,3), Materials.Salt.getDust(2), Materials.SulfuricAcid.getFluid(432L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyelime"), 288), new ItemStack(Items.sugar), 600, 48 );
    	}
    	
    	//Goldfish
    	GT_Values.RA.addFluidExtractionRecipe(BppItems.GoldfischS, new ItemStack(Items.gold_nugget), Materials.FishOil.getFluid(100L), 1, 16, 8);
    	GT_Values.RA.addPulveriserRecipe(BppItems.GoldfischS, new ItemStack[] {Materials.MeatRaw.getDust(1), Materials.Gold.getDustTiny(1), null, null, null}, new int[] {10000,100,0,0,0},3,8,false); //(ItemStack aInput, ItemStack[] aOutputs, int[] aChances, int aDuration, int aEUt, boolean hidden
    	
    	if(ModsLoaded.dreamcraft) {
    	//Space Modifier
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Iron.getDust(1),new ItemStack(BppItems.Modifier,16,0) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.MeteoricIron.getNeutrons()+Materials.MeteoricIron.getProtons())}, null, new ItemStack[] {Materials.MeteoricIron.getDust(1)}, 240, 512);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Steel.getDust(1),new ItemStack(BppItems.Modifier,16,0) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.MeteoricSteel.getNeutrons()+Materials.MeteoricSteel.getProtons())}, null, new ItemStack[] {Materials.MeteoricSteel.getDust(1)}, 240, 512);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Bismuth.getDust(1),new ItemStack(BppItems.Modifier,16,0) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.Oriharukon.getNeutrons()+Materials.Oriharukon.getProtons())}, null, new ItemStack[] {Materials.Oriharukon.getDust(1)}, 240, 512);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Titanium.getDust(1),new ItemStack(BppItems.Modifier,16,0) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.Desh.getNeutrons()+Materials.Desh.getProtons())}, null, new ItemStack[] {Materials.Desh.getDust(1)}, 240, 512);
    	//NON-ELEMENTAR
    	//UV
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Plutonium241.getDust(1),new ItemStack(BppItems.Modifier,64,0) }, new FluidStack[] {Materials.UUMatter.getFluid((Materials.Neutronium.getNeutrons()+Materials.Neutronium.getProtons()))}, null, new ItemStack[] {Materials.BlackPlutonium.getDust(1)}, 120, 524544);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.MeteoricIron.getDust(1),new ItemStack(BppItems.Modifier,64,0) }, new FluidStack[] {Materials.UUMatter.getFluid((Materials.Neutronium.getNeutrons()+Materials.Neutronium.getProtons()))}, null, new ItemStack[] {Materials.DeepIron.getDust(1)}, 120, 524544);
    	//IV
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Ice.getDust(1),new ItemStack(BppItems.Modifier,16,0) }, new FluidStack[] {Materials.UUMatter.getFluid((Materials.Water.getProtons()+Materials.Water.getNeutrons())*10)}, null, new ItemStack[] {Materials.CallistoIce.getDust(1)}, 240, 8196);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Lead.getDust(1),new ItemStack(BppItems.Modifier,16,0) }, new FluidStack[] {Materials.UUMatter.getFluid((Materials.Water.getProtons()+Materials.Water.getNeutrons())*10)}, null, new ItemStack[] {Materials.Ledox.getDust(1)}, 240, 8196);
    	}
    	
    	if(ModsLoaded.TC) {
    	//Magic Modifier PrimP
    	GT_Values.RA.addExtractorRecipe(thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3), new ItemStack(BppItems.Modifier,8,1), 2000, 128);
    	GT_Values.RA.addExtractorRecipe(new ItemStack(BppItems.Modifier,1,1),new ItemStack(thaumcraft.api.ItemApi.getItem("itemResource", 14).getItem(),16,14), 2400, 128);
    	if (!ModsLoaded.dreamcraft)
    		GT_Values.RA.addAutoclaveRecipe(new ItemStack(BppItems.Modifier,16,1), Materials.UUMatter.getFluid(52L),thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3), 10000, 24000, 384, false);	
    	else
    		GT_Values.RA.addAutoclaveRecipe(new ItemStack(BppItems.Modifier,16,1), Materials.UUMatter.getFluid(52L),com.dreammaster.item.ItemList.PrimordialPearlFragment.getIS().splitStack(3), 10000, 24000, 384, false);	
    	GT_Values.RA.addAutoclaveRecipe(new ItemStack(thaumcraft.api.ItemApi.getItem("itemResource", 14).getItem(),32,14), Materials.UUMatter.getFluid(500L),new ItemStack(BppItems.Modifier,1,1), 3300, 2400, 128, false);	
    	//Magic Modifier
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Iron.getDust(1),new ItemStack(BppItems.Modifier,1,1) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.Thaumium.getNeutrons()+Materials.Thaumium.getProtons())}, null, new ItemStack[] {Materials.Thaumium.getDust(1)}, 240, 128);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Thaumium.getDust(1),new ItemStack(BppItems.Modifier,1,1) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.Arsenic.getNeutrons()+Materials.Arsenic.getProtons())}, null, new ItemStack[] {Materials.Void.getDust(1)}, 240, 512);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Void.getDust(1),new ItemStack(BppItems.Modifier,2,1) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.Indium.getNeutrons()+Materials.Indium.getProtons())}, null, new ItemStack[] {Materials.Shadow.getDust(1)}, 240, 8196);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Shadow.getDust(1),new ItemStack(BppItems.Modifier,16,1) }, new FluidStack[] {Materials.UUMatter.getFluid((Materials.Osmium.getNeutrons()+Materials.Osmium.getProtons())*1000)}, null, new ItemStack[] {Materials.Ichorium.getIngots(1)}, 1800, 32768);
    	}
    	
    	if(ModsLoaded.dreamcraft) {
    	//Magic Modifier + Space Modifier
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] { new ItemStack(BppItems.Modifier,16,0), new ItemStack(BppItems.Modifier,4,1)}, new FluidStack[] {Materials.Platinum.getMolten(288L),Materials.MeteoricIron.getMolten(144L), Materials.UUMatter.getFluid(Materials.Platinum.getProtons()+Materials.Platinum.getNeutrons())}, null, new ItemStack[] {Materials.Mytryl.getDust(1)}, 1800, 8196);
    	}
    	
    	if(!ModsLoaded.dreamcraft) {
        GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("BiomesOPlenty", "flowers", 2L, 3), new ItemStack(Items.glowstone_dust, 1, 32767), 300, 2);
    	GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("BiomesOPlenty", "mushrooms", 2L, 3), new ItemStack(Items.glowstone_dust, 1, 32767), 300, 2);
        GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("BiomesOPlenty", "coral1", 2L, 15), new ItemStack(Items.glowstone_dust, 1, 32767), 300, 2);
    	GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "Glowshroom", 2L, 0), new ItemStack(Items.glowstone_dust, 1, 32767), 300, 2);
    	GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "Glowshroom", 2L, 1), new ItemStack(Items.glowstone_dust, 1, 32767), 300, 2);
    	GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "Glowshroom", 2L, 2), new ItemStack(Items.glowstone_dust, 1, 32767), 300, 2);
    	}
    	
    	//Trophy
    	GT_Values.RA.addExtruderRecipe(Materials.Neutronium.getBlocks(64), Materials.Neutronium.getBlocks(64), BppItems.Trophy, 2147483647, 8);
    	GT_Values.RA.addFluidExtractionRecipe(new ItemStack(BppItems.Modifier,1,0), null, Materials.UUMatter.getFluid(2L), 5000, 128, 4);
    	
    	//Chem Refine
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {new ItemStack(BppItems.Modifier,9,0), new ItemStack(GCItems.meteoricIronRaw) }, new FluidStack[] {Materials.Water.getFluid(1000L)}, null, new ItemStack[] {Materials.MeteoricIron.getDust(4)}, 240, 512);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {new ItemStack(BppItems.Modifier,9,0), new ItemStack(MarsItems.marsItemBasic) }, new FluidStack[] {Materials.Water.getFluid(1000L)}, null, new ItemStack[] {Materials.Desh.getDust(4)}, 240, 512);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {new ItemStack(BppItems.Modifier,9,0), GT_OreDictUnificator.get(OrePrefixes.crushed.get(Materials.MeteoricIron), 1)}, new FluidStack[] {Materials.Water.getFluid(1000L)}, null, new ItemStack[] {GT_OreDictUnificator.get(OrePrefixes.crushedPurified.get(Materials.MeteoricIron), 4)}, 240, 512);
      	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {new ItemStack(BppItems.Modifier,9,0), GT_OreDictUnificator.get(OrePrefixes.crushed.get(Materials.Desh), 1)}, new FluidStack[] {Materials.Water.getFluid(1000L)}, null, new ItemStack[] {GT_OreDictUnificator.get(OrePrefixes.crushedPurified.get(Materials.Desh), 4)}, 240, 512);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {new ItemStack(BppItems.Modifier,9,0), GT_OreDictUnificator.get(OrePrefixes.crushed.get(Materials.Oriharukon), 1)}, new FluidStack[] {Materials.Water.getFluid(1000L)}, null, new ItemStack[] {GT_OreDictUnificator.get(OrePrefixes.crushedPurified.get(Materials.Oriharukon), 4)}, 240, 512);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {new ItemStack(BppItems.Modifier,9,0), GT_OreDictUnificator.get(OrePrefixes.crushed.get(Materials.Ledox), 1)}, new FluidStack[] {Materials.Water.getFluid(1000L)}, null, new ItemStack[] {GT_OreDictUnificator.get(OrePrefixes.crushedPurified.get(Materials.Ledox), 4)}, 240, 512);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {new ItemStack(BppItems.Modifier,9,0), GT_OreDictUnificator.get(OrePrefixes.crushed.get(Materials.CallistoIce), 1)}, new FluidStack[] {Materials.Water.getFluid(1000L)}, null, new ItemStack[] {GT_OreDictUnificator.get(OrePrefixes.crushedPurified.get(Materials.CallistoIce), 4)}, 240, 512);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {new ItemStack(BppItems.Modifier,9,0), GT_OreDictUnificator.get(OrePrefixes.crushed.get(Materials.BlackPlutonium), 1)}, new FluidStack[] {Materials.Water.getFluid(1000L)}, null, new ItemStack[] {GT_OreDictUnificator.get(OrePrefixes.crushedPurified.get(Materials.BlackPlutonium), 4)}, 240, 32768);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {new ItemStack(BppItems.Modifier,9,0), GT_OreDictUnificator.get(OrePrefixes.crushed.get(Materials.DeepIron), 1)}, new FluidStack[] {Materials.Water.getFluid(1000L)}, null, new ItemStack[] {GT_OreDictUnificator.get(OrePrefixes.crushedPurified.get(Materials.DeepIron), 4)}, 240, 32768);
   
    	//Potions from Netherberries
    	GT_Values.RA.addBrewingRecipe(new ItemStack(NContent.netherBerryItem,16,0), Materials.Water.getFluid(1000L).getFluid(), FluidRegistry.getFluid("potion.regen"), false);
    	GT_Values.RA.addBrewingRecipe(new ItemStack(NContent.netherBerryItem,16,1), Materials.Water.getFluid(1000L).getFluid(), FluidRegistry.getFluid("potion.nightvision"), false);
    	GT_Values.RA.addBrewingRecipe(new ItemStack(NContent.netherBerryItem,16,2), Materials.Water.getFluid(1000L).getFluid(), FluidRegistry.getFluid("potion.speed"), false);
    	GT_Values.RA.addBrewingRecipe(new ItemStack(NContent.netherBerryItem,16,3), Materials.Water.getFluid(1000L).getFluid(), FluidRegistry.getFluid("potion.strength"), false);
    	
    	/*if (ModsLoaded.dreamcraft)
    	for (int i=0; i<OreDictionary.getOres("blockUnstable").size();i++)
    		for (int j=0; j<OreDictionary.getOres("ingotBedrockium").size();j++)
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {OreDictionary.getOres("blockUnstable").get(i),OreDictionary.getOres("ingotBedrockium").get(j),thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3)} , new FluidStack[] {new FluidStack(FluidRegistry.getFluid("mutagen"),1000),Materials.UUMatter.getFluid(1000L)}, null, new ItemStack[] {new ItemStack(BppItems.Modifier,1,6)}, 2400, 8192);
    	 */
    }
}