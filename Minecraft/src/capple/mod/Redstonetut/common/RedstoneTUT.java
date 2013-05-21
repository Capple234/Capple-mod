package capple.mod.Redstonetut.common;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import org.lwjgl.input.Keyboard;
import capple.mod.Redstonetut.Armor.ItemObidianLeggings;
import net.minecraft.entity.*;
import capple.mod.Redstonetut.block.GunpowderOre;
import capple.mod.Redstonetut.Armor.ItemDiaHelmLC;
import capple.mod.Redstonetut.Armor.ItemGoldHelmLC;
import capple.mod.Redstonetut.Armor.ItemIronHelmLC;
import capple.mod.Redstonetut.Armor.ItemObsidianBoots;
import capple.mod.Redstonetut.Armor.ItemObsidianChestplate;
import capple.mod.Redstonetut.Armor.ItemObsidianHelmet;
import capple.mod.Redstonetut.Armor.ItemRedHelmLC;
import capple.mod.Redstonetut.Armor.ItemRedstoneBoots;
import capple.mod.Redstonetut.Armor.ItemRedstoneChestplate;
import capple.mod.Redstonetut.Armor.ItemRedstoneHelmet;
import capple.mod.Redstonetut.Armor.ItemRedstoneLeggings;
import capple.mod.Redstonetut.WorldGeneration.GunpowderOreWorldGeneration;
import capple.mod.Redstonetut.WorldGeneration.ObsidianOreWorldGeneration;
import capple.mod.Redstonetut.block.ObsidianOre;
import capple.mod.Redstonetut.client.ClientProxy;
import capple.mod.Redstonetut.item.ItemCoalIngot;
import capple.mod.Redstonetut.item.ItemGlowstoneCore;
import capple.mod.Redstonetut.item.ItemObsidianDust;
import capple.mod.Redstonetut.item.ItemObsidianIngot;
import capple.mod.Redstonetut.item.ItemRedstoneIngot;
import capple.mod.Redstonetut.tool.ItemCoalPickaxe;
import capple.mod.Redstonetut.tool.ItemObsidianAxe;
import capple.mod.Redstonetut.tool.ItemObsidianHoe;
import capple.mod.Redstonetut.tool.ItemObsidianPickaxe;
import capple.mod.Redstonetut.tool.ItemObsidianShovel;
import capple.mod.Redstonetut.tool.ItemObsidianSword;
import capple.mod.Redstonetut.tool.ItemRedstoneAxe;
import capple.mod.Redstonetut.tool.ItemRedstoneHoe;
import capple.mod.Redstonetut.tool.ItemRedstonePickaxe;
import capple.mod.Redstonetut.tool.ItemRedstoneShovel;
import capple.mod.Redstonetut.tool.ItemRedstoneSword;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRedstone;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = "Capple's UNBELIEVABLE mod", name = "RedstoneTUT", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)


public class RedstoneTUT {
  @SidedProxy(clientSide = "capple.mod.Redstonetut.client.ClientProxy", serverSide = "capple.mod.Redstonetut.common.CommonProxy")
	@Instance("RedstoneTUT")
	
	
	public static RedstoneTUT instance;
	public static CommonProxy proxy; 
	public static final StepSound soundStoneFootstep = new StepSound("stone", 1.0F, 1.0F);
	public static Item GlowstoneCore;
	public static Item RedstonePickaxe;
	public static Item RedstoneSword;
	public static Item RedstoneShovel;
	public static Item RedstoneAxe;
	public static Item RedstoneHoe;
	public static Item RedstoneIngot;
	public static Item ObsidianPickaxe;
	public static Item ObsidianSword;
	public static Item ObsidianShovel;
	public static Item ObsidianAxe;
	public static Item ObsidianHoe;
	public static Item ObsidianIngot;
	public static Item ObsidianDust;
	public static Item RedstoneHelmet;
	public static Item ObsidianHelmet;
	public static Item RedstoneChestplate;
	public static Item ObsidianChestplate;
	public static Item RedstoneLeggings;
	public static Item ObsidianLeggings;
	public static Item RedstoneBoots;
	public static Item ObsidianBoots;
	public static Item IronHelmLC;
	public static Item GoldHelmLC;
	public static Item DiaHelmLC;
	public static Item RedHelmLC;
	public static Block ObsidianOre;
	public static Block GunpowderOre;
	public static Item CoalPickaxe;
	public static Item CoalIngot;
	
    
	
	
	
	
	public static EnumArmorMaterial armorGoldLC = EnumHelper.addArmorMaterial("GOLDLC", 7, new int[]{2, 5, 3, 1}, 25 );
	public static EnumArmorMaterial armorDiaLC = EnumHelper.addArmorMaterial("DIALC", 33, new int[]{3, 8, 6, 3}, 10 );
	public static EnumArmorMaterial armorIronLC = EnumHelper.addArmorMaterial("IRONLC", 15, new int[]{2, 6, 5, 2}, 9 );
	public static EnumArmorMaterial armorRedstoneLC = EnumHelper.addArmorMaterial("REDSTONELC", 44, new int []{3, 7, 6, 3}, 8 );
	public static EnumArmorMaterial armorRedstone = EnumHelper.addArmorMaterial("REDSTONE", 44, new int []{3, 7, 6, 3}, 8 );
	public static EnumArmorMaterial armorObsidian = EnumHelper.addArmorMaterial("OBSIDIAN", 44, new int []{6, 11, 9, 5}, 7 );
	public static EnumToolMaterial toolRedstone = EnumHelper.addToolMaterial("REDSTONE", 2, 350, 7.0F, 2, 12);
	public static EnumToolMaterial toolObsidian = EnumHelper.addToolMaterial("OBSIDIAN", 3, 2061, 9.0F, 4, 10);
	public static EnumToolMaterial toolCoal = EnumHelper.addToolMaterial("COAL", 1, 100, 3.5F, 1, 5);

	
public RedstoneTUT () {

	
	CoalIngot = new ItemCoalIngot(1029).setUnlocalizedName("CoalIngot").setCreativeTab(CreativeTabs.tabMaterials);
	CoalPickaxe = new ItemCoalPickaxe(1028, toolCoal).setUnlocalizedName("CoalPickaxe").setCreativeTab(CreativeTabs.tabTools);
	RedHelmLC = new ItemRedHelmLC(1027, armorRedstone, proxy.addArmor("Redstone"), 0).setUnlocalizedName("RedHelmLC").setCreativeTab(CreativeTabs.tabCombat);
	DiaHelmLC = new ItemDiaHelmLC(1026, armorDiaLC, proxy.addArmor("DiaLC"), 0).setUnlocalizedName("DiaHelmLC").setCreativeTab(CreativeTabs.tabCombat);
	GoldHelmLC = new ItemGoldHelmLC(1025, armorGoldLC, proxy.addArmor("GoldLC"), 0).setUnlocalizedName("GoldHelmLC").setCreativeTab(CreativeTabs.tabCombat);
	IronHelmLC = new ItemIronHelmLC(1024, armorIronLC, proxy.addArmor("IronLC"), 0).setUnlocalizedName("GoldHelmLC").setCreativeTab(CreativeTabs.tabCombat);
	GlowstoneCore = new ItemGlowstoneCore(1023).setUnlocalizedName("GlowstoneCore").setCreativeTab(CreativeTabs.tabMaterials);
	RedstonePickaxe = new ItemRedstonePickaxe(1000, toolRedstone).setUnlocalizedName("RedstonePickaxe").setCreativeTab(CreativeTabs.tabTools);
	RedstoneSword = new ItemRedstoneSword(1001, toolRedstone).setUnlocalizedName("RedstoneSword").setCreativeTab(CreativeTabs.tabCombat);
	RedstoneShovel = new ItemRedstoneShovel(1002, toolRedstone).setUnlocalizedName("RedstoneShovel").setCreativeTab(CreativeTabs.tabTools);
	RedstoneAxe = new ItemRedstoneAxe(1003, toolRedstone).setUnlocalizedName("RedstoneAxe").setCreativeTab(CreativeTabs.tabTools);
	RedstoneHoe = new ItemRedstoneHoe(1004, toolRedstone).setUnlocalizedName("RedstoneHoe").setCreativeTab(CreativeTabs.tabTools);
	RedstoneIngot = new ItemRedstoneIngot(1005).setUnlocalizedName("RedstoneIngot").setCreativeTab(CreativeTabs.tabMaterials);
	ObsidianPickaxe = new ItemObsidianPickaxe(1006, toolObsidian).setUnlocalizedName("ObsidianPickaxe").setCreativeTab(CreativeTabs.tabTools);
	ObsidianSword = new ItemObsidianSword(1007, toolObsidian).setUnlocalizedName("ObsidianSword").setCreativeTab(CreativeTabs.tabTools);
	ObsidianShovel = new ItemObsidianShovel(1008, toolObsidian).setUnlocalizedName("ObsidianShovel").setCreativeTab(CreativeTabs.tabTools);
	ObsidianAxe = new ItemObsidianAxe(1009, toolObsidian).setUnlocalizedName("ObsidianAxe").setCreativeTab(CreativeTabs.tabTools);
	ObsidianHoe = new ItemObsidianHoe(1010, toolObsidian).setUnlocalizedName("ObsidianHoe").setCreativeTab(CreativeTabs.tabTools);
	ObsidianIngot = new ItemObsidianIngot(1011).setUnlocalizedName("ObsidianIngot").setCreativeTab(CreativeTabs.tabMaterials);
	ObsidianDust= new ItemObsidianDust(1013).setUnlocalizedName("ObsidianDust").setCreativeTab(CreativeTabs.tabMaterials);
	RedstoneHelmet = new ItemRedstoneHelmet(1014, armorRedstone, proxy.addArmor("Redstone"), 0).setUnlocalizedName("RedstoneHelmet").setCreativeTab(CreativeTabs.tabCombat);
	RedstoneChestplate = new ItemRedstoneChestplate(1015, armorRedstone, proxy.addArmor("Redstone"), 1).setUnlocalizedName("RedstoneChestplate").setCreativeTab(CreativeTabs.tabCombat);
	RedstoneLeggings = new ItemRedstoneLeggings(1016, armorRedstone, proxy.addArmor("Redstone"), 2).setUnlocalizedName("RedstoneLeggings").setCreativeTab(CreativeTabs.tabCombat);
	RedstoneBoots = new ItemRedstoneBoots(1017, armorRedstone, proxy.addArmor("Redstone"), 3).setUnlocalizedName("RedstoneBoots").setCreativeTab(CreativeTabs.tabCombat);
	ObsidianBoots = new ItemObsidianBoots(1018, armorObsidian, proxy.addArmor("Obsidian"), 3).setUnlocalizedName("ObsidianBoots").setCreativeTab(CreativeTabs.tabCombat);
	ObsidianLeggings = new ItemObidianLeggings(1019, armorObsidian, proxy.addArmor("Obsidian"), 2).setUnlocalizedName("ObsidianLeggings").setCreativeTab(CreativeTabs.tabCombat);
	ObsidianChestplate = new ItemObsidianChestplate(1020, armorObsidian, proxy.addArmor("Obsidian"), 1).setUnlocalizedName("ObsidianChestplate").setCreativeTab(CreativeTabs.tabCombat);
	ObsidianHelmet = new ItemObsidianHelmet(1021, armorObsidian, proxy.addArmor("Obsidian"), 0).setUnlocalizedName("ObsidianHelmet").setCreativeTab(CreativeTabs.tabCombat);
	ObsidianOre = new ObsidianOre(1012, Material.rock).setUnlocalizedName("ObsidianOre").setCreativeTab(CreativeTabs.tabBlock).setHardness(22.0F).setResistance(6.000F).setLightValue(0.0F).setStepSound(soundStoneFootstep);
	GunpowderOre = new GunpowderOre(1022, Material.rock).setUnlocalizedName("GunpowderOre").setCreativeTab(CreativeTabs.tabBlock).setHardness(8.0F).setResistance(7.0F).setLightValue(0.0F).setStepSound(soundStoneFootstep);
	
	
	
	
	
	GameRegistry.registerBlock(GunpowderOre);
	GameRegistry.registerBlock(ObsidianOre);
	GameRegistry.registerWorldGenerator(new ObsidianOreWorldGeneration() ) ;
	GameRegistry.registerWorldGenerator(new GunpowderOreWorldGeneration() ) ;

	
	LanguageRegistry.addName(CoalIngot, "Coal Ingot");
	LanguageRegistry.addName(CoalPickaxe, "Coal Pickaxe");
	LanguageRegistry.addName(RedHelmLC, "Light core Redstone Helmet");
	LanguageRegistry.addName(GoldHelmLC, "Light core Gold Helmet");
	LanguageRegistry.addName(DiaHelmLC, "Light core Diamond Helmet");
	LanguageRegistry.addName(IronHelmLC, "Light core Iron Helmet");
	LanguageRegistry.addName(GlowstoneCore, "Light Core");
	LanguageRegistry.addName(RedstoneBoots, "Redstone Boots");
	LanguageRegistry.addName(RedstoneLeggings, "Redstone Leggings");
	LanguageRegistry.addName(RedstoneChestplate, "Redstone Chestplate");
	LanguageRegistry.addName(RedstoneHelmet, "Redstone Helmet");
	LanguageRegistry.addName(ObsidianHelmet, "Obsidian Helmet");
	LanguageRegistry.addName(ObsidianChestplate, "Obsidian Chestplate");
	LanguageRegistry.addName(ObsidianLeggings, "Obsidian Leggings");
	LanguageRegistry.addName(ObsidianBoots, "Obsidian Boots");
	LanguageRegistry.addName(ObsidianDust, "Obsidian Dust");
	LanguageRegistry.addName(ObsidianOre, "Obsidian Ore");
	LanguageRegistry.addName(ObsidianHoe, "Obsidian Hoe");
	LanguageRegistry.addName(ObsidianAxe, "Obsidian Axe");
	LanguageRegistry.addName(ObsidianIngot, "Obsidian Ingot");
	LanguageRegistry.addName(ObsidianShovel, "Obsidian Shovel");
	LanguageRegistry.addName(ObsidianSword, "Obsidian Sword");
	LanguageRegistry.addName(ObsidianPickaxe, "Obsidian Pickaxe");
	LanguageRegistry.addName(RedstoneIngot, "Redstone Ingot");
	LanguageRegistry.addName(RedstonePickaxe, "Redstone Pickaxe");
	LanguageRegistry.addName(RedstoneSword, "Redstone Sword");
	LanguageRegistry.addName(RedstoneShovel, "Redstone Shovel");
	LanguageRegistry.addName(RedstoneAxe, "Redstone Axe");
	LanguageRegistry.addName(RedstoneHoe, "Redstone Hoe");
	LanguageRegistry.addName(GunpowderOre, "Gunpowder Ore");
	 
	
	
	
	GameRegistry.addRecipe(new ItemStack(RedstoneBoots, 1), new Object[] {
		"   ", "X X", "X X", Character.valueOf('X'), RedstoneIngot});
	
	GameRegistry.addRecipe(new ItemStack(RedstoneLeggings, 1), new Object[] {
		"XXX", "X X", "X X", Character.valueOf('X'), RedstoneIngot});
	
	GameRegistry.addRecipe(new ItemStack(RedstoneChestplate, 1), new Object[] {
		"X X", "XXX", "XXX", Character.valueOf('X'), RedstoneIngot});
	
	GameRegistry.addRecipe(new ItemStack(RedstoneHelmet, 1), new Object[] {
		"XXX", "X X", "   ", Character.valueOf('X'), RedstoneIngot});
	
	
	GameRegistry.addRecipe(new ItemStack(ObsidianBoots, 1), new Object[] {
		"   ", "X X", "X X", Character.valueOf('X'), ObsidianIngot});
	
	GameRegistry.addRecipe(new ItemStack(ObsidianLeggings, 1), new Object[] {
		"XXX", "X X", "X X", Character.valueOf('X'), ObsidianIngot});
	
	GameRegistry.addRecipe(new ItemStack(ObsidianChestplate, 1), new Object[] {
		"X X", "XXX", "XXX", Character.valueOf('X'), ObsidianIngot});
	
	GameRegistry.addRecipe(new ItemStack(ObsidianHelmet, 1), new Object[] {
		"XXX", "X X", "   ", Character.valueOf('X'), ObsidianIngot});
	
	GameRegistry.addRecipe(new ItemStack(ObsidianHoe, 1), new Object[] {
		"XX ", " * ", " * ", Character.valueOf('X'), ObsidianIngot, 
		Character.valueOf('*'), Item.stick});
	
	GameRegistry.addRecipe(new ItemStack(ObsidianAxe, 1), new Object[] {
		"XX ", "X* ", " * ", Character.valueOf('X'), ObsidianIngot, 
		Character.valueOf('*'), Item.stick});
	
	GameRegistry.addRecipe(new ItemStack(ObsidianShovel, 1), new Object[] {
		" X ", " * ", " * ", Character.valueOf('X'), ObsidianIngot, 
		Character.valueOf('*'), Item.stick});
	
	GameRegistry.addRecipe(new ItemStack(ObsidianSword, 1), new Object[] {
		" X ", " X ", " * ", Character.valueOf('X'), ObsidianIngot, 
		Character.valueOf('*'), Item.stick});
	
	GameRegistry.addRecipe(new ItemStack(ObsidianPickaxe, 1), new Object[] {
		"XXX", " * ", " * ", Character.valueOf('X'), ObsidianIngot, 
		Character.valueOf('*'), Item.stick});
	
	GameRegistry.addRecipe(new ItemStack(RedstonePickaxe, 1), new Object[] {
		"XXX", " * ", " * ", Character.valueOf('X'), RedstoneIngot, 
		Character.valueOf('*'), Item.stick});
	
	GameRegistry.addRecipe(new ItemStack(RedstoneSword, 1), new Object[] {
		" X ", " X ", " * ", Character.valueOf('X'), RedstoneIngot, 
		Character.valueOf('*'), Item.stick});
	
	GameRegistry.addRecipe(new ItemStack(RedstoneShovel, 1), new Object[] {
		" X ", " * ", " * ", Character.valueOf('X'), RedstoneIngot, 
		Character.valueOf('*'), Item.stick});
	
	GameRegistry.addRecipe(new ItemStack(RedstoneAxe, 1), new Object[] {
		"XX ", "X* ", " * ", Character.valueOf('X'), RedstoneIngot, 
		Character.valueOf('*'), Item.stick});	
	
	GameRegistry.addRecipe(new ItemStack(RedstoneHoe, 1), new Object[] {
		"XX ", " * ", " * ", Character.valueOf('X'), RedstoneIngot, 
		Character.valueOf('*'), Item.stick});
	
	GameRegistry.addRecipe(new ItemStack(DiaHelmLC, 1), new Object[] {
		" X ", " * ", "", Character.valueOf('X'), GlowstoneCore,
		Character.valueOf('*'), Item.helmetDiamond});
	
	GameRegistry.addRecipe(new ItemStack(IronHelmLC, 1), new Object[] {
		" X ", " * ", "", Character.valueOf('X'), GlowstoneCore,
		Character.valueOf('*'), Item.helmetIron});
	
	GameRegistry.addRecipe(new ItemStack(GoldHelmLC, 1), new Object[] {
		" X ", " * ", "", Character.valueOf('X'), GlowstoneCore,
		Character.valueOf('*'), Item.helmetGold});
	
	GameRegistry.addRecipe(new ItemStack(RedHelmLC, 1), new Object[] {
		" X ", " * ", "", Character.valueOf('X'), GlowstoneCore,
		Character.valueOf('*'), RedstoneHelmet});
	
	GameRegistry.addRecipe(new ItemStack(CoalPickaxe, 1), new Object [] {
		"XXX", " * ", " * ", Character.valueOf('X'), CoalIngot,
		Character.valueOf('*'), Item.stick });
	
	
	}
	

	
	@Init
	public void load(FMLInitializationEvent event){
	smeltingRecipes();
	BlockHarvestLevel();
	
	
	
	
	
	
	
	}
	private void BlockHarvestLevel() {
		MinecraftForge.setBlockHarvestLevel(ObsidianOre, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(GunpowderOre, "pickaxe", 0);
	}




	private void smeltingRecipes() {
		GameRegistry.addSmelting(ObsidianDust.itemID, new ItemStack(ObsidianIngot, 1), 3.0F);
		GameRegistry.addSmelting(Item.redstone.itemID, new ItemStack(RedstoneIngot, 1), 2.0F);
		GameRegistry.addSmelting(Item.coal.itemID, new ItemStack(CoalIngot, 1), 1.0F);
		
	
	

	
		
		
	
		

	
	KeyBinding[] key = new KeyBinding[]{new KeyBinding("G", Keyboard.KEY_G)};
    boolean[] repeat = {false};
    PanicKey ppp = new PanicKey(key, repeat); KeyBindingRegistry.registerKeyBinding(ppp);

    

	}

}

	


































