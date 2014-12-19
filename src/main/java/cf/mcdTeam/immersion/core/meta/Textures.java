package cf.mcdTeam.immersion.core.meta;

import net.minecraft.util.ResourceLocation;
import cf.mcdTeam.immersion.core.utils.ResourceLocationHelper;

public class Textures {


    // Model base directory
    public static final String MODEL_FILE_PATH = "textures/model/";
    public static final String GUI_FILE_PATH = "textures/gui/";

    // Gui's
    public static final ResourceLocation GUI_ENERGY_CELL = ResourceLocationHelper.getResourceLocation(GUI_FILE_PATH + "creativeEnergyCell.png");

    // Block Models
    public static final ResourceLocation MODEL_ELECTRICAL_WIRE_BASIC = ResourceLocationHelper.getResourceLocation(MODEL_FILE_PATH + "electricalWireBasic.png");


}
