package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ExampleMod implements ModInitializer {

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier("tutorial", "general"),
            () -> new ItemStack(Blocks.COBBLESTONE));

    public static final ItemGroup OTHER_GROUP = FabricItemGroupBuilder.create(new Identifier("tutorial", "other"))
            .icon(() -> new ItemStack(Items.BOWL)).build();

    // an instance of our new item
    public static final FabricItem FABRIC_ITEM = new FabricItem(new Item.Settings().group(ExampleMod.ITEM_GROUP));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("tutorial", "fabric_item"), FABRIC_ITEM);
    }
}
