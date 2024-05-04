package com.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColWWPGridState.FilterValue", namespace ="Gregory")
public final  class StructSdtColWWPGridState_FilterValue implements Cloneable, java.io.Serializable
{
   public StructSdtColWWPGridState_FilterValue( )
   {
      this( -1, new ModelContext( StructSdtColWWPGridState_FilterValue.class ));
   }

   public StructSdtColWWPGridState_FilterValue( int remoteHandle ,
                                                ModelContext context )
   {
   }

   public  StructSdtColWWPGridState_FilterValue( java.util.Vector<StructSdtWWPGridState_FilterValue> value )
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

   @javax.xml.bind.annotation.XmlElement(name="WWPGridState.FilterValue",namespace="Gregory")
   public java.util.Vector<StructSdtWWPGridState_FilterValue> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPGridState_FilterValue> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPGridState_FilterValue> item = new java.util.Vector<>();
}

