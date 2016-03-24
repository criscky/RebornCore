package ic2.api.recipe;

import java.util.List;

import net.minecraft.item.ItemStack;

public interface IListRecipeManager extends Iterable<IRecipeInput>
{
	void add(IRecipeInput p0);

	boolean contains(ItemStack p0);

	boolean isEmpty();

	List<IRecipeInput> getInputs();
}
