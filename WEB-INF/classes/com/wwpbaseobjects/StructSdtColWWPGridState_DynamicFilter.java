package com.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColWWPGridState.DynamicFilter", namespace ="Gregory")
public final  class StructSdtColWWPGridState_DynamicFilter implements Cloneable, java.io.Serializable
{
   public StructSdtColWWPGridState_DynamicFilter( )
   {
      this( -1, new ModelContext( StructSdtColWWPGridState_DynamicFilter.class ));
   }

   public StructSdtColWWPGridState_DynamicFilter( int remoteHandle ,
                                                  ModelContext context )
   {
   }

   public  StructSdtColWWPGridState_DynamicFilter( java.util.Vector<StructSdtWWPGridState_DynamicFilter> value )
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

   @javax.xml.bind.annotation.XmlElement(name="WWPGridState.DynamicFilter",namespace="Gregory")
   public java.util.Vector<StructSdtWWPGridState_DynamicFilter> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPGridState_DynamicFilter> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPGridState_DynamicFilter> item = new java.util.Vector<>();
}

