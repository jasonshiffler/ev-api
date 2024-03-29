package com.tesla.springboot.evapi.exceptions;

public class ItemNotFoundException extends Exception {

    public ItemNotFoundException(){
        super("Item not found");
    }

    public ItemNotFoundException(Long id){
        super("Item with {id} = " + id + " not found");
    }

    public ItemNotFoundException(Long id, String itemType){
        super(itemType + " with {id} = " + id + " not found");
    }

    public ItemNotFoundException(String itemType){
        super(itemType + " not found");
    }

}
