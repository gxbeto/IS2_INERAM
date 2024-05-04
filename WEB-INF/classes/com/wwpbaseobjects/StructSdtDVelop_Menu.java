package com.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "DVelop_Menu", namespace ="Gregory")
public final  class StructSdtDVelop_Menu implements Cloneable, java.io.Serializable
{
   public StructSdtDVelop_Menu( )
   {
      this( -1, new ModelContext( StructSdtDVelop_Menu.class ));
   }

   public StructSdtDVelop_Menu( int remoteHandle ,
                                ModelContext context )
   {
   }

   public  StructSdtDVelop_Menu( java.util.Vector<StructSdtDVelop_Menu_Item> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Item",namespace="Gregory")
   public java.util.Vector<StructSdtDVelop_Menu_Item> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtDVelop_Menu_Item> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtDVelop_Menu_Item> item = new java.util.Vector<>();
}

