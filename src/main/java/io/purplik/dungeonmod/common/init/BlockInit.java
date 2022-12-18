package io.purplik.dungeonmod.common.init;

import io.purplik.dungeonmod.DungeonMod;
import io.purplik.dungeonmod.common.blocks.TestStone;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DungeonMod.MODID);

    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block", () -> new TestStone(BlockBehaviour.Properties.of(Material.STONE)), new Item.Properties().tab(CreativeModeTab.TAB_MISC));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, Item.Properties properties){
        RegistryObject<T> registeredBlock = BLOCKS.register(name, block);
        registerBlockItem(name, registeredBlock, properties);
        return registeredBlock;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, Item.Properties properties) {
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
    }
}
