package com.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtWWPTransactionContext implements Cloneable, java.io.Serializable
{
   public StructSdtWWPTransactionContext( )
   {
      this( -1, new ModelContext( StructSdtWWPTransactionContext.class ));
   }

   public StructSdtWWPTransactionContext( int remoteHandle ,
                                          ModelContext context )
   {
      gxTv_SdtWWPTransactionContext_Callerobject = "" ;
      gxTv_SdtWWPTransactionContext_Callerurl = "" ;
      gxTv_SdtWWPTransactionContext_Transactionname = "" ;
      gxTv_SdtWWPTransactionContext_Attributes_N = (byte)(1) ;
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

   public String getCallerobject( )
   {
      return gxTv_SdtWWPTransactionContext_Callerobject ;
   }

   public void setCallerobject( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPTransactionContext_Callerobject = value ;
   }

   public boolean getCallerondelete( )
   {
      return gxTv_SdtWWPTransactionContext_Callerondelete ;
   }

   public void setCallerondelete( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPTransactionContext_Callerondelete = value ;
   }

   public String getCallerurl( )
   {
      return gxTv_SdtWWPTransactionContext_Callerurl ;
   }

   public void setCallerurl( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPTransactionContext_Callerurl = value ;
   }

   public String getTransactionname( )
   {
      return gxTv_SdtWWPTransactionContext_Transactionname ;
   }

   public void setTransactionname( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPTransactionContext_Transactionname = value ;
   }

   public java.util.Vector<com.wwpbaseobjects.StructSdtWWPTransactionContext_Attribute> getAttributes( )
   {
      return gxTv_SdtWWPTransactionContext_Attributes ;
   }

   public void setAttributes( java.util.Vector<com.wwpbaseobjects.StructSdtWWPTransactionContext_Attribute> value )
   {
      gxTv_SdtWWPTransactionContext_Attributes_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPTransactionContext_Attributes = value ;
   }

   protected byte gxTv_SdtWWPTransactionContext_Attributes_N ;
   protected byte sdtIsNull ;
   protected boolean gxTv_SdtWWPTransactionContext_Callerondelete ;
   protected String gxTv_SdtWWPTransactionContext_Callerobject ;
   protected String gxTv_SdtWWPTransactionContext_Callerurl ;
   protected String gxTv_SdtWWPTransactionContext_Transactionname ;
   protected java.util.Vector<com.wwpbaseobjects.StructSdtWWPTransactionContext_Attribute> gxTv_SdtWWPTransactionContext_Attributes=null ;
}

