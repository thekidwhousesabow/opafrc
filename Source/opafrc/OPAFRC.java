package opafrc;

import opafrc.integration.ModuleRotaryCraft;
import openperipheral.api.IntegrationRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "opafrc",version = "1.6.4.953.Alpha", name = "OpenPeripheralAddonForRotaryCraft", dependencies = "required-after:OpenPeripheral;after:RotaryCraft")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class OPAFRC {

	public static IntegrationRegistry integrationRegistry = new IntegrationRegistry();
	@EventHandler
	public void init(FMLPostInitializationEvent evt) {
		if (Loader.isModLoaded("RotaryCraft")) {
			ModuleRotaryCraft.init();
			System.out.println("OPAFRC initialized.");
		}
	}

}
