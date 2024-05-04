package com.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColWWPTransactionContext", namespace ="Gregory")
public final  class StructSdtColWWPTransactionContext implements Cloneable, java.io.Serializable
{
   public StructSdtColWWPTransactionContext( )
   {
      this( -1, new ModelContext( StructSdtColWWPTransactionContext.class ));
   }

   public StructSdtColWWPTransactionContext( int remoteHandle ,
                                             ModelContext context )
   {
   }

   public  StructSdtColWWPTransactionContext( java.util.Vector<StructSdtWWPTransactionContext> value )
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

   @javax.xml.bind.annotation.XmlElement(name="WWPTransactionContext",namespace="Gregory")
   public java.util.Vector<StructSdtWWPTransactionContext> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPTransactionContext> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPTransactionContext> item = new java.util.Vector<>();
}

