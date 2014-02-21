package opafrc.integration;

import opafrc.OPAFRC;
import opafrc.adapter.rotarycraft.AdapterEngine;
import opafrc.adapter.rotarycraft.AdapterMachine;

public class ModuleRotaryCraft {
	public static void init() {
		OPAFRC.integrationRegistry.registerAdapter(new AdapterMachine());
		OPAFRC.integrationRegistry.registerAdapter(new AdapterEngine());
		System.out.println("RotaryCraft Adapters Loaded.");
	}
}
