/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pythonmetadata;

/**
 *
 * @author G-sta
 */
public class Variable {
    
    
    private String type;
    private String name;
    private String value;
    
    /**
     * Take a string as input and parse it to get variable data for the final file:
     *     "var_type:var_name:var_value
     * 
     * Variables instantiated as null variables will have the following input String
     *     "var_type:var_type:_"
     * 
     * Currently supported variable types:
     *  - string
     *  - integer
     *  - float
     *  - boolean
     */
    public Variable(String variable) {
        // Parse through input string for 3 components.
        int partition_index = variable.indexOf(":");
        this.type = variable.substring(0,partition_index);
        variable = variable.substring(partition_index + 1);
        partition_index = variable.indexOf(":");
        this.name = variable.substring(0,partition_index);
        variable = variable.substring(partition_index + 1);
        partition_index = variable.indexOf(":");
        this.value = variable;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public String codeInstantiate() {
        if (this.value.equals("_")) {
            return (this.name + " = " + "None");
        } else {
            return (this.name + " = " + this.value);
        }
    }
    
    public String codeUpdate(String value) {
        return (this.name + " = " + this.value);
    }    
    
    public String codeIncrement() {
        if (this.type.equals("integer") || this.type.equals("float")){
            return (this.name + " = " + this.name + " + 1");
        }
        throw new IllegalArgumentException("Variable must be numeric");
    }
    
    public String codeIncrement(int n) {
        if (this.type.equals("integer") || this.type.equals("float")){
            return (this.name + " = " + this.name + " + " + Integer.toString(n));
        }
        throw new IllegalArgumentException("Variable must be numeric");
    }
    
    public String codeDecrement() {
        if (this.type.equals("integer") || this.type.equals("float")){
            return (this.name + " = " + this.name + " - 1");
        }
        throw new IllegalArgumentException("Variable must be numeric");
    }
    
    public String codeDecrement(int n) {
        if (this.type.equals("integer") || this.type.equals("float")){
            return (this.name + " = " + this.name + " - " + Integer.toString(n));
        }
        throw new IllegalArgumentException("Variable must be numeric");
    }
    
    public String toString() {
        if (this.value.equals("_")) {
            return this.type + " " + this.name;
        } else {
            return this.type + " " + this.name + " = " + this.value;
        }
    }
}
