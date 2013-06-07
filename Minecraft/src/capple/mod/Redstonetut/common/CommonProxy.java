package capple.mod.Redstonetut.common;

public abstract class CommonProxy
{
	
	public static String Redstone_1 = "mods.RedstoneTUT.textures.armor.Redstone_1.png";
	public static String Redstone_2 = "mods.RedstoneTUT.textures.armor.Redstone_1.png";
	public static String Obsidian_1 = "mods.RedstoneTUT.textures.armor.Obsidian_1.png";
	public static String Obsidian_2 = "mods.RedstoneTUT.textures.armor.Obsidian_2.png";
	public static String ITEMS = "mods.RedstoneTUT.textures.items.png";
	public ServerTickHandler tickHandlerServer = null;

	abstract public void registerRenderers();
	
	
	
	abstract public int addArmor(String armor);


	public void registerTickHandlers() {
		
		
	}

}
