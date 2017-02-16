package com.test.shopping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Alex on 15.02.2017.
 */
public class ShoppingCart {
    private List<ShoppingItem> items = new ArrayList<>();

    public void addItem( ShoppingItem item )
    {
        items.add( item );
    }

    public List<ShoppingItem> getItems()
    {
        return items;
    }

    public boolean deleteItem( String productName )
    {
        Iterator<ShoppingItem> iterator = items.iterator();

        while( iterator.hasNext() )
        {
            ShoppingItem item = iterator.next();

            if( item.product.equals( productName ) )
            {
                iterator.remove();
                return true;
            }
        }

        return false;
    }
}
