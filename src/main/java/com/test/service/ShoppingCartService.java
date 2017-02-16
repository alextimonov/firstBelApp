package com.test.service;

import com.backendless.Backendless;
import com.backendless.servercode.IBackendlessService;
import com.test.shopping.ShoppingCart;
import com.test.shopping.ShoppingItem;

import java.util.List;

/**
 * Created by Alex on 15.02.2017.
 */
public class ShoppingCartService implements IBackendlessService {
    public void addItem( String cartName, ShoppingItem item )
    {
        ShoppingCart shoppingCart = getCart( cartName );

        if( shoppingCart == null )
            shoppingCart = new ShoppingCart();

        shoppingCart.addItem( item );
        item.objectId = null;
        Backendless.Cache.put( cartName, shoppingCart );
    }

    public boolean deleteItem( String cartName, String productName )
    {
        ShoppingCart shoppingCart = getCart( cartName );

        if( shoppingCart == null )
            return false;

        boolean result = shoppingCart.deleteItem( productName );
        Backendless.Cache.put( cartName, shoppingCart );
        return result;
    }

    public List<ShoppingItem> getItems(String cartName )
    {
        ShoppingCart shoppingCart = getCart( cartName );

        if( shoppingCart == null )
            shoppingCart = new ShoppingCart();

        return shoppingCart.getItems();
    }

    private ShoppingCart getCart( String cartName )
    {
        if( cartName == null || cartName.trim().length() == 0 )
            throw new IllegalArgumentException( "Missing cart name" );

        return Backendless.Cache.get( cartName, ShoppingCart.class );
    }
}
