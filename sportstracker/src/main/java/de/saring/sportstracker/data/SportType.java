package de.saring.sportstracker.data;

import de.saring.util.data.IdObject;
import de.saring.util.data.IdObjectList;
import java.awt.Color;

/**
 * This class contains all informations of a single sport type (e.g. cycling).
 * 
 * @author  Stefan Saring
 * @version 1.0
 */
public final class SportType extends IdObject implements Cloneable {

    /** Name of sport type. */
    private String name;

    /** Flag is true, when the distance needs to be recorded for this sport type. */
    private boolean recordDistance = true;

    /** Filename of sport type icon. */
    private String icon;

    /** Color used for sport type visualization in GUI. */
    private Color color = Color.BLACK;
    
    /** This is the list of all subtypes of this sport type. */
    private IdObjectList<SportSubType> sportSubTypeList = new IdObjectList<> ();
    
    /** 
     * This is the list of all possible equipments of this sport type. 
     * The equipment definition is optional, so this list can be empty.
     */
    private IdObjectList<Equipment> equipmentList = new IdObjectList<> ();
    
    
    /**
     * Standard c'tor.
     * @param id the ID of the object
     */
    public SportType (int id) {
        super (id);
    }
    
    /***** BEGIN: Generated Getters and Setters *****/
    
    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public boolean isRecordDistance () {
        return recordDistance;
    }

    public void setRecordDistance (boolean recordDistance) {
        this.recordDistance = recordDistance;
    }

    public String getIcon () {
        return icon;
    }

    public void setIcon (String icon) {
        this.icon = icon;
    }

    public Color getColor () {
        return color;
    }

    public void setColor (Color color) {
        this.color = color;
    }

    public IdObjectList<SportSubType> getSportSubTypeList () {
        return sportSubTypeList;
    }

    public IdObjectList<Equipment> getEquipmentList () {
        return equipmentList;
    }

    /***** END: Generated Getters and Setters *****/

    /**
     * Returns a deep clone copy of this SportType object.
     * @return clone of this object
     */
    @Override
    public SportType clone () {
        try {
            // primitives and immutable strings must not be re-assigned
            // (the exception can't happen)
            SportType clone = (SportType) super.clone ();

            if (this.sportSubTypeList != null) {
                clone.sportSubTypeList = new IdObjectList<> ();
                for (SportSubType subType : this.sportSubTypeList) {
                    clone.sportSubTypeList.set ((SportSubType) subType.clone ());
                }
            }
            if (this.equipmentList != null) {
                clone.equipmentList = new IdObjectList<> ();
                for (Equipment equipment : this.equipmentList) {
                    clone.equipmentList.set ((Equipment) equipment.clone ());
                }
            }
            
            return clone;
        }
        catch (CloneNotSupportedException ex) {
            throw new AssertionError ();
        }
    }

    /** 
     * Returns a string representation of this object. 
     * @return string with object content
     */
    @Override
    public String toString () {
        
        StringBuilder sBuilder = new StringBuilder ();
        sBuilder.append (this.getClass ().getName () + ":\n");
        sBuilder.append (" [id=" + this.getId () + "\n");
        sBuilder.append ("  name=" + this.name + "\n");
        sBuilder.append ("  recordDistance=" + this.recordDistance + "\n");
        sBuilder.append ("  icon=" + this.icon + "\n");
        sBuilder.append ("  color=" + this.color + "]\n");
        
        if (this.sportSubTypeList != null) {
            for (SportSubType subType : this.sportSubTypeList) {
                sBuilder.append (subType);
            }
        }
        if (this.equipmentList != null) {
            for (Equipment equipment : this.equipmentList) {
                sBuilder.append (equipment);
            }
        }        
        return sBuilder.toString ();
    }
}
