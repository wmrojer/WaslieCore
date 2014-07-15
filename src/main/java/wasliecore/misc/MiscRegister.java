package wasliecore.misc;

import wasliecore.interfaces.IInitalization;
import wasliecore.misc.items.ItemSwordCheat;
import wasliecore.misc.items.ItemWE;

public class MiscRegister implements IInitalization{

	@Override
	public void preInit() {
		we = new ItemWE();
		sword_cheat = new ItemSwordCheat();
	}
	public static ItemWE we;
	public static ItemSwordCheat sword_cheat;
	
	@Override
	public void init() {
		
	}

	@Override
	public void postInit() {
		
	}
}