package com.x_j0nnay_x.defincraft.world.gen;

import com.x_j0nnay_x.defincraft.definecraftCore;
import com.x_j0nnay_x.defincraft.util.RegHandler;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;


//    getOre(biome, 12, 5, 5, 80, OreFeatureConfig.FillerBlockType.NETHERRACK, RegHandler.HELLSTONEORE.get().getDefaultState(), 4);
//   getOre(biome, 15, 8, 6, 60, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegHandler.SILVERORE.get().getDefaultState(), 10);
//  getOre(biome, 15, 8, 1, 40, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegHandler.TERBIUMORE.get().getDefaultState(), 6);

@Mod.EventBusSubscriber
public class DefiencraftGenHandler {

    private static final ArrayList<ConfiguredFeature<?, ?>> overworldOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> netherOres1 = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> endOres = new ArrayList<ConfiguredFeature<?, ?>>();

    public static void registerOres() {
        //BASE_STONE_OVERWORLD is for generating in stone, granite, diorite, and andesite
        //NETHERRACK is for generating in netherrack
        //BASE_STONE_NETHER is for generating in netherrack, basalt and blackstone

        //Overworld Ore Register
        overworldOres.add(register("neutralis_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegHandler.SILVERORE.get().getDefaultState(), 8)) //Vein Size
                .range(50).square() //Spawn height start
                .func_242731_b(12))); //Chunk spawn frequency
        overworldOres.add(register("neutralis_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegHandler.TERBIUMORE.get().getDefaultState(), 5)) //Vein Size
                .range(30).square() //Spawn height start
                .func_242731_b(5))); //Chunk spawn frequency
        //Nether Ore Register
        netherOres.add(register("flame_crystal_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.NETHERRACK, RegHandler.HELLSTONEORE.get().getDefaultState(), 4))
                .range(120).square()//spawn hight start
                .func_242731_b(14)));//chunk spawn fequency

        netherOres1.add(register("flame_crystal_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER, RegHandler.HELLSTONEOREBL.get().getDefaultState(), 4))
                .range(120).square()//spawn hight start
                .func_242731_b(10)));//chunk spawn fequency


        //The End Ore Register
        /*endOres.add(register("air_block", Feature.ORE.withConfiguration(new OreFeatureConfig(
                new BlockMatchRuleTest(Blocks.END_STONE), RegHandler.HELLSPAWNORE.get().getDefaultState(), 4)) //Vein Size
                .range(128).square() //Spawn height start
                .func_242731_b(64))); //Chunk spawn frequency*/
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void gen(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if (event.getCategory().equals(Biome.Category.NETHER)) {
            for (ConfiguredFeature<?, ?> ore : netherOres) {
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        if (event.getCategory().equals(Biome.Category.NETHER)) {
            if (event.getCategory().equals(new BlockMatchRuleTest(Blocks.BLACKSTONE))) {
                for (ConfiguredFeature<?, ?> ore : netherOres1) {
                    if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
                }
            }
        }
        if (event.getCategory().equals(Biome.Category.NETHER)) {
            if (event.getCategory().equals(new BlockMatchRuleTest(Blocks.BASALT))) {
                for (ConfiguredFeature<?, ?> ore : netherOres1) {
                    if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
                }
            }
        }
        if (event.getCategory().equals(Biome.Category.THEEND)) {
            for (ConfiguredFeature<?, ?> ore : endOres) {
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        for (ConfiguredFeature<?, ?> ore : overworldOres) {
            if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
        }
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, definecraftCore.MODID + ":" + name, configuredFeature);
    }

}