package reborncore.common.powerSystem.traits;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import reborncore.api.power.IEnergyInterfaceItem;
import reborncore.jtraits.JTrait;
import ic2.api.item.IElectricItem;

public class EUItemPowerTrait extends JTrait<IEnergyInterfaceItem> implements IElectricItem
{

	@Override
	public boolean canProvideEnergy(ItemStack itemStack)
	{
		return _self.canAcceptEnergy(itemStack);
	}

	@Override
	public Item getChargedItem(ItemStack itemStack)
	{
		return (Item) _self;
	}

	@Override
	public Item getEmptyItem(ItemStack itemStack)
	{
		return (Item) _self;
	}

	@Override
	public double getMaxCharge(ItemStack itemStack)
	{
		return _self.getMaxPower(itemStack);
	}

	@Override
	public int getTier(ItemStack itemStack)
	{
		return _self.getStackTier(itemStack);
	}

	@Override
	public double getTransferLimit(ItemStack itemStack)
	{
		return _self.getMaxTransfer(itemStack);
	}
}
