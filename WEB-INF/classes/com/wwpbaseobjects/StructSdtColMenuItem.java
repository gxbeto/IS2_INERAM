package com.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColMenuItem", namespace ="Gregory")
public final  class StructSdtColMenuItem implements Cloneable, java.io.Serializable
{
   public StructSdtColMenuItem( )
   {
      this( -1, new ModelContext( StructSdtColMenuItem.class ));
   }

   public StructSdtColMenuItem( int remoteHandle ,
                                ModelContext context )
   {
   }

   public  StructSdtColMenuItem( java.util.Vector<StructSdtMenuItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="MenuItem",namespace="Gregory")
   public java.util.Vector<StructSdtMenuItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtMenuItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtMenuItem> item = new java.util.Vector<>();
}

