package teamUnknown.immersion.features.magic.api.mana;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class ManaPacket 
{
	public HashMap<Integer, Integer> mana = new HashMap<Integer, Integer>();
	
	public ManaPacket(HashMap<Integer, Integer> mana)
	{
		this.mana = mana;
	}
	
	public ManaPacket(int type, int amount)
	{
		mana.put(type, amount);
	}
	
	//this is for creating an empty manapacket
	public ManaPacket()
	{
		
	}
	
	public void condensetotype(int type, float conservation)
	{
		int totalmana = 0;
		for (int value : mana.values())
		{
			totalmana = totalmana + value;
		}
		totalmana = (int)(totalmana * conservation);
		mana.clear();
		mana.put(type, totalmana);
	}
	
	public void addPacket(ManaPacket packet)
	{
		for (Entry<Integer, Integer> entry : packet.mana.entrySet())
		{
			if (mana.containsKey(entry.getKey()))
			{
				int totalmana = (mana.get(entry.getKey()) + entry.getValue());
				mana.remove(entry.getKey());
				mana.put(entry.getKey(), totalmana);
			}
			else
			{
				mana.put(entry.getKey(), entry.getValue());
			}
		}
	}
	
	public void removePacket(ManaPacket packet)
	{
		for (Entry<Integer, Integer> entry : packet.mana.entrySet())
		{
			if (mana.containsKey(entry.getKey()))
			{
				int totalmana = (mana.get(entry.getKey()) - entry.getValue());
				mana.remove(entry.getKey());
				if (totalmana > 0)
				{
					mana.put(entry.getKey(), totalmana);
				}
			}
		}
	}
	
	public ManaPacket getExcessPacket(int imax, int tmax)
	{
		ManaPacket excess = new ManaPacket();
		int totalmana = 0;
		
		for (Entry<Integer, Integer> entry : this.mana.entrySet())
		{
			totalmana = totalmana + entry.getValue();
			if (entry.getValue() > imax)
			{
				ManaPacket iexcess = new ManaPacket(entry.getKey(), (entry.getValue() - imax));
				excess.addPacket(iexcess);
				this.removePacket(iexcess);
			}
		}
		
		if (totalmana > tmax)
		{
			Float cutpercentage = 1.0F - ((float)tmax/(float)totalmana);
			
			for (Entry<Integer, Integer> entry : this.mana.entrySet())
			{
				ManaPacket iexcess = new ManaPacket(entry.getKey(), (int)((float)entry.getValue() * cutpercentage));
				excess.addPacket(iexcess);
				this.removePacket(iexcess);
			}
		}
		return excess;
	}
}
