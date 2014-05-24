package bcwadsworth.devices.items.tools;

import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import bcwadsworth.devices.resources.BlockCompound;
import bcwadsworth.devices.resources.BlockList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolVoidBlockRanged extends Item
{
	public ToolVoidBlockRanged() 
	{
		maxStackSize = 1;
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName("toolVoidBlockRanged");
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) 
	{
		itemIcon = iconRegister.registerIcon("devices:toolVoid");
	}
	
	public void onCreated(ItemStack stack, World world, EntityPlayer pplayer)
	{
		NBTTagList nbttaglist = new NBTTagList();
		NBTTagCompound tag = new NBTTagCompound();
		
		tag.setInteger("nx", 0);
		tag.setInteger("ny", 0);
		tag.setInteger("nz", 0);
		tag.setInteger("px", 0);
		tag.setInteger("py", 0);
		tag.setInteger("pz", 0);
		nbttaglist.appendTag(tag);
		stack.stackTagCompound.setTag("BiggerDim", nbttaglist);
	}
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer EntityPlayer) 
	{
		NBTTagList nbttaglist = (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("BiggerDim") ? (NBTTagList) stack.stackTagCompound.getTag("BiggerDim") : new NBTTagList());
		NBTTagCompound tag = new NBTTagCompound();
		MovingObjectPosition movingobjectposition = getMovingObjectPositionFromPlayer(world, EntityPlayer, true);
		if (world.isRemote) 
		{
			
		} 
		else 
		{
			if ((EntityPlayer.isSneaking() && movingobjectposition == null))
			{
				nbttaglist = new NBTTagList();
				tag.setInteger("nx", 0);
				tag.setInteger("ny", 0);
				tag.setInteger("nz", 0);
				tag.setInteger("px", 0);
				tag.setInteger("py", 0);
				tag.setInteger("pz", 0);
				nbttaglist.appendTag(tag);
				stack.stackTagCompound.setTag("BiggerDim", nbttaglist);
			}
			if (movingobjectposition == null)
			{
				return stack;
			}
			if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && EntityPlayer.isSneaking())
			{
				switch (movingobjectposition.sideHit)
				{
					case 0:
					{
						int NY = nbttaglist.getCompoundTagAt(0).getInteger("ny");
						NY ++;
						tag.setInteger("ny", NY);
						
						tag.setInteger("py", nbttaglist.getCompoundTagAt(0).getInteger("py"));
						tag.setInteger("nz", nbttaglist.getCompoundTagAt(0).getInteger("nz"));
						tag.setInteger("pz", nbttaglist.getCompoundTagAt(0).getInteger("pz"));
						tag.setInteger("nx", nbttaglist.getCompoundTagAt(0).getInteger("nx"));
						tag.setInteger("px", nbttaglist.getCompoundTagAt(0).getInteger("px"));
						break;
					}
					case 1:
					{
						int PY = nbttaglist.getCompoundTagAt(0).getInteger("py");
						PY++;
						tag.setInteger("py", PY);
						
						tag.setInteger("ny", nbttaglist.getCompoundTagAt(0).getInteger("ny"));
						tag.setInteger("nz", nbttaglist.getCompoundTagAt(0).getInteger("nz"));
						tag.setInteger("pz", nbttaglist.getCompoundTagAt(0).getInteger("pz"));
						tag.setInteger("nx", nbttaglist.getCompoundTagAt(0).getInteger("nx"));
						tag.setInteger("px", nbttaglist.getCompoundTagAt(0).getInteger("px"));
						break;
					}

					case 2:
					{
						int NZ = nbttaglist.getCompoundTagAt(0).getInteger("nz");
						NZ++;
						tag.setInteger("nz", NZ);
						
						tag.setInteger("py", nbttaglist.getCompoundTagAt(0).getInteger("py"));
						tag.setInteger("ny", nbttaglist.getCompoundTagAt(0).getInteger("ny"));
						tag.setInteger("pz", nbttaglist.getCompoundTagAt(0).getInteger("pz"));
						tag.setInteger("nx", nbttaglist.getCompoundTagAt(0).getInteger("nx"));
						tag.setInteger("px", nbttaglist.getCompoundTagAt(0).getInteger("px"));
						break;
					}

					case 3:
					{
						int PZ = nbttaglist.getCompoundTagAt(0).getInteger("pz");
						PZ++;
						tag.setInteger("pz", PZ);
						
						tag.setInteger("py", nbttaglist.getCompoundTagAt(0).getInteger("py"));
						tag.setInteger("nz", nbttaglist.getCompoundTagAt(0).getInteger("nz"));
						tag.setInteger("ny", nbttaglist.getCompoundTagAt(0).getInteger("ny"));
						tag.setInteger("nx", nbttaglist.getCompoundTagAt(0).getInteger("nx"));
						tag.setInteger("px", nbttaglist.getCompoundTagAt(0).getInteger("px"));
						break;
					}

					case 4:
					{
						int NX = nbttaglist.getCompoundTagAt(0).getInteger("nx");
						NX++;
						tag.setInteger("nx", NX);
						
						tag.setInteger("py", nbttaglist.getCompoundTagAt(0).getInteger("py"));
						tag.setInteger("nz", nbttaglist.getCompoundTagAt(0).getInteger("nz"));
						tag.setInteger("pz", nbttaglist.getCompoundTagAt(0).getInteger("pz"));
						tag.setInteger("ny", nbttaglist.getCompoundTagAt(0).getInteger("ny"));
						tag.setInteger("px", nbttaglist.getCompoundTagAt(0).getInteger("px"));
						break;
					}

					case 5:
					{
						int PX = nbttaglist.getCompoundTagAt(0).getInteger("px");
						PX++;
						tag.setInteger("px", PX);
						
						tag.setInteger("py", nbttaglist.getCompoundTagAt(0).getInteger("py"));
						tag.setInteger("nz", nbttaglist.getCompoundTagAt(0).getInteger("nz"));
						tag.setInteger("pz", nbttaglist.getCompoundTagAt(0).getInteger("pz"));
						tag.setInteger("nx", nbttaglist.getCompoundTagAt(0).getInteger("nx"));
						tag.setInteger("ny", nbttaglist.getCompoundTagAt(0).getInteger("ny"));
						break;
					}
				}
				nbttaglist = new NBTTagList();
    	        stack.setTagCompound(new NBTTagCompound());
    	        nbttaglist.appendTag(tag);
                stack.stackTagCompound.setTag("BiggerDim", nbttaglist);
			}
			if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && !EntityPlayer.isSneaking()) 
			{
				int X = movingobjectposition.blockX;
				int Y = movingobjectposition.blockY;
				int Z = movingobjectposition.blockZ;

				BlockCompound block = BlockCompound.get(world, X, Y, Z);
				for(int x = (-(nbttaglist.getCompoundTagAt(0).getInteger("nx")) + X); x <= (nbttaglist.getCompoundTagAt(0).getInteger("px") + X); x++)
				{
					for(int y = (-(nbttaglist.getCompoundTagAt(0).getInteger("ny")) + Y); y <= (nbttaglist.getCompoundTagAt(0).getInteger("py") + Y); y++)
					{	
						for(int z = (-(nbttaglist.getCompoundTagAt(0).getInteger("nz")) + Z); z <= (nbttaglist.getCompoundTagAt(0).getInteger("pz") + Z); z++)
						{
							if (block.getBlock() == Blocks.bedrock) 
							{

							}
							else
							{
								world.setBlockToAir(x, y, z);
							}
						}
					}
				}
			}
		}
		return stack;
    }
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) 
	{
		list.add("404 Error: Block not Found");
		NBTTagList nbttaglist = (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("BiggerDim") ? (NBTTagList) stack.stackTagCompound.getTag("BiggerDim") : new NBTTagList());
		int PX = nbttaglist.getCompoundTagAt(0).getInteger("px");
		int PY = nbttaglist.getCompoundTagAt(0).getInteger("py");
		int PZ = nbttaglist.getCompoundTagAt(0).getInteger("pz");
		int NX = nbttaglist.getCompoundTagAt(0).getInteger("nx");
		int NY = nbttaglist.getCompoundTagAt(0).getInteger("ny");
		int NZ = nbttaglist.getCompoundTagAt(0).getInteger("nz");
		list.add("Positive Dimensions: X-" + PX + " Y-" + PY + " Z-" + PZ);
		list.add("Negative Dimensions: X-" + NX + " Y-" + NY + " Z-" + NZ);
		super.addInformation(stack, player, list, par4);
	}
}

