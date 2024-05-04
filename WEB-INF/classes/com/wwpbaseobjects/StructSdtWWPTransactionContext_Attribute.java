package com.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtWWPTransactionContext_Attribute implements Cloneable, java.io.Serializable
{
   public StructSdtWWPTransactionContext_Attribute( )
   {
      this( -1, new ModelContext( StructSdtWWPTransactionContext_Attribute.class ));
   }

   public StructSdtWWPTransactionContext_Attribute( int remoteHandle ,
                                                    ModelContext context )
   {
      gxTv_SdtWWPTransactionContext_Attribute_Attributename = "" ;
      gxTv_SdtWWPTransactionContext_Attribute_Attributevalue = "" ;
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

   public String getAttributename( )
   {
      return gxTv_SdtWWPTransactionContext_Attribute_Attributename ;
   }

   public void setAttributename( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPTransactionContext_Attribute_Attributename = value ;
   }

   public String getAttributevalue( )
   {
      return gxTv_SdtWWPTransactionContext_Attribute_Attributevalue ;
   }

   public void setAttributevalue( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPTransactionContext_Attribute_Attributevalue = value ;
   }

   protected byte sdtIsNull ;
   protected String gxTv_SdtWWPTransactionContext_Attribute_Attributename ;
   protected String gxTv_SdtWWPTransactionContext_Attribute_Attributevalue ;
}

