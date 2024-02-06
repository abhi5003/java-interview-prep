package com.spring.example.LLD.DesignPatterns.caseStudies.VendingMachine.VendingStates;

import com.spring.example.LLD.DesignPatterns.caseStudies.VendingMachine.Coin;
import com.spring.example.LLD.DesignPatterns.caseStudies.VendingMachine.Item;
import com.spring.example.LLD.DesignPatterns.caseStudies.VendingMachine.VendingMachine;

import java.util.List;

public interface State {

    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception;

    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception;

    public void insertCoin(VendingMachine machine , Coin coin) throws Exception;

    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception;

    public int getChange(int returnChangeMoney) throws Exception;

    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception;

    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception;

    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception;


}
