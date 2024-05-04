package com.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColWWPGridState", namespace ="Gregory")
public final  class StructSdtColWWPGridState implements Cloneable, java.io.Serializable
{
   public StructSdtColWWPGridState( )
   {
      this( -1, new ModelContext( StructSdtColWWPGridState.class ));
   }

   public StructSdtColWWPGridState( int remoteHandle ,
                                    ModelContext context )
   {
   }

   public  StructSdtColWWPGridState( java.util.Vector<StructSdtWWPGridState> value )
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

   @javax.xml.bind.annotation.XmlElement(name="WWPGridState",namespace="Gregory")
   public java.util.Vector<StructSdtWWPGridState> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPGridState> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPGridState> item = new java.util.Vector<>();
}

