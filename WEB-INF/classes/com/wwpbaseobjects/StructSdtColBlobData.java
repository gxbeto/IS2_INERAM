package com.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColBlobData", namespace ="Gregory")
public final  class StructSdtColBlobData implements Cloneable, java.io.Serializable
{
   public StructSdtColBlobData( )
   {
      this( -1, new ModelContext( StructSdtColBlobData.class ));
   }

   public StructSdtColBlobData( int remoteHandle ,
                                ModelContext context )
   {
   }

   public  StructSdtColBlobData( java.util.Vector<StructSdtBlobData> value )
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

   @javax.xml.bind.annotation.XmlElement(name="BlobData",namespace="Gregory")
   public java.util.Vector<StructSdtBlobData> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtBlobData> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtBlobData> item = new java.util.Vector<>();
}

