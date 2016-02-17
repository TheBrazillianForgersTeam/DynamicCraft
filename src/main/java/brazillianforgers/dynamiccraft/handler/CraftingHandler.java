package brazillianforgers.dynamiccraft.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import brazillianforgers.lib.RecipeHelper.ICraftable;
import brazillianforgers.lib.RecipeHelper.Recipe;
import brazillianforgers.lib.RecipeHelper.RecipeValue;

public class CraftingHandler{
	
	public static void Init() {
		registerRecipe();
		registerShapeless();
	}
	
	private static void registerRecipe() {
		addRecipe(new ItemStack(BlockHandler.infusionAltar), new Object[] {
			"B B",
			"QPQ",
			"PEP", 'B', new ItemStack(Blocks.iron_bars), 'E', new ItemStack(Blocks.enchanting_table), 'P', new ItemStack(ItemHandler.dynamicPearl),
					'Q', new ItemStack(Items.quartz)
		});
		
		addRecipe(new ItemStack(ItemHandler.dynamicPearl), new Object[] {
				"SRS",
				"RSR",
				"SRS", 'S', new ItemStack(ItemHandler.dynamicShard), 'R', new ItemStack(Items.redstone)
		});
		
		addRecipe(new ItemStack(BlockHandler.blockDynamic),
				"DDD",
				"DDD",
				"DDD",
				'D', ItemHandler.dynamicPearl
		);
		
		addRecipe(new ItemStack(ItemHandler.magicFinder), new Object[] {
				"MMM",
				"POP",
				"MMM", 'M', new ItemStack(Blocks.log), 'P', new ItemStack(ItemHandler.dynamicPearl), 'O', new ItemStack(Items.ender_eye)
		});
	}
	
	private static void registerShapeless() {
		GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.dynamicPearl, 9), BlockHandler.blockDynamic);
	}
	
	private static void addRecipe(ItemStack result, Object... recipe) {
		GameRegistry.addRecipe(result, recipe);
	}

}
