package bcwadsworth.devices.resources.core;


public class BlockConversionRecipieHandler 
{
	private BlockList Convert;
	private BlockList Finish;
	public BlockConversionRecipieHandler(BlockList start, BlockList end)
	{
		Convert = start;
		Finish = end;
	}
	
	public BlockCompound getRecipie(BlockCompound block)
	{
		System.out.println(Convert.get(block));
		int index = Convert.get(block);
		if (index != -1)
		{
			return Finish.get(index);
		}
		else
		{
			return null;
		}
	}
	
	public void addRecipie(BlockCompound block, BlockCompound result)
	{
		Convert.addToList(block);
		Finish.addToList(result);
	}
	
	public void changeRecipie(BlockCompound block, BlockCompound output)
	{
		Finish.changeToList(Convert.get(block), output);
	}
	
	public void removeRecipie(BlockCompound block)
	{
		Finish.removeFromList(Convert.get(block));
		Convert.removeFromList(block);
	}
	
	public void clearRecipies()
	{
		Convert.clearList();
		Finish.clearList();
	}
	
	public void setRecipies(BlockList start, BlockList end)
	{
		Convert = start;
		Finish = end;
	}
}
