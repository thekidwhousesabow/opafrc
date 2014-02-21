package opafrc.adapter.rotarycraft;

import java.util.HashMap;

import Reika.RotaryCraft.Base.TileEntity.TileEntityPowerReceiver;
import net.minecraft.tileentity.TileEntity;
import dan200.computer.api.IComputerAccess;
import openperipheral.api.IPeripheralAdapter;
import openperipheral.api.LuaMethod;
import openperipheral.api.LuaType;

public class AdapterMachine implements IPeripheralAdapter {

	@Override
	public Class getTargetClass() {
		return TileEntityPowerReceiver.class;
	}
	
	@LuaMethod(returnType=LuaType.TABLE)
	public HashMap<Object, Object> getMachineData(IComputerAccess computer, TileEntityPowerReceiver par2) {
		TileEntity te = null;
		if(par2 instanceof TileEntityPowerReceiver) {
			te = (TileEntityPowerReceiver)par2;
		}
		if (te != null) {
			HashMap<Object,Object> data = new HashMap<Object,Object>();
			data.put("name", par2.getMultiValuedName());
			data.put("power", par2.power);
			data.put("speed", par2.omega);
			
			if (par2.machine.hasMultiValuedPower()) {
				System.out.println("Testing");
				HashMap<Integer, Integer> torques = new HashMap<Integer, Integer>();
				System.out.println(par2.machine.getMultiValuedPowerTypes()+1);
				HashMap<Integer, Integer> speeds = new HashMap<Integer, Integer>();
				HashMap<Integer, Integer> powers = new HashMap<Integer, Integer>();
				for (int i=0; i<par2.machine.getMultiValuedPowerTypes();i++) {
					System.out.println("testing "+(i+1)+".");
					if (par2.machine.getMinTorque(i)>1)
						torques.put((i+1), par2.machine.getMinTorque(i));
					if (par2.machine.getMinSpeed(i)>1)
						speeds.put((i+1), par2.machine.getMinSpeed(i));
					if (par2.machine.getMinPower(i)>1)
						powers.put((i+1), par2.machine.getMinPower(i));
				}
				data.put("minTorques", torques);
				data.put("minSpeeds", speeds);
				data.put("minPowers", powers);
			} else {
				if (par2.machine.getMinTorque()>1)
					data.put("minTorque", par2.machine.getMinTorque());
				if (par2.machine.getMinSpeed()>1)
					data.put("minSpeed", par2.machine.getMinSpeed());
				if (par2.machine.getMinPower()>1)
					data.put("minPower", par2.machine.getMinPower());
			}
			
			for (Object dat : data.values()) {
				if (dat instanceof Integer || dat instanceof String)
					System.out.println(dat);
				else if (dat instanceof Integer[]) {
					for (int dat2 : ((int[])dat)) {
						System.out.println(dat2);
					}
				}
			}
			return data;
		}
		return null;
	}
}
