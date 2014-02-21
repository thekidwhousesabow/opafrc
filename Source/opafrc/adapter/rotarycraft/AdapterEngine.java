package opafrc.adapter.rotarycraft;

import java.util.HashMap;

import net.minecraft.tileentity.TileEntity;
import openperipheral.api.IPeripheralAdapter;
import openperipheral.api.LuaMethod;
import openperipheral.api.LuaType;
import Reika.RotaryCraft.Base.TileEntity.RotaryCraftTileEntity;
import Reika.RotaryCraft.Registry.EngineType;
import Reika.RotaryCraft.TileEntities.Production.TileEntityEngine;
import dan200.computer.api.IComputerAccess;

public class AdapterEngine implements IPeripheralAdapter {

	private static final double WATTS2MJ = 56280.0D;
	@SuppressWarnings("rawtypes")
	Class targetClass;
	
	@SuppressWarnings("rawtypes")
	@Override
	public Class getTargetClass() {
		try {
			targetClass = Class.forName("Reika.RotaryCraft.TileEntities.Production.TileEntityEngine");
			return targetClass;
		} catch (ClassNotFoundException e) {
		}
		return null;
	}

	@LuaMethod(returnType=LuaType.TABLE)
	public HashMap<Object, Object> getMachineData(IComputerAccess computer, Object par2) {
		TileEntity te = null;
		if(par2 instanceof TileEntity) {
			te = (TileEntity)par2;
		}
		if (te != null) {
			HashMap<Object,Object> data = new HashMap<Object,Object>();
			String name = ((RotaryCraftTileEntity)te).getMultiValuedName();
			data.put("name", name);
			data.put("power", ((TileEntityEngine)te).power);
			data.put("speed", ((TileEntityEngine)te).omega);
			if (((TileEntityEngine)te).type.isEthanolFueled() || ((TileEntityEngine)te).type.isJetFueled())
				data.put("fuelRequired", ((TileEntityEngine)te).type.getFuelType().getLocalizedName());
			if (((TileEntityEngine)te).type.hasTemperature())
				data.put("temp", ((TileEntityEngine)te).temperature);
			if (((TileEntityEngine)te).type.requiresLubricant())
				data.put("lubeLevels", ((TileEntityEngine)te).getLube());
			if (((TileEntityEngine)te).type.equals(EngineType.SPORT))
				data.put("addiLevels", ((TileEntityEngine)te).additives);
			if (((TileEntityEngine)te).type.burnsFuel())
				data.put("fuelLevel", ((TileEntityEngine)te).getFuelLevel());
			return data;
		}
		return null;

	}
	
	public String getTypeName(EngineType engine) {
		String name;
		switch (engine) {
		case DC:
			name = "DC";
			break;
		case STEAM:
			name = "STEAM";
			break;
		case GAS:
			name = "GAS";
			break;
		case AC:
			name = "AC";
			break;
		case HYDRO:
			name = "HYDRO";
			break;
		case JET:
			name = "JET";
			break;
		case MICRO:
			name = "MICRO";
			break;
		case SPORT:
			name = "SPORT";
			break;
		case WIND:
			name = "WIND";
			break;
		default:
			name = "Invalid Engine";
			break;
		}
		return name;
	}
}
