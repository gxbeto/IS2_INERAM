package com.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColWWPColumnsSelector", namespace ="Gregory")
public final  class StructSdtColWWPColumnsSelector implements Cloneable, java.io.Serializable
{
   public StructSdtColWWPColumnsSelector( )
   {
      this( -1, new ModelContext( StructSdtColWWPColumnsSelector.class ));
   }

   public StructSdtColWWPColumnsSelector( int remoteHandle ,
                                          ModelContext context )
   {
   }

   public  StructSdtColWWPColumnsSelector( java.util.Vector<StructSdtWWPColumnsSelector> value )
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

   @javax.xml.bind.annotation.XmlElement(name="WWPColumnsSelector",namespace="Gregory")
   public java.util.Vector<StructSdtWWPColumnsSelector> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPColumnsSelector> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPColumnsSelector> item = new java.util.Vector<>();
}

