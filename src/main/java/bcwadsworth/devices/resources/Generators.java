package bcwadsworth.devices.resources;

import java.util.Random;

import bcwadsworth.devices.Devices;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class Generators 
{
	public static void createVein(World world, Random random, Block generate, Block check, int chunkX, int chunkZ, int Ymin, int Ymax, int generateMin, int generateMax)
	{
		int X = 0;
		int Y = 0;
		int Z = 0;
		
		for (int k = 0; k < ConfigLoad.OREGENERATIONATTEMPTS; k++)
		{
			X = chunkX*16 + random.nextInt(16);
			Y = Ymin + random.nextInt(Ymax-Ymin);
			Z = chunkZ*16 + random.nextInt(16);
			if (world.getBlock(X, Y, Z) == check)
			{
		    	//Generate a piece of ore at the determined random spot in the chunk
		    	world.setBlock(X, Y, Z, generate);
		    	break;
			}
		}
    	if (ConfigLoad.DEBUG)
    	{
    		System.out.println("Started Generating vein of " + generate.getLocalizedName() + " at X:" + X + " Y:" + Y + " Z:" + Z);
    	}  
    	//Decide the next Blocks
    	for (int i = 0; i < ((generateMin - 1) + random.nextInt(generateMax-generateMin)); i++)
    	{
			int Xprev = X; //Store last values
			int Yprev = Y;
			int Zprev = Z;
			
			for (int t = 0; t < ConfigLoad.OREGENERATIONATTEMPTS; t++) 
			{
				switch (random.nextInt(3)) 
				{
				case 0: // X Direction
					if (random.nextBoolean()) 
					{
						X++;
					} 
					else 
					{
						X = X - 1;
					}
					break;

				case 1: // Y direction
					if (random.nextBoolean()) 
					{
						Y++;
					} 
					else 
					{
						Y = Y - 1;
					}
					break;

				case 2: // Z direction
					if (random.nextBoolean()) 
					{
						Z++;
					} 
					else 
					{
						Z = Z - 1;
					}
					break;
				}
				if (world.getBlock(X, Y, Z) == check) //Checks to make sure we are not overwriting ourself
				{
					world.setBlock(X, Y, Z, generate);
					break;
				}
				else //returns to the previous block
				{
					X = Xprev;
					Y = Yprev;
					Z = Zprev;
				}
			}
    	}     	
    }
}

