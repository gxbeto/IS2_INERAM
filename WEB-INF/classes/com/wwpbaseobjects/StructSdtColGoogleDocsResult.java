package com.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColGoogleDocsResult", namespace ="DVelop.Extensions.GoogleDocs")
public final  class StructSdtColGoogleDocsResult implements Cloneable, java.io.Serializable
{
   public StructSdtColGoogleDocsResult( )
   {
      this( -1, new ModelContext( StructSdtColGoogleDocsResult.class ));
   }

   public StructSdtColGoogleDocsResult( int remoteHandle ,
                                        ModelContext context )
   {
   }

   public  StructSdtColGoogleDocsResult( java.util.Vector<StructSdtGoogleDocsResult> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Result",namespace="DVelop.Extensions.GoogleDocs")
   public java.util.Vector<StructSdtGoogleDocsResult> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtGoogleDocsResult> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtGoogleDocsResult> item = new java.util.Vector<>();
}

