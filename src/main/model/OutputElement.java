package model;

// Represents all output elements. Output elements contain power inputs in all directions but no power outputs
public abstract class OutputElement extends LogicElement {
    
    // EFFECTS: should not be called, but if so, does nothing and stops propagation of output to the left
    @Override
    public void outputLeft() {
        
    }

    // EFFECTS: should not be called, but if so, does nothing and stops propagation of output to the right
    @Override
    public void outputRight() {
        
    }

    // EFFECTS: should not be called, but if so, does nothing and stops propagation of output to above
    @Override
    public void outputAbove() {
        
    }

    // EFFECTS: should not be called, but if so, does nothing and stops propagation of output to below
    @Override
    public void outputBelow() {
        
    }
}
