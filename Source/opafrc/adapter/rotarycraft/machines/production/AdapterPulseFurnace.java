package opafrc.adapter.rotarycraft.machines.production;

import java.util.HashMap;

import dan200.computer.api.IComputerAccess;
import Reika.RotaryCraft.Base.TileEntity.TileEntityPowerReceiver;
import Reika.RotaryCraft.TileEntities.Processing.TileEntityPulseFurnace;
import opafrc.adapter.rotarycraft.AdapterMachine;
import openperipheral.api.IPeripheralAdapter;
import openperipheral.api.LuaMethod;
import openperipheral.api.LuaType;

public class AdapterPulseFurnace extends AdapterMachine implements IPeripheralAdapter {
	@Override
	public Class getTargetClass() {
		return TileEntityPulseFurnace.class;
	}
	
	@Override
	@LuaMethod(returnType=LuaType.TABLE)
	public HashMap<Object, Object> getMachineData(IComputerAccess computer, TileEntityPowerReceiver par2) {
		HashMap<Object, Object> data = new HashMap<Object, Object>();
		data.putAll(super.getMachineData(computer, par2));
		
		return data;
	}
}
