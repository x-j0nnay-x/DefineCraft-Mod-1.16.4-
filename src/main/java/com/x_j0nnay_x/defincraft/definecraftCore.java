package com.x_j0nnay_x.defincraft;

import com.x_j0nnay_x.defincraft.util.RegHandler;
import com.x_j0nnay_x.defincraft.world.gen.DefiencraftGenHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("definecraft")
public class definecraftCore {
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "definecraft";

    public definecraftCore() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        RegHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        DefiencraftGenHandler.registerOres();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    // Custom ItemGroup TAB
    public static final ItemGroup TAB = new ItemGroup("DefineCraftTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegHandler.HELLSTONEBAR.get());
        }
    };

}

