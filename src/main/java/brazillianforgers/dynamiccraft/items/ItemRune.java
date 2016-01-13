package brazillianforgers.dynamiccraft.items;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import brazillianforgers.dynamiccraft.DynamicCraft;

public class ItemRune extends BaseItem {
	
	private RuneType type;
	
	public static enum RuneType {
		BASE,
		AQUA,
		FIRE,
		EATH;
	}
	
	public ItemRune(RuneType type) {
		setCreativeTab(DynamicCraft.dynamicTab);
		setMaxStackSize(1);
		setHasSubtypes(true);
		setMaxDamage(20);

		this.type = type;
		setName();
	}
	
	public RuneType getType() {
		return type;
	}
	
	public void setName() {
		if(type == RuneType.AQUA) {
			setUnlocalizedName("aquaRune");
		}else if(type == RuneType.FIRE) {
			setUnlocalizedName("fireRune");
		}else if(type == RuneType.EATH) {
			setUnlocalizedName("earthRune");
		}else if(type == RuneType.BASE) {
			setUnlocalizedName("baseRune");
		}
	}
	
	@Override
    public void onUpdate(ItemStack item, World world, Entity ent, int i, boolean b) {
		if(!(ent instanceof EntityPlayer))
			return;
		
		EntityPlayer p = (EntityPlayer) ent;
		
		if(p.getHeldItem() == null || p.getHeldItem().getItem() != this)
			return;
		
		if(type == RuneType.FIRE) {
			if(p.isBurning()) {
				p.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 100, 2));
			}else {
				p.removePotionEffect(Potion.fireResistance.getId());
			}
		}else if(type == RuneType.AQUA) {
			if(p.handleWaterMovement()) {
				p.addPotionEffect(new PotionEffect(Potion.waterBreathing.getId(), 100, 4));
			}else {
				p.removePotionEffect(Potion.waterBreathing.getId());
			}
		}else if(type == RuneType.EATH) {
			Material m = world.getBlock((int) p.posX, (int) p.posY, (int) p.posZ).getMaterial();
			if(m == Material.lava || m == Material.water)
				return;
			
			p.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 25, 1));
		}
	}
}
