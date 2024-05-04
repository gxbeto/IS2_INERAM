package com.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "Data", namespace ="")
public final  class StructSdtDVB_SDTDropDownOptionsData implements Cloneable, java.io.Serializable
{
   public StructSdtDVB_SDTDropDownOptionsData( )
   {
      this( -1, new ModelContext( StructSdtDVB_SDTDropDownOptionsData.class ));
   }

   public StructSdtDVB_SDTDropDownOptionsData( int remoteHandle ,
                                               ModelContext context )
   {
   }

   public  StructSdtDVB_SDTDropDownOptionsData( java.util.Vector<StructSdtDVB_SDTDropDownOptionsData_Item> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Item",namespace="")
   public java.util.Vector<StructSdtDVB_SDTDropDownOptionsData_Item> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtDVB_SDTDropDownOptionsData_Item> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtDVB_SDTDropDownOptionsData_Item> item = new java.util.Vector<>();
}

