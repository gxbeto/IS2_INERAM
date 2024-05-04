package com.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "Data", namespace ="")
public final  class StructSdtDVB_SDTComboData implements Cloneable, java.io.Serializable
{
   public StructSdtDVB_SDTComboData( )
   {
      this( -1, new ModelContext( StructSdtDVB_SDTComboData.class ));
   }

   public StructSdtDVB_SDTComboData( int remoteHandle ,
                                     ModelContext context )
   {
   }

   public  StructSdtDVB_SDTComboData( java.util.Vector<StructSdtDVB_SDTComboData_Item> value )
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
   public java.util.Vector<StructSdtDVB_SDTComboData_Item> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtDVB_SDTComboData_Item> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtDVB_SDTComboData_Item> item = new java.util.Vector<>();
}

