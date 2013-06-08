package capple.mod.Redstonetut.client;

import capple.mod.Redstonetut.*;
import capple.mod.Redstonetut.common.CommonProxy;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ClientProxy extends CommonProxy

{
	
	@Override
	public void registerRenderers(){
		MinecraftForgeClient.preloadTexture(Redstone_1);
		MinecraftForgeClient.preloadTexture(Redstone_2);
		MinecraftForgeClient.preloadTexture(Obsidian_1);
		MinecraftForgeClient.preloadTexture(Obsidian_2);
		MinecraftForgeClient.preloadTexture(ITEMS);
	}
	
	
	@Override
	public int addArmor(String armor){
			return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
	

