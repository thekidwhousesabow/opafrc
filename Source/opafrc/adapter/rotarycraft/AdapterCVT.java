package opafrc.adapter.rotarycraft;

import openperipheral.api.IPeripheralAdapter;

public class AdapterCVT implements IPeripheralAdapter {

	@Override
	public Class getTargetClass() {
		try {
			return Class.forName("Reika.RotaryCraft.TileEntities.Transmission.TileEntityAdvancedGear");
		} catch (ClassNotFoundException e) {
		}
		return null;
	}
	

}
