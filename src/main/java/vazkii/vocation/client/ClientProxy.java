package vazkii.vocation.client;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.MinecraftForge;
import vazkii.vocation.common.CommonProxy;
import vazkii.vocation.common.core.Message;
import vazkii.vocation.common.core.MessageLoader;

public class ClientProxy extends CommonProxy {

	public static HUDHandler hud;
	
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		
		hud = new HUDHandler();
		MinecraftForge.EVENT_BUS.register(hud);
		FMLCommonHandler.instance().bus().register(hud);
	}
	
	@Override
	public void showMessage(String id) {
		Message message = MessageLoader.allMessages.get(id);
		if(message != null)
			hud.addMessageToQueue(message);
	}
	
}
