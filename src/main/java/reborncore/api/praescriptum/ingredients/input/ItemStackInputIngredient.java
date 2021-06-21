/*
 * Copyright (c) 2018 modmuss50 and Gigabit101
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package reborncore.api.praescriptum.ingredients.input;

import net.minecraft.item.ItemStack;

import reborncore.common.util.ItemUtils;

/**
 * @author estebes
 */
public class ItemStackInputIngredient extends InputIngredient<ItemStack> {
    public static ItemStackInputIngredient of(ItemStack ingredient) {
        return new ItemStackInputIngredient(ingredient);
    }

    public static ItemStackInputIngredient of(ItemStack ingredient, boolean consumable) {
        return new ItemStackInputIngredient(ingredient, consumable);
    }

    public static ItemStackInputIngredient copyOf(ItemStack ingredient) {
        return new ItemStackInputIngredient(ingredient.copy());
    }

    public static ItemStackInputIngredient copyOf(ItemStack ingredient, boolean consumable) {
        return new ItemStackInputIngredient(ingredient.copy(), consumable);
    }

    protected ItemStackInputIngredient(ItemStack ingredient) {
        super(ingredient);
    }

    protected ItemStackInputIngredient(ItemStack ingredient, boolean consumable) {
        super(ingredient, consumable);
    }

    @Override
    public Object getUnspecific() {
        return ingredient.getItem();
    }

    @Override
    public InputIngredient<ItemStack> copy() {
        return of(ingredient.copy());
    }

    @Override
    public boolean isEmpty() {
        return ItemUtils.isEmpty(ingredient);
    }

    @Override
    public int getCount() {
        return ItemUtils.getSize(ingredient);
    }

    @Override
    public void shrink(int amount) {
        ingredient.shrink(amount);
    }

    @Override
    public boolean matches(Object other) {
        return other instanceof ItemStack &&
                ItemUtils.isItemEqual(ingredient, (ItemStack) other, true, true);
    }

    @Override
    public boolean matchesStrict(Object other) {
        return other instanceof ItemStack &&
                ItemUtils.isItemEqual(ingredient, (ItemStack) other, true, true);
    }

    @Override
    public String toFormattedString() {
        return ItemUtils.toFormattedString(ingredient);
    }

    @Override
    public boolean equals(Object object) {
        if (getClass() != object.getClass()) return false;

        return matches(((ItemStackInputIngredient) object).ingredient) && this.consumable == ((ItemStackInputIngredient) object).consumable;
    }
}
