package com.TaxAddVisitor;
public class TaxVisitor extends IVisitor {
    @Override
    public void visit(Bed bedObj) {
        bedObj.setPrice(bedObj.getPrice() + bedObj.getPrice() * 0.5);
    }

    @Override
    public void visit(Chair chairObj) {
        chairObj.setPrice(chairObj.getPrice() + chairObj.getPrice() * 0.6);
    }
}
