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
		nbttaglist.getCompoundTagAt(0).setInteger("nx", 0);
		nbttaglist.getCompoundTagAt(0).setInteger("ny", 0);
		nbttaglist.getCompoundTagAt(0).setInteger("nz", 0);
		nbttaglist.getCompoundTagAt(0).setInteger("px", 0);
		nbttaglist.getCompoundTagAt(0).setInteger("py", 0);
		nbttaglist.getCompoundTagAt(0).setInteger("pz", 0);
		stack.stackTagCompound.setTag("BiggerDim", nbttaglist);
	}
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer EntityPlayer) 
	{
		NBTTagList nbttaglist = (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("BiggerDim") ? (NBTTagList) stack.stackTagCompound.getTag("BiggerDim") : new NBTTagList());
		MovingObjectPosition movingobjectposition = getMovingObjectPositionFromPlayer(world, EntityPlayer, true);
		if (world.isRemote) 
		{
			
		} 
		else 
		{
			if ((EntityPlayer.isSneaking() && movingobjectposition == null) || nbttaglist == new NBTTagList())
			{
				nbttaglist.getCompoundTagAt(0).setInteger("nx", 0);
				nbttaglist.getCompoundTagAt(0).setInteger("ny", 0);
				nbttaglist.getCompoundTagAt(0).setInteger("nz", 0);
				nbttaglist.getCompoundTagAt(0).setInteger("px", 0);
				nbttaglist.getCompoundTagAt(0).setInteger("py", 0);
				nbttaglist.getCompoundTagAt(0).setInteger("pz", 0);
		        stack.setTagCompound(new NBTTagCompound());
				stack.stackTagCompound.setTag("BiggerDim", nbttaglist);
			}
			if (movingobjectposition == null)
			{
				return stack;
			}
			if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && EntityPlayer.isSneaking())
			{
                if (movingobjectposition.sideHit == 0)
                {
            		int NY = nbttaglist.getCompoundTagAt(0).getInteger("ny");
            		NY ++;
            		nbttaglist.getCompoundTagAt(0).setInteger("ny", NY);
                }

                if (movingobjectposition.sideHit == 1)
                {
            		int PY = nbttaglist.getCompoundTagAt(0).getInteger("py");
            		PY++;
            		nbttaglist.getCompoundTagAt(0).setInteger("py", PY);
                }

                if (movingobjectposition.sideHit == 2)
                {
            		int NZ = nbttaglist.getCompoundTagAt(0).getInteger("nz");
            		NZ++;
            		nbttaglist.getCompoundTagAt(0).setInteger("nz", NZ);
                }

                if (movingobjectposition.sideHit == 3)
                {
            		int PZ = nbttaglist.getCompoundTagAt(0).getInteger("pz");
            		PZ++;
            		nbttaglist.getCompoundTagAt(0).setInteger("pz", PZ);
                }

                if (movingobjectposition.sideHit == 4)
                {
            		int NX = nbttaglist.getCompoundTagAt(0).getInteger("nx");
            		NX++;
            		nbttaglist.getCompoundTagAt(0).setInteger("nx", NX);
                }

                if (movingobjectposition.sideHit == 5)
                {
            		int PX = nbttaglist.getCompoundTagAt(0).getInteger("px");
            		PX++;
            		nbttaglist.getCompoundTagAt(0).setInteger("px", PX);
                }
    	        stack.setTagCompound(new NBTTagCompound());
                stack.stackTagCompound.setTag("BiggerDim", nbttaglist);
			}
			if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && !EntityPlayer.isSneaking()) 
			{
				int X = movingobjectposition.blockX;
				int Y = movingobjectposition.blockY;
				int Z = movingobjectposition.blockZ;

				BlockCompound block = BlockCompound.get(world, X, Y, Z);
				for(int x = (nbttaglist.getCompoundTagAt(0).getInteger("nx") + X); x <= (nbttaglist.getCompoundTagAt(0).getInteger("px") + X); x++)
				{
					for(int y = (nbttaglist.getCompoundTagAt(0).getInteger("ny") + Y); y <= (nbttaglist.getCompoundTagAt(0).getInteger("py") + Y); y++)
					{	
						for(int z = (nbttaglist.getCompoundTagAt(0).getInteger("nz") + Z); z <= (nbttaglist.getCompoundTagAt(0).getInteger("pz") + Z); z++)
						{
							if (block.getBlock().canHarvestBlock(EntityPlayer, block.getMetadata())) 
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

