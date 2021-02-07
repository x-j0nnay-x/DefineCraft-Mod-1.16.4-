package com.x_j0nnay_x.defincraft.util;

import com.mojang.serialization.DataResult;
import com.x_j0nnay_x.defincraft.blocks.*;
import com.x_j0nnay_x.defincraft.definecraftCore;
import com.x_j0nnay_x.defincraft.enchantments.LiquidWalker;
import com.x_j0nnay_x.defincraft.enchantments.lightbringer;
import com.x_j0nnay_x.defincraft.items.*;
import com.x_j0nnay_x.defincraft.tools.ModItemTier;
import com.x_j0nnay_x.defincraft.tools.modarmor;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.particles.ParticleTypes;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class RegHandler {
    //enchantments
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, definecraftCore.MODID);
    //items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, definecraftCore.MODID);
    //blocks
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, definecraftCore.MODID);
    

    public static void init() {
        ENCHANTMENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //enchantments
    public static final RegistryObject<Enchantment> LiquidWalker = ENCHANTMENTS.register("liquidwalker", () ->
            new LiquidWalker(Enchantment.Rarity.RARE, EquipmentSlotType.FEET));
    public static final RegistryObject<Enchantment> LightBringer = ENCHANTMENTS.register("lightbringer", () ->
            new lightbringer(Enchantment.Rarity.RARE, EquipmentSlotType.HEAD));
    public static final RegistryObject<Enchantment> Flight = ENCHANTMENTS.register("flight", () ->
            new LiquidWalker(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.CHEST));
    public static final RegistryObject<Enchantment> GodMode = ENCHANTMENTS.register("godmode", () ->
            new LiquidWalker(Enchantment.Rarity.VERY_RARE));
    //items
    public static final RegistryObject<Item> GRINDERHEAD = ITEMS.register("grinderhead", () -> new GrinderHead(10));
    public static final RegistryObject<Item> GRINDERHEAC = ITEMS.register("grinderheadc", () -> new GrinderHead(13));
    public static final RegistryObject<Item> GRINDERHEADI = ITEMS.register("grinderheadi", () -> new GrinderHead(26));
    public static final RegistryObject<Item> GRINDERHEADS = ITEMS.register("grinderheads", () -> new GrinderHead(30));
    public static final RegistryObject<Item> GRINDERHEADG = ITEMS.register("grinderheadg", () -> new GrinderHead(32));
    public static final RegistryObject<Item> GRINDERHEADT = ITEMS.register("grinderheadt", () -> new GrinderHead(38));
    public static final RegistryObject<Item> GRINDERHEADD = ITEMS.register("grinderheadd", () -> new GrinderHead(46));
    public static final RegistryObject<Item> GRINDERHEAO = ITEMS.register("grinderheado", () -> new GrinderHead(60));
    public static final RegistryObject<Item> GRINDERHEADH = ITEMS.register("grinderheadh", () -> new GrinderHead(90));
    public static final RegistryObject<Item> GRINDERHEADHS = ITEMS.register("grinderheadhs", () -> new GrinderHead(244));

    public static final RegistryObject<Item> COALDUST = ITEMS.register("coaldust", () -> new coaldust());
    public static final RegistryObject<Item> GOLDSTICK = ITEMS.register("goldstick", () -> new DCBasicItem(0));
    public static final RegistryObject<Item> OBSIDIANSTICK = ITEMS.register("obsidianstick", () -> new DCBasicItem(0));
    public static final RegistryObject<Item> IRONDUST = ITEMS.register("irondust", () -> new DCBasicItem(1));
    public static final RegistryObject<Item> GOLDDUST = ITEMS.register("golddust", () -> new DCBasicItem(1));
    public static final RegistryObject<Item> DIAMONDDUST = ITEMS.register("diamondust", () -> new DCBasicItem(1));
    public static final RegistryObject<Item> NETHERITEDUST = ITEMS.register("netheritedust", () -> new DCBasicItem(1));
    public static final RegistryObject<Item> NETHERITEDUSTC = ITEMS.register("netheritedustc", () -> new DCBasicItem(1));

    //silver
    public static final RegistryObject<Item> SILVERDUST = ITEMS.register("silverdust", () -> new DCBasicItem(1));
    public static final RegistryObject<Item> SILVERBAR = ITEMS.register("silverbar", () -> new DCBasicItem(2));
    public static final RegistryObject<Item> SILVERNUG = ITEMS.register("silvernug", () -> new DCBasicItem(3));
    //tools
    public static final RegistryObject<SwordItem> SILVERSWORD = ITEMS.register("silversword", () ->
            new SwordItem(ModItemTier.Silver, 3, -2.4f, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<ShovelItem> SILVERSPADE = ITEMS.register("silverspade", () ->
            new ShovelItem(ModItemTier.Silver, 0, -3.4f, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<PickaxeItem> SILVERPICKAXE = ITEMS.register("silverpickaxe", () ->
            new PickaxeItem(ModItemTier.Silver, 0, -3f, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<AxeItem> SILVERAXE = ITEMS.register("silveraxe", () ->
            new AxeItem(ModItemTier.Silver, 3, -3.4f, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<HoeItem> SILVERHOE = ITEMS.register("silverhoe", () ->
            new HoeItem(ModItemTier.Silver, -3, -3.4f, new Item.Properties().group(definecraftCore.TAB)));
    //armor
    public static final RegistryObject<ArmorItem> SILVERHELMET = ITEMS.register("silverhelmet", () ->
            new ArmorItem(modarmor.Silver, EquipmentSlotType.HEAD, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<ArmorItem> SILVERCHEST = ITEMS.register("silverchest", () ->
            new ArmorItem(modarmor.Silver, EquipmentSlotType.CHEST, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<ArmorItem> SILVERLEGS = ITEMS.register("silverlegs", () ->
            new ArmorItem(modarmor.Silver, EquipmentSlotType.LEGS, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<ArmorItem> SILVERBOOTS = ITEMS.register("silverboots", () ->
            new ArmorItem(modarmor.Silver, EquipmentSlotType.FEET, new Item.Properties().group(definecraftCore.TAB)));
    //block
    public static final RegistryObject<Block> SILVERORE = BLOCKS.register("silverore", DCOreBLock::new);
    public static final RegistryObject<Block> SILVERBLOCK = BLOCKS.register("silverblock", ComplactBlockDC::new);
    //block Items
    public static final RegistryObject<Item> SILVERORE_ITEM = ITEMS.register("silverore", () -> new BlockItemBase(SILVERORE.get()));
    public static final RegistryObject<Item> SILVERBLOCK_ITEM = ITEMS.register("silverblock", () -> new BlockItemBase(SILVERBLOCK.get()));

    //terbium
    public static final RegistryObject<Item> TERBIUMDUST = ITEMS.register("terbiumdust", () -> new DCBasicItem(1));
    public static final RegistryObject<Item> TERBIUMBAR = ITEMS.register("terbiumbar", () -> new DCBasicItem(2));
    public static final RegistryObject<Item> TERBIUMNUG = ITEMS.register("terbiumnug", () -> new DCBasicItem(3));
    //tools
    public static final RegistryObject<SwordItem> TERBIUMSWORD = ITEMS.register("terbiumsword", () ->
            new SwordItem(ModItemTier.Terbium, 3, -2f, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<ShovelItem> TERBIUMSPADE = ITEMS.register("terbiumspade", () ->
            new ShovelItem(ModItemTier.Terbium, 0, -2.7f, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<PickaxeItem> TERBIUMPICKAXE = ITEMS.register("terbiumpickaxe", () ->
            new PickaxeItem(ModItemTier.Terbium, 0, -2.7f, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<AxeItem> TERBIUMAXE = ITEMS.register("terbiumaxe", () ->
            new AxeItem(ModItemTier.Terbium, 4, -3f, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<HoeItem> TERBIUMHOE = ITEMS.register("terbiumhoe", () ->
            new HoeItem(ModItemTier.Terbium, -3, -2.7f, new Item.Properties().group(definecraftCore.TAB)));
    //armor
    public static final RegistryObject<ArmorItem> TERBIUMHELMET = ITEMS.register("terbiumhelmet", () ->
            new ArmorItem(modarmor.Terbium, EquipmentSlotType.HEAD, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<ArmorItem> TERBIUMCHEST = ITEMS.register("terbiumchest", () ->
            new ArmorItem(modarmor.Terbium, EquipmentSlotType.CHEST, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<ArmorItem> TERBIUMLEGS = ITEMS.register("terbiumlegs", () ->
            new ArmorItem(modarmor.Terbium, EquipmentSlotType.LEGS, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<ArmorItem> TERBIUMBOOTS = ITEMS.register("terbiumboots", () ->
            new ArmorItem(modarmor.Terbium, EquipmentSlotType.FEET, new Item.Properties().group(definecraftCore.TAB)));
    //block
    public static final RegistryObject<Block> TERBIUMORE = BLOCKS.register("terbiumore", DCOreBLock::new);
    public static final RegistryObject<Block> TERBIUMBLOCK = BLOCKS.register("terbiumblock", ComplactBlockDC::new);
    //block Items
    public static final RegistryObject<Item> TERBIUMORE_ITEM = ITEMS.register("terbiumore", () -> new BlockItemBase(TERBIUMORE.get()));
    public static final RegistryObject<Item> TERBIUMBLOCK_ITEM = ITEMS.register("terbiumblock", () -> new BlockItemBase(TERBIUMBLOCK.get()));

    //obsidian
    public static final RegistryObject<Item> OBSIDIANDUST = ITEMS.register("obsidiandust", () -> new DCBasicItem(1));
    public static final RegistryObject<Item> OBSIDIANBAR = ITEMS.register("obsidianbar", () -> new DCBasicItem(2));
    public static final RegistryObject<Item> OBSIDIANNUG = ITEMS.register("obsidiannug", () -> new DCBasicItem(3));
    //tools
    public static final RegistryObject<SwordItem> OBSIDIANSWORD = ITEMS.register("obsidiansword", () ->
            new customesword(ModItemTier.Obsidian, 4, -2.4f, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<ShovelItem> OBSIDIANSPADE = ITEMS.register("obsidianspade", () ->
            new ShovelItem(ModItemTier.Obsidian, 0, -3.4f, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<PickaxeItem> OBSIDIANPICKAXE = ITEMS.register("obsidianpickaxe", () ->
            new customepickaxe(ModItemTier.Obsidian, 0, -3.4f, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<AxeItem> OBSIDIANAXE = ITEMS.register("obsidianaxe", () ->
            new customaxe(ModItemTier.Obsidian, 5, -2.5f, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<HoeItem> OBSIDIANHOE = ITEMS.register("obsidianhoe", () ->
            new HoeItem(ModItemTier.Obsidian, -3, -3.4f, new Item.Properties().group(definecraftCore.TAB)));
    //armor
    public static final RegistryObject<ArmorItem> OBSIDIANHELMET = ITEMS.register("obsidianhelmet", () ->
            new customearmor(modarmor.Obsidian, EquipmentSlotType.HEAD, new Item.Properties().group(definecraftCore.TAB), 0));
    public static final RegistryObject<ArmorItem> OBSIDIANCHEST = ITEMS.register("obsidianchest", () ->
            new customearmor(modarmor.Obsidian, EquipmentSlotType.CHEST, new Item.Properties().group(definecraftCore.TAB), 0));
    public static final RegistryObject<ArmorItem> OBSIDIANLEGS = ITEMS.register("obsidianlegs", () ->
            new customearmor(modarmor.Obsidian, EquipmentSlotType.LEGS, new Item.Properties().group(definecraftCore.TAB), 0));
    public static final RegistryObject<ArmorItem> OBSIDIANBOOTS = ITEMS.register("obsidianboots", () ->
            new customearmor(modarmor.Obsidian, EquipmentSlotType.FEET, new Item.Properties().group(definecraftCore.TAB), 0));
    //blocks
    public static final RegistryObject<Block> OBSIDIANBLCOKCOMPACT = BLOCKS.register("obsidianblockcompact", ComplactBlockDC::new);
    //block Items
    public static final RegistryObject<Item> OBSIDIANBLCOKCOMPACT_ITEM = ITEMS.register("obsidianblockcompact", () -> new BlockItemBase(OBSIDIANBLCOKCOMPACT.get()));
    //hellstone
    public static final RegistryObject<Item> HELLSTONEDUST = ITEMS.register("hellstonedust", () -> new DCBasicItem(1));
    public static final RegistryObject<Item> HELLSTONEBAR = ITEMS.register("hellstonebar", () -> new DCBasicItem(2));
    public static final RegistryObject<Item> HELLSTONENUG = ITEMS.register("hellstonenug", () -> new DCBasicItem(3));
    //tools
    public static final RegistryObject<SwordItem> HELLSTONESWORD = ITEMS.register("hellstonesword", () ->
            new customesword(ModItemTier.Hellstone, 5, -2f, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<ShovelItem> HELLSTONESPADE = ITEMS.register("hellstonespade", () ->
            new customspade(ModItemTier.Hellstone, 0, -2.7f, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<PickaxeItem> HELLSTONEPICKAXE = ITEMS.register("hellstonepickaxe", () ->
            new customepickaxe(ModItemTier.Hellstone, 0, -2.7f, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<AxeItem> HELLSTONEAXE = ITEMS.register("hellstoneaxe", () ->
            new customaxe(ModItemTier.Hellstone, 6, -2.5f, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<HoeItem> HELLSTONEHOE = ITEMS.register("hellstonehoe", () ->
            new customHoe(ModItemTier.Hellstone, -3, -2.7f, new Item.Properties().group(definecraftCore.TAB)));
    //armor
    public static final RegistryObject<ArmorItem> HELLSTONEHELMET = ITEMS.register("hellstonehelmet", () ->
            new customearmor(modarmor.Hellstone, EquipmentSlotType.HEAD, new Item.Properties().group(definecraftCore.TAB), 1));
    public static final RegistryObject<ArmorItem> HELLSTONECHEST = ITEMS.register("hellstonechest", () ->
            new customearmor(modarmor.Hellstone, EquipmentSlotType.CHEST, new Item.Properties().group(definecraftCore.TAB), 1));
    public static final RegistryObject<ArmorItem> HELLSTONELEGS = ITEMS.register("hellstonelegs", () ->
            new customearmor(modarmor.Hellstone, EquipmentSlotType.LEGS, new Item.Properties().group(definecraftCore.TAB), 1));
    public static final RegistryObject<ArmorItem> HELLSTONEBOOTS = ITEMS.register("hellstoneboots", () ->
            new customearmor(modarmor.Hellstone, EquipmentSlotType.FEET, new Item.Properties().group(definecraftCore.TAB), 1));
    //block
    public static final RegistryObject<Block> HELLSTONEORE = BLOCKS.register("hellstoneore", DCHellOreBLock::new);
    public static final RegistryObject<Block> HELLSTONEOREBL = BLOCKS.register("hellstoneorebl", DCHellOreBLock::new);
    public static final RegistryObject<Block> HELLSTONEBLOCK = BLOCKS.register("hellstoneblock", ComplactBlockDC::new);
    //block Items
    public static final RegistryObject<Item> HELLSTONEORE_ITEM = ITEMS.register("hellstoneore", () -> new BlockItemBase(HELLSTONEORE.get()));
    public static final RegistryObject<Item> HELLSTONEOREBL_ITEM = ITEMS.register("hellstoneorebl", () -> new BlockItemBase(HELLSTONEOREBL.get()));
    public static final RegistryObject<Item> HELLSTONEBLOCK_ITEM = ITEMS.register("hellstoneblock", () -> new BlockItemBase(HELLSTONEBLOCK.get()));
    //hellspawn
    public static final RegistryObject<Item> HELLSPAWNBAR = ITEMS.register("hellspawnbar", () -> new DCBasicItem(2));
    public static final RegistryObject<Item> HELLSPAWNNUG = ITEMS.register("hellspawnnug", () -> new DCBasicItem(3));
    //tools
    public static final RegistryObject<SwordItem> HELLSPAWNSWORD = ITEMS.register("hellspawnsword", () ->
            new customesword(ModItemTier.Hellspawn, 5, -2f, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<ShovelItem> HELLSPAWNSPADE = ITEMS.register("hellspawnspade", () ->
            new customspade(ModItemTier.Hellspawn, 0, -2.7f, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<PickaxeItem> HELLSPAWNPICKAXE = ITEMS.register("hellspawnpickaxe", () ->
            new customepickaxe(ModItemTier.Hellspawn, 0, -2.7f, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<AxeItem> HELLSPAWNAXE = ITEMS.register("hellspawnaxe", () ->
            new customaxe(ModItemTier.Hellspawn, 8, -2.5f, new Item.Properties().group(definecraftCore.TAB)));
    public static final RegistryObject<HoeItem> HELLSPAWNHOE = ITEMS.register("hellspawnhoe", () ->
            new customHoe(ModItemTier.Hellspawn, -3, -2.7f, new Item.Properties().group(definecraftCore.TAB)));
    //armor
    public static final RegistryObject<ArmorItem> HELLSPAWNHELMET = ITEMS.register("hellspawnhelmet", () ->
            new customearmor(modarmor.HellSpawn, EquipmentSlotType.HEAD, new Item.Properties().group(definecraftCore.TAB), 2));
    public static final RegistryObject<ArmorItem> HELLSPAWNCHEST = ITEMS.register("hellspawnchest", () ->
            new customearmor(modarmor.HellSpawn, EquipmentSlotType.CHEST, new Item.Properties().group(definecraftCore.TAB), 2));
    public static final RegistryObject<ArmorItem> HELLSPAWNLEGS = ITEMS.register("hellspawnlegs", () ->
            new customearmor(modarmor.HellSpawn, EquipmentSlotType.LEGS, new Item.Properties().group(definecraftCore.TAB), 2));
    public static final RegistryObject<ArmorItem> HELLSPAWNBOOTS = ITEMS.register("hellspawnboots", () ->
            new customearmor(modarmor.HellSpawn, EquipmentSlotType.FEET, new Item.Properties().group(definecraftCore.TAB), 2));
    //meltingobsidian Blocks
     public static final RegistryObject<Block> MELTINGOBSIDIANW = BLOCKS.register("meltingobsidianw", ()->
         new MeltingOBsidian(AbstractBlock.Properties.create(Material.ICE).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.GLASS).notSolid(), 0));
    public static final RegistryObject<Block> MELTINGOBSIDIANL = BLOCKS.register("meltingobsidianl", () ->
            new MeltingOBsidian(AbstractBlock.Properties.create(Material.ICE).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.GLASS).notSolid(), 1));
    public static final RegistryObject<Block> MELTINGOBSIDIANBL = BLOCKS.register("meltingobsidianbl", () ->
            new MeltingOBsidianBace(AbstractBlock.Properties.create(Material.ICE).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.GLASS).notSolid(), 1));
    public static final RegistryObject<Block> MELTINGOBSIDIANBW = BLOCKS.register("meltingobsidianbw", ()->
            new MeltingOBsidianBace(AbstractBlock.Properties.create(Material.ICE).slipperiness(0.98F).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.GLASS).notSolid(), 0));
//vanishinglight
    public static final RegistryObject<Block> VANISHINGLIGHT = BLOCKS.register("invislight", ()->
            new invisLight(AbstractBlock.Properties.create(Material.MISCELLANEOUS).tickRandomly().doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.WOOD), ParticleTypes.FLAME,20));

}
