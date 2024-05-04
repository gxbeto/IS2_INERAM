package com.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "Items", namespace ="")
public final  class StructSdtGridStateCollection implements Cloneable, java.io.Serializable
{
   public StructSdtGridStateCollection( )
   {
      this( -1, new ModelContext( StructSdtGridStateCollection.class ));
   }

   public StructSdtGridStateCollection( int remoteHandle ,
                                        ModelContext context )
   {
   }

   public  StructSdtGridStateCollection( java.util.Vector<StructSdtGridStateCollection_Item> value )
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
   public java.util.Vector<StructSdtGridStateCollection_Item> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtGridStateCollection_Item> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtGridStateCollection_Item> item = new java.util.Vector<>();
}

