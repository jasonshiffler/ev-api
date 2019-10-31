package com.tesla.springboot.evapi.exceptions;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(){
        super("Item not found");
    }

    public ItemNotFoundException(Long id){
        super("Item with {id} = " + id + " not found");
    }

    public ItemNotFoundException(Long id, String itemType){
        super(itemType + " with {id} = " + id + " not found");
    }

}
