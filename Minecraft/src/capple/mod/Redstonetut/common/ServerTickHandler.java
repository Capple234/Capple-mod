package capple.mod.Redstonetut.common;

import java.util.EnumSet;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.world.WorldServer;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler {

  public void playerTick(WorldServer world, EntityPlayerMP player)
	  {
			List<Entity> ents = world.loadedEntityList;
			for(int i = 0; i < ents.size(); i++){
				Entity ent = ents.get(i);
				if(ent instanceof EntityPig){
					double dist = player.getDistanceToEntity(ent);
					if(player.getCurrentEquippedItem().getItem() == RedstoneTUT.PorkchopSword){
						// 16F is maximum search distance for entity
						PathEntity thePath = world.getPathEntityToEntity(ent, player, 5F, true, true, true, true);
						((EntityPig)ent).getNavigator().setPath(thePath, 5F);
					}
				}
			}
	  }

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}
}
