package teamUnknown.immersion.features.electricalAge.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import teamUnknown.immersion.core.meta.Energy;
import teamUnknown.immersion.core.meta.Textures;
import teamUnknown.immersion.core.utils.GuiUtil;
import teamUnknown.immersion.features.electricalAge.container.ContainerEnergyCell;
import teamUnknown.immersion.features.electricalAge.energy.EnergyBar;
import teamUnknown.immersion.features.electricalAge.energy.IEnergy;
import teamUnknown.immersion.features.electricalAge.tileEntitys.machine.TileEntityCreativeStorage;

import java.util.Arrays;

public class GuiEnergyCell extends GuiContainer {

    public final EntityPlayer player;
    public final World world;
    public final int x;
    public final int y;
    public final int z;
    public TileEntityCreativeStorage tileentity;
    public boolean prevExtraInventory;

    public GuiEnergyCell(EntityPlayer player, World world, int x, int y, int z) {

        super(new ContainerEnergyCell(player, world, x, y, z));
        this.player = player;
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.tileentity = (TileEntityCreativeStorage) world.getTileEntity(x, y, z);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int x, int y)
    {
        xSize = 176;
        this.mc.getTextureManager().bindTexture(Textures.GUI_ENERGY_CELL);
        GuiUtil.drawRectangle(guiLeft, guiTop, 176, ySize, 256, 256, 0, 0);
        int energyBarSize = 48;
        this.drawTexturedModalRect(guiLeft + 8, guiTop + 8 + energyBarSize - ((IEnergy) tileentity).getEnergyBar().getEnergyLevelScaled(energyBarSize), 176, 31, 16, ((IEnergy) tileentity).getEnergyBar().getEnergyLevelScaled(energyBarSize));
        int middleX = (this.width - this.xSize) / 2;
        int middleY = (this.height - this.ySize) / 2;

    }

    @Override
    public void drawGuiContainerForegroundLayer(int x, int y)
    {
        drawEnergyLevel(x, y);
    }

    private void drawEnergyLevel(int x, int y)
    {
        int minX = guiLeft + 8;
        int maxX = guiLeft + 8 + 15;
        int minY = guiTop + 8;
        int maxY = guiTop + 8 + 47;
        EnergyBar energyBar = ((IEnergy) tileentity).getEnergyBar();
        if (x >= minX && x <= maxX && y >= minY && y <= maxY)
        {
            this.drawHoveringText(Arrays.asList(energyBar.getEnergyLevel() + " / " + energyBar.getMaxEnergyLevel() + " " + Energy.Wired.QM.getName()), x - guiLeft - 6, y - guiTop, fontRendererObj);
        }
    }
}
