package com.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColDVB_SDTDropDownOptionsTitleSettingsIcons", namespace ="")
public final  class StructSdtColDVB_SDTDropDownOptionsTitleSettingsIcons implements Cloneable, java.io.Serializable
{
   public StructSdtColDVB_SDTDropDownOptionsTitleSettingsIcons( )
   {
      this( -1, new ModelContext( StructSdtColDVB_SDTDropDownOptionsTitleSettingsIcons.class ));
   }

   public StructSdtColDVB_SDTDropDownOptionsTitleSettingsIcons( int remoteHandle ,
                                                                ModelContext context )
   {
   }

   public  StructSdtColDVB_SDTDropDownOptionsTitleSettingsIcons( java.util.Vector<StructSdtDVB_SDTDropDownOptionsTitleSettingsIcons> value )
   {
      item = value;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   @javax.xml.bind.annotation.XmlElement(name="TitleSettingsIcons",namespace="")
   public java.util.Vector<StructSdtDVB_SDTDropDownOptionsTitleSettingsIcons> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtDVB_SDTDropDownOptionsTitleSettingsIcons> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtDVB_SDTDropDownOptionsTitleSettingsIcons> item = new java.util.Vector<>();
}

