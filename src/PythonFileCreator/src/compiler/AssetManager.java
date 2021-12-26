/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.util.ArrayList;
import pythonmetadata.Section;
import pythonmetadata.Variable;
import workbenchcomponents.SectionView;
import workbenchcomponents.VariableView;

/**
 *
 * @author G-sta
 */
public class AssetManager {
    
    private final SectionView section_view;
    private final VariableView variable_view;
    
    
    private final ArrayList<Section> sections;
    private final ArrayList<Variable> variables;
    
    
    public AssetManager(SectionView section_view, VariableView variable_view) {
        this.section_view = section_view;
        this.variable_view = variable_view;
        
        sections = new ArrayList<Section>();
        variables = new ArrayList<Variable>();
    }
    
    public void initialize() {
        section_view.assignManager(this);
        variable_view.assignManager(this);
    }
    
    public void addVariable(String name, String type) {
        String new_variable_string = name + ":" + type + ":_";
        Variable new_variable = new Variable(new_variable_string);
        variables.add(new_variable);
        organizeVariables();
    }
    
    public void addVariable(String name, String type, String value) {
        String new_variable_string = name + ":" + type + ":" + value;
        Variable new_variable = new Variable(new_variable_string);
        variables.add(new_variable);
        organizeVariables();
    }
    
    public Variable getVariableByName(String name) {
        for (int i = 0; i < variables.size(); i++) {
            if (variables.get(i).getName() == name) {
                return variables.get(i);
            }
        }
        return null;
    }
    
    private int getVariableIndexByName(String name) {
        for (int i = 0; i < variables.size(); i++) {
            if (variables.get(i).getName() == name) {
                return i;
            }
        }
        return -1;
    }
    
    private void organizeVariables() {
        if (variables.size() < 2) { return; }
        for (int i = 0; i < variables.size()-1; i++) {
            for (int j = i+1; j < variables.size(); j++) {
                Variable variable_1 = variables.get(i);
                Variable variable_2 = variables.get(j);
                String variable_1_name = variable_1.getName();
                String variable_2_name = variable_2.getName();
                
                if (variable_1_name.compareTo(variable_2_name) > 1) {
                    variables.set(i, variable_2);
                    variables.set(j, variable_1);
                }
            }
        }
    }
    
    public void removeVariable(String name) {
        Variable variable = getVariableByName(name);
        variables.remove(variable);
    }
    
    public void updateVariable(String old_name, String new_name, String type, String value) {
        int i = getVariableIndexByName(old_name);
        variables.get(i).setName(new_name);
        variables.get(i).setType(type);
        variables.get(i).setValue(value);
    }
    
}
