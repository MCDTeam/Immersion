package bcwadsworth.devices.generation;

import java.util.Random;

import bcwadsworth.devices.Devices;
import bcwadsworth.devices.resources.General;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class Generators 
{
	public static void createVein(World world, Random random, Block Generate, Block Check, int ChunkX, int ChunkZ, int Ymin, int Ymax, int GenerateMin, int GenerateMax)
	{
		int X = ChunkX*16 + random.nextInt(16);
    	int Y = Ymin + random.nextInt(Ymax-Ymin);
    	int Z = ChunkZ*16 + random.nextInt(16);
    	//Generate a piece of ore at the determined random spot in the chunk
    	world.setBlock(X, Y, Z, Generate);
    	if (General.DEBUG)
    	{
    		System.out.println("Started Generating vein of " + Generate.getLocalizedName() + " at X:" + X + " Y:" + Y + " Z:" + Z);
    	}  
    	//Decide the next Blocks
    	for (int i = 0; i < ((GenerateMin - 1) + random.nextInt(GenerateMax-GenerateMin)); i++)
    	{
			int Xprev = X; //Store last values
			int Yprev = Y;
			int Zprev = Z;
			
			for (int t = 0; t < General.OREGENERATIONATTEMPTS; t++) 
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
				if (world.getBlock(X, Y, Z) == Check) //Checks to make sure we are not overwriting ourself
				{
					world.setBlock(X, Y, Z, Generate);
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

