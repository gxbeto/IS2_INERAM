package com.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColWWPTransactionContext.Attribute", namespace ="Gregory")
public final  class StructSdtColWWPTransactionContext_Attribute implements Cloneable, java.io.Serializable
{
   public StructSdtColWWPTransactionContext_Attribute( )
   {
      this( -1, new ModelContext( StructSdtColWWPTransactionContext_Attribute.class ));
   }

   public StructSdtColWWPTransactionContext_Attribute( int remoteHandle ,
                                                       ModelContext context )
   {
   }

   public  StructSdtColWWPTransactionContext_Attribute( java.util.Vector<StructSdtWWPTransactionContext_Attribute> value )
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

   @javax.xml.bind.annotation.XmlElement(name="WWPTransactionContext.Attribute",namespace="Gregory")
   public java.util.Vector<StructSdtWWPTransactionContext_Attribute> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWPTransactionContext_Attribute> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWPTransactionContext_Attribute> item = new java.util.Vector<>();
}

